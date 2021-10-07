package com.works.restapix.repositories;


import com.works.restapix.entities.MoneyCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaseRepository extends JpaRepository<MoneyCase, Integer> {

    // buy ekle
    @Query(value = "SELECT SUM(cmoney) FROM money_case WHERE cdatenow LIKE %:keyword% AND money_case.cbuysell = 1",nativeQuery = true)
    long countByCdatenowLike1(@Param("keyword") String cdate);

    // buy çıkar
    @Query(value = "SELECT SUM(cmoney) FROM money_case WHERE cdatenow LIKE %:keyword% AND money_case.cbuysell = 2",nativeQuery = true)
    long countByCdatenowLike2(@Param("keyword") String cdate);

    // listeleme desc
    @Query("select m from MoneyCase m order by m.cid DESC")
    List<MoneyCase> findByOrderByCidDesc();


}
