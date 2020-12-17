package com.hg.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//1,加载配置文件
//2，生产配置文件中记录的相应的对象
public class MyFactory {
    private Properties properties=new Properties();
    public MyFactory() throws IOException {
        InputStream resourceAsStream=MyFactory.class.getResourceAsStream("/bean,properties");
        properties.load(resourceAsStream);
    }
   public  Object getBean(String name) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //1,通过name，获取对应的类路径
       String classPath=properties.getProperty(name);
       //2,反射，构建对象
       Class claz=Class.forName(classPath);
       return claz.newInstance();
   }
}
