package com.javabycode.springmvc.controller;

import com.javabycode.springmvc.dao.StudentDao;
import com.javabycode.springmvc.dao.WriterDao;
import com.javabycode.springmvc.model.Writer;
import com.javabycode.springmvc.service.WriterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class Test {

    @Autowired
    private WriterServiceImpl dao;

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        Writer writer = new Writer("sergey", "samare");
        dao.saveWriter(writer);
        return "test";
    }
}
