package com.works.restapix.dto;

import com.works.restapix.entities.Customer;
import com.works.restapix.entities.Suppliers;
import com.works.restapix.repositories.SuppliersRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SupplierDto {

final SuppliersRepository sRepo;

    public SupplierDto(SuppliersRepository sRepo) {
        this.sRepo = sRepo;
    }

    public Map<RestEnum, Object> SupplierAddUpdate(Suppliers suppliers) {
        Map<RestEnum, Object> hm=new LinkedHashMap<>();

        try {
            if (suppliers.getSuid() !=null){
                Suppliers c=  sRepo.saveAndFlush(suppliers);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Supplier Updated");
                hm.put(RestEnum.result,c);

            }else{
                Suppliers c=  sRepo.saveAndFlush(suppliers);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Supplier saved");
                hm.put(RestEnum.result,c);
            }


        } catch (Exception e) {

            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Supplier saving process failed ");

        }

        return hm;
    }

    public Map<RestEnum, Object> SupplierfindId(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int cid=Integer.parseInt(index);

        try {
            Optional<Suppliers> c= sRepo.findById(cid);
            if (c .isPresent()){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"single Supplier find");
                hm.put(RestEnum.result,c);

            }else {
                hm.put(RestEnum.status,"WARN :no such Supplier with this id->"+cid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hm;
    }

    public Map<RestEnum, Object> Supplierdelete(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int pid=Integer.parseInt(index);


        try {
            sRepo.deleteById(pid);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"The Supplier has been deleted");

        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"an error occurred in Supplier deleting action "+e.getLocalizedMessage());

        }

    return hm;
    }



}
