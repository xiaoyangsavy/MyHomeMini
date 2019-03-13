package com.savy.controller;

import com.savy.model.Test;
import com.savy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/test/get")
    @ResponseBody
    public Test testFreemarker() {
        System.out.println("call /test/get");
        Test test = new Test();
        test.setValue("test");
        return test;
    }

    @RequestMapping(value = "/test/test")
    @ResponseBody
    public Test testTest() {
        System.out.println("call /test/test");
        Test test = testService.queryTestValue(2);
        return test;
    }

}
