package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.FieldInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class FieldInfoMapperTest {

    FieldInfoMapper fieldInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        fieldInfoMapper=session.getMapper(FieldInfoMapper.class);
    }

    @Test
    public void list() {
        System.out.println(fieldInfoMapper.list());
    }

    @Test
    public void insert() {
        FieldInfo fieldInfo=new FieldInfo();
        fieldInfo.setSort(1);
        fieldInfo.setName("madmsoamd");
        fieldInfo.setVarName("dakdnasmdka");
        fieldInfo.setInputType("naisncianc");
        fieldInfo.setType("csaoms");
        fieldInfo.setIsAllowEdit(1);
        fieldInfoMapper.insert(fieldInfo);
    }

    @Test
    public void update() {
        FieldInfo fieldInfo=new FieldInfo();
        fieldInfo.setSort(1);
        fieldInfo.setName("madmsoamd");
        fieldInfo.setVarName("dakdnasmdka");
        fieldInfo.setInputType("naisncianc");
        fieldInfo.setType("csaoms");
        fieldInfo.setIsAllowEdit(1);
        fieldInfo.setContent("nihao");
        fieldInfo.setId(46);
        fieldInfoMapper.update(fieldInfo);
    }

    @Test
    public void delete() {
        Integer integer[]=new Integer[]{47,48};
        fieldInfoMapper.delete(integer);
    }

    @Test
    public void listCategoryField() {
        System.out.println(fieldInfoMapper.listCategoryField(1).size());
        FieldInfo fieldInfo=fieldInfoMapper.listCategoryField(1).get(0);
        System.out.println(fieldInfo.getId()+"  "+fieldInfo.getName()+"  "+fieldInfo.getVarName()+"  "+fieldInfo.getInputType());
    }

    @Test
    public void countByVarName() {
        System.out.println(fieldInfoMapper.countByVarName("dakdnasmdka", 49));
    }

    @Test
    public void selectById() {
        System.out.println(fieldInfoMapper.selectById(49));
    }

    @Test
    public void listVarNameByIdArr() {
        System.out.println(fieldInfoMapper.listVarNameByIdArr(new Integer[]{7,8,13,17,20}));
    }

    @Test
    public void listByTypeId() {
        System.out.println(fieldInfoMapper.listByTypeId(1));
        FieldInfo fieldInfo=fieldInfoMapper.listByTypeId(1).get(0);
        System.out.println(fieldInfo.getId()+"  "+fieldInfo.getName()+"  "+fieldInfo.getVarName()+"  "+fieldInfo.getInputType());
    }

    @Test
    public void listRadio() {
        System.out.println(fieldInfoMapper.listRadio());
    }

    @Test
    public void listRadioByTypeId() {
        System.out.println(fieldInfoMapper.listRadioByTypeId(1));
        FieldInfo fieldInfo=fieldInfoMapper.listRadioByTypeId(1).get(0);
        System.out.println(fieldInfo.getId()+"  "+fieldInfo.getName()+"  "+fieldInfo.getVarName()+"  "+fieldInfo.getInputType());
    }

    @Test
    public void selectByVarName() {
        FieldInfo fieldInfo=fieldInfoMapper.selectByVarName("csacsacs");
        System.out.println(fieldInfo.getId()+"  "+fieldInfo.getName()+"  "+fieldInfo.getVarName()+"  "+fieldInfo.getInputType());
    }
}