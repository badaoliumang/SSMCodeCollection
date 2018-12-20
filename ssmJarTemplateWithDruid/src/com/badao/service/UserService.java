package com.badao.service;

import java.util.List;

import com.badao.pojo.User;
import com.badao.util.Page;

public interface UserService {
	List<User> selectAllUser();
	//List<User> selectAllUser(Page page);
	//int total();

}
