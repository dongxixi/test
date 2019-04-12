import com.lovo.EIM.bean.Address;
import com.lovo.EIM.bean.User;
import com.lovo.EIM.service.AddressService;
import com.lovo.EIM.service.UserService;
import com.lovo.EIM.service.impl.AddressServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
//        AddressService as = new AddressServiceImpl();

        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        AddressService as = (AddressService) ctx.getBean("addressService");
        List<Address> list = as.getlist(1, 5);

        for (Address address : list) {
            System.out.println(address);
        }
        System.out.println(as.getTotalNum());
//        User user = new User();
//        user.setUserName("dong");
//        user.setPassword("dong");
//        System.out.println(as.login(user));
    }
}
