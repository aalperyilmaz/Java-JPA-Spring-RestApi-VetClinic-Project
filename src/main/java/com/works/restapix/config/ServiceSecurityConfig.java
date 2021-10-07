package com.works.restapix.config;
import com.works.restapix.utils.UserService;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ServiceSecurityConfig extends WebSecurityConfigurerAdapter {

    final UserService uService;
    public ServiceSecurityConfig(UserService uService) {
        this.uService = uService;
    }

    // sql -> jpa query -> user control
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(uService).passwordEncoder(uService.encoder());
    }

    // hangi yöntemle giriş yapılarak, rollere göre hangi servis kullanılcak?
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/agenda/**").hasAnyRole("ADMIN")
        .antMatchers("/pet/**").permitAll()
        .antMatchers("/customer/**").hasAnyRole("ADMIN")
                .antMatchers("/passchange/**").hasAnyRole("ADMIN")
                .antMatchers("/vacc/**").hasAnyRole("ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable()
        .logout().logoutUrl("/admin/logout").invalidateHttpSession(true) ;
        http.headers().frameOptions().disable(); // h2-console for using



    }



    private static final String[] AUTH_WHITELIST = {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"
    };


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(AUTH_WHITELIST);
    }





}
