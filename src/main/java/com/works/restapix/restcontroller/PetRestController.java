package com.works.restapix.restcontroller;

import com.works.restapix.dto.PetDto;
import com.works.restapix.entities.Pet;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/pet")
@RestController
@Api(value="Pet Rest Service")
public class PetRestController {
    final PetDto petDto;

    public PetRestController(PetDto petDto) {
        this.petDto = petDto;
    }


    @PostMapping("/add")
    public Map<RestEnum,Object> petAdd(@RequestBody Pet pet){

        return petDto.addAndUpdate(pet);
    }



    @GetMapping("/delete/{index}")
    public Map<RestEnum,Object> petDelete(@PathVariable String index){

     return petDto.delete(index);
    }

    @GetMapping("/listbyId/{index}")
    public Map<RestEnum,Object> petList(@PathVariable String index ){


       return petDto.listsByCustomerId(index);
    }


    @GetMapping("/singlePEt/{index}")
    public Map<RestEnum,Object> snglPet(@PathVariable String index ){


        return petDto.findSinglePet(index);
    }



}
