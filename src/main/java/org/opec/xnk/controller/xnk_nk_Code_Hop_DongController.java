package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.xnk_Nk_Code_Hop_Dong;
import org.opec.xnk.service.xnk_Nk_Code_Hop_DongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class xnk_nk_Code_Hop_DongController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="xnk_Nk_Code_Hop_DongService")
	private xnk_Nk_Code_Hop_DongService xnk_Nk_Code_Hop_DongService;
	
	@RequestMapping(value="xnk_nk_code_hop_dong", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/xnk_nk_code_hop_dong");
		return modelAndView;
	}
	
	@RequestMapping(value = "/data/xnk_nk_code_hop_dong", method = RequestMethod.GET)
	public @ResponseBody List<xnk_Nk_Code_Hop_Dong> getData(
				@RequestParam(required = false,value="thongquan") String thongquan) 
	{
		if(thongquan != null){
			if(thongquan.equalsIgnoreCase("1")){
				return xnk_Nk_Code_Hop_DongService.getDaThongQuan();
			}else if(thongquan.equalsIgnoreCase("0")){
				return xnk_Nk_Code_Hop_DongService.getChuaThongQuan();
			}
		}
		return xnk_Nk_Code_Hop_DongService.getAll();
	}
	
	@RequestMapping(value = "/xnk_nk_code_hop_dong/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> update(@RequestBody Map<String, Object> fields,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		xnk_Nk_Code_Hop_DongService.update(fields);
		return fields;
	}
	
	@RequestMapping(value = "/xnk_nk_code_hop_dong/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insert(@RequestBody Map<String, Object> fields,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return xnk_Nk_Code_Hop_DongService.insert(fields);
	}
}
