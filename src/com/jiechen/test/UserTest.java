package com.jiechen.test;

import com.jiechen.pojo.UserMapper;
import com.jiechen.pojo.User;
import com.jiechen.pojo.UserOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 3. 创建SqlSessionFactory对象
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void testQueryUserById() {
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询方法
        User user = userMapper.queryUserById(2);
        System.out.println(user);

        // 和spring整合后由spring管理
        sqlSession.close();
    }


    @Test
    public void testQueryUserByUsername() throws Exception {
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询方法
        List<User> list = userMapper.queryUserByUsername("%小%");
        for (Object user : list) {
            System.out.println(user);
        }

        // 和spring整合后由spring管理
        sqlSession.close();
    }


    @Test
    public void testQueryUserByUsername2() throws Exception {
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询方法
        List<User> list = userMapper.queryUserByUsername2("小");
        for (Object user : list) {
            System.out.println(user);
        }

        // 和spring整合后由spring管理
        sqlSession.close();
    }

    @Test
    public void testSaveUser() {
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 创建需要保存的User
        User user = new User();
        user.setUsername("小江");
        user.setPassword("123456");

        userMapper.saveUser(user);
        System.out.println(user);

        // 和spring整合后由spring管理
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUserById() {
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 创建需要保存的User
        User user = new User();
        user.setId(3);
        user.setUsername("小子");
        user.setPassword("654321");

        userMapper.updateUserById(user);
        System.out.println(user);

        // 和spring整合后由spring管理
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDeleteUserById() {
        // 获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        // 从sqlSession中获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.deleteUserById(2);

        // 和spring整合后由spring管理
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryUserOrder() {
        // mybatis和spring整合，整合之后，交给spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // 创建Mapper接口的动态代理对象，整合之后，交给spring管理
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 使用userMapper执行根据条件查询用户
        List<UserOrder> list = userMapper.queryUserOrder();

        for (UserOrder u : list) {
            System.out.println(u.toString());
        }

        // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }


}
