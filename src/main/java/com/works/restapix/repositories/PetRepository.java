package com.works.restapix.repositories;


import com.works.restapix.entities.Customer;
import com.works.restapix.entities.Pet;
import com.works.restapix.projections.PetProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    // Cid e göre pet bilgileri
    @Query(value = "select * from Pet  where upper(Pet .cid) = upper(?1)",nativeQuery = true)
    List<Pet> findByCid_CidIsAllIgnoreCase(Customer customer);

    // Cid e göre
    List<Pet> findByCid_CidEquals(Integer cid);

    @Query("select p from Pet p where p.cid.cid = ?1")
    List<Pet> notstackoverflow(Integer cid);



    // active count
    @Query(value = "SELECT COUNT(pet.pid) FROM pet",nativeQuery = true)
    long totalpet();


}