package com.javabycode.springmvc.service;


import com.javabycode.springmvc.dao.StudentDao;
import com.javabycode.springmvc.dao.WriterDao;
import com.javabycode.springmvc.model.Student;
import com.javabycode.springmvc.model.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("writerService")
@Transactional
public class WriterServiceImpl {

    @Autowired
    private WriterDao dao;

    public void saveWriter(Writer writer) {
        dao.saveWriter(writer);
    }
}
