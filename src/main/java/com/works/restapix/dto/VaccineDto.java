package com.works.restapix.dto;


import com.works.restapix.entities.Storage;
import com.works.restapix.entities.Vaccine;
import com.works.restapix.repositories.StorageRepository;
import com.works.restapix.repositories.VaccineRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VaccineDto {

    final VaccineRepository vacRepo;
    final StorageRepository storageRepository;

    public VaccineDto(VaccineRepository vacRepo, StorageRepository storageRepository) {
        this.vacRepo = vacRepo;
        this.storageRepository = storageRepository;
    }

    public Map<RestEnum, Object> addVacc( Vaccine vaccine) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            Vaccine c=  vacRepo.saveAndFlush(vaccine);

            // first add Storage
            Storage storage = new Storage();
            Date date = new Date();
            int last_id = vacRepo.findByAllIgnoreCaseOrderByVacidDesc().get(0).getVacid(); // find last vac id
            Optional<Vaccine> vaccine1 = vacRepo.findById(last_id);

            storage.setStdate(date);
            storage.setStaction(1);
            storage.setStchangeamount(vaccine1.get().getVacstock());
            storage.setStlastamount(vaccine1.get().getVacstock());
            storage.setStvac(vaccine1.get());
            Storage str = storageRepository.save(storage);

            hm.put(RestEnum.Warn,"storage could be effected by vaccine");
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"The Vaccine saved");
            hm.put(RestEnum.result,c);
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Vaccine saving process failed "+e.getLocalizedMessage());
        }

        return hm;
    }



    public Map<RestEnum, Object> listAllVac() {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            List<Vaccine> ls =vacRepo.findByAllIgnoreCaseOrderByVacidDesc();
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalCustomer");
            hm.put(RestEnum.result,ls);
        } catch (Exception e) {
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalCustomer list failed"+e.getLocalizedMessage());
        }
        return hm;
    }


    public Map<RestEnum, Object> singleVacc(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
int id=Integer.parseInt(index);

        try {
            Optional<Vaccine> c= vacRepo.findById(id);
            if (c .isPresent()){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"single vacc find");
                hm.put(RestEnum.result,c);

            }else {
                hm.put(RestEnum.status,"WARN :no such vaccc with this id->"+id);
            }
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed singleVaccFind");
        }

    return hm;
    }

    public Map<RestEnum, Object> deleteVacc(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id= Integer.parseInt(index);

        try {
            vacRepo.deleteById(id);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"The vaccine has been deleted");
        } catch (Exception e) {
            hm.put(RestEnum.result,"failed");
            hm.put(RestEnum.message,"an error occurred in deleting process"+e.getLocalizedMessage());
        }

        return hm;
    }



    public Map<RestEnum, Object> addUpdate(Vaccine vaccine) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            if (vaccine.getVacid() !=null){
                Vaccine c=  vacRepo.saveAndFlush(vaccine);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Vacc Updated");
                hm.put(RestEnum.result,c);

            }else{
                Vaccine c=  vacRepo.saveAndFlush(vaccine);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Vacc saved");
                hm.put(RestEnum.result,c);
            }


        } catch (Exception e) {

            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Vacc saving process failed ");

        }
        return hm;
    }



}
