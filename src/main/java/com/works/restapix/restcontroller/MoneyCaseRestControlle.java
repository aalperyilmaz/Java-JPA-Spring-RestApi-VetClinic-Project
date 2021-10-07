package com.works.restapix.restcontroller;


import com.works.restapix.dto.MoneyCaseDto;
import com.works.restapix.entities.MoneyCase;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/money")
@Api(value="MoneyCase Rest Service")
public class MoneyCaseRestControlle {
    final MoneyCaseDto moneyCaseDto;


    public MoneyCaseRestControlle(MoneyCaseDto moneyCaseDto) {
        this.moneyCaseDto = moneyCaseDto;
    }


    @PostMapping("/add")
    public Map<RestEnum, Object> addMoneyCase(@RequestBody MoneyCase moneyCase) {


        return  moneyCaseDto.addMoneyCase(moneyCase);
    }

    @GetMapping("/listAllMoneyCase")
    public Map<RestEnum, Object> listAllMoneyCase() {

        return moneyCaseDto.listAllCase();
    }

    @GetMapping("/singleMoneyCase/{index}")
    public Map<RestEnum, Object> sngleMoneyCase(@PathVariable String index) {

        return moneyCaseDto.singleMoneyCase(index);
    }
    @GetMapping("/deleteMoneyCase/{index}")
    public Map<RestEnum, Object> deleteMoneyCase(@PathVariable String index) {

        return moneyCaseDto.deleteCase(index);
    }

    @PostMapping("/addAndUpdate")
    public Map<RestEnum, Object> addAndUpdateMoneyCase(@RequestBody MoneyCase moneyCase) {

        return  moneyCaseDto.addUpdateMoneyCase(moneyCase);
    }







}
