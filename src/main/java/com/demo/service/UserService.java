package com.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.entity.User;

/**
 * @desc:
 * @author:zhongziqi
 * @create 2018年3月22日
*/
@Service

public class UserService {
	@Autowired
	private UserDao userDao;

	public List<User> getUsers() {
		return userDao.getUsers();
	}

}
