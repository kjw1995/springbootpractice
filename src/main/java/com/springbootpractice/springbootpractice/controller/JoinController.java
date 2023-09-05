package com.springbootpractice.springbootpractice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springbootpractice.springbootpractice.model.JoinProcessModel;
import com.springbootpractice.springbootpractice.service.JoinService;

@RestController
public class JoinController {

    private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

    @Autowired
    private JoinService joinService;

    @GetMapping(value="/join")
    public ModelAndView join() {
        return new ModelAndView("join.html");
    }

    @PostMapping(value="/join/process")
    public void joinProcess(@RequestBody JoinProcessModel joinProcessModel) {

        logger.info("joinId = " + joinProcessModel.getJoinId());
        logger.info("joinPw = " + joinProcessModel.getJoinPassword());
        logger.info("joinEmail = " + joinProcessModel.getEmail());
        logger.info("joinPhoneNumber = " + joinProcessModel.getPhoneNumber());

    }
    
}
