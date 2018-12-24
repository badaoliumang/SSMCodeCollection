package com.badao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
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
	
	@RequestMapping("testJson")
	public ModelAndView testJson(){
		ModelAndView mav = new ModelAndView();
		// 放入jsp路径
		//mav.setViewName("submit");
		//mav.setViewName("getOneUser");
		mav.setViewName("getManyUser");
		return mav;
	}
		
	@RequestMapping("addUser")
	public ModelAndView addUser(User user){
		System.out.println(user.getName());
		userService.addUser(user);
		ModelAndView mav = new ModelAndView("redirect:/listUser");
	    return mav;
	}	
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(int id){
		userService.deleteUser(id);
		ModelAndView mav = new ModelAndView("redirect:/listUser");
		return mav;
	}	
	@RequestMapping("editUser")
	public ModelAndView editUser(User user){
	    user= userService.selectUser(user.getId());
		ModelAndView mav = new ModelAndView("editUser");
		mav.addObject("user", user);
		return mav;
	}	
	@RequestMapping("updateUser")
	public ModelAndView updateUser(User user){
		userService.updateUser(user);
		ModelAndView mav = new ModelAndView("redirect:/listUser");
		return mav;
	}	
	//处理JSON相关开始
	 @ResponseBody
	 @RequestMapping("/submitUser")
	 public String submitUser(@RequestBody User user) {
	        System.out.println("SSM接受到浏览器提交的json，并转换为User对象:"+user);
	        return "ok";
	    }
	     
	 @ResponseBody
	 @RequestMapping("/getOneUser")
	 public String getOneUser() {
	         User user = new User();
	         user.setId(100);
	         user.setName("第100个用户");
	         user.setAge(100);
	         JSONObject json= new JSONObject();
	         json.put("user", JSONObject.toJSON(user));
	         return json.toJSONString();
	    }
	 @ResponseBody
	 @RequestMapping("/getManyUser")
	    public String getManyUser() {
	        List<User> us = new ArrayList<>();
	        for (int i = 0; i < 10; i++) {
	            User user = new User();
	            user.setId(i);
	            user.setName("用户名称:"+i);
	            user.setAge(i+1);
	            us.add(user);
	        }
	 
	        return JSONObject.toJSON(us).toString();
	    }
	

}

