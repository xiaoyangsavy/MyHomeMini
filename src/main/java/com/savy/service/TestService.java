package com.savy.service;


import com.savy.mapper.TestMapper;
import com.savy.model.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

    public Test queryTestValue(int id){

        Test result = testMapper.getById(id);

        return result;
    }

}
