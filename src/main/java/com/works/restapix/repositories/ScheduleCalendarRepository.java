package com.works.restapix.repositories;


import com.works.restapix.entities.ScheduleCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScheduleCalendarRepository extends JpaRepository<ScheduleCalendar, Integer> {

    List<ScheduleCalendar> findByCalendarIdEquals(String calendarId);

    @Query(value = "SELECT * from Schedule_Calendar where id = ?1", nativeQuery = true)
    Optional<ScheduleCalendar> findScheduleId(String id);

    // son randevular
    @Query("select s from ScheduleCalendar s order by s.sid DESC")
    List<ScheduleCalendar> findByOrderBySidDesc();


}
