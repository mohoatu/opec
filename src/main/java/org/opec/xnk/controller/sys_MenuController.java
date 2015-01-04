package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opec.xnk.domain.sys_Menu;
import org.opec.xnk.domain.sys_MenuRight;
import org.opec.xnk.service.sys_MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class sys_MenuController {
	
	@Resource(name="sys_MenuService")
	private sys_MenuService sys_MenuService;
	
	@RequestMapping(value="/sys_menu", method = RequestMethod.GET)
	public ModelAndView menuPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/menu");
		return modelAndView;
	}
	
	@RequestMapping(value="/sys_menu/get", method = RequestMethod.GET)
	public @ResponseBody List<sys_Menu> getMenu()
	{
		return sys_MenuService.getMenu();
	}
	
	@RequestMapping(value="/sys_user_menu/get", method = RequestMethod.GET)
	public @ResponseBody List<sys_MenuRight> getUserMenu()
	{
		return sys_MenuService.getUserMenu();
	}
	
	@RequestMapping(value="/sys_menu/import_xml", method = RequestMethod.POST)
	public @ResponseBody Integer importXml(@RequestBody Map<String,Object> item,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		
		sys_MenuService.importXml(item);
		return 1;
	}
	
}

