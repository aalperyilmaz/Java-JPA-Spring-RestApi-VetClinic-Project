package com.works.restapix.dto;

import com.works.restapix.entities.ScheduleCalendar;
import com.works.restapix.entities.Storage;
import com.works.restapix.repositories.ScheduleCalendarRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ScheduleCalenderDto {

    final ScheduleCalendarRepository schCalender;

    public ScheduleCalenderDto(ScheduleCalendarRepository schCalender) {
        this.schCalender = schCalender;
    }


    public Map<RestEnum, Object> addCalendar(ScheduleCalendar calendar) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {
            ScheduleCalendar c=  schCalender.saveAndFlush(calendar);
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"The calendar saved");
            hm.put(RestEnum.result,c);
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The calendar saving process failed "+e.getLocalizedMessage());
        }

        return hm;
    }

    public Map<RestEnum, Object> updateCalendar(ScheduleCalendar calendar) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            if (calendar.getCalendarId() !=null){
                ScheduleCalendar c=  schCalender.saveAndFlush(calendar);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The calendar Updated");
                hm.put(RestEnum.result,c);

            }else{
                ScheduleCalendar c=  schCalender.saveAndFlush(calendar);
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"The Storage saved");
                hm.put(RestEnum.result,c);
            }


        } catch (Exception e) {

            hm.put(RestEnum.status,"failed");
            hm.put(RestEnum.message,"The Storage saving process failed ");

        }
        return hm;
    }






    public Map<RestEnum, Object> calendarList( ) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            List<ScheduleCalendar> ls =schCalender.findAll();
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalStorage");
            hm.put(RestEnum.result,ls);
        } catch (Exception e) {
            hm.put(RestEnum.status,"success");
            hm.put(RestEnum.message,"totalStorage list failed"+e.getLocalizedMessage());
        }
        return hm;
    }

    public Map<RestEnum, Object> singleCalendar(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        int id=Integer.parseInt(index);

        try {
            Optional<ScheduleCalendar> c= schCalender.findById(id);
            if (c .isPresent()){
                hm.put(RestEnum.status,"success");
                hm.put(RestEnum.message,"single calendar find");
                hm.put(RestEnum.result,c);

            }else {
                hm.put(RestEnum.status,"WARN :no such calendar with this id->"+id);
            }
        } catch (Exception e) {
            hm.put(RestEnum.status,"failed singleCalendarFind");
        }

        return hm;
    }

    public Map<RestEnum, Object> deleteSchCalendars(String index) {

        Map<RestEnum, Object> hm =  new LinkedHashMap<>();
        int id= Integer.parseInt(index);

        try {
            schCalender.deleteById(id);
            hm.put(RestEnum.status,"succes");
            hm.put(RestEnum.message,"The Storage has been deleted");
        } catch (Exception e) {
            hm.put(RestEnum.result,"failed");
            hm.put(RestEnum.message,"an error occurred in deleting process"+e.getLocalizedMessage());
        }

        return hm;
    }




}
