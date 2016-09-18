package dao;

import com.weirdo.demo.dao.IUserInfoDAO;
import com.weirdo.demo.dataobject.UserInfoDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Class IUserInfoDAOTest
 *
 * @author daiqiang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class IUserInfoDAOTest {

    @Resource(name = "userInfoDAO")
    private IUserInfoDAO userInfoDAO;

    @Test
    public void insertUserInfoSelective() throws Exception {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserName("测试");
        userInfoDAO.insertUserInfoSelective(userInfoDO);
        System.out.println(userInfoDO);
    }

    @Test
    public void getUserInfoByID() throws Exception {

    }

}