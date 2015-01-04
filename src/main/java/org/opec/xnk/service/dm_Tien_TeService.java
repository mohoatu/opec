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
import org.opec.xnk.domain.dm_Tien_Te;


@Service("dm_Tien_TeService")
@Transactional
public class dm_Tien_TeService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Tien_Te> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Tien_Te");
		return  query.list();
	}

	public List<dm_Tien_Te> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Tien_Te";
		else
			hql = "FROM dm_Tien_Te Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Tien_Te getOne(int Tiente_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Tien_Te obj = (dm_Tien_Te) session.get(dm_Tien_Te.class, Tiente_id);
		return obj; 
	}

	public dm_Tien_Te insert(dm_Tien_Te obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Tiente_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Tien_Te obj = (dm_Tien_Te) session.get(dm_Tien_Te.class, Tiente_id);
		session.delete(obj);
	}

	public void update(dm_Tien_Te obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Tien_Te existingObj = (dm_Tien_Te) session.get(dm_Tien_Te.class, obj.getTiente_id());
		existingObj.setTiente_id(obj.getTiente_id());
		existingObj.setTiente_ma(obj.getTiente_ma());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Tien_Te obj = getOne(Integer.parseInt(fields.get("tiente_id").toString()));
		
		obj.setTiente_ma(fields.get("tiente_ma").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Tien_Te obj = new dm_Tien_Te();
		
		obj.setTiente_ma(fields.get("tiente_ma").toString());
		
		session.save(obj);
		return obj.getTiente_id();
	}
	
}