package com.hg.person;

public class TestPersonDelete {
    public static void main(String[] args) {
        PersonDaolmpl personDao=new PersonDaolmpl();
        int result=personDao.delete(1);
        if (result==1){
            System.out.println("success");
        }else{
            System.out.println("false");
        }
    }
}
