package com.hg.person.view;

import com.hg.person.dao.PersonDao;
import com.hg.person.dao.impl.PersonDaoImpl;
import com.hg.person.entity.Person;
import com.hg.person.utils.DateUtils;

public class TestPerson {
    public static void main(String[] args) {
        PersonDaoImpl personDao=new PersonDaoImpl();
//        Person person=new Person("lhg",19, DateUtils.strToUtil("1998-12-11"),"123@qq.com","hangzhou");
//        int result=personDao.insert(person);
//        System.out.println(result);
        Person person=personDao.select(2);
        System.out.println(person);




    }
}
