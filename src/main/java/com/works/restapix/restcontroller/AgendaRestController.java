package com.works.restapix.restcontroller;

import com.works.restapix.dto.AgendaDto;
import com.works.restapix.model.Agenda;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/agenda")
@Api(value="Agena Rest Service")
public class AgendaRestController {
final AgendaDto agendaDto;

    public AgendaRestController(AgendaDto agendaDto) {
        this.agendaDto = agendaDto;
    }

    @PostMapping("/add")
    public Map<RestEnum, Object> addVac(@RequestBody Agenda agenda) {


        return  agendaDto.agendaAdd(agenda);
    }

    @GetMapping("/listAllagenda")
    public Map<RestEnum, Object> listAllAgenda() {

        return agendaDto.agendaList();
    }

    @GetMapping("/singleAgenda/{index}")
    public Map<RestEnum, Object> sngleAgenda(@PathVariable String index) {

        return agendaDto.agendaProfile(index);
    }
    @GetMapping("/deleteAgenda/{index}")
    public Map<RestEnum, Object> deleteAgenda(@PathVariable String index) {

        return agendaDto.agendaDelete(index);
    }

    @PostMapping("/addAndUpdate")
    public Map<RestEnum, Object> addAndUpdateAgenda(@RequestBody Agenda agenda) {

        return  agendaDto.agendaUpdate(agenda);
    }



}
