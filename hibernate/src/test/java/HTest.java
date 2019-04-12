import com.lovo.dao.DaoBasic;
import com.lovo.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

public class HTest {



    private SessionFactory sessionFactory = null;

    @Before
    public void before() {

        sessionFactory = DaoBasic.getSessionFactory();
    }

    @Test
    public void test1() {
        System.out.println(sessionFactory);
    }

    @Test
    public void test2() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setName("张三");
            session.save(userEntity);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Test
    public void testGet() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        UserEntity userEntity = session.get(UserEntity.class, 1);
        transaction.commit();
        System.out.println(userEntity.getName());
    }
}
