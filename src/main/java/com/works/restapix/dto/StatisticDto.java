package com.works.restapix.dto;

import com.works.restapix.repositories.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class StatisticDto {


        final CustomerRepository cuRepo;
        final CaseRepository caRepo;
        final StorageRepository stRepo;
        final VaccineRepository vacRepo;
        final ProductRepository prRepo;
        final PetRepository petRepo;
        final CureRepository cureRepo;
        final ScheduleCalendarRepository calRepo;

    public StatisticDto(CustomerRepository cuRepo, CaseRepository caRepo, StorageRepository stRepo, VaccineRepository vacRepo, ProductRepository prRepo, PetRepository petRepo, CureRepository cureRepo, ScheduleCalendarRepository calRepo) {
        this.cuRepo = cuRepo;
        this.caRepo = caRepo;
        this.stRepo = stRepo;
        this.vacRepo = vacRepo;
        this.prRepo = prRepo;
        this.petRepo = petRepo;
        this.cureRepo = cureRepo;
        this.calRepo = calRepo;
    }


    public Map<String, Object> list() {
            Map<String, Object> hm = new LinkedHashMap<>();

            try {
                hm.put("Status", "Success!");
                hm.put("Message", "İstatistik verileri aşağıya listelendi.");
                String dateparse = new String();
                dateparse = String.valueOf(new Date().getDate());
                long cuCount = cuRepo.countByCdateLike(dateparse);
                hm.put("Customer Count", cuCount);


                long moneyCount1 = 0;
                try {
                    moneyCount1 = caRepo.countByCdatenowLike1(dateparse);
                } catch (Exception e) {
                    moneyCount1 = 0;
                }

                long moneyCount2 = 0;
                try {
                    moneyCount2 = caRepo.countByCdatenowLike2(dateparse);
                } catch (Exception e) {
                    moneyCount2 = 0;
                }

                hm.put("Money", moneyCount1 - moneyCount2);

                long storage = stRepo.sumlastamount();
                hm.put("Storage", storage);

                long totalVaccine = vacRepo.countByVacactiveEquals(1);
                hm.put("Total Vaccine", totalVaccine);

                long totalProduct = prRepo.countByPractiveEquals(1);
                hm.put("Total Product", totalProduct);

                long totalPet = petRepo.totalpet();
                hm.put("Total Pet", totalPet);

                long totallab = cureRepo.totallab();
                hm.put("Total Lab", totallab);


            } catch (Exception ex) {
                hm.put("Status", "Failed!");
                hm.put("Message", "İstatistik verileri listelenemedi Ex:" + ex.getLocalizedMessage());
            }
            return hm;
        }






    }

