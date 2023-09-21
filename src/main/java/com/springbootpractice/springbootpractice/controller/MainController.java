package com.springbootpractice.springbootpractice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbootpractice.springbootpractice.common.utils.SessionUtil;
import com.springbootpractice.springbootpractice.dto.session.SessionDto;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    
    @Autowired
    SessionUtil sessionUtil;

    @GetMapping(value={"/", "/main"})
    public ModelAndView goMain() {

        ModelAndView mav = new ModelAndView("main.html");

        SessionDto sessionDto = sessionUtil.getSession();

        logger.info("Session = " + sessionDto);

        if(sessionDto != null) {
            mav.addObject("sessionDto", sessionDto);
        }

        return mav;
    }

    @GetMapping(value="/elements")
    public ModelAndView preEle() {
        return new ModelAndView("elements");
    }


}
