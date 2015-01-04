package org.opec.xnk.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ViewController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView homePage() 
	{
		return new ModelAndView("common/index");
	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView logoHomePage() 
	{
		return new ModelAndView("common/index");
	}
	
	
	@RequestMapping(value="intro", method = RequestMethod.GET)
	public ModelAndView opecIntroPage() 
	{
		return new ModelAndView("common/intro");
	}
	
	
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public ModelAndView loginPage()
	{
		ModelAndView modelAndView = new ModelAndView("common/login");
		
		return modelAndView;
	}
	
	@RequestMapping(value="denied", method = RequestMethod.GET)
	public ModelAndView deniedPage()
	{
		ModelAndView modelAndView = new ModelAndView("opec/deniedpage");
		
		return modelAndView;
	}
	
	// Danh muc nha cung cap
	@RequestMapping(value="dm_ncc", method = RequestMethod.GET)
	//public ModelAndView dmNccPage(@RequestParam("module") String module)   
	public ModelAndView dmNccPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_ncc");
		//modelAndView.addObject("name", module);
				
		return modelAndView;
	}
	
	
	@RequestMapping(value="dm_nsx", method = RequestMethod.GET)
	public ModelAndView dmNsxPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_nsx");
		return modelAndView;
	}
}
