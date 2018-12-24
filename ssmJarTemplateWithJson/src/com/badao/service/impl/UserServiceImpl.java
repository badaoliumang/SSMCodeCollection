package com.badao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Override
	public User selectUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(id);
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
	     userMapper.updateUser(user);
	}
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(id);
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.addUser(user);
	}
	
	
	@Override
	/*@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")*/
	public void addTwo() {
		// TODO Auto-generated method stub
		User user1 = new User();
		user1.setName("张三");
		user1.setAge(22);
		userMapper.addUser(user1);
		//用户2故意设置名字长度过长
		User user2 = new User();
		user2.setName("嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿嘿");
		user2.setAge(25);
		userMapper.addUser(user2);
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		 List<User> userList = selectAllUser();
		 for (User user : userList) {
			userMapper.deleteUser(user.getId());
		}
	}

}
