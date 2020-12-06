import com.hg.dao.IUserDao;
import com.hg.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream is;
    private SqlSession session;
    private IUserDao userDao;

    public void init() throws Exception {
        //1.读取配置文件
        is = Resources.class.getResourceAsStream("/SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(is);

        //3.使用工厂生产SqlSession对象
        session = sessionFactory.openSession();

        //4.使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    public void destory() throws Exception {
        session.commit();
        session.close();
        is.close();
    }

    @Test
    public void testFindAll() throws Exception {
        init();
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        destory();
    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setUsername("lol");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("杭州");
        init();
        System.out.println("保存之前"+user);
        userDao.saveUser(user);
        System.out.println("保存之后"+user);

        destory();
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(60);
        user.setUsername("cunzhu");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("杭州");
        init();
        userDao.updateUser(user);
        destory();
    }
    @Test
    public void testDelete() throws Exception {
        init();
        userDao.deleteUser(50);
        destory();
    }
    @Test
    public void testFindOne() throws Exception {
        init();
        User user=userDao.findById(48);
        System.out.println(user);
        destory();
    }
    @Test
    public void testFindByName() throws Exception {
        init();
        List<User> users=userDao.findByName("%王%");//模糊查询，在配置文件中没有百分号这一要提供
        for (User user:users){
           System.out.println(user);
        }
        destory();
    }
    @Test
    public void testFindTotal() throws Exception {
        init();
        int result= userDao.findTotal();
        System.out.println(result);
        destory();
    }
    @Test
    public void testFindByVo() throws Exception {
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        init();
        List<User> users=userDao.findUserByVo(vo);
        for (User u:users){
            System.out.println(u);
        }
        destory();
    }
}