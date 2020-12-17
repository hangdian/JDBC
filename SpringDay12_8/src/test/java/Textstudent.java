import com.hg.entity.Student;
import com.hg.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Configuration
@ComponentScan(basePackages ={"com.hg"})
public class Textstudent {
    @Test
    public void textStudend(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
        Student student= (Student) context.getBean("student");
        System.out.println(student.getGrade().getNumber());


    }

    @Test
    public void testService(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
        StudentService studentService=(StudentService)context.getBean("StudentService");
        //ApplicationContext context1=new ClassPathXmlApplicationContext("spring-context.xml");
        Student student= (Student) context.getBean("student");
        studentService.add(student);

    }




}
