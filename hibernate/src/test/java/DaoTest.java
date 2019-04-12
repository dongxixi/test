import com.lovo.dao.UserDao;
import com.lovo.dao.impl.UserDaoImpl;
import com.lovo.entity.UserEntity;
import org.junit.Test;

import java.util.List;

public class DaoTest {

    @Test
    public void addUserTest() {
        UserDao userDao = new UserDaoImpl();
        UserEntity userEntity = new UserEntity();
        userEntity.setName("李四");
        userDao.add(userEntity);
    }

    @Test
    public void listTest() {
        UserDao userDao = new UserDaoImpl();
        List<UserEntity> list = userDao.getList();
        for (UserEntity userEntity : list) {
            System.out.println(userEntity.getId() + userEntity.getName());
        }
    }
}
