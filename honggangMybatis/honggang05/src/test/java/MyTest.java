import com.hg.dao.StudentMapper;
import com.hg.dao.TeacherMapper;
import com.hg.pojo.Student;
import com.hg.pojo.Teacher;
import com.hg.utils.MybatisUtils;
import lombok.ToString;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public  void test1() {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);


    }
    @Test
    public  void test2(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        for (Student student1 : student) {
            System.out.println(student1);

        }

    }
    @Test
    public  void test3(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent2();
        for (Student student1 : student) {
            System.out.println(student1);

        }
    }

}
