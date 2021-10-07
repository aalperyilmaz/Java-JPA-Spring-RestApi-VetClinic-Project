package com.works.restapix.config;


import com.works.restapix.entities.Logger;
import com.works.restapix.utils.UserService;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    final UserService userService;

    public FilterConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
       Logger log= new Logger();
        userService.info(req,res,log);

        filterChain.doFilter(req, res);
    }


}
