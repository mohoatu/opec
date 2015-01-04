package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Hang_Tau_Bien;
import org.opec.xnk.service.dm_Hang_Tau_BienService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class dm_Hang_Tau_BienController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Hang_Tau_BienService")
	private dm_Hang_Tau_BienService dm_Hang_Tau_BienService;
	
	@RequestMapping(value="dm_hang_tau_bien", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_hang_tau_bien");
		return modelAndView;
	}

	// Danh muc Nha cung cap
		@RequestMapping(value = "/dm_hang_tau_bien/get", method = RequestMethod.GET)
		public @ResponseBody List<dm_Hang_Tau_Bien> dataDmNcc() 
		{
			return dm_Hang_Tau_BienService.getAll();
		}
		
		@RequestMapping(value = "/dm_hang_tau_bien/update", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			System.out.println(vals.get("quocgia_id").toString());
			
			dm_Hang_Tau_BienService.update(vals);
			return vals;
		}
		
		@RequestMapping(value = "/dm_hang_tau_bien/insert", method = RequestMethod.POST)
		public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			System.out.println(vals.get("nhacungcap_ten").toString());
			
			//dm_Hang_Tau_BienService.insert(vals);
			
			return 1;
		}
		
		@RequestMapping(value = "/dm_hang_tau_bien/delete", method = RequestMethod.POST)
		public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
				final HttpServletRequest request,
				final HttpServletResponse response)
		{
			System.out.println(Integer.parseInt(vals.get("nhacungcap_id").toString()));
			
			dm_Hang_Tau_BienService.remove(Integer.parseInt(vals.get("nhacungcap_id").toString()));
			
			return 1;
		}
}
