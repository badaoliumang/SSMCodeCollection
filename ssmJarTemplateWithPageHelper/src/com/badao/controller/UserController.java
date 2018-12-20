package com.badao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.badao.pojo.User;
import com.badao.service.UserService;
import com.badao.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("listUser")
	public ModelAndView listUser(Page page){
		ModelAndView mav = new ModelAndView();
		//根据分页对象，进行查询获取查询对象集合
		//List<User> cs= userService.selectAllUser(page);
		//int total = userService.total();
		//根据总数，计算最后一页的信息
		
		 PageHelper.offsetPage(page.getStart(),5);
	     List<User> cs= userService.selectAllUser();
	     int total = (int) new PageInfo<>(cs).getTotal();
	     page.caculateLast(total);
		// 放入转发参数
		mav.addObject("userList", cs);
		// 放入jsp路径
		mav.setViewName("listUser");
		return mav;
	}

}

