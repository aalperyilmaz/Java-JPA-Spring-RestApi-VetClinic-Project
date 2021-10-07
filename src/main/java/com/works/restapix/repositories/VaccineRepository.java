package com.works.restapix.repositories;


import com.works.restapix.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

    @Query(value = "select * from Vaccine order by vacid DESC", nativeQuery = true)
    List<Vaccine> findByAllIgnoreCaseOrderByVacidDesc();

    // last added
    @Query(value = "select * from Vaccine order by vacid DESC", nativeQuery = true)
    Optional<Vaccine> findFirstByOrderByVacidDesc();

    // active count
    @Query(value = "select count(vacid) from Vaccine where vacactive = ?1",nativeQuery = false)
    long countByVacactiveEquals(Integer vacactive);







}
