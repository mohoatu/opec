package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Ung_Dung;
import org.opec.xnk.service.dm_Ung_DungService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Ung_DungController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Ung_DungService")
	private dm_Ung_DungService dm_Ung_DungService;
	
	@RequestMapping(value="dm_ung_dung", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_ung_dung");
		return modelAndView;
	}

	@RequestMapping(value = "/dm_ung_dung/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Ung_Dung> dataDmNcc() 
	{
		return dm_Ung_DungService.getAll();
	}
	
	@RequestMapping(value = "/dm_ung_dung/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Ung_DungService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_ung_dung/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Ung_DungService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_ung_dung/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Ung_DungService.remove(Integer.parseInt(vals.get("ungdung_id").toString()));
		return 1;
	}
}
