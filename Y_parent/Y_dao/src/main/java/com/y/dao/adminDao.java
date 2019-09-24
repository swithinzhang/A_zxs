package com.y.dao;

import com.y.entity.admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface adminDao {

    @Select("select * from admin where username=#{username} and password=#{password}")
    public admin adminLogin(@Param("username")String username, @Param("password")String password);
}
