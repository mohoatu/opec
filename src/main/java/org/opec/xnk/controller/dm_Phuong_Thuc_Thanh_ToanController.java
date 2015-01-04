package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Phuong_Thuc_Thanh_Toan;
import org.opec.xnk.domain.dm_Phuong_Thuc_Thanh_Toan;
import org.opec.xnk.service.dm_Phuong_Thuc_Thanh_ToanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class dm_Phuong_Thuc_Thanh_ToanController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Phuong_Thuc_Thanh_ToanService")
	private dm_Phuong_Thuc_Thanh_ToanService dm_Phuong_Thuc_Thanh_ToanService;
	

	@RequestMapping(value="dm_phuong_thuc_thanh_toan", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_phuong_thuc_thanh_toan");
		return modelAndView;
	}

	// Danh muc Nha cung cap
	@RequestMapping(value = "/dm_phuong_thuc_thanh_toan/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Phuong_Thuc_Thanh_Toan> dataDmNcc() 
	{
		return dm_Phuong_Thuc_Thanh_ToanService.getAll();
	}
	
	@RequestMapping(value = "/dm_phuong_thuc_thanh_toan/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Phuong_Thuc_Thanh_ToanService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_phuong_thuc_thanh_toan/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Phuong_Thuc_Thanh_ToanService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_phuong_thuc_thanh_toan/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Phuong_Thuc_Thanh_ToanService.remove(Integer.parseInt(vals.get("phuongthuctt_id").toString()));
		return 1;
	}
}
