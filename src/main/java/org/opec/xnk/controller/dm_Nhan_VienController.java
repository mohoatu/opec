package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Nhan_Vien;
import org.opec.xnk.service.dm_Nhan_VienService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class dm_Nhan_VienController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Nhan_VienService")
	private dm_Nhan_VienService dm_Nhan_VienService;
	
	@RequestMapping(value="dm_nhan_vien", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_nhan_vien");
		return modelAndView;
	}

	// Danh muc Nha cung cap
	@RequestMapping(value = "/dm_nhan_vien/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Nhan_Vien> dataDmNcc() 
	{
		return dm_Nhan_VienService.getAll();
	}
	
	@RequestMapping(value = "/dm_nhan_vien/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Nhan_VienService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_nhan_vien/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Nhan_VienService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_nhan_vien/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Nhan_VienService.remove(Integer.parseInt(vals.get("nhanvien_id").toString()));
		return 1;
	}

}
