package com.hg.person;

import java.util.List;

public class TestPersonSelectAll {
    public static void main(String[] args) {
        PersonDaolmpl personDao=new PersonDaolmpl();
        List<Person> personList=personDao.selectAll();
        for (Person p:personList){
            System.out.println(p);
        }

    }
}
