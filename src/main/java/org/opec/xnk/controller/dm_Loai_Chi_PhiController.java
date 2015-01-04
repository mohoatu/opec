package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Loai_Chi_Phi;
import org.opec.xnk.service.dm_Loai_Chi_PhiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Loai_Chi_PhiController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Loai_Chi_PhiService")
	private dm_Loai_Chi_PhiService dm_Loai_Chi_PhiService;
	
	@RequestMapping(value="dm_loai_chi_phi", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_loai_chi_phi");
		return modelAndView;
	}

	// Danh muc Nha cung cap
		@RequestMapping(value = "/dm_loai_chi_phi/get", method = RequestMethod.GET)
		public @ResponseBody List<dm_Loai_Chi_Phi> dataDmNcc() 
		{
			return dm_Loai_Chi_PhiService.getAll();
		}
		
		@RequestMapping(value = "/dm_loai_chi_phi/update", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			dm_Loai_Chi_PhiService.update(vals);
			return vals;
		}
		
		@RequestMapping(value = "/dm_loai_chi_phi/insert", method = RequestMethod.POST)
		public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			return dm_Loai_Chi_PhiService.insert(vals);
		}
		
		@RequestMapping(value = "/dm_loai_chi_phi/delete", method = RequestMethod.POST)
		public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			dm_Loai_Chi_PhiService.remove(Integer.parseInt(vals.get("loaichiphi_id").toString()));
			return 1;
		}
}
