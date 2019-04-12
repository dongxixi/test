import com.lovo.dao.UserDao;
import com.lovo.entity.Role;
import com.lovo.entity.User;
import com.lovo.service.UserService;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Calendar;

public class Test {

    private ClassPathXmlApplicationContext cpa = null;
    private UserDao userDao = null;

    @Before
    public void before() {
        cpa = new ClassPathXmlApplicationContext("conf/dispatcherServlet.xml");

        userDao = (UserDao) cpa.getBean("userDao");
    }

    @org.junit.Test
    public void testfile() {
        File f=new File("C:\\");
        File[] f1=f.listFiles();
        for(int i=0;i<f1.length;i++){
            if(f1[i].isDirectory()){
                System.out.println("dirctory is"+f1[i].getName());
            } else {
                System.out.println("file is"+f1[i].getName());
            }
        }
    }

    @org.junit.Test
    public void test() {
        Role role = userDao.findByRoleName("张三", "12", "1");
        System.out.println(role);
    }
}
