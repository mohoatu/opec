package org.opec.xnk.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.xnk_Nk_Ky_Hau;
import org.opec.xnk.service.xnk_Nk_Ky_HauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class xnk_nk_Ky_HauController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="xnk_Nk_Ky_HauService")
	private xnk_Nk_Ky_HauService xnk_Nk_Ky_HauService;
	

	@RequestMapping(value="xnk_nk_ngan_hang_ky_hau", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/xnk_nk_ngan_hang_ky_hau");
		return modelAndView;
	}
	
	@RequestMapping(value = "/data/xnk_nk_ky_hau", method = RequestMethod.GET)
	public @ResponseBody List<xnk_Nk_Ky_Hau> getData() 
	{
		System.out.println("===============getData ky hau================="+xnk_Nk_Ky_HauService.getAll());
		return xnk_Nk_Ky_HauService.getAll();
	}

	
//	@RequestMapping(value = "/xnk_nk_hop_dong/update", method = RequestMethod.POST)
//	public @ResponseBody Map<String, Object> updateDataDmNsx(@RequestBody Map<String, Object> fields,
//			final HttpServletRequest request,
//			final HttpServletResponse response)
//	{
//		xnk_Nk_Hop_DongService.update(fields);
//		return fields;
//	}
//	
//	@RequestMapping(value = "/xnk_nk_hop_dong/insert", method = RequestMethod.POST)
//	public @ResponseBody Integer insertDataDmNsx(@RequestBody Map<String, Object> fields,
//			final HttpServletRequest request,
//			final HttpServletResponse response)
//	{
//		return xnk_Nk_Hop_DongService.insert(fields);
//	}
//	
//	@RequestMapping(value = "/xnk_nk_hop_dong/delete", method = RequestMethod.POST)
//	public @ResponseBody Integer deleteDataDmNsx(@RequestBody Map<String, Object> fields,
//			final HttpServletRequest request,
//			final HttpServletResponse response)
//	{
//		xnk_Nk_Hop_DongService.remove(Integer.parseInt(fields.get("nhasanxuat_id").toString()));
//		
//		return 1;
//	}
}

