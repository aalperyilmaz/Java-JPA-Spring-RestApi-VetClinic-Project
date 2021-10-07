package com.works.restapix.restcontroller;

import com.works.restapix.entities.Lab;
import com.works.restapix.entities.Pet;
import com.works.restapix.properties.LabProp;
import com.works.restapix.repositories.LabRepository;
import com.works.restapix.repositories.PetRepository;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import java.io.IOException;

@RestController
@RequestMapping("/lab")
@Api(value="Lab Rest Service")
public class LabRestController {

    final LabRepository labRepository;
final PetRepository petRepository;
    public LabRestController(LabRepository labRepository, PetRepository petRepository) {
        this.labRepository = labRepository;
        this.petRepository = petRepository;
    }


    private final String UPLOAD_DIR =  "src/main/resources/static/uploads/";
    long maxFileUploadSize = 2048;


    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("fileName") MultipartFile file, LabProp labProp) {
        int sendSuccessCount = 0;
        String errorMessage = "";
        Map<String, Object> hm = new LinkedHashMap<>();

        if (!file.isEmpty() ) {
            long fileSizeMB = file.getSize() / 1024;
            if ( fileSizeMB > maxFileUploadSize ) {
                System.err.println("Dosya boyutu çok büyük Max 2MB");
                errorMessage = "Dosya boyutu çok büyük Max "+ (maxFileUploadSize / 1024) +"MB olmalıdır";
            }else {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                String ext = fileName.substring(fileName.length()-5, fileName.length());
                String uui = UUID.randomUUID().toString();
                fileName = uui + ext;
                try {
                    Path path = Paths.get(UPLOAD_DIR + fileName);
                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                    sendSuccessCount += 1;

                    // add database
                    System.out.println(labProp);
                    //image.setPid(pid);
                    Lab lab=new Lab();
                    lab.setLcomment(labProp.getLcomment());
                    lab.setLtitle(labProp.getLtitle());
                    lab.setFileName(fileName);
                   lab.setPid( petRepository.findById(labProp.getPid()).get());
                    lab.setLdate(new Date());
                   labRepository.save(lab);

                    //image.setFileName(fileName);
                    //piRepo.save(image);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            errorMessage = "Lütfen resim seçiniz!";
        }

        if ( errorMessage.equals("") ) {
            hm.put("status", true);
            hm.put("message", "Yükleme Başarılı");
        }else {
            hm.put("status", false);
            hm.put("message", errorMessage);
        }

        return hm;
    }

    @GetMapping("deleteLabresult/{iid}")
    public Map<RestEnum, Object> deleteLabresult(@PathVariable String iid ) {
        Map<RestEnum, Object> hm =new LinkedHashMap<>();
        try {
            int ciid = Integer.parseInt( iid );
            Optional<Lab> opi = labRepository.findById(ciid);
            if ( opi.isPresent() ) {
                labRepository.deleteById(ciid);
                // file delete
                String deleteFilePath = opi.get().getFileName();
                File file = new File(UPLOAD_DIR+deleteFilePath);
                file.delete();
                hm.put(RestEnum.status,"succes");
                hm.put(RestEnum.message,"lab result deleted");
            }
        }catch (Exception ex) {
           hm.put(RestEnum.status,"succes");
           hm.put(RestEnum.message,"Silme işlemi sırasında bir hata oluştu!"+ex.getLocalizedMessage());
        }
       return hm;
    }

}
