package com.badao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badao.mapper.UserMapper;
import com.badao.pojo.User;
import com.badao.service.UserService;
import com.badao.util.Page;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userMapper.selectAllUser();
	}
/*	@Override
	public List<User> selectAllUser(Page page) {
		// TODO Auto-generated method stub
		return userMapper.selectAllUser(page);
	}
	@Override
	public int total() {
		// TODO Auto-generated method stub
		return userMapper.total();
	}*/

}
