package com.works.restapix.dto;

import com.works.restapix.entities.Cure;
import com.works.restapix.entities.Vaccine;
import com.works.restapix.repositories.CureRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CureDto {

    final CureRepository cureRepository;

    public CureDto(CureRepository cureRepository) {
        this.cureRepository = cureRepository;
    }

    public Map<RestEnum, Object> addCure(Cure cure) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            Cure c=  cureRepository.saveAndFlush(cure);
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"The Cure saved");
            hm.put(RestEnum.result,c);
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Cure saving process failed "+e.getLocalizedMessage());
        }

        return hm;
    }



    public Map<RestEnum, Object> listAllCure() {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            List<Cure> ls =cureRepository.findAll();
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalCure");
            hm.put(RestEnum.result,ls);
        } catch (Exception e) {
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalCure list failed"+e.getLocalizedMessage());
        }
        return hm;
    }


    public Map<RestEnum, Object> singleCure(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id=Integer.parseInt(index);

        try {
            Optional<Cure> c= cureRepository.findById(id);
            if (c .isPresent()){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"single cure find");
                hm.put(RestEnum.result,c);

            }else {
                hm.put(RestEnum.status,"WARN :no such cure with this id->"+id);
            }
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed singleCureFind");
        }

        return hm;
    }

    public Map<RestEnum, Object> deleteCure(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id= Integer.parseInt(index);

        try {
            cureRepository.deleteById(id);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"The Cure has been deleted");
        } catch (Exception e) {
            hm.put(RestEnum.result,"failed");
            hm.put(RestEnum.message,"an error occurred in deleting process"+e.getLocalizedMessage());
        }

        return hm;
    }



    public Map<RestEnum, Object> addUpdateCure(Cure cure) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            if (cure.getCurid() !=null){
                Cure c=  cureRepository.saveAndFlush(cure);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Cure Updated");
                hm.put(RestEnum.result,c);

            }else{
                Cure c=  cureRepository.saveAndFlush(cure);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Cure saved");
                hm.put(RestEnum.result,c);
            }


        } catch (Exception e) {

            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Cure saving process failed ");

        }
        return hm;
    }






}
