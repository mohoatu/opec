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
import org.opec.xnk.domain.sys_Log_Error;


@Service("sys_Log_ErrorService")
@Transactional

public class sys_Log_ErrorService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	
	public List<sys_Log_Error> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM sys_Log_Error");
		return  query.list();
	}

	
	public sys_Log_Error getOne(int Error_id) {
		Session session = sessionFactory.getCurrentSession();
		sys_Log_Error obj = (sys_Log_Error) session.get(sys_Log_Error.class, Error_id);
		return obj; 
	}

	
	public sys_Log_Error insert(sys_Log_Error obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	
	public void remove(int Error_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		sys_Log_Error obj = (sys_Log_Error) session.get(sys_Log_Error.class, Error_id);
		session.delete(obj);
	}

	
	public void update(sys_Log_Error obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Log_Error existingObj = (sys_Log_Error) session.get(sys_Log_Error.class, obj.getError_id());
		existingObj.setError_id(obj.getError_id());
		existingObj.setError_name(obj.getError_name());
		existingObj.setUser_name(obj.getUser_name());
		existingObj.setUser_ip(obj.getUser_ip());
		existingObj.setModule(obj.getModule());
		existingObj.setDate_error(obj.getDate_error());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Log_Error obj = getOne(Integer.parseInt(fields.get("error_id").toString()));
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Log_Error obj = new sys_Log_Error();
		
		session.save(obj);
		return obj.getError_id();
	}
}