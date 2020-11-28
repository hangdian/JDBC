package com.hg.person;

public class TestPersonUpdate {
    public static void main(String[] args) {
        PersonDaolmpl personDao=new PersonDaolmpl();
        Person person=new Person(1,"honggang",24,null,"1506120391@qq.com","HDU");
        int result=personDao.update(person);
        if (result==1){
            System.out.println("success");
        }else {
            System.out.println("false");
        }


    }
}
