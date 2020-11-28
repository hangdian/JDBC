package com.hg.person;

public class PersonServiceImpl {
    //注册,一个业务由多个DAO的访问操作组成。
    public void register(Person person){
        PersonDaolmpl personDao=new PersonDaolmpl();
        //1,查询用户是否存在
        Person persons=personDao.select(person.getName());
        //2，不存在则新增
        if (persons==null){
            personDao.insert(person);
            System.out.println("success");
        }else {
            System.out.println("existed");
        }
        //3，存在则返回已经注册

    }

}
