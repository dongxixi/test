import com.lovo.bean.Student;
import com.lovo.service.impl.HibernateService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Set;

public class HibernateTest {

    private ClassPathXmlApplicationContext cpa = null;
    private Session session;
    private Transaction transaction;
    @Before
    public void before() {
        cpa = new ClassPathXmlApplicationContext("applicationContext.xml");


    }

    @Test
    public void test() {

        HibernateService hibernateService = (HibernateService) cpa.getBean("hibernateService");

        session = hibernateService.getSession();

        transaction = session.beginTransaction();

        Student student = new Student();

        student.setName("张三");

        session.save(student);

    }
    @Test
    public void testset() {
        HashSet<Student> set = new HashSet<>();


    }


    @After
    public void after() {
        transaction.commit();
        session.close();
    }
}
