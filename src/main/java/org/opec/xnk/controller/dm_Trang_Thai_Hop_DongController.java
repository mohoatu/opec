package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Trang_Thai_Hop_Dong;
import org.opec.xnk.domain.dm_Trang_Thai_Hop_Dong;
import org.opec.xnk.service.dm_Trang_Thai_Hop_DongService;
import org.opec.xnk.service.dm_Trang_Thai_Hop_DongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class dm_Trang_Thai_Hop_DongController {
	
protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Trang_Thai_Hop_DongService")
	private dm_Trang_Thai_Hop_DongService dm_Trang_Thai_Hop_DongService;
	
	@RequestMapping(value="dm_trang_thai_hop_dong", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_trang_thai_hop_dong");
		return modelAndView;
	}

	@RequestMapping(value = "/dm_trang_thai_hop_dong/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Trang_Thai_Hop_Dong> dataDmNcc() 
	{
		return dm_Trang_Thai_Hop_DongService.getAll();
	}
	
	@RequestMapping(value = "/dm_trang_thai_hop_dong/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Trang_Thai_Hop_DongService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_trang_thai_hop_dong/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Trang_Thai_Hop_DongService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_trang_thai_hop_dong/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Trang_Thai_Hop_DongService.remove(Integer.parseInt(vals.get("trangthai_id").toString()));
		return 1;
	}
}
