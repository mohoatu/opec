package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Loai_Container;
import org.opec.xnk.service.dm_Loai_ContainerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class dm_Loai_ContainerController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Loai_ContainerService")
	private dm_Loai_ContainerService dm_Loai_ContainerService;
	

	@RequestMapping(value="dm_loai_container", method = RequestMethod.GET)
	public ModelAndView viewPage()
	{
		ModelAndView modelAndView = new ModelAndView("data/dm_loai_container");
		return modelAndView;
	}
	
	@RequestMapping(value = "/dm_loai_container/get", method = RequestMethod.GET)
	public @ResponseBody List<dm_Loai_Container> dataDmNcc() 
	{
		return dm_Loai_ContainerService.getAll();
	}
	
	@RequestMapping(value = "/dm_loai_container/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Loai_ContainerService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_loai_container/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Loai_ContainerService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_loai_container/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Loai_ContainerService.remove(Integer.parseInt(vals.get("container_id").toString()));
		return 1;
	}
}
