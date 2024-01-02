package com.springbootpractice.springbootpractice.service.join;

import com.springbootpractice.springbootpractice.model.join.JoinProcessModel;
import com.springbootpractice.springbootpractice.model.response.ResponseModel;

public interface JoinService {

    public ResponseModel checkId(String id);

    public ResponseModel joinProcess(JoinProcessModel joinProcessModel);
    
}
