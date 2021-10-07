package com.works.restapix.dto;

import com.works.restapix.entities.PasswordResetToken;
import com.works.restapix.entities.User;
import com.works.restapix.properties.PassChange;
import com.works.restapix.properties.PassToken;
import com.works.restapix.repositories.PassChangeTokenRepository;
import com.works.restapix.repositories.UserRepository;
import com.works.restapix.utils.RestEnum;
import com.works.restapix.utils.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service

@Transactional
public class PassChangeDto {

    final UserService uService;
final UserRepository uRepo;
final PassChangeTokenRepository passChangeTokenRepository;

    public PassChangeDto(UserService userService, UserRepository uRepo, PassChangeTokenRepository passChangeTokenRepository) {
        this.uService = userService;
        this.uRepo = uRepo;
        this.passChangeTokenRepository = passChangeTokenRepository;
    }


    public Map<RestEnum,Object> passChange(PassChange passChange){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();
        UserDetails userDetails =  uService.loadUserByUsername(passChange.getEmail());
        System.out.println(userDetails.getUsername());

        if (userDetails.getUsername().equals(passChange.getEmail())){
            PasswordResetToken pResetToken=new PasswordResetToken();
            String email=passChange.getEmail();
            String token = UUID.randomUUID().toString();
            Optional<User> oUser = uRepo.findByEmailEqualsAllIgnoreCase(email);
            User us=oUser.get();
            pResetToken.setUser(us);
            pResetToken.setToken(token);
     PasswordResetToken p=passChangeTokenRepository.save(pResetToken);

          /*  us.setPassword( uService.encoder().encode(passChange.getNewPass()));
            uRepo.saveAndFlush(us);*/
            hm.put(RestEnum.result,"success");
            hm.put(RestEnum.message,"passResetToken saved");
            hm.put(RestEnum.result,p.getToken());
        }else {
            hm.put(RestEnum.result, "failed");
            hm.put(RestEnum.message, "Kullanıcı adı veya şifre hatalı");
        }
return hm;
    }



    public Map<RestEnum,Object> passChangeWithToken(PassToken passToken){
        Map<RestEnum,Object> hm =new LinkedHashMap<>();
        UserDetails userDetails =  uService.loadUserByUsername(passToken.getEmail());
        System.out.println("LOADUSARNAME__________________"+userDetails);
        PasswordResetToken ptoken= passChangeTokenRepository.findByTokenEquals(passToken.getToken());
        if (ptoken.getToken() != null) {

    hm.put(RestEnum.result,ptoken);
    hm.put(RestEnum.message,"token ok ");
        if (userDetails.getUsername().equals(passToken.getEmail())){
            System.out.println(userDetails);
            String email=passToken.getEmail();
            Optional<User> oUser = uRepo.findByEmailEqualsAllIgnoreCase(email);
            User us=oUser.get();
            us.setPassword( uService.encoder().encode(passToken.getNewPass()));
            uRepo.saveAndFlush(us);
            hm.put(RestEnum.result,"succes");
            hm.put(RestEnum.message,"şifre değişimi başarılı ");
        }


        }else {

            hm.put(RestEnum.result, "Email hatalı ");
            hm.put(RestEnum.message, "şifre yada email hatalı ");
        }
    return hm;
    }







}
