package com.works.restapix.repositories;


import com.works.restapix.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from Product order by prid DESC", nativeQuery = true)
    List<Product> findByAllIgnoreCaseOrderByPridDesc();

    // last added
    @Query(value = "select * from Product order by prid DESC",  nativeQuery = true)
    Optional<Product> findFirstByOrderByPridDesc();

    // active count
    @Query(value = "select count(prid) from Product where practive = ?1",nativeQuery = false)
    long countByPractiveEquals(Integer practive);



}
