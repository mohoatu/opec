package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Phuong_Thuc_Gia;
import org.opec.xnk.service.dm_Phuong_Thuc_GiaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class dm_Phuong_Thuc_GiaController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Phuong_Thuc_GiaService")
	private dm_Phuong_Thuc_GiaService dm_Phuong_Thuc_GiaService;
	

	@RequestMapping(value="dm_phuong_thuc_gia", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_phuong_thuc_gia");
		return modelAndView;
	}

	// Danh muc Nha cung cap
	@RequestMapping(value = "/dm_phuong_thuc_gia/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Phuong_Thuc_Gia> dataDmNcc() 
	{
		return dm_Phuong_Thuc_GiaService.getAll();
	}
	
	@RequestMapping(value = "/dm_phuong_thuc_gia/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Phuong_Thuc_GiaService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_phuong_thuc_gia/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Phuong_Thuc_GiaService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_phuong_thuc_gia/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Phuong_Thuc_GiaService.remove(Integer.parseInt(vals.get("phuongthucgia_id").toString()));
		return 1;
	}
}
