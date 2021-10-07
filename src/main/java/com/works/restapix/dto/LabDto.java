package com.works.restapix.dto;

import com.works.restapix.repositories.LabRepository;
import com.works.restapix.repositories.PetRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class LabDto {

    final LabRepository labRepository;


  final PetRepository petRepository;


    public LabDto(LabRepository labRepository, PetRepository petRepository) {
        this.labRepository = labRepository;
        this.petRepository = petRepository;
    }


    private final String UPLOAD_DIR =  "src/main/resources/static/uploads/";
    long maxFileUploadSize = 20048;

    int sendCount = 0;
    int sendSuccessCount = 0;
    String errorMessage = "";




    public Map<RestEnum, Object> LabInsert() {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();



        return hm;
    }









}
