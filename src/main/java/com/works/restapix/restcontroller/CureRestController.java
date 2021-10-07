package com.works.restapix.restcontroller;


import com.works.restapix.dto.CureDto;
import com.works.restapix.entities.Cure;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cure")
@Api(value="Cure Rest Service")
public class CureRestController {

    final CureDto cureDto;


    public CureRestController(CureDto cureDto) {
        this.cureDto = cureDto;
    }




    @PostMapping("/add")
    public Map<RestEnum, Object> addCure(@RequestBody Cure cure) {


        return  cureDto.addCure(cure);
    }

    @GetMapping("/listAllCure")
    public Map<RestEnum, Object> listAllCure() {

        return cureDto.listAllCure();
    }

    @GetMapping("/singleCure/{index}")
    public Map<RestEnum, Object> sngleCure(@PathVariable String index) {

        return cureDto.singleCure(index);
    }
    @GetMapping("/deleteCure/{index}")
    public Map<RestEnum, Object> deleteCure(@PathVariable String index) {

        return cureDto.deleteCure(index);
    }

    @PostMapping("/addAndUpdate")
    public Map<RestEnum, Object> addAndUpdateCure(@RequestBody Cure cure) {

        return  cureDto.addUpdateCure(cure);
    }





}
