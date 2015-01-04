package org.opec.xnk.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opec.xnk.domain.sys_Menu;
import org.opec.xnk.domain.sys_MenuRight;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sys_MenuService")
@Transactional
public class sys_MenuService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public List<sys_Menu> getMenu()
	{
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("FROM sys_Menu");
		return  query.list();
		
	}
	
	public List<sys_MenuRight> getUserMenu()
	{
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "SELECT b.id AS id, " +
					" a.id AS menu_id, a.parentid, a.name, a.func, b.user_id, b.right, " +
					" true as r, true as w, true as d " + 
					" FROM sys_menu AS a LEFT JOIN user_menu AS b ON a.id=b.menu_id " + 
					" ORDER BY menu_id ";
		
		SQLQuery query = session.createSQLQuery(sql).addEntity(sys_MenuRight.class);
				
		return  query.list();
	}
	
	public void importXml(Map<String, Object> item)
	{
		Session session = sessionFactory.getCurrentSession();
		
		/*
		String sql = "DELETE FROM sys_menu";
		SQLQuery query = session.createSQLQuery(sql);
		query.executeUpdate();
		*/
		
		sys_Menu menu = new sys_Menu();
		menu.setId(item.get("id").toString());
		menu.setParentid(item.get("parentid").toString());
		menu.setFunc(item.get("func").toString());
		menu.setName(item.get("name").toString());
		menu.setSubMenuWidth(item.get("subMenuWidth").toString());
		menu.setFullscreen(Boolean.parseBoolean(item.get("fullscreen").toString()));
		
		session.save(menu);
	}
	
}
