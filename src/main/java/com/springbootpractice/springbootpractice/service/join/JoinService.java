package com.springbootpractice.springbootpractice.service.join;

import com.springbootpractice.springbootpractice.model.join.JoinProcessModel;
import com.springbootpractice.springbootpractice.model.response.ResponseModel;

public interface JoinService {

    ResponseModel checkId(String id);

    ResponseModel joinProcess(JoinProcessModel joinProcessModel);
    
}
