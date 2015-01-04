package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Trang_Thai_Giao_Hang;
import org.opec.xnk.service.dm_Trang_Thai_Giao_HangService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Trang_Thai_Giao_HangController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Trang_Thai_Giao_HangService")
	private dm_Trang_Thai_Giao_HangService dm_Trang_Thai_Giao_HangService;
	
	@RequestMapping(value="dm_trang_thai_giao_hang", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_trang_thai_giao_hang");
		return modelAndView;
	}

	@RequestMapping(value = "/dm_trang_thai_giao_hang/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Trang_Thai_Giao_Hang> dataDmNcc() 
	{
		return dm_Trang_Thai_Giao_HangService.getAll();
	}
	
	@RequestMapping(value = "/dm_trang_thai_giao_hang/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Trang_Thai_Giao_HangService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_trang_thai_giao_hang/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Trang_Thai_Giao_HangService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_trang_thai_giao_hang/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Trang_Thai_Giao_HangService.remove(Integer.parseInt(vals.get("trangthai_id").toString()));
		return 1;
	}
}
