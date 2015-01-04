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
import org.opec.xnk.domain.sys_Log_Check_In;


@Service("sys_Log_Check_InService")
@Transactional

public class sys_Log_Check_InService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	
	public List<sys_Log_Check_In> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM sys_Log_Check_In");
		return  query.list();
	}

	
	public sys_Log_Check_In getOne(int Log_id) {
		Session session = sessionFactory.getCurrentSession();
		sys_Log_Check_In obj = (sys_Log_Check_In) session.get(sys_Log_Check_In.class, Log_id);
		return obj; 
	}

	
	public sys_Log_Check_In insert(sys_Log_Check_In obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	
	public void remove(int Log_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		sys_Log_Check_In obj = (sys_Log_Check_In) session.get(sys_Log_Check_In.class, Log_id);
		session.delete(obj);
	}

	
	public void update(sys_Log_Check_In obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Log_Check_In existingObj = (sys_Log_Check_In) session.get(sys_Log_Check_In.class, obj.getLog_id());
		existingObj.setLog_id(obj.getLog_id());
		existingObj.setUser_name(obj.getUser_name());
		existingObj.setCheck_in(obj.getCheck_in());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Log_Check_In obj = getOne(Integer.parseInt(fields.get("log_id").toString()));
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Log_Check_In obj = new sys_Log_Check_In();
		
		session.save(obj);
		return obj.getLog_id();
	}
	
}