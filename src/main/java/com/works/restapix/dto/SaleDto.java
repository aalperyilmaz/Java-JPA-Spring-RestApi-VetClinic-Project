package com.works.restapix.dto;


import com.works.restapix.entities.MoneyCase;
import com.works.restapix.entities.Sale;
import com.works.restapix.repositories.MoneyCaseRepository;
import com.works.restapix.repositories.SaleRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleDto {

    final SaleRepository saleRepository;
   final MoneyCaseRepository cRepo;


    public SaleDto(SaleRepository saleRepository, MoneyCaseRepository cRepo) {
        this.saleRepository = saleRepository;
        this.cRepo = cRepo;
    }


    public Map<RestEnum,Object> SaleInsert(Sale sale){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();

        try{ sale.setSaleDate(new Date());
            float tax=0.3f;
            sale.setGrossPrice(sale.getPamount()*sale.getPprice());
            sale.setNetPrice(sale.getGrossPrice()-sale.getGrossPrice()*sale.getPdiscount()/100);
            if(sale.getTax_type()==0){
                tax = 0;
            }
            else if(sale.getTax_type()==1){
                tax = 0.01f;
            }
            else if(sale.getTax_type()==2){
                tax = 0.08f;
            }
            else if(sale.getTax_type()==3){
                tax = 0.18f;
            }

            sale.setTotalPrice((int) (sale.getNetPrice()*(1+tax)));

            Sale s = saleRepository.save(sale);

            Authentication aut = SecurityContextHolder.getContext().getAuthentication();
            String email = aut.getName(); // username

            // KASA
            MoneyCase casec = new MoneyCase();
            casec.setCmoney(sale.getTotalPrice());
            casec.setCbuysell(1);
            casec.setCdatenow(new Date());
            casec.setCpeople(sale.getCname());
            casec.setCcomment("Satış");
            casec.setCname(email);
            cRepo.save(casec);

            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.result,sale);
            hm.put(RestEnum.message,"sale saved");
        }
        catch (Exception ex){
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"save  failed ");
        }

    return hm;
    }




    public Map<RestEnum,Object> SaleDelete(String index){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();

        try{
            int sid = Integer.parseInt(index);
            saleRepository.deleteById(sid);
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"Sale deleted");


        } catch (Exception ex){
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"Sale delete failed");
        }


    return hm;
    }


    public Map<RestEnum,Object> StatusChange(String index){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();

        try{
            int faturaNo = Integer.parseInt(index);
            List<Sale> saleList = saleRepository.getByFaturaNoEquals(faturaNo);

            for (Sale sale: saleList){

                sale.setStatus(true);
            }

            saleRepository.saveAllAndFlush(saleList);
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"status change  ");
            hm.put(RestEnum.result,"OK");

        }

        catch (Exception ex){
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"status change failed");
        }


        return hm;
    }





    }
