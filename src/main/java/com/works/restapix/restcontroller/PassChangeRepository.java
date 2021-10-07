package com.works.restapix.restcontroller;

import com.works.restapix.dto.PassChangeDto;
import com.works.restapix.entities.User;
import com.works.restapix.properties.PassChange;
import com.works.restapix.properties.PassToken;
import com.works.restapix.repositories.UserRepository;
import com.works.restapix.utils.RestEnum;
import com.works.restapix.utils.UserService;
import io.swagger.annotations.Api;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/passchange")
@Api(value="Passchange Rest Service")
public class PassChangeRepository {
    final PassChangeDto passChangeDto;
    final UserService uService;
    final UserRepository uRepo;

    public PassChangeRepository(PassChangeDto passChangeDto, UserService uService, UserRepository uRepo) {
        this.passChangeDto = passChangeDto;
        this.uService = uService;
        this.uRepo = uRepo;
    }

    @PostMapping("/passchanger")
    public Map<RestEnum, Object> passChangeRequest( PassToken passToken) {
        System.out.println("passchange-----------------------"+passToken);
        return passChangeDto.passChangeWithToken(passToken);
    }

    @PostMapping("/request")
    public Map<RestEnum, Object> passChanger( PassChange passChange) {

        return passChangeDto.passChange(passChange);

    }
}
