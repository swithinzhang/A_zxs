package com.y.service.Impl;

import com.y.dao.UserDao;
import com.y.entity.user;
import com.y.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public user Login(@Param("email")String email,@Param("password")String password) {
        user u = userDao.Login(email, password);
        return u;
    }

    public void Register(@Param("email")String email,@Param("password")String password) {
        userDao.Register(email, password);

    }

    public user validatemail(String email) {
        user user = null;
        user = userDao.validatemail(email);
        return user;
    }

    public void updateUser(@Param("id")Integer id,@Param("nickName")String nickName,@Param("phoneNum")String phoneNum ) {
        userDao.updateUser(id,nickName,phoneNum);
    }

    public void totalUpdateUser(@Param("id")Integer id,@Param("nickName")String nickname,@Param("sex")String sex,@Param("birthday")String birthday,@Param("address")String address){
        userDao.totalUpdateUser(id,nickname,sex,birthday,address);
    }

    public void imgUpdateUser(@Param("id")Integer id,@Param("imgUrl")String imgUrl){
        userDao.imgUpdateUser(id,imgUrl);
    }

    public void passwordUpdateUser(@Param("id")Integer id,@Param("password")String password) {
        userDao.passwordUpdateUser(id,password);
    }
}
