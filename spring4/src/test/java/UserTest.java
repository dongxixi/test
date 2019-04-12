import com.lovo.dao.UserPowerDao;
import com.lovo.service.OrderManager;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserPowerDao userPowerDao = (UserPowerDao) app.getBean("userPowerDao");

        Scanner input = new Scanner(System.in);
        System.out.println("请输入要查看的人的姓名：");
        String name = input.next();
        System.out.println(name + "拥有的权力有：");
        List<String> list = userPowerDao.getPowerListByUserName(name);
        for (String s : list) {
            System.out.println(s);
        }
        input.close();

        "dsf".length();
    }
}
