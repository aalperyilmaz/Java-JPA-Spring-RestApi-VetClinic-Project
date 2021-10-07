package com.works.restapix.restcontroller;

import com.works.restapix.dto.SaleDto;
import com.works.restapix.entities.Sale;
import com.works.restapix.entities.User;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sale")
@Api(value="Sale Rest Service")
public class SaleRestController {
    final SaleDto saleDto;


    public SaleRestController(SaleDto saleDto) {
        this.saleDto = saleDto;
    }

    @GetMapping("/saleStatus/{index}")
    public Map<RestEnum, Object> saleStatus(@PathVariable String index) {

        return saleDto.StatusChange(index);
    }
    @GetMapping("/deleteSale/{index}")
    public Map<RestEnum, Object> deleteSale(@PathVariable String index) {

        return saleDto.SaleDelete(index);
    }

    @PostMapping("/SaleInsert")
    public Map<RestEnum, Object> SaleInsert(@RequestBody Sale sale) {

        return  saleDto.SaleInsert(sale);
    }



}
