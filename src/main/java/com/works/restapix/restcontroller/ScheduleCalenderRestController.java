package com.works.restapix.restcontroller;


import com.works.restapix.dto.ScheduleCalenderDto;
import com.works.restapix.entities.ScheduleCalendar;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/scheduleCallender")
@Api(value="Schedule Calender Rest Service")
public class ScheduleCalenderRestController {

final ScheduleCalenderDto scheduleCalenderDto;

    public ScheduleCalenderRestController(ScheduleCalenderDto scheduleCalenderDto) {
        this.scheduleCalenderDto = scheduleCalenderDto;
    }


    @PostMapping("/add")
    public Map<RestEnum, Object> addScheduleCalendar(@RequestBody ScheduleCalendar scheduleCalendar) {


        return  scheduleCalenderDto.addCalendar(scheduleCalendar);
    }

    @GetMapping("/listAllSchedule")
    public Map<RestEnum, Object> listAllScheduleCalendar() {

        return scheduleCalenderDto.calendarList();
    }

    @GetMapping("/singleSchedule/{index}")
    public Map<RestEnum, Object> sngleScheduleCalendar(@PathVariable String index) {

        return scheduleCalenderDto.singleCalendar(index);
    }
    @GetMapping("/deleteSchedule/{index}")
    public Map<RestEnum, Object> deleteScheduleCalendar(@PathVariable String index) {

        return scheduleCalenderDto.deleteSchCalendars(index);
    }

    @PostMapping("/addAndUpdate")
    public Map<RestEnum, Object> addAndUpdateScheduleCalendar(@RequestBody ScheduleCalendar scheduleCalendar) {

        return  scheduleCalenderDto.updateCalendar(scheduleCalendar);
    }






}
