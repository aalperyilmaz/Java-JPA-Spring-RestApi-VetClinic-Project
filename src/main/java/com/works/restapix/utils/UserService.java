package com.works.restapix.utils;


import com.works.restapix.entities.Logger;
import com.works.restapix.entities.Role;
import com.works.restapix.entities.User;
import com.works.restapix.properties.PassChange;
import com.works.restapix.repositories.LogRepository;
import com.works.restapix.repositories.PassChangeTokenRepository;
import com.works.restapix.repositories.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService extends SimpleUrlLogoutSuccessHandler implements UserDetailsService, LogoutSuccessHandler {

    final UserRepository uRepo;
    final LogRepository lRepo;
    final PassChangeTokenRepository passChangeRepository;


    public UserService(UserRepository uRepo, LogRepository lRepo, PassChangeTokenRepository passChangeRepository) {
        this.uRepo = uRepo;
        this.lRepo = lRepo;

        this.passChangeRepository = passChangeRepository;
    }


    // security login
    @Override
    public UserDetails loadUserByUsername(String email) {
        UserDetails userDetails = null;
        Optional<User> oUser = uRepo.findByEmailEqualsAllIgnoreCase(email);
        if (oUser.isPresent()) {
            User us = oUser.get();
            userDetails = new org.springframework.security.core.userdetails.User(
                    us.getEmail(),
                    us.getPassword(),
                    us.isEnabled(),
                    us.isTokenExpired(),
                    true,
                    true,
                    getAuthorities(us.getRoles()));
        } else {
            throw new UsernameNotFoundException("Kullanıcı adı yada şifre hatalı");
        }
        return userDetails;
    }


    private List<GrantedAuthority> getAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }


    public User register(User us) throws AuthenticationException {

        if (!Util.isEmail(us.getEmail())) {
            throw new AuthenticationException("Bu mail formatı hatalı!");
        }

        Optional<User> uOpt = uRepo.findByEmailEqualsAllIgnoreCase(us.getEmail());
        if (uOpt.isPresent()) {
            throw new AuthenticationException("Bu kullanıcı daha önce kayıtlı!");
        }
        us.setPassword(encoder().encode(us.getPassword()));
        return uRepo.save(us);
    }


    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //final String refererUrl = httpServletRequest.getHeader("Referer");
        System.out.println("onLogoutSuccess Call ");
        //super.onLogoutSuccess(httpServletRequest, httpServletResponse, authentication );
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() );
    }


    // user info
    public void info(HttpServletRequest req, HttpServletResponse res, Logger logger) throws IOException {

        Authentication aut = SecurityContextHolder.getContext().getAuthentication();
        String email = null; // username
        try {
            email = aut.getName();
        } catch (Exception e) {
            email="anonim@mail.com";
        }
        if (email != null) {
            System.out.println(email);
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        System.out.println("ip " + ip);

        String session = req.getSession().getId();
        System.out.println("session :" + session);

        Optional<User> user = uRepo.findByEmailEqualsAllIgnoreCase(email);
        if (user.isPresent()) {
            logger.setLname(user.get().getFirstName());
            logger.setLsurname(user.get().getLastName());
            String roles = "";
            for (Role item : user.get().getRoles()) {
                roles += item.getName() + ", ";
            }
            if (roles.length() > 0) {
                roles = roles.substring(0, roles.length() - 2);
            }
            logger.setLroles(roles);
        }

        logger.setLemail(email);
        logger.setLsessionId(session);
        logger.setLIp(ip);

        logger.setLUrl(req.getRequestURI());
        logger.setLDate(LocalDateTime.now());

        lRepo.save(logger);

        System.out.println(logger);
    }




}
