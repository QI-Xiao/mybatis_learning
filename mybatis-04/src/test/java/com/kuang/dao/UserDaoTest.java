package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    // 不使用SQL，老方法，不推荐
    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RowBounds rowBounds = new RowBounds(1, 2);

        List<User> userList = sqlSession.selectList("com.kuang.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (User user: userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user: userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info: come into tesetLog4j");
        logger.debug("debug: come into testlog4j");
        logger.debug("error: come into log4j");
    }

}
