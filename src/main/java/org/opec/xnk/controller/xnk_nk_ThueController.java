package org.opec.xnk.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class xnk_nk_ThueController {
	
protected static Logger logger = Logger.getLogger("controller");
	
	
	@RequestMapping(value="xnk_nk_thue", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/xnk_nk_thue");
		return modelAndView;
	}

}
