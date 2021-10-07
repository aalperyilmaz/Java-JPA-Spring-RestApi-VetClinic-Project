package com.works.restapix.elasticmodel;

import com.works.restapix.elasticrepository.LaborElasticRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class LaborElasticDto {
final LaborElasticRepository laborElasticRepository;

    public LaborElasticDto(LaborElasticRepository laborElasticRepository) {
        this.laborElasticRepository = laborElasticRepository;
    }

    public Map<String, Object>search(String data) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Page<LaborElastic> searchPage = laborElasticRepository.findByDetailName(data, PageRequest.of(0, 10));
        List<LaborElastic> companyList = searchPage.getContent();
        hm.put("status", true);
        hm.put("result",companyList);
        return hm;
    }


}
