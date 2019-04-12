import com.lovo.dao.DaoBasic;
import com.lovo.entity.OrderEntity;
import com.lovo.entity.ParkEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

public class OrderTest {

    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction transaction = null;
    int total = 0;
    int initial = 0;
    int time = 0;
    int timing = 0;

    Properties properties = null;


    @Before
    public void before() {
        sessionFactory = DaoBasic.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @Test
    public void init() {
        load();

        ParkEntity parkEntity = new ParkEntity();
        parkEntity.setId("1");
        parkEntity.setTotal(total);
        parkEntity.setUsing(0);
        session.save(parkEntity);
    }

    @Test
    public void inPark() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setInTime(new Date());

        session.save(orderEntity);
    }

    @Test
    public void outPark() {
        load();
        OrderEntity orderEntity = session.get(OrderEntity.class, "4028818869be8a6f0169be8a75fb0000");
        orderEntity.setOutTime(new Date());

        session.update(orderEntity);
        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        int times = (int) Math.ceil((double) (orderEntity.getOutTime().getTime() - orderEntity.getInTime().getTime()) / 3600000);
        int money;
        if (times <= time) {
            money = initial;
        } else {
            money = initial + (times - 3) * timing;
        }
        System.out.println("应收费" + money + "元");
    }

    @After
    public void after() {
        transaction.commit();
        session.close();
    }

    public void load() {
        properties = new Properties();
        try {
            properties.load(new InputStreamReader(new FileInputStream("D:\\GitHub\\hibernate\\src\\main\\resources\\park.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        total = Integer.valueOf(properties.getProperty("park.total"));
        initial = Integer.valueOf(properties.getProperty("price.initial"));
        time = Integer.valueOf(properties.getProperty("price.time"));
        timing = Integer.valueOf(properties.getProperty("price.timing"));
    }
}
