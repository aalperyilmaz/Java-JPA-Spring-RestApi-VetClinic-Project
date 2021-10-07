package com.works.restapix.repositories;

import com.works.restapix.entities.MoneyCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyCaseRepository extends JpaRepository<MoneyCase,Integer> {
}
