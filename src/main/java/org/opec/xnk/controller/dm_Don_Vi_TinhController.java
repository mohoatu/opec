package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Don_Vi_Tinh;
import org.opec.xnk.service.dm_Don_Vi_TinhService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Don_Vi_TinhController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Don_Vi_TinhService")
	private dm_Don_Vi_TinhService dm_Don_Vi_TinhService;
	
	@RequestMapping(value="dm_don_vi_tinh", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_don_vi_tinh");
		return modelAndView;
	}

	@RequestMapping(value = "/dm_don_vi_tinh/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Don_Vi_Tinh> dataDmNcc() 
	{
		return dm_Don_Vi_TinhService.getAll();
	}
	
	@RequestMapping(value = "/dm_don_vi_tinh/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Don_Vi_TinhService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_don_vi_tinh/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Don_Vi_TinhService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_don_vi_tinh/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Don_Vi_TinhService.remove(Integer.parseInt(vals.get("id").toString()));
		return 1;
	}
}
