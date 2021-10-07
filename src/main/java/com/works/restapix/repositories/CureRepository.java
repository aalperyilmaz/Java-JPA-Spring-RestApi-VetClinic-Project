package com.works.restapix.repositories;


import com.works.restapix.entities.Cure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CureRepository extends JpaRepository<Cure,Integer> {

    List<Cure> findByPet_Pid(Integer pid);

    // active count
    @Query(value = "SELECT COUNT(cure.curid) FROM cure",nativeQuery = true)
    long totallab();

}
