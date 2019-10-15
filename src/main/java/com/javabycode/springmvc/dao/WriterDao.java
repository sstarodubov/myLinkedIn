package com.javabycode.springmvc.dao;

import com.javabycode.springmvc.model.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;

@Repository("WriterDao")
public class WriterDao extends AbstractDao<Integer, Writer>{

    public void saveWriter(Writer writer) {
        persist(writer);
    }



}
