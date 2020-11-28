package com.hg.pool.test;

import com.hg.pool.utils.DBUtils;

import java.sql.Connection;

public class TestPool {
    public static void main(String[] args) throws Exception {
        for (int i=1;i<=20;i++){
            Connection connection= DBUtils.getConnection();
            System.out.println(connection);
            connection.close();//是重写后的close方法，不是关闭而是放回连接池中
        }
    }
}
