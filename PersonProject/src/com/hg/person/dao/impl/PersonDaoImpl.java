package com.hg.person.dao.impl;

import com.hg.person.advanced.impl.PersonRowMapper;
import com.hg.person.dao.PersonDao;
import com.hg.person.entity.Person;
import com.hg.person.utils.DaoUtils;
import com.hg.person.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    private DaoUtils<Person> daoUtils=new DaoUtils();

    @Override
    public int insert(Person person) {
        Object[] args={person.getName(),person.getAge(),DateUtils.utilToSql(person.getBornDate()),person.getEmail(),person.getAddress()};
        String sql="insert into person (name,age,bornDate,email,address)values(?,?,?,?,?);";
        return daoUtils.commonsUpdate(sql,args);

    }

    @Override
    public int update(Person person) {
        Object[] args={person.getName(),person.getAge(),DateUtils.utilToSql(person.getBornDate()),person.getEmail(),person.getAddress(),person.getId()};
        String sql="update person set name=?,age=?,bornDate=?,email=?,address=?where id=?";
        return daoUtils.commonsUpdate(sql,args);
    }

    @Override
    public int delete(int id) {
        String sql="delete from person where id=?;";
        return daoUtils.commonsUpdate(sql,id);
    }

    @Override
    public Person select(int id) {
        String sql="select * from person where id=?;";
        DaoUtils daoUtils=new DaoUtils();
        List<Person> list=daoUtils.commonSelect(sql,new PersonRowMapper(),id);
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Person> selectAll() {
        String sql="select *from person;";
        DaoUtils daoUtils=new DaoUtils();
        List<Person> list=daoUtils.commonSelect(sql,new PersonRowMapper(),null);

        return list;
    }
}
