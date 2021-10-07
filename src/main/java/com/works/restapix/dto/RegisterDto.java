package com.works.restapix.dto;

import com.works.restapix.entities.Role;
import com.works.restapix.entities.User;
import com.works.restapix.repositories.RoleRepository;
import com.works.restapix.utils.RestEnum;
import com.works.restapix.utils.UserService;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterDto {
    final UserService uSevice;
    final RoleRepository rRepo;

    public RegisterDto(UserService uSevice, RoleRepository rRepo) {
        this.uSevice = uSevice;
        this.rRepo = rRepo;
    }


    public Map<RestEnum, Object> register(User us , String roleIDSt) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        try {

            long roleID = Long.parseLong(roleIDSt);
            us.setEnabled(true);
            us.setTokenExpired(true);

            Role role = rRepo.findById(roleID).get();

            List<Role> roles = new ArrayList<>();
            roles.add(role);

            us.setRoles(roles);

        User usrr=    uSevice.register(us);
          hm.put(RestEnum.status,"succes");
          hm.put(RestEnum.result,usrr);

        }catch ( AuthenticationException ex ) {}
       hm.put(RestEnum.status,"Register failed");
        return hm;
    }
}
