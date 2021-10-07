package com.works.restapix.restcontroller;

import com.works.restapix.dto.StatisticDto;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/statistic")
@Api(value="Statistic Rest Service")
public class StatisticRestController {


    final StatisticDto stDto;

    public StatisticRestController(StatisticDto stDto) {
        this.stDto = stDto;
    }

    @GetMapping("/list")
    public Map<String, Object> agendaList() {

        return stDto.list();
    }



}
