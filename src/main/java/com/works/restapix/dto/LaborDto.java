package com.works.restapix.dto;

import com.works.restapix.elasticmodel.LaborElastic;
import com.works.restapix.elasticrepository.LaborElasticRepository;
import com.works.restapix.entities.Labor;
import com.works.restapix.repositories.LaborRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LaborDto {

final LaborRepository laborRepository;
final LaborElasticRepository laborElasticRepository;

    public LaborDto(LaborRepository laborRepository, LaborElasticRepository laborElasticRepository) {
        this.laborRepository = laborRepository;
        this.laborElasticRepository = laborElasticRepository;
    }


    public Map<RestEnum, Object> addLabor(Labor labor) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            Labor c=  laborRepository.saveAndFlush(labor);
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"The Labor saved");
            hm.put(RestEnum.result,c);
            LaborElastic laborElastic=new LaborElastic();
            laborElastic.setTitle(labor.getLaname());
            laborElastic.setDetail(String.valueOf(labor.getLamoney()));
           LaborElastic lbr= laborElasticRepository.save(laborElastic);
            hm.put(RestEnum.totalSize,"elastic labor addd");
           hm.put(RestEnum.Warn,lbr);

        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Labor saving process failed "+e.getLocalizedMessage());
        }

        return hm;
    }



    public Map<RestEnum, Object> listAllLabor() {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            List<Labor> ls =laborRepository.findAll();
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalLabor");
            hm.put(RestEnum.result,ls);
        } catch (Exception e) {
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalLabor list failed"+e.getLocalizedMessage());
        }
        return hm;
    }


    public Map<RestEnum, Object> singleLabor(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id=Integer.parseInt(index);

        try {
            Optional<Labor> c= laborRepository.findById(id);
            if (c .isPresent()){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"single Labor find");
                hm.put(RestEnum.result,c);

            }else {
                hm.put(RestEnum.status,"WARN :no such Labor with this id->"+id);
            }
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed singleLaborFind");
        }

        return hm;
    }

    public Map<RestEnum, Object> deleteLabor(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id= Integer.parseInt(index);

        try {
            laborRepository.deleteById(id);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"The Labor has been deleted");
        } catch (Exception e) {
            hm.put(RestEnum.result,"failed");
            hm.put(RestEnum.message,"an error occurred in deleting process"+e.getLocalizedMessage());
        }

        return hm;
    }



    public Map<RestEnum, Object> addUpdateLabor(Labor
                                                        labor) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            if (labor.getLaid() !=null){
                Labor c=  laborRepository.saveAndFlush(labor);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Labor Updated");
                hm.put(RestEnum.result,c);

            }else{
                Labor c=  laborRepository.saveAndFlush(labor);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Labor saved");
                hm.put(RestEnum.result,c);
            }


        } catch (Exception e) {

            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Labor saving process failed ");

        }
        return hm;
    }






}
