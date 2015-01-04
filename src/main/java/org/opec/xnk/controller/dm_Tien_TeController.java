package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Tien_Te;
import org.opec.xnk.service.dm_Tien_TeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Tien_TeController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Tien_TeService")
	private dm_Tien_TeService dm_Tien_TeService;
	
	@RequestMapping(value="dm_tien_te", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_tien_te");
		return modelAndView;
	}

	// Danh muc Nha cung cap
	@RequestMapping(value = "/dm_tien_te/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Tien_Te> dataDmNcc() 
	{
		return dm_Tien_TeService.getAll();
	}
	
	@RequestMapping(value = "/dm_tien_te/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Tien_TeService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_tien_te/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Tien_TeService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_tien_te/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Tien_TeService.remove(Integer.parseInt(vals.get("tiente_id").toString()));
		return 1;
	}


}
