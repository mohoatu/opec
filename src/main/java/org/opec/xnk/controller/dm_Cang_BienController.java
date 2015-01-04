package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Cang_Bien;
import org.opec.xnk.service.dm_Cang_BienService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Cang_BienController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Cang_BienService")
	private dm_Cang_BienService dm_Cang_BienService;
	

	@RequestMapping(value="dm_cang_bien", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_cang_bien");
		return modelAndView;
	}

	// Danh muc Nha cung cap
	@RequestMapping(value = "/dm_cang_bien/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Cang_Bien> dataDmNcc() 
	{
		return dm_Cang_BienService.getAll();
	}
	
	@RequestMapping(value = "/dm_cang_bien/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Cang_BienService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_cang_bien/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Cang_BienService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_cang_bien/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Cang_BienService.remove(Integer.parseInt(vals.get("cangbien_id").toString()));
		
		return 1;
	}

}
