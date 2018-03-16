package com.jiechen.test;

import com.jiechen.pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class OrderTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testQueryAll() {
        // 获取sqlSession
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // 获取OrderMapper
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        // 执行查询
        List<Order> list = orderMapper.queryOrderAll();
        for (Order order : list) {
            System.out.println(order.toString());
        }
    }

    @Test
    public void testQueryOrderUser() {
        // mybatis和spring整合，整合之后，交给spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // 创建Mapper接口的动态代理对象，整合之后，交给spring管理
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        // 使用userMapper执行根据条件查询用户
        List<OrderUser> list = orderMapper.queryOrderUser();

        for (OrderUser ou : list) {
            System.out.println(ou.toString());
        }

        // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }

    @Test
    public void testQueryOrderUserResultMap() {
        // mybatis和spring整合，整合之后，交给spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // 创建Mapper接口的动态代理对象，整合之后，交给spring管理
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        // 使用userMapper执行根据条件查询用户
        List<OrderUser2> list = orderMapper.queryOrderUserResultMap();

        for (Order o : list) {
            System.out.println(o);
        }

        // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }



}
