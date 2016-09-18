package dao;

import com.weirdo.demo.dao.IUserInfoDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.Reader;
import java.nio.channels.Pipe;

/**
 * Class UserInfoDAOTest
 *
 * @author daiqiang
 */
public class UserInfoDAOTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    private InputStream inputStream;

    @Before
    public void init(){
        if (reader == null){
            try {
//                reader = Resources.getResourceAsReader("mybatis-config.xml");
                inputStream = UserInfoDAOTest.class.getClass().getResourceAsStream("/mybatis/mybatis-config.xml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (sqlSessionFactory == null) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
    }

    @Test
    public void testAdd(){
        SqlSession session = sqlSessionFactory.openSession(true);
        try {
            IUserInfoDAO userInfoDAO = session.getMapper(IUserInfoDAO.class);
            System.out.println(userInfoDAO);
        } finally {
            session.close();
        }
    }
}
