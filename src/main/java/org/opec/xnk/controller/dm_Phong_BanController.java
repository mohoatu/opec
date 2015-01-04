package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Phong_Ban;
import org.opec.xnk.service.dm_Phong_BanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Phong_BanController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Phong_BanService")
	private dm_Phong_BanService dm_Phong_BanService;
	
	@RequestMapping(value="dm_phong_ban", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_phong_ban");
		return modelAndView;
	}

	// Danh muc Nha cung cap
		@RequestMapping(value = "/dm_phong_ban/get", method = RequestMethod.GET)
		public @ResponseBody List<dm_Phong_Ban> dataDmNcc() 
		{
			return dm_Phong_BanService.getAll();
		}
		
		@RequestMapping(value = "/dm_phong_ban/update", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			dm_Phong_BanService.update(vals);
			return vals;
		}
		
		@RequestMapping(value = "/dm_phong_ban/insert", method = RequestMethod.POST)
		public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			return dm_Phong_BanService.insert(vals);
		}
		
		@RequestMapping(value = "/dm_phong_ban/delete", method = RequestMethod.POST)
		public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			dm_Phong_BanService.remove(Integer.parseInt(vals.get("donvi_id").toString()));
			return 1;
		}
}
