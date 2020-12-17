import com.hg.dao.TeacherMapper;
import com.hg.pojo.Teacher;
import com.hg.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class Mytest {
//    @Test
//    public void test1(){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        TeacherMapper mapper=sqlSession.getMapper(TeacherMapper.class);
//        List<Teacher> teacher = mapper.getTeacher();
//        for (Teacher teacher1 : teacher) {
//            System.out.println(teacher1);
//
//        }


   // }
    @Test
    public  void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        System.out.println(mapper.getTeacher(1));

    }
    @Test
    public  void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        System.out.println(mapper.getTeacher2(1));

    }
}
