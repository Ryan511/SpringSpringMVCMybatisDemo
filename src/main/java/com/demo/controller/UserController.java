package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.User;
import com.demo.service.UserService;

/**
 * @desc:
 * @author:zhongziqi
 * @create 2018年3月23日
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/hello")
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("hello");
		List<User> users = userService.getUsers();
		User vo = new User();
		for(User po :users) {
			vo =po;
		}
		mv.addObject("user",vo);
		return mv;

	}
}
