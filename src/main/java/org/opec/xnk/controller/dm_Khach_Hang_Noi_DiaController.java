package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Khach_Hang_Noi_Dia;
import org.opec.xnk.domain.dm_Khach_Hang_Noi_Dia;
import org.opec.xnk.service.dm_Khach_Hang_Noi_DiaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Khach_Hang_Noi_DiaController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Khach_Hang_Noi_DiaService")
	private dm_Khach_Hang_Noi_DiaService dm_Khach_Hang_Noi_DiaService;
	

	@RequestMapping(value="dm_khach_hang_noi_dia", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_khach_hang_noi_dia");
		return modelAndView;
	}

	// Danh muc Nha cung cap
	@RequestMapping(value = "/dm_khach_hang_noi_dia/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Khach_Hang_Noi_Dia> dataDmNcc() 
	{
		return dm_Khach_Hang_Noi_DiaService.getAll();
	}
	
	@RequestMapping(value = "/dm_khach_hang_noi_dia/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Khach_Hang_Noi_DiaService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_khach_hang_noi_dia/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Khach_Hang_Noi_DiaService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_khach_hang_noi_dia/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Khach_Hang_Noi_DiaService.remove(Integer.parseInt(vals.get("khachhangnoidia_id").toString()));
		return 1;
	}
}
