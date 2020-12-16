package com.rest.dani.apidani.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class InterceptorController implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(InterceptorController.class);
    private long iniTime = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        LOG.info("[preHandle]" + request.getMethod() + " / " + request.getRequestURI() + " \n ");
        iniTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        LOG.info("[postHandle]" + request.getMethod() + " / " + request.getRequestURI() + "." +
                " Processed in " + String.valueOf(System.currentTimeMillis() - this.iniTime) + " ms");
    }

}
