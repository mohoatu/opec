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
import org.opec.xnk.domain.sys_Accounts_Groups;


@Service("sys_Accounts_GroupsService")
@Transactional

public class sys_Accounts_GroupsService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<sys_Accounts_Groups> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM sys_Accounts_Groups");
		return  query.list();
	}


	public sys_Accounts_Groups getOne(String Groups_id) {
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts_Groups obj = (sys_Accounts_Groups) session.get(sys_Accounts_Groups.class, Groups_id);
		return obj; 
	}


	public sys_Accounts_Groups insert(sys_Accounts_Groups obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(String Groups_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		sys_Accounts_Groups obj = (sys_Accounts_Groups) session.get(sys_Accounts_Groups.class, Groups_id);
		session.delete(obj);
	}


	public void update(sys_Accounts_Groups obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts_Groups existingObj = (sys_Accounts_Groups) session.get(sys_Accounts_Groups.class, obj.getGroups_id());
		existingObj.setGroups_id(obj.getGroups_id());
		existingObj.setGroups_name(obj.getGroups_name());
		existingObj.setDate_modify(obj.getDate_modify());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
	    sys_Accounts_Groups obj = getOne(fields.get("groups_id").toString());
		
		session.save(obj);
	}
	
	public String insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts_Groups obj = new sys_Accounts_Groups();
		
		session.save(obj);
		return obj.getGroups_id();
	}
	
}