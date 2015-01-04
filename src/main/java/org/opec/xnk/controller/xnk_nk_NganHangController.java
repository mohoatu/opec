package org.opec.xnk.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.xnk_Nk_Ngan_Hang;
import org.opec.xnk.service.xnk_Nk_Code_Hop_DongService;
import org.opec.xnk.service.xnk_Nk_Ngan_HangService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class xnk_nk_NganHangController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	
	@Resource(name="xnk_Nk_Ngan_HangService")
	private xnk_Nk_Ngan_HangService xnk_Nk_Ngan_HangService;
	
	@RequestMapping(value="xnk_nk_ngan_hang_lc", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/xnk_nk_ngan_hang_lc");
		return modelAndView;
	}
	
	@RequestMapping(value = "/data/xnk_nk_ngan_hang_lc", method = RequestMethod.GET)
	public @ResponseBody List<xnk_Nk_Ngan_Hang> getData() 
	{
		return xnk_Nk_Ngan_HangService.getAll();
	}

}
