package com.badao.ssm.ssmTemplate.mapper;

import java.util.List;

import com.badao.ssm.ssmTemplate.pojo.User;


public interface UserMapper {
	public int insertUser(User user);
	public int deleteUser(int id);
	public int updateUser(User user);
	public User getUser(int id);
	public List<User> findUsers(String userName);
}
