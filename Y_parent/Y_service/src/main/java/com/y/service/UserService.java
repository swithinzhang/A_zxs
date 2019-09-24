package com.y.service;

import com.y.dao.UserDao;
import com.y.entity.user;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {

    public user Login(String email,String password);

    public void Register(String email,String password);

    public user validatemail(String email);

    public void updateUser(Integer id,String nickName,String phoneNum );

    public void totalUpdateUser(Integer id,String nickname,String sex,String birthday,String address);

    public void imgUpdateUser(Integer id,String imgUrl);

    public void passwordUpdateUser(Integer id,String password);

}
