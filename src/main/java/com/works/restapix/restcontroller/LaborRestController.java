package com.works.restapix.restcontroller;

import com.works.restapix.dto.LaborDto;
import com.works.restapix.entities.Labor;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/labor")
@Api(value="Labor Rest Service")
public class LaborRestController {
final LaborDto laborDto;

    public LaborRestController(LaborDto laborDto) {
        this.laborDto = laborDto;
    }


    @PostMapping("/add")
    public Map<RestEnum, Object> addlabor(@RequestBody Labor labor) {


        return  laborDto.addLabor(labor);
    }

    @GetMapping("/listAllLabor")
    public Map<RestEnum, Object> listAllLabor() {

        return laborDto.listAllLabor();
    }

    @GetMapping("/singleLabor/{index}")
    public Map<RestEnum, Object> sngleAgenda(@PathVariable String index) {

        return laborDto.singleLabor(index);
    }
    @GetMapping("/deleteLabor/{index}")
    public Map<RestEnum, Object> deleteAgenda(@PathVariable String index) {

        return laborDto.deleteLabor(index);
    }

    @PostMapping("/addAndUpdate")
    public Map<RestEnum, Object> addAndUpdateAgenda(@RequestBody Labor labor) {

        return  laborDto.addUpdateLabor(labor);
    }





}
