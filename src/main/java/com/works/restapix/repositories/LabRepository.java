package com.works.restapix.repositories;


import com.works.restapix.entities.Lab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LabRepository extends JpaRepository<Lab, Integer> {

    List<Lab> findByOrderByLidDesc();

    @Query("select l from Lab l where l.pid.pid = ?1 order by l.lid DESC")
    List<Lab> findByPid_PidEqualsOrderByLidDesc(Integer pid);


}
