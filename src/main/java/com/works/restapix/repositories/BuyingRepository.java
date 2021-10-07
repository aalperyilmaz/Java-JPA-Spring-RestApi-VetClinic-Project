package com.works.restapix.repositories;



import com.works.restapix.entities.Buying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BuyingRepository extends JpaRepository<Buying, Integer> {

   List<Buying> findByStatusEquals(int status);

   Buying findByBidEquals(Integer bid);

   List<Buying> getByBfaturaNoEquals(int bfaturaNo);

  List<Buying> findByBfaturaNoEqualsAndStatusEquals(int bfaturaNo, int status);

  List<Buying> getByBfaturaNoEqualsAndStatusEquals(int bfaturaNo, int status);

    // tedarikçi id
    @Query("select b from Buying b where b.tname = ?1 and b.status = ?2 order by b.bid DESC")
    List<Buying> findByTnameEqualsAndStatusEqualsOrderByBidDesc(String tname, int status);

    // product id
    @Query("select b from Buying b where upper(b.pname) = upper(?1) and b.status = ?2 order by b.bid DESC")
    List<Buying> findByPnameEqualsIgnoreCaseAndStatusEqualsOrderByBidDesc(String pname, int status);






}
