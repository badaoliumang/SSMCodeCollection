package com.badao.service;

import java.util.List;

import com.badao.pojo.User;
import com.badao.util.Page;

public interface UserService {
	List<User> selectAllUser();

	User selectUser(Integer id);

	void updateUser(User user);

	void deleteUser(int id);

	void addUser(User user);
	
	//List<User> selectAllUser(Page page);
	//int total();

}
