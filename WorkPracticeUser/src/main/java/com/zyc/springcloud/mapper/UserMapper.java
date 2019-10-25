package com.zyc.springcloud.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zyc.springcloud.entity.User;



@Repository
public interface UserMapper {
	// 通过用户名去查找密码
	String getPassword(String username);
	
	// 通过用户名去查找用户信息
	User getUserInfo(String username);
	
	// 注册 
	boolean instUser(@Param("username")String username, @Param("password")String password,@Param("role")String role,
			@Param("permission")String permission,@Param("ban")String ban,@Param("money")float money);
	
	// 查询所有用户
	List<User> getAllUser();
	
	//查询用户余额
	float getMoney(String username);
	
	//修改用户金钱
	boolean UpdateUserMoney(@Param("username")String username,@Param("totalPrice")float totalPrice);
}
