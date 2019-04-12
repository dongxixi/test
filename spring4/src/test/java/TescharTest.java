import com.lovo.bean.Teacher;
import com.lovo.service.TeacherService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TescharTest {


    ClassPathXmlApplicationContext cpa = null;
    TeacherService teacherService = null;

    @Before
    public void before() {
        cpa = new ClassPathXmlApplicationContext("applicationContext.xml");

        teacherService
                = (TeacherService) cpa.getBean("teacherServiceImpl");
    }

    @Test
    public void test() {

        Teacher teacher = new Teacher();
        teacher.setName("老湿");

        teacherService.addTeacher(teacher);
    }
}
