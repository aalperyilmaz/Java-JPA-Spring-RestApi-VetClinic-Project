package com.works.restapix.dto;

import com.works.restapix.model.Agenda;
import com.works.restapix.model.AgendaRedis;
import com.works.restapix.redisrepositories.AgendaRedisRepository;
import com.works.restapix.repositories.AgendaRepository;
import com.works.restapix.utils.RestEnum;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AgendaDto {

    final AgendaRepository agendaRepository;
    final AgendaRedisRepository agendaRedisRepository;

    public AgendaDto(AgendaRepository agendaRepository, AgendaRedisRepository agendaRedisRepository) {
        this.agendaRepository = agendaRepository;
        this.agendaRedisRepository = agendaRedisRepository;
    }


    public Map<RestEnum, Object> agendaAdd(Agenda agenda) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            AgendaRedis aRediss = new AgendaRedis();
            aRediss.setAgdate(agenda.getAgdate());
            aRediss.setAgtext(agenda.getAgtext());
            aRediss.setAgtitle(agenda.getAgtitle());
            aRediss.setAgtime(agenda.getAgtime());
            String temp = UUID.randomUUID().toString();
            aRediss.setId(temp);
            AgendaRedis aRedis = agendaRedisRepository.save(aRediss);
            hm.put(RestEnum.status, "Success!");
            hm.put(RestEnum.message, "Agenda(Ajanda) Redis'e başarıyla eklendi.");
            hm.put(RestEnum.result, aRedis);

            agenda.setId(temp);
            Agenda c = agendaRepository.save(agenda);
            hm.put(RestEnum.status, "Success!");
            hm.put(RestEnum.message, "Agenda(Ajanda) DB'ye başarıyla eklendi.");
            hm.put(RestEnum.result, c);

        } catch (Exception ex) {
            hm.put(RestEnum.status, "Failed!");
            hm.put(RestEnum.message, "Agenda(Ajanda) ekleme işlemi başarısız oldu. " + ex.getLocalizedMessage());
        }
        return hm;
    }

    public Map<RestEnum, Object> agendaDelete(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            agendaRepository.deleteById(index);
            agendaRedisRepository.deleteById(index);
            hm.put(RestEnum.status, "Success!");
            hm.put(RestEnum.message, "Agenda(Ajanda) başarıyla silindi. Silinen Id: " + index);
        } catch (Exception ex) {
            hm.put(RestEnum.status, "Failed!");
            hm.put(RestEnum.message, "Agenda(Ajanda) silme işlemi başarısız oldu." + ex.getLocalizedMessage());
        }
        return hm;
    }


    public Map<RestEnum, Object> agendaList() {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            List<Agenda> listAgenda = agendaRepository.findAll();
            hm.put(RestEnum.status, "Success!");
            hm.put(RestEnum.message, "Agenda(Ajanda) başarıyla listelendi.");
            hm.put(RestEnum.result, listAgenda);
        } catch (Exception ex) {
            hm.put(RestEnum.status, "Failed!");
            hm.put(RestEnum.message, "Agenda(Ajanda) listeleme işlemi başarısız oldu." + ex.getLocalizedMessage());
        }
        return hm;
    }

    public Map<RestEnum, Object> agendaProfile(String index) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            Agenda ag = agendaRepository.findById(index).get();

            hm.put(RestEnum.status, "Success!");
            hm.put(RestEnum.message, "Agenda(Ajanda) profil görüntüleme başarılı oldu. Görüntülenen Id: " + index);
            hm.put(RestEnum.result, ag);
        } catch (Exception ex) {
            hm.put(RestEnum.status, "Failed!");
            hm.put(RestEnum.message, "Agenda(Ajanda) profil görüntüleme işlemi başarısız oldu. Ex: " + ex.getLocalizedMessage());
        }
        return hm;
    }


    public Map<RestEnum, Object> agendaUpdate(Agenda agenda) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {

            agendaRepository.saveAndFlush(agenda);

            AgendaRedis updateAgendaRedis = new AgendaRedis();
            updateAgendaRedis.setId(agenda.getId());
            updateAgendaRedis.setAgdate(agenda.getAgdate());
            updateAgendaRedis.setAgtext(agenda.getAgtext());
            updateAgendaRedis.setAgtitle(agenda.getAgtitle());
            updateAgendaRedis.setAgtime(agenda.getAgtime());
            AgendaRedis aRedis = agendaRedisRepository.save(updateAgendaRedis);

            hm.put(RestEnum.status, "Success!");
            hm.put(RestEnum.message, "Agenda(Ajanda) başarıyla güncellendi.");
            hm.put(RestEnum.result, aRedis);

        } catch (Exception ex) {
            hm.put(RestEnum.status, "Failed!");
            hm.put(RestEnum.message, "Agenda(Ajanda) güncelleme işlemi başarısız oldu. " + ex.getLocalizedMessage());
        }
        return hm;


    }




}
