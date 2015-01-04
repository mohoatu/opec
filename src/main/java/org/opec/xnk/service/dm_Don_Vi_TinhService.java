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
import org.opec.xnk.domain.dm_Don_Vi_Tinh;


@Service("dm_Don_Vi_TinhService")
@Transactional
public class dm_Don_Vi_TinhService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Don_Vi_Tinh> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Don_Vi_Tinh");
		return  query.list();
	}

	public List<dm_Don_Vi_Tinh> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Don_Vi_Tinh";
		else
			hql = "FROM dm_Don_Vi_Tinh Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Don_Vi_Tinh getOne(int Id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Tinh obj = (dm_Don_Vi_Tinh) session.get(dm_Don_Vi_Tinh.class, Id);
		return obj; 
	}

	public dm_Don_Vi_Tinh insert(dm_Don_Vi_Tinh obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Tinh obj = (dm_Don_Vi_Tinh) session.get(dm_Don_Vi_Tinh.class, Id);
		session.delete(obj);
	}

	public void update(dm_Don_Vi_Tinh obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Tinh existingObj = (dm_Don_Vi_Tinh) session.get(dm_Don_Vi_Tinh.class, obj.getId());
		existingObj.setId(obj.getId());
		existingObj.setDon_vi_tinh(obj.getDon_vi_tinh());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Tinh obj = getOne(Integer.parseInt(fields.get("id").toString()));
		
		obj.setDon_vi_tinh(fields.get("don_vi_tinh").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Tinh obj = new dm_Don_Vi_Tinh();
		
		obj.setDon_vi_tinh(fields.get("don_vi_tinh").toString());
		
		session.save(obj);
		return obj.getId();
	}
	
}