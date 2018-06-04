package com.demo;

import java.util.List;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.entity.User;
import com.demo.service.UserService;

/**
 * @desc:
 * @author:zhongziqi
 * @create 2018年3月23日
*/
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
    private static Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    UserService userService;

    @org.junit.Test
    public void testtest() {
		List<User> user = userService.getUsers();
		for (User vo : user) {
			logger.info("userid:" + vo.getUserId());
			logger.info("userpwd:" + vo.getPassword());
		}
    }
}