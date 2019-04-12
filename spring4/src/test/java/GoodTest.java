import com.lovo.bean.Good;
import com.lovo.service.GoodService;
import com.lovo.service.impl.GoodServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class GoodTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        GoodService goodService = (GoodServiceImpl) app.getBean("goodService");

        List<Good> listGoods = goodService.getListGoods();
        for (Good listGood : listGoods) {
            System.out.println(listGood);
        }
    }
}
