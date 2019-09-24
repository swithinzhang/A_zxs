package com.y.dao;

import com.y.entity.user;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
    @Select("select * from user where email=#{email} and password=#{password}")
    public user Login(@Param("email")String email,@Param("password")String password);

    @Insert("INSERT INTO user (email,password) VALUES (#{email},#{password})")
    public void Register(@Param("email")String email,@Param("password")String password);

    @Select("select * from user where email=#{email}")
    public user validatemail(String email);

    @Update("UPDATE user SET `id`=#{id},`phoneNum`=#{phoneNum},`nickName`=#{nickName} WHERE (`id`=#{id})")
    public void updateUser(@Param("id")Integer id,@Param("nickName")String nickName,@Param("phoneNum")String phoneNum );

    @Update("UPDATE user SET `id`=#{id},`nickName`=#{nickName}, `sex`=#{sex},`birthday`=#{birthday},`address`=NULL WHERE (`id`=#{id})")
    public void totalUpdateUser(@Param("id")Integer id,@Param("nickName")String nickname,@Param("sex")String sex,@Param("birthday")String birthday,@Param("address")String address);

    @Update("UPDATE user SET `imgUrl`=#{imgUrl} WHERE (`id`=#{id})")
    public void imgUpdateUser(@Param("id")Integer id,@Param("imgUrl")String imgUrl);

    @Update("UPDATE user SET `password`=#{password} WHERE (`id`=#{id})")
    public void passwordUpdateUser(@Param("id")Integer id,@Param("password")String password);
}
