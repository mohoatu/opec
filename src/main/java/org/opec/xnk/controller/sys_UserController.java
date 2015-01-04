package org.opec.xnk.controller;

import java.util.List;

import javax.annotation.Resource;

import org.opec.xnk.domain.sys_User;
import org.opec.xnk.service.sys_UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class sys_UserController {
	
	@Resource(name="sys_UserService")
	private sys_UserService sys_UserService;
	
	@RequestMapping(value="/sys_user", method = RequestMethod.GET)
	public ModelAndView menuPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/user");
		return modelAndView;
	}
	
	@RequestMapping(value="/sys_user/get", method = RequestMethod.GET)
	public @ResponseBody List<sys_User> getAll()
	{
		return sys_UserService.getAll();
	}

	
}
