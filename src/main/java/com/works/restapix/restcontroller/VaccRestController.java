package com.works.restapix.restcontroller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.works.restapix.dto.VaccineDto;
import com.works.restapix.entities.Vaccine;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/vacc")
@Api(value="Vacc Rest Service")
public class VaccRestController {
final VaccineDto vaccineDto;

    public VaccRestController(VaccineDto vaccineDto) {
        this.vaccineDto = vaccineDto;
    }

    @PostMapping("/add")
    public Map<RestEnum, Object> addVac(@RequestBody Vaccine vaccine) {


        return  vaccineDto.addVacc(vaccine);
    }

    @GetMapping("/listAllVacc")
    public Map<RestEnum, Object> listAllVacc() {

        return vaccineDto.listAllVac();
    }

    @GetMapping("/singleVacc/{index}")
    public Map<RestEnum, Object> sngleVacc(@PathVariable String index) {

        return vaccineDto.singleVacc(index);
    }
    @GetMapping("/deleteVacc/{index}")
    public Map<RestEnum, Object> deleteVacc(@PathVariable String index) {

        return vaccineDto.deleteVacc(index);
    }

    @PostMapping("/addAndUpdate")
    public Map<RestEnum, Object> addAndUpdateVacc(@RequestBody Vaccine vaccine) {

        return  vaccineDto.addUpdate(vaccine);
    }



}
