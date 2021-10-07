package com.works.restapix.restcontroller;

import com.works.restapix.dto.CalenderInfoDto;
import com.works.restapix.entities.CalendarInfo;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/calenderInfo")
@Api(value="Calender Rest Service")
public class CalenderInfoRestController {

    final CalenderInfoDto calenderInfoDto;

    public CalenderInfoRestController(CalenderInfoDto calenderInfoDto) {
        this.calenderInfoDto = calenderInfoDto;
    }

    @PostMapping("/add")
    public Map<RestEnum, Object> addCalender(@RequestBody CalendarInfo calendarInfo) {


        return  calenderInfoDto.addCalender(calendarInfo);
    }

    @GetMapping("/listCalender")
    public Map<RestEnum, Object> listAllCalender() {

        return calenderInfoDto.listCalender();
    }

    @GetMapping("/singleCalender/{index}")
    public Map<RestEnum, Object> sngleCalender(@PathVariable String index) {

        return calenderInfoDto.singleCalender(index);
    }
    @GetMapping("/deleteCalender/{index}")
    public Map<RestEnum, Object> deleteCalender(@PathVariable String index) {

        return calenderInfoDto.deleteCalender(index);
    }

    @PostMapping("/addAndUpdate")
    public Map<RestEnum, Object> addAndUpdateCalender(@RequestBody CalendarInfo calendarInfo) {

        return  calenderInfoDto.addUpdateCalender(calendarInfo);
    }



}
