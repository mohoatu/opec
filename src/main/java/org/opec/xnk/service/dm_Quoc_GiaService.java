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
import org.opec.xnk.domain.dm_Quoc_Gia;


@Service("dm_Quoc_GiaService")
@Transactional
public class dm_Quoc_GiaService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Quoc_Gia> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Quoc_Gia");
		return  query.list();
	}

	public List<dm_Quoc_Gia> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Quoc_Gia";
		else
			hql = "FROM dm_Quoc_Gia Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Quoc_Gia getOne(int Quocgia_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Quoc_Gia obj = (dm_Quoc_Gia) session.get(dm_Quoc_Gia.class, Quocgia_id);
		return obj; 
	}

	public dm_Quoc_Gia insert(dm_Quoc_Gia obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Quocgia_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Quoc_Gia obj = (dm_Quoc_Gia) session.get(dm_Quoc_Gia.class, Quocgia_id);
		session.delete(obj);
	}

	public void update(dm_Quoc_Gia obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Quoc_Gia existingObj = (dm_Quoc_Gia) session.get(dm_Quoc_Gia.class, obj.getQuocgia_id());
		existingObj.setQuocgia_id(obj.getQuocgia_id());
		existingObj.setQuocgia_ten(obj.getQuocgia_ten());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Quoc_Gia obj = getOne(Integer.parseInt(fields.get("quocgia_id").toString()));
		
		obj.setQuocgia_ten(fields.get("quocgia_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Quoc_Gia obj = new dm_Quoc_Gia();
		
		obj.setQuocgia_ten(fields.get("quocgia_ten").toString());
		
		session.save(obj);
		return obj.getQuocgia_id();
	}
	
}