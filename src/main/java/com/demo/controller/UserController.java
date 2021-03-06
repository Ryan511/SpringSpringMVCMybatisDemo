package com.demo.controller;

import com.demo.entity.User;
import com.demo.frame.DataSourceSwitcher;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.List;

/**
 * @desc:
 * @author:zhongziqi
 * @create 2018年3月23日
 */
@Controller
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/hello")
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) {
        logger.info("==============hello===========");
		ModelAndView mv = new ModelAndView("hello");
		List<User> users = userService.getUsers();
		ServletContext application = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		//这个是获取Spring父上下文
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		//这个是获取子上下文 每个DispatcherServlet有一个自己的上下文对象 可访问父上下文
		ApplicationContext  subContext = (ApplicationContext) RequestContextUtils.getWebApplicationContext(request);
		String[] webString = context.getBeanDefinitionNames();
		String[] subString = subContext.getBeanDefinitionNames();
		String[] subToParent = subContext.getParent().getBeanDefinitionNames();
		User vo = new User();
		for (User po : users) {
			vo = po;
		}
		DataSourceSwitcher.setDatasourceKey("ds2");
		users = userService.getUsers();
		mv.addObject("user", vo);
		return mv;

	}
}
