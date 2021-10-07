package com.works.restapix.repositories;


import com.works.restapix.entities.Product;
import com.works.restapix.entities.Storage;
import com.works.restapix.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Integer> {

    // Gönderilen vaccine ait depo işlemleri
    @Query(value = "select * from Storage where upper(stvac) = upper(?1) order by stid DESC LIMIT 6", nativeQuery = true)
    List<Storage> findByStvacEqualsAllIgnoreCaseOrderByStidDesc(Vaccine stvac);

    // Gönderilen product ait depo işlemleri
    @Query(value = "select * from Storage where upper(stpro) = upper(?1) order by stid DESC LIMIT 6", nativeQuery = true)
    List<Storage> findByStproEqualsAllIgnoreCaseOrderByStidDesc(Product product);

    // Depo Ürünleri
    @Query(value = "SELECT * from storage group by stvac, stpro order by stid DESC", nativeQuery = true)
    List<Storage> findByOrderByStidDesc();

    // Son 10 Depo işlemini sıralama
    @Query(value = "select * from Storage order by stdate DESC LIMIT 10",nativeQuery = true)
    List<Storage> findByOrderByStdateDesc();

    // Depo Ürünleri Toplam
    @Query(value = "SELECT SUM(stlastamount) from storage", nativeQuery = true)
    long sumlastamount();

}
