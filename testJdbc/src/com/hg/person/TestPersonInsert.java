package com.hg.person;

public class TestPersonInsert {
    public static void main(String[] args) {
        //测试新增
        PersonDaolmpl personDao=new PersonDaolmpl();
        Person person=new Person("honggang",23,UtilDate.strToUtil("1996-11-24"),"liuhonggang@qq.com","杭州");
        int result= personDao.insert(person);
        if (result==1){
            System.out.println("success");
        }else {
            System.out.println("false");
        }
    }
}
