package com.hg.person;

public class TestRegister {
    public static void main(String[] args) {
        PersonServiceImpl personService=new PersonServiceImpl();
        Person person=new Person("cunzhu",20,UtilDate.strToUtil("1998-10-10"),"12345@qq.com","hangzhou");
        personService.register(person);
    }
}
