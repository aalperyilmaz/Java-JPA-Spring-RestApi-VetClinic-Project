package com.works.restapix.dto;

import com.works.restapix.entities.Customer;
import com.works.restapix.entities.Pet;
import com.works.restapix.projections.PetCustomerProjection;
import com.works.restapix.projections.PetProjection;
import com.works.restapix.repositories.CustomerRepository;
import com.works.restapix.repositories.PetRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PetDto {
final PetRepository pRepo;
final CustomerRepository cRepo;

    public PetDto(PetRepository pRepo, CustomerRepository cRepo) {
        this.pRepo = pRepo;
        this.cRepo = cRepo;
    }

    public Map<RestEnum, Object> addAndUpdate(Pet pet) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {

            if (pet.getCid() != null) {
                Pet p= pRepo.saveAndFlush(pet);
                hm.put(RestEnum.status, "success");
                hm.put(RestEnum.message, "The pet saved");
                hm.put(RestEnum.result, p);
            }
            if (pet.getCid() == null){
                Pet p= pRepo.saveAndFlush(pet);
                hm.put(RestEnum.status, "success");
                hm.put(RestEnum.message, "The pet updated");
                hm.put(RestEnum.result, p);
            }
        } catch (Exception e) {
            hm.put(RestEnum.status, "failed");
            hm.put(RestEnum.message, "an error occurred in saving process "+e.getLocalizedMessage());
        }


        return hm;
    }

    public Map<RestEnum, Object> delete(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int pid=Integer.parseInt(index);


        try {
           pRepo.deleteById(pid);
        hm.put(RestEnum.status,"succes");
        hm.put(RestEnum.message,"The Pet has been deleted");

        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"an error occurred in deleting action "+e.getLocalizedMessage());

        }
        return hm;
    }


    public Map<RestEnum, Object> listsByCustomerId(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        Integer cidx=Integer.parseInt(index);
        try {
         /* List<PetCustomerProjection> c=cRepo.findByAllIgnoreCaseOrderByCidDesc()*/;
            System.out.println();


            List<Pet> petList= pRepo.findByCid_CidIsAllIgnoreCase( cRepo.findById(cidx).get());
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.result,petList);
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"listing by custumer id failed"+ e.getLocalizedMessage());

        }

        return hm;
    }



    public Map<RestEnum, Object> findSinglePet(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        Integer cidx=Integer.parseInt(index);
        try {
            /* List<PetCustomerProjection> c=cRepo.findByAllIgnoreCaseOrderByCidDesc()*/;



            Pet petList= pRepo.findById(cidx).get();
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.result,petList);
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"single pet id failed"+ e.getLocalizedMessage());

        }

        return hm;
    }






}
