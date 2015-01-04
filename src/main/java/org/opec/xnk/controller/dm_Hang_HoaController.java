package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Hang_Hoa;
import org.opec.xnk.domain.dm_Hang_Hoa;
import org.opec.xnk.service.dm_Hang_HoaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Hang_HoaController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Hang_HoaService")
	private dm_Hang_HoaService dm_Hang_HoaService;
		
	@RequestMapping(value="dm_hang_hoa", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_hang_hoa");
		return modelAndView;
	}

	@RequestMapping(value = "/dm_hang_hoa/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Hang_Hoa> data() 
	{
		return dm_Hang_HoaService.getAll();
	}
	
	@RequestMapping(value = "/dm_hang_hoa/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> update(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Hang_HoaService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_hang_hoa/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insert(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Hang_HoaService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_hang_hoa/delete", method = RequestMethod.POST)
	public @ResponseBody Integer delete(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Hang_HoaService.remove(Integer.parseInt(vals.get("hang_id").toString()));
		return 1;
	}

}
