package com.works.restapix.dto;

import com.works.restapix.entities.Customer;
import com.works.restapix.projections.PetCustomerProjection;
import com.works.restapix.repositories.CustomerRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class CustomerDto {
final CustomerRepository cRepo;

    public CustomerDto(CustomerRepository cRepo) {
        this.cRepo = cRepo;
    }

    public Map<RestEnum, Object> saveAndUpdatex(Customer customer){
        Map<RestEnum, Object> hm=new LinkedHashMap<>();


    try {
        if (customer.getCid() !=null){
            Customer c=  cRepo.saveAndFlush(customer);
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"The Customer Updated");
            hm.put(RestEnum.result,c);

        }else{
            Customer c=  cRepo.saveAndFlush(customer);
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"The Customer saved");
            hm.put(RestEnum.result,c);
        }


    } catch (Exception e) {

        hm.put(RestEnum.status,"failed");
        hm.put(RestEnum.message,"The customer saving process failed ");

    }


        return hm;
    }


    public Map<RestEnum, Object> listAll( ) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            List<Customer> ls=cRepo.findAll();
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalCustomer");
            hm.put(RestEnum.result,ls);
        } catch (Exception e) {
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalCustomer list failed"+e.getLocalizedMessage());
        }

        return hm;
    }


    public Map<RestEnum, Object> listPageable(int startPage,int pageSize) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        Pageable pageable = PageRequest.of(startPage, pageSize);
      List<Customer> ls=  cRepo.findByOrderByCidAsc(pageable);
        if (ls.size() != 0) {
            long totalCustomer= cRepo.countByCidAllIgnoreCase();
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"pageable list --- you are listing"+(startPage*pageSize-pageSize)+"to"+startPage*pageSize);
            hm.put(RestEnum.totalSize,"total customer size"+totalCustomer);
            hm.put(RestEnum.result,ls);
        } else {

            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.status,"Database don't have enough data ");
        }

        return hm;
    }




    public Map<RestEnum, Object> delete(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
int id= Integer.parseInt(index);

        try {
            cRepo.deleteById(id);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"The Customer has been deleted");
        } catch (Exception e) {
            hm.put(RestEnum.result,"failed");
            hm.put(RestEnum.message,"an error occurred in deleting process"+e.getLocalizedMessage());
        }

        return hm;
    }


    public Map<RestEnum, Object> searchKeyword(String keyword) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        List<Customer> ls= null;
        try {
            ls = cRepo.findByCnameContains(keyword);
        } catch (Exception e) {
            hm.put(RestEnum.result,"The customer doesn't exist with this keyword->"+keyword);
        }
        if (ls.size() != 0){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"search by name and surname for customer");
                hm.put(RestEnum.result,ls);
            }else {
                hm.put(RestEnum.status,"failed");
                hm.put(RestEnum.message,"Search by name and surname for the customer has no such value");
            }

        return hm;
    }


    public Map<RestEnum, Object> findSingleCustomer(String id) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int cid=Integer.parseInt(id);

        try {
            Optional<Customer> c= cRepo.findById(cid);
            if (c .isPresent()){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"single customer find");
                hm.put(RestEnum.result,c);

            }else {
                hm.put(RestEnum.status,"WARN :no such customer with this id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hm;
    }

}
