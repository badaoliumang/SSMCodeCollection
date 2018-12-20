package com.badao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import com.badao.mapper.UserMapper;
import com.badao.pojo.User;
import com.badao.util.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;//使用junit4时报错导这个包
@RunWith(SpringJUnit4ClassRunner.class)//使用junit4进行测试
@ContextConfiguration("classpath:applicationContext.xml")//加载配置文件
public class InsertTest {
	@Autowired//自动注入
	private UserMapper userMapper;
	 @Test//标明是测试方法
	 @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
	 public void testAdd() {
	        for (int i = 0; i < 100; i++) {
	        	User user = new User();
	        	user.setName("user"+i);
	            userMapper.addUser(user);
	        }
	 
	    }
	     
	  /*  @Test
	    public void testTotal() {
	        int total = userMapper.total();
	        System.out.println(total);
	    }
	 
	    @Test
	    public void testList() {
	        Page p = new Page();
	        p.setStart(2);
	        p.setCount(3);
	        List<User> cs=userMapper.selectAllUser(p);
	        for (User c : cs) {
	            System.out.println(c.getName());
	        }
	    }*/
}
