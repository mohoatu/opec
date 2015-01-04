package org.opec.xnk.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class xnk_nk_LogisticController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	
	@RequestMapping(value="xnk_nk_logistic_phi_thu_ho", method = RequestMethod.GET)
	public ModelAndView viewPagePhiThuHo()
	{
		ModelAndView modelAndView = new ModelAndView("data/xnk_nk_logistic_phi_thu_ho");
		return modelAndView;
	}

	@RequestMapping(value="xnk_nk_logistic_phi_dich_vu", method = RequestMethod.GET)
	public ModelAndView viewPagePhiDichVu()
	{
		ModelAndView modelAndView = new ModelAndView("data/xnk_nk_logistic_phi_dich_vu");
		return modelAndView;
	}
	
	@RequestMapping(value="xnk_nk_logistic_phi_van_chuyen", method = RequestMethod.GET)
	public ModelAndView viewPagePhiVanChuyen()
	{
		ModelAndView modelAndView = new ModelAndView("data/xnk_nk_logistic_phi_van_chuyen");
		return modelAndView;
	}
}
