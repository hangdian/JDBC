import com.hg.dao.IUserDao;
import com.hg.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    /**
     * 入门的案例
     * @param args
     */
    public static void main(String[] args) throws Exception{

        //1.读取配置文件
        InputStream is= Resources.class.getResourceAsStream("/SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory=builder.build(is);

        //3.使用工厂生产SqlSession对象
        SqlSession session = sessionFactory.openSession();

        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();

        //6.循环输出查询数据
        for(User user : users){

            System.out.println(user);
        }

        //7.释放资源
        session.close();
        is.close();
    }
}