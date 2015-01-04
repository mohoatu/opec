package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Don_Vi_Van_Tai_Duong_Bo;
import org.opec.xnk.service.dm_Don_Vi_Van_Tai_Duong_BoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Don_Vi_Van_Tai_Duong_BoController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Don_Vi_Van_Tai_Duong_BoService")
	private dm_Don_Vi_Van_Tai_Duong_BoService dm_Don_Vi_Van_Tai_Duong_BoService;
	
	@RequestMapping(value="dm_don_vi_van_tai_duong_bo", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_don_vi_van_tai_duong_bo");
		return modelAndView;
	}

	// Danh muc Nha cung cap
		@RequestMapping(value = "/dm_don_vi_van_tai_duong_bo/get", method = RequestMethod.GET)
		public @ResponseBody List<dm_Don_Vi_Van_Tai_Duong_Bo> dataDmNcc() 
		{
			return dm_Don_Vi_Van_Tai_Duong_BoService.getAll();
		}
		
		@RequestMapping(value = "/dm_don_vi_van_tai_duong_bo/update", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			System.out.println(vals.get("quocgia_id").toString());
			
			dm_Don_Vi_Van_Tai_Duong_BoService.update(vals);
			return vals;
		}
		
		@RequestMapping(value = "/dm_don_vi_van_tai_duong_bo/insert", method = RequestMethod.POST)
		public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			System.out.println(vals.get("nhacungcap_ten").toString());
			
			//dm_Don_Vi_Van_Tai_Duong_BoService.insert(vals);
			
			return 1;
		}
		
		@RequestMapping(value = "/dm_don_vi_van_tai_duong_bo/delete", method = RequestMethod.POST)
		public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			System.out.println(Integer.parseInt(vals.get("nhacungcap_id").toString()));
			
			dm_Don_Vi_Van_Tai_Duong_BoService.remove(Integer.parseInt(vals.get("nhacungcap_id").toString()));
			
			return 1;
		}
}
