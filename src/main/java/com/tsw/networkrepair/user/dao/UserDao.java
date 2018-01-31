package com.tsw.networkrepair.user.dao;

import com.tsw.networkrepair.user.Model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao {

    List<UserModel> selectAll(UserModel userModel);

    void insertInfo(UserModel userModel);

    void upDateInfo(UserModel userModel);

    void deleteInfo(int id);

    List<UserModel> selectUserByName(String name);

    UserModel login(@Param("username") String username, @Param("password") String password);

    String selectUsername(@Param("username") String username);

    UserModel selectById(int id);

}
