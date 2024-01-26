package com.cocovrend.springbootwebapp.errorhandler;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(ExceptionImpl e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errorMessage", e.getMessage());
        return mav;
    }

}
