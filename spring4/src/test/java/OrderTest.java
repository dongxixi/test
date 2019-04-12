import com.lovo.bean.Order;
import com.lovo.service.OrderManager;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

public class OrderTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderManager orderManager = (OrderManager) app.getBean("orderManager");


        Order order = new Order();
        order.setGoodsId(2);
        order.setOrderNum(2);
        order.setOrderPrice(6000);
        order.setOrderNumber(3250002);
        boolean b = orderManager.addOrder(order);
        if (b) {
            System.out.println("添加订单成功");
        }

    }

    @Test
    public void uuid() {
        for (int i = 0; i < 100; i++) {
            System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        }
    }
}
