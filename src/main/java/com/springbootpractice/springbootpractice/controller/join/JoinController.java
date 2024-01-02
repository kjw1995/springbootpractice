package com.springbootpractice.springbootpractice.controller.join;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springbootpractice.springbootpractice.common.url.commonUrl;
import com.springbootpractice.springbootpractice.model.join.JoinProcessModel;
import com.springbootpractice.springbootpractice.model.response.ResponseModel;
import com.springbootpractice.springbootpractice.service.join.JoinService;

@RestController
public class JoinController {

    private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

    @Autowired
    private JoinService joinService;

    @GetMapping(value = commonUrl.JOIN_URI)
    public ModelAndView join() {
        return new ModelAndView("join/join");
    }

    @PostMapping(value = commonUrl.JOIN_CHECK_ID)
    public ResponseModel checkId(@RequestBody String id) { return joinService.checkId(id); }

    @PostMapping(value = commonUrl.JOIN_PROGRESS)
    public ResponseModel joinProcess(@RequestBody JoinProcessModel joinProcessModel) {

        logger.info("joinId = " + joinProcessModel.getJoinId());
        logger.info("joinPw = " + joinProcessModel.getJoinPassword());
        logger.info("joinEmail = " + joinProcessModel.getJoinEmail());
        logger.info("joinPhoneNumber = " + joinProcessModel.getJoinPhoneNumber());

        return joinService.joinProcess(joinProcessModel);

    }


    
}
