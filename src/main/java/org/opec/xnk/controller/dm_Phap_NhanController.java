package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Phap_Nhan;
import org.opec.xnk.service.dm_Phap_NhanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class dm_Phap_NhanController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Phap_NhanService")
	private dm_Phap_NhanService dm_Phap_NhanService;
	
	@RequestMapping(value="dm_phap_nhan", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_phap_nhan");
		return modelAndView;
	}

	// Danh muc Nha cung cap
	@RequestMapping(value = "/dm_phap_nhan/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Phap_Nhan> dataDmNcc() 
	{
		return dm_Phap_NhanService.getAll();
	}
	
	@RequestMapping(value = "/dm_phap_nhan/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Phap_NhanService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_phap_nhan/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Phap_NhanService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_phap_nhan/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Phap_NhanService.remove(Integer.parseInt(vals.get("phapnhan_id").toString()));
		return 1;
	}
	
}
