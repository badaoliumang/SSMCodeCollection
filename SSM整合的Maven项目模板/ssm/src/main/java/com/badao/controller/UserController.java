package com.badao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.badao.pojo.User;
import com.badao.service.UserService;



// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("listUser")
	public ModelAndView listUser(){
		ModelAndView mav = new ModelAndView();
		List<User> cs= userService.selectAllUser();
		
		// 放入转发参数
		mav.addObject("userList", cs);
		// 放入jsp路径
		mav.setViewName("listUser");
		return mav;
	}

}

