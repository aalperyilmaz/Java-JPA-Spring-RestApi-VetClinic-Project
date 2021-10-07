package com.works.restapix.dto;

import com.works.restapix.entities.Buying;
import com.works.restapix.entities.MoneyCase;
import com.works.restapix.entities.Storage;
import com.works.restapix.entities.Suppliers;
import com.works.restapix.repositories.*;
import com.works.restapix.utils.RestEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuyingDto {

    final BuyingRepository bRepo;
    final SuppliersRepository supRepo;
    final StorageRepository strRepo;
    final VaccineRepository vacRepo;
    final ProductRepository proRepo;
    final CaseRepository caRepo;

    public BuyingDto(BuyingRepository bRepo, SuppliersRepository supRepo, StorageRepository strRepo, VaccineRepository vacRepo, ProductRepository proRepo, CaseRepository caRepo) {
        this.bRepo = bRepo;
        this.supRepo = supRepo;
        this.strRepo = strRepo;
        this.vacRepo = vacRepo;
        this.proRepo = proRepo;
        this.caRepo = caRepo;
    }


    public Map<RestEnum,Object> BuyingInsert(Buying buying){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();


        try {

            float tax=0.3f;
            buying.setBuyingDate(new Date());
            buying.setBgrossPrice(buying.getProprice()*buying.getProamount());
            buying.setBnetPrice(buying.getBgrossPrice()-buying.getBgrossPrice()*buying.getPdiscount()/100);
            buying.setStatus(0);

            if(buying.getTaxtype()==0){
                tax = 0;
            }
            else if(buying.getTaxtype()==1){
                tax = 0.01f;
            }
            else if(buying.getTaxtype()==2){
                tax = 0.08f;
            }
            else if(buying.getTaxtype()==3){
                tax = 0.18f;
            }

            buying.setBtotalPrice((int) (buying.getBnetPrice()*(1+tax)));

            Buying b = bRepo.saveAndFlush(buying);

            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.result,b);
            hm.put(RestEnum.message,"buying saved ");



        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"failed by"+ e.getLocalizedMessage());

        }

return hm;
    }







    public Map<RestEnum,Object> BuyingtDelete(String bidx){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();

        try{
            int bid = Integer.parseInt(bidx);
            Buying dObject = bRepo.findByBidEquals(bid);

            List<Buying> dlist = bRepo.getByBfaturaNoEquals(dObject.getBfaturaNo());

            //  bRepo.deleteAll(dlist);

            for(Buying ditem : dlist){
                bRepo.delete(ditem);
            }
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"buying failed ");

        } catch (Exception ex){
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"buying delete failed ");
        }

        return hm;
    }



    public Map<RestEnum,Object> BuyingStatusChange(String scfatno){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();
        int bfaturaNo = Integer.parseInt(scfatno);
        try{
            Buying buyingObject = new Buying();

            int objGrossPrice = buyingObject.getBgrossPrice();
            int objNetPrice   = buyingObject.getBnetPrice();
            int objTotalPrice = buyingObject.getBtotalPrice();
            int objFaturaNo = buyingObject.getBfaturaNo();
            int objDiscount = buyingObject.getPdiscount();
            int objPurType = buyingObject.getPurtype();
            String objTname = buyingObject.getTname();
            int objTaxType = buyingObject.getTaxtype();
            String objPname = buyingObject.getPname();



            List<Buying> buyingList = bRepo.getByBfaturaNoEquals(bfaturaNo);

            for (Buying buying: buyingList){
                buying.setStatus(1);
                objFaturaNo = buying.getBfaturaNo();
                objGrossPrice += buying.getBgrossPrice();
                objNetPrice += buying.getBnetPrice();
                objTotalPrice += buying.getBtotalPrice();
                objDiscount += buying.getPdiscount();
                objTname = buying.getTname();
                objPname = buying.getPname();
                objPurType = buying.getPurtype();
                objTaxType = buying.getTaxtype();


                // product vaccine güncelleme
                Integer pname = Integer.parseInt(buying.getPname());

                if(vacRepo.findById(pname).isPresent()) {
                    int temp = vacRepo.findById(pname).get().getVacstock();
                    vacRepo.findById(pname).get().setVacstock(temp + buying.getProamount());

                    Storage storage = new Storage();
                    storage.setStaction(1);
                    storage.setStdate(new Date());
                    storage.setStchangeamount(buying.getProamount());
                    storage.setStlastamount(temp + buying.getProamount());
                    storage.setStvac(vacRepo.findById(pname).get());
                    strRepo.save(storage);
                }
                else if (proRepo.findById(pname).isPresent()) {
                    int temp = proRepo.findById(pname).get().getPrstock();
                    proRepo.findById(pname).get().setPrstock(temp + buying.getProamount());

                    Storage storage = new Storage();
                    storage.setStaction(1);
                    storage.setStdate(new Date());
                    storage.setStchangeamount(buying.getProamount());
                    storage.setStlastamount(temp + buying.getProamount());
                    storage.setStpro(proRepo.findById(pname).get());
                    strRepo.save(storage);
                }
                else {
                    System.out.println("");
                }

                Authentication aut = SecurityContextHolder.getContext().getAuthentication();
                String email = aut.getName(); // username

                // KASA
                MoneyCase casec = new MoneyCase();
                casec.setCmoney(buying.getBtotalPrice());
                casec.setCbuysell(2);
                casec.setCdatenow(new Date());
                casec.setCpeople(supRepo.findById(Integer.parseInt(buying.getTname())).get().getSuname());
                casec.setCcomment("Fatura");
                casec.setCname(email);
                caRepo.save(casec);
            }

            buyingObject.setBfaturaNo(objFaturaNo);
            buyingObject.setBgrossPrice(objGrossPrice);
            buyingObject.setBnetPrice(objNetPrice);
            buyingObject.setBtotalPrice(objTotalPrice);
            buyingObject.setBuyingDate(new Date());
            buyingObject.setPdiscount(objDiscount/(buyingList.size()));
            buyingObject.setPurtype(objPurType);
            buyingObject.setTaxtype(objTaxType);
            buyingObject.setTname(objTname);
            buyingObject.setPname(objPname);

            buyingObject.setStatus(2);
            bRepo.saveAndFlush(buyingObject);
            bRepo.saveAllAndFlush(buyingList);


            // Tedarikçiye borç ekleme
            int tname = Integer.parseInt(buyingObject.getTname());
            Suppliers suppliers = supRepo.findById(tname).get();
            suppliers.setSudebt(suppliers.getSudebt()+buyingObject.getBtotalPrice());
            supRepo.saveAndFlush(suppliers);

            // List<Buying> buyings = bRepo.findByPnameEqualsIgnoreCaseAndStatusEqualsOrderByBidDesc(buyingObject.getTname(), 1);

            hm.put(RestEnum.status,"succes");

            hm.put(RestEnum.message,"status  changed ");

        }

        catch (Exception ex){
            hm.put(RestEnum.status,"failed");

            hm.put(RestEnum.message,"status  change failed "+ex.getLocalizedMessage());
        }


        return hm;
    }





    public Map<RestEnum,Object> BuyingComplatedList(){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();

        try {
            List<Buying> b= bRepo.findByStatusEquals(2);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.result,b);
            hm.put(RestEnum.message,"status complated list  changed ");

        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");

            hm.put(RestEnum.message,"status complated list  changed"+e.getLocalizedMessage());
        }


        return hm;
    }


    public Map<RestEnum,Object> BuyingDelete(String pdindex){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();
        int bid = Integer.parseInt(pdindex);
        try{
            bRepo.deleteById(bid);
            hm.put(RestEnum.status,"succes");

            hm.put(RestEnum.message,"BuyingDelete success");
        }
        catch (Exception ex ){
            hm.put(RestEnum.status,"failed");

            hm.put(RestEnum.message,"BuyingDelete failed"+ex.getLocalizedMessage());
        }


        return hm;
    }




    public Map<RestEnum,Object> BuyingDetail(String detailNo){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();

        int bfaturaNo = Integer.parseInt(detailNo);
        List<Buying> buyings = bRepo.findByBfaturaNoEqualsAndStatusEquals(bfaturaNo, 1);
        try{

            bRepo.saveAllAndFlush(buyings);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.result,buyings);
            hm.put(RestEnum.message,"BuyingDetails  ");

        }
        catch (Exception ex){
            hm.put(RestEnum.status,"failed");

            hm.put(RestEnum.message,"BuyingDetails failed"+ex.getLocalizedMessage());
        }

        return hm;
    }







}
