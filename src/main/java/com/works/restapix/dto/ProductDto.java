package com.works.restapix.dto;

import com.works.restapix.entities.Product;
import com.works.restapix.entities.Storage;
import com.works.restapix.repositories.ProductRepository;
import com.works.restapix.repositories.StorageRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductDto {
    final ProductRepository pRepo;
final StorageRepository storageRepository;

    public ProductDto(ProductRepository pRepo, StorageRepository storageRepository) {
        this.pRepo = pRepo;
        this.storageRepository = storageRepository;
    }


    public Map<RestEnum, Object> saveProduct(Product product) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            Product c=  pRepo.saveAndFlush(product);
            Storage storage = new Storage();
            Date date = new Date();
            int last_id = pRepo.findByAllIgnoreCaseOrderByPridDesc().get(0).getPrid(); // find last product id
            Optional<Product> pro1 = pRepo.findById(last_id);

            storage.setStdate(date);
            storage.setStaction(1);
            storage.setStchangeamount(pro1.get().getPrstock());
            storage.setStlastamount(pro1.get().getPrstock());
            storage.setStpro(pro1.get());
            Storage str = storageRepository.save(storage);

            hm.put(RestEnum.Warn,"storage could be effected by product ");
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"The Product saved");
            hm.put(RestEnum.result,c);
        } catch (Exception e) {
            e.printStackTrace(); hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Product saving process failed "+e.getLocalizedMessage());
        }

        return hm;
    }

    public Map<RestEnum, Object> listAllProduct() {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            List<Product> ls=pRepo.findAll();
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalProduct");
            hm.put(RestEnum.result,ls);
        } catch (Exception e) {
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalProduct list failed"+e.getLocalizedMessage());
        }

    return hm;
    }


    public Map<RestEnum, Object> singleProduct(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int cid=Integer.parseInt(index);

        try {
            Optional<Product> c= pRepo.findById(cid);
            if (c .isPresent()){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"single Product find");
                hm.put(RestEnum.result,c);

            }else {
                hm.put(RestEnum.status,"WARN :no such Product with this id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            hm.put(RestEnum.status,"WARN :no such Product with this id"+e.getLocalizedMessage());
        }


    return hm;
    }

    public Map<RestEnum, Object> deleteProduct(String index) {
        int id= Integer.parseInt(index);
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            pRepo.deleteById(id);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"The Customer has been deleted");
        } catch (Exception e) {
            hm.put(RestEnum.result,"failed");
            hm.put(RestEnum.message,"an error occurred in deleting process"+e.getLocalizedMessage());
        }

    return hm;
    }


    public Map<RestEnum, Object> updateProduct(Product product) {

        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            if (product.getPrid() !=null){
                Product c=  pRepo.saveAndFlush(product);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Supplier Updated");
                hm.put(RestEnum.result,c);

            }else{
                Product c=  pRepo.saveAndFlush(product);
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



}
