package com.qinjingcao.finance.service;

import com.qinjingcao.finance.entity.User;
import com.qinjingcao.finance.mapper.UserMapper;

import java.util.List;

public interface UserService {

    User selectUserByTerms(String username,String password);

    List<User> selectUserByStatusDesc();

    List<User> selectAllUser();

    Integer updateUser(User user);

    Integer insertUser(User user);

    User selectUserById(Integer id);

    Integer deleteUserById(Integer id);
}
