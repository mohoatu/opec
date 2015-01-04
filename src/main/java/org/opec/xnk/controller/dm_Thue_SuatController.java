package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Thue_Suat;
import org.opec.xnk.service.dm_Thue_SuatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Thue_SuatController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Thue_SuatService")
	private dm_Thue_SuatService dm_Thue_SuatService;
	

	@RequestMapping(value="dm_thue_suat", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_thue_suat");
		return modelAndView;
	}

	@RequestMapping(value = "/dm_thue_suat/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Thue_Suat> dataDmNcc() 
	{
		return dm_Thue_SuatService.getAll();
	}
	
	@RequestMapping(value = "/dm_thue_suat/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Thue_SuatService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_thue_suat/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Thue_SuatService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_thue_suat/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Thue_SuatService.remove(Integer.parseInt(vals.get("thuesuat_id").toString()));
		return 1;
	}

}
