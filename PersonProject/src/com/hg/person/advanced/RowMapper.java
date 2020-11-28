package com.hg.person.advanced;

import java.sql.ResultSet;

/**
 * 约束封装对象的ORM
 */

public interface RowMapper<T> {
    public T getRow(ResultSet resultSet);
    //通过这个方法不管结果集是什么，都返回一个object的值
}
