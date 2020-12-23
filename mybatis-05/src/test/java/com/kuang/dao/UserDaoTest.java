package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


//        List<User> userList = mapper.getUsers();
//        for (User user : userList) {
//            System.out.println(user);
//        }

//
//        User userByID = mapper.getUserByID(1);
//        System.out.println(userByID);


//        mapper.addUser(new User(6, "qx6", "6666666"));


//        mapper.updateUser(new User(5, "qx5555", "555333"));


        mapper.deleteUser(5);

        sqlSession.close();
    }
}
