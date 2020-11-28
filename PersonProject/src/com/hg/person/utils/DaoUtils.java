package com.hg.person.utils;

import com.hg.person.advanced.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 复用增删改和查找
 */
public class DaoUtils<T> {
    /**不知道sql语句里的？个数，所以传一个可变参数列表进去
     *
     * @param sql 执行的sql语句
     * @param args 参数列表
     * @return 受影响的行数
     */
    public int commonsUpdate(String sql,Object... args){
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        try {
            connection=DBUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            for (int i=0;i< args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
                //sql中从1计数，args中从0计数。
            }
            int result=preparedStatement.executeUpdate();
            return  result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,preparedStatement,null);
        }
        return 0;
    }

    /**
     * 公共的查询方法（可查询任意的一张表，单个对象和多个对象）
     * @param sql 语句
     * @param args 参数列表
     * @return 集合
     */
    public  List<T> commonSelect(String sql, RowMapper<T> rowMapper, Object... args){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<T> list=new ArrayList<>();
        connection=DBUtils.getConnection();
        try {

            preparedStatement=connection.prepareStatement(sql);
            if(args!=null){
                for (int i=0;i<args.length;i++){
                    preparedStatement.setObject(i+1,args[i]);
                }
            }

            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                /**
                 * 此处采用回调的方法，因为不知道result set返回的值
                 * 具体的情况，但是调用者知道
                 *
                 */
                T t= rowMapper.getRow(resultSet);
                list.add(t);

            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
