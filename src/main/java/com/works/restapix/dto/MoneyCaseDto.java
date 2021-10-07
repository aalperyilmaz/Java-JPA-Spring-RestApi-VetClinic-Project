package com.works.restapix.dto;

import com.works.restapix.entities.MoneyCase;
import com.works.restapix.entities.Vaccine;
import com.works.restapix.repositories.MoneyCaseRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MoneyCaseDto {

final MoneyCaseRepository moneyCaseRepository;

    public MoneyCaseDto(MoneyCaseRepository moneyCaseRepository) {
        this.moneyCaseRepository = moneyCaseRepository;
    }


    public Map<RestEnum, Object> addMoneyCase(MoneyCase moneyCase) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            MoneyCase c=  moneyCaseRepository.saveAndFlush(moneyCase);
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"The MoneyCase saved");
            hm.put(RestEnum.result,c);
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The MoneyCase saving process failed "+e.getLocalizedMessage());
        }

        return hm;
    }



    public Map<RestEnum, Object> listAllCase() {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            List<MoneyCase> ls =moneyCaseRepository.findAll();
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalMoneyCase");
            hm.put(RestEnum.result,ls);
        } catch (Exception e) {
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalMoneyCase list failed"+e.getLocalizedMessage());
        }
        return hm;
    }


    public Map<RestEnum, Object> singleMoneyCase(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id=Integer.parseInt(index);

        try {
            Optional<MoneyCase> c= moneyCaseRepository.findById(id);
            if (c .isPresent()){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"single moneyCase find");
                hm.put(RestEnum.result,c);

            }else {
                hm.put(RestEnum.status,"WARN :no such vaccc with this id->"+id);
            }
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed singleVaccFind");
        }

        return hm;
    }

    public Map<RestEnum, Object> deleteCase(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id= Integer.parseInt(index);

        try {
            moneyCaseRepository.deleteById(id);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"The vaccine has been deleted");
        } catch (Exception e) {
            hm.put(RestEnum.result,"failed");
            hm.put(RestEnum.message,"an error occurred in deleting process"+e.getLocalizedMessage());
        }

        return hm;
    }



    public Map<RestEnum, Object> addUpdateMoneyCase(MoneyCase moneyCase) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            if (moneyCase.getCid() !=null){
                MoneyCase c=  moneyCaseRepository.saveAndFlush(moneyCase);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The MoneyCase Updated");
                hm.put(RestEnum.result,c);

            }else{
                MoneyCase c=  moneyCaseRepository.saveAndFlush(moneyCase);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Vacc saved");
                hm.put(RestEnum.result,c);
            }


        } catch (Exception e) {

            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The MoneyCase saving process failed ");

        }
        return hm;
    }

}
