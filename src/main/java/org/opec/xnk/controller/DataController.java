package org.opec.xnk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.opec.xnk.domain.dm_Nha_Cung_Cap;
import org.opec.xnk.domain.dm_Nha_San_Xuat;
import org.opec.xnk.service.dm_Nha_Cung_CapService;
import org.opec.xnk.service.dm_Nha_San_XuatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/data")
public class DataController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="dm_Nha_Cung_CapService")
	private dm_Nha_Cung_CapService dm_Nha_Cung_CapService; 
	
	@Resource(name="dm_Nha_San_XuatService")
	private dm_Nha_San_XuatService dm_Nha_San_XuatService; 
	
	
	// Danh muc Nha cung cap
	@RequestMapping(value = "dm_ncc", method = RequestMethod.GET)
	public @ResponseBody List<dm_Nha_Cung_Cap> dataDmNcc() 
	{
		return dm_Nha_Cung_CapService.getAll();
	}
	
	@RequestMapping(value = "/dm_ncc/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		System.out.println(vals.get("quocgia_id").toString());
		
		dm_Nha_Cung_CapService.update(vals);
		return vals;
	}
	
	@RequestMapping(value = "/dm_ncc/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		System.out.println(vals.get("nhacungcap_ten").toString());
		
		return dm_Nha_Cung_CapService.insert(vals);
	}
	
	@RequestMapping(value = "/dm_ncc/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNcc(@RequestBody Map<String, Object> vals,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		System.out.println(Integer.parseInt(vals.get("nhacungcap_id").toString()));
		
		dm_Nha_Cung_CapService.remove(Integer.parseInt(vals.get("nhacungcap_id").toString()));
		
		return 1;
	}
	
	// Danh muc nha san xuat
	@RequestMapping(value = "/dm_nsx", method = RequestMethod.GET)
	public @ResponseBody List<dm_Nha_San_Xuat> dataDmNsx() 
	{
		return dm_Nha_San_XuatService.getAll();
	}
	
	@RequestMapping(value = "/dm_nsx/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDataDmNsx(@RequestBody Map<String, Object> fields,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Nha_San_XuatService.update(fields);
		return fields;
	}
	
	@RequestMapping(value = "/dm_nsx/insert", method = RequestMethod.POST)
	public @ResponseBody Integer insertDataDmNsx(@RequestBody Map<String, Object> fields,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		return dm_Nha_San_XuatService.insert(fields);
	}
	
	@RequestMapping(value = "/dm_nsx/delete", method = RequestMethod.POST)
	public @ResponseBody Integer deleteDataDmNsx(@RequestBody Map<String, Object> fields,
			final HttpServletRequest request,
			final HttpServletResponse response)
	{
		dm_Nha_San_XuatService.remove(Integer.parseInt(fields.get("nhasanxuat_id").toString()));
		
		return 1;
	}
}
