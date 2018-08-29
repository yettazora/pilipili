package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.TypeField;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TypeFieldMapperTest {

    TypeFieldMapper typeFieldMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        typeFieldMapper=session.getMapper(TypeFieldMapper.class);
    }

    @Test
    public void listByTypeId() {
        System.out.println(typeFieldMapper.listByTypeId(1));
    }

    @Test
    public void countFieldByTypeIdAndFieldId() {
        System.out.println(typeFieldMapper.countFieldByTypeIdAndFieldId(1, 49));
    }

    @Test
    public void deleteByTypeId() {
        typeFieldMapper.deleteByTypeId(3);
    }

    @Test
    public void batchInsert() {
        TypeField typeField=new TypeField();
        typeField.setFieldId(1);
        typeField.setFieldName("dsada");
        typeField.setIsRequired(1);
        typeField.setIsScreen(1);
        typeField.setSort(1);
        typeField.setTypeId(1);
        List<TypeField> list=new ArrayList<>();
        list.add(typeField);
        list.add(typeField);
        typeFieldMapper.batchInsert(list);
    }

    @Test
    public void selectIsRequired() {
        System.out.println(typeFieldMapper.selectIsRequired(1, "csacsacs"));
    }

    @Test
    public void countByFieldId() {
        System.out.println(typeFieldMapper.countByFieldId(49));
    }

    @Test
    public void countByTypeId() {
        System.out.println(typeFieldMapper.countByTypeId(1));
    }
}