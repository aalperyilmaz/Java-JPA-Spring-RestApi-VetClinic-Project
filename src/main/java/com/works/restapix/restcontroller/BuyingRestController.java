package com.works.restapix.restcontroller;

import com.works.restapix.dto.BuyingDto;
import com.works.restapix.entities.Buying;
import com.works.restapix.entities.Vaccine;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/buying")
@Api(value="Buying Rest Service")
public class BuyingRestController {

    final BuyingDto buyingDto;

    public BuyingRestController(BuyingDto buyingDto) {
        this.buyingDto = buyingDto;
    }


    @PostMapping("/add")
    public Map<RestEnum, Object> bInsert(@RequestBody Buying buying) {


        return  buyingDto.BuyingInsert(buying);
    }



    @GetMapping("/buyingDetail/{index}")
    public Map<RestEnum, Object> buyingDetail(@PathVariable String index) {

        return buyingDto.BuyingDetail(index);
    }
    @GetMapping("/deleteBuying/{index}")
    public Map<RestEnum, Object> deletebuying(@PathVariable String index) {

        return buyingDto.BuyingDelete(index);
    }

    @GetMapping("/list")
    public Map<RestEnum, Object> buyingList() {

        return  buyingDto.BuyingComplatedList();
    }

    @GetMapping("/buyigstChange/{index}")
    public Map<RestEnum, Object> buyingStatusChange(@PathVariable String index) {

        return buyingDto.BuyingStatusChange(index);
    }



}
