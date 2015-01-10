package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.xnk_Nk_Ngan_Hang;
import org.opec.xnk.service.xnk_Nk_Code_Hop_DongService;
import org.opec.xnk.service.xnk_Nk_Ngan_HangService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	@RequestMapping(value = "/xnk_nk_ngan_hang_lc/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNsx(@RequestBody Map<String, Object> fields,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		xnk_Nk_Ngan_HangService.update(fields);
		return fields;
	}
	
	@RequestMapping(value = "/xnk_nk_ngan_hang_lc/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNsx(@RequestBody Map<String, Object> fields,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return xnk_Nk_Ngan_HangService.insert(fields);
	}
	
	@RequestMapping(value = "/xnk_nk_ngan_hang_lc/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNsx(@RequestBody Map<String, Object> fields,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		xnk_Nk_Ngan_HangService.remove(Integer.parseInt(fields.get("nhasanxuat_id").toString()));
		
		return 1;
	}

}
