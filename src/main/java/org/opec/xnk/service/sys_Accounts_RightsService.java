package org.opec.xnk.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.opec.xnk.domain.sys_Accounts_Rights;


@Service("sys_Accounts_RightsService")
@Transactional

public class sys_Accounts_RightsService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	
	public List<sys_Accounts_Rights> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM sys_Accounts_Rights");
		return  query.list();
	}

	
	public sys_Accounts_Rights getOne(int Rights_id) {
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts_Rights obj = (sys_Accounts_Rights) session.get(sys_Accounts_Rights.class, Rights_id);
		return obj; 
	}

	
	public sys_Accounts_Rights insert(sys_Accounts_Rights obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	
	public void remove(int Rights_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		sys_Accounts_Rights obj = (sys_Accounts_Rights) session.get(sys_Accounts_Rights.class, Rights_id);
		session.delete(obj);
	}

	
	public void update(sys_Accounts_Rights obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts_Rights existingObj = (sys_Accounts_Rights) session.get(sys_Accounts_Rights.class, obj.getRights_id());
		existingObj.setRights_id(obj.getRights_id());
		existingObj.setUser_name(obj.getUser_name());
		existingObj.setMenu_id(obj.getMenu_id());
		existingObj.setIs_insert(obj.getIs_insert());
		existingObj.setIs_delete(obj.getIs_delete());
		existingObj.setIs_update(obj.getIs_update());
		existingObj.setIs_select(obj.getIs_select());
		existingObj.setUser_modify(obj.getUser_modify());
		existingObj.setDate_modify(obj.getDate_modify());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts_Rights obj = getOne(Integer.parseInt(fields.get("rights_id").toString()));
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts_Rights obj = new sys_Accounts_Rights();
		
		session.save(obj);
		return obj.getRights_id();
	}
	
}