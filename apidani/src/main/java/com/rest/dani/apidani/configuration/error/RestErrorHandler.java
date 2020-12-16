package com.rest.dani.apidani.configuration.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestErrorHandler {
    private static final Logger LOG = LoggerFactory.getLogger(RestErrorHandler.class);
    private final MessageSource messageSource;

    @Autowired
    public RestErrorHandler(MessageSource messageSource) {this.messageSource = messageSource;};

    //private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrorList){}

    @ExceptionHandler(DaniException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleDaniException(DaniException ex){
        LOG.error(ex.getMessageDani());

        return ex.getMessageDani();
    }

}
