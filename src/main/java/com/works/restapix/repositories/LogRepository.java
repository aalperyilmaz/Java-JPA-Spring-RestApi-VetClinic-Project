package com.works.restapix.repositories;


import com.works.restapix.entities.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Logger, Integer> {
}
