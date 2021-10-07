package com.works.restapix.dto;

import com.works.restapix.entities.CalendarInfo;
import com.works.restapix.repositories.CalendarInfoRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CalenderInfoDto {
    final CalendarInfoRepository calenderRepo;

    public CalenderInfoDto(CalendarInfoRepository calenderRepo) {
        this.calenderRepo = calenderRepo;
    }


    public Map<RestEnum, Object> addCalender(CalendarInfo calendarInfo) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            CalendarInfo c=  calenderRepo.saveAndFlush(calendarInfo);
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"The Calender saved");
            hm.put(RestEnum.result,c);
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Calender saving process failed "+e.getLocalizedMessage());
        }

        return hm;
    }



    public Map<RestEnum, Object> listCalender() {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            List<CalendarInfo> ls =calenderRepo.findAll();
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalCalender");
            hm.put(RestEnum.result,ls);
        } catch (Exception e) {
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalAgenda list failed"+e.getLocalizedMessage());
        }
        return hm;
    }

    public Map<RestEnum, Object> singleCalender(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id=Integer.parseInt(index);

        try {
            Optional<CalendarInfo> c= calenderRepo.findById(id);
            if (c .isPresent()){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"single Calender find");
                hm.put(RestEnum.result,c);

            }else {
                hm.put(RestEnum.status,"WARN :no such CAlender with this id->"+id);
            }
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed singleCalenderFind");
        }

        return hm;
    }



    public Map<RestEnum, Object> deleteCalender(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id= Integer.parseInt(index);

        try {
            calenderRepo.deleteById(id);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"The Calender has been deleted");
        } catch (Exception e) {
            hm.put(RestEnum.result,"failed");
            hm.put(RestEnum.message,"an error occurred in deleting process"+e.getLocalizedMessage());
        }

        return hm;
    }



    public Map<RestEnum, Object> addUpdateCalender(CalendarInfo calendarInfo) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            if (calendarInfo.getCid() !=null){
                CalendarInfo c=  calenderRepo.saveAndFlush(calendarInfo);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Calender Updated");
                hm.put(RestEnum.result,c);

            }else{
                CalendarInfo c=  calenderRepo.saveAndFlush(calendarInfo);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Calender saved");
                hm.put(RestEnum.result,c);
            }


        } catch (Exception e) {

            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Calender saving process failed ");

        }
        return hm;
    }




}
