package com.works.restapix.repositories;


import com.works.restapix.entities.CalendarInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarInfoRepository extends JpaRepository<CalendarInfo, Integer> {
}
