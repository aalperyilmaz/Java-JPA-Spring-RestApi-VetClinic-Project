package com.works.restapix.elasticrepository;


import com.works.restapix.elasticmodel.LaborElastic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface LaborElasticRepository extends ElasticsearchRepository<LaborElastic, String> {
    @Query("{\"bool\":{\"must\":[],\"must_not\":[],\"should\":[{\"match\":{\"title\":\"?0\"}}]}},\"from\":0,\"size\":10,\"sort\":[],\"aggs\":{}}")
    Page<LaborElastic> findByDetailName(String name, Pageable pageable );

}
