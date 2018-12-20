package com.badao.mapper;

import java.util.List;
import com.badao.pojo.User;
import com.badao.util.Page;



public interface UserMapper {
	public int addUser(User user);
	public User selectUser(int id);
	public int updateUser(User user);
	public void deleteUser(int id);
	public List<User> selectAllUser();
	public List<User> selectAllUser(Page page);
	public int total();
	
}
