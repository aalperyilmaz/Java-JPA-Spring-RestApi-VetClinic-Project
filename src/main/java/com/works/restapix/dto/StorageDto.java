package com.works.restapix.dto;

import com.works.restapix.entities.Storage;
import com.works.restapix.entities.Vaccine;
import com.works.restapix.repositories.StorageRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StorageDto {
final StorageRepository sRepo;

    public StorageDto(StorageRepository sRepo) {
        this.sRepo = sRepo;
    }

    public Map<RestEnum, Object> addStorage(Storage storage) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            Storage c=  sRepo.saveAndFlush(storage);
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"The storage saved");
            hm.put(RestEnum.result,c);
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The storage saving process failed "+e.getLocalizedMessage());
        }

    return hm;
    }

    public Map<RestEnum, Object> updateStorage(Storage storage) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

            try {
                if (storage.getStid() !=null){
                    Storage c=  sRepo.saveAndFlush(storage);
                    hm.put(RestEnum.status,"success");
                    hm.put(RestEnum.message,"The Storage Updated");
                    hm.put(RestEnum.result,c);

                }else{
                    Storage c=  sRepo.saveAndFlush(storage);
                    hm.put(RestEnum.status,"success");
                    hm.put(RestEnum.message,"The Storage saved");
                    hm.put(RestEnum.result,c);
                }


            } catch (Exception e) {

                hm.put(RestEnum.status,"failed");
                hm.put(RestEnum.message,"The Storage saving process failed ");

            }
            return hm;
        }






    public Map<RestEnum, Object> storageList( ) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            List<Storage> ls =sRepo.findAll();
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalStorage");
            hm.put(RestEnum.result,ls);
        } catch (Exception e) {
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalStorage list failed"+e.getLocalizedMessage());
        }
        return hm;
    }

    public Map<RestEnum, Object> singleStorage(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id=Integer.parseInt(index);

        try {
            Optional<Storage> c= sRepo.findById(id);
            if (c .isPresent()){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"single Storage find");
                hm.put(RestEnum.result,c);

            }else {
                hm.put(RestEnum.status,"WARN :no such Storage with this id->"+id);
            }
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed singleStorageFind");
        }

        return hm;
    }

    public Map<RestEnum, Object> deleteStorage(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id= Integer.parseInt(index);

        try {
            sRepo.deleteById(id);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"The Storage has been deleted");
        } catch (Exception e) {
            hm.put(RestEnum.result,"failed");
            hm.put(RestEnum.message,"an error occurred in deleting process"+e.getLocalizedMessage());
        }

        return hm;
    }





}
