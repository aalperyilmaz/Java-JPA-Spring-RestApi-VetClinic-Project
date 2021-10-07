package com.works.restapix.repositories;


import com.works.restapix.entities.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SuppliersRepository extends JpaRepository<Suppliers, Integer> {

    @Query(value = "select * from Suppliers order by suid DESC", nativeQuery = true)
    List<Suppliers> findByOrderBySuidDesc();

}
