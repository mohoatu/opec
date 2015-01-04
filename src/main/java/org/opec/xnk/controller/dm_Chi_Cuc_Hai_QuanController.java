package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Chi_Cuc_Hai_Quan;
import org.opec.xnk.service.dm_Chi_Cuc_Hai_QuanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Chi_Cuc_Hai_QuanController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Chi_Cuc_Hai_QuanService")
	private dm_Chi_Cuc_Hai_QuanService dm_Chi_Cuc_Hai_QuanService;
	
	@RequestMapping(value="dm_chi_cuc_hai_quan", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_chi_cuc_hai_quan");
		return modelAndView;
	}

	@RequestMapping(value = "/dm_chi_cuc_hai_quan/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Chi_Cuc_Hai_Quan> dataDmNcc() 
	{
		return dm_Chi_Cuc_Hai_QuanService.getAll();
	}
	
	@RequestMapping(value = "/dm_chi_cuc_hai_quan/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Chi_Cuc_Hai_QuanService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_chi_cuc_hai_quan/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Chi_Cuc_Hai_QuanService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_chi_cuc_hai_quan/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Chi_Cuc_Hai_QuanService.remove(Integer.parseInt(vals.get("chicuchq_id").toString()));
		
		return 1;
	}
}
