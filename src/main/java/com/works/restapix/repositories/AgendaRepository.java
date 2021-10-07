package com.works.restapix.repositories;


import com.works.restapix.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, String> {

    @Query(value = "select * from Agenda order by agid DESC", nativeQuery = true)
    List<Agenda> findByOrderByAgidDesc();

}
