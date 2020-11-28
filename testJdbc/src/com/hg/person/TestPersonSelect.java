package com.hg.person;

public class TestPersonSelect {
    public static void main(String[] args) {
        PersonDaolmpl personDao=new PersonDaolmpl();
        Person person=personDao.select(1);
        System.out.println(person);
    }
}
