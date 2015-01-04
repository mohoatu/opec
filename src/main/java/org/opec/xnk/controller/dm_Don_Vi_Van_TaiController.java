package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Don_Vi_Van_Tai;
import org.opec.xnk.service.dm_Don_Vi_Van_TaiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Don_Vi_Van_TaiController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Don_Vi_Van_TaiService")
	private dm_Don_Vi_Van_TaiService dm_Don_Vi_Van_TaiService;
	
	@RequestMapping(value="dm_don_vi_van_tai", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_don_vi_van_tai");
		return modelAndView;
	}

	// Danh muc Nha cung cap
	@RequestMapping(value = "/dm_don_vi_van_tai/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Don_Vi_Van_Tai> dataDmNcc() 
	{
		return dm_Don_Vi_Van_TaiService.getAll();
	}
	
	@RequestMapping(value = "/dm_don_vi_van_tai/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		System.out.println(vals.get("quocgia_id").toString());
		
		dm_Don_Vi_Van_TaiService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_don_vi_van_tai/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		System.out.println(vals.get("nhacungcap_ten").toString());
		
		//dm_Don_Vi_Van_TaiService.insert(vals);
		
		return 1;
	}
	
	@RequestMapping(value = "/dm_don_vi_van_tai/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		System.out.println(Integer.parseInt(vals.get("nhacungcap_id").toString()));
		
		dm_Don_Vi_Van_TaiService.remove(Integer.parseInt(vals.get("nhacungcap_id").toString()));
		
		return 1;
	}
}
