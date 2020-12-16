package com.rest.dani.apidani.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Value("${spring.locale.default}")
    private String defaultLocale;

    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/message")
    public String getMessage(@RequestParam(value = "message", defaultValue = "world") String message){
        String greeting = messageSource.getMessage("greeting", null, LocaleContextHolder.getLocale());
        message = String.format("%s %s!", greeting, message);
        return message;
    }

    @GetMapping(value = "/language")
    public String changeLocale(HttpServletRequest request, HttpServletResponse response){
        String cadena;
        if (defaultLocale.equalsIgnoreCase(StringUtils.parseLocale("ES").toString())) {
            localeResolver.setLocale(request, response, StringUtils.parseLocale("en"));
            cadena = "cambiado locale: " + defaultLocale + " -> en";
            defaultLocale = "en";
        }
        else {
            localeResolver.setLocale(request, response, StringUtils.parseLocale("es"));
            cadena = "cambiado locale: " + defaultLocale + " -> es";
            defaultLocale = "es";
        }
        return cadena;
    }
}
