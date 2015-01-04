package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Muc_Do_Yeu_Cau;
import org.opec.xnk.service.dm_Muc_Do_Yeu_CauService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Muc_Do_Yeu_CauController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Muc_Do_Yeu_CauService")
	private dm_Muc_Do_Yeu_CauService dm_Muc_Do_Yeu_CauService;
	
	@RequestMapping(value="dm_muc_do_yeu_cau", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_muc_do_yeu_cau");
		return modelAndView;
	}

	@RequestMapping(value = "/dm_muc_do_yeu_cau/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Muc_Do_Yeu_Cau> dataDmNcc() 
	{
		return dm_Muc_Do_Yeu_CauService.getAll();
	}
	
	@RequestMapping(value = "/dm_muc_do_yeu_cau/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Muc_Do_Yeu_CauService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_muc_do_yeu_cau/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Muc_Do_Yeu_CauService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_muc_do_yeu_cau/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Muc_Do_Yeu_CauService.remove(Integer.parseInt(vals.get("mucdoyc_id").toString()));
		return 1;
	}


}
