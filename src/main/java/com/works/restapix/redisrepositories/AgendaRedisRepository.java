package com.works.restapix.redisrepositories;

import com.works.restapix.model.AgendaRedis;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableRedisRepositories
public interface AgendaRedisRepository extends CrudRepository<AgendaRedis,String> {
}

