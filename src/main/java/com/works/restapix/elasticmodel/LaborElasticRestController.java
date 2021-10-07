package com.works.restapix.elasticmodel;

import com.works.restapix.utils.RestEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("laborElastic")
public class LaborElasticRestController {
    final LaborElasticDto laborElasticDto;

    public LaborElasticRestController(LaborElasticDto laborElasticDto) {
        this.laborElasticDto = laborElasticDto;
    }

    @GetMapping("list/{index}")
    public Map<String,Object> laborElastic(@PathVariable String index){
    Map <RestEnum,Object> hm =new LinkedHashMap<>();

    return laborElasticDto.search(index);
}

}
