package com.works.restapix.restcontroller;

import com.works.restapix.dto.RegisterDto;
import com.works.restapix.entities.User;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(value="Register Rest Service")
public class RegisterRestController {
final RegisterDto registerDto;

    public RegisterRestController(RegisterDto registerDto) {
        this.registerDto = registerDto;
    }

    @PostMapping("/register")
    public Map<RestEnum,Object> register(User us, @RequestParam(defaultValue = "1") String roleIDSt) {



        return registerDto.register(us,roleIDSt);
    }





}
