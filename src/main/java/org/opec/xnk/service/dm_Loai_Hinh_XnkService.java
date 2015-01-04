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
import org.opec.xnk.domain.dm_Loai_Hinh_Xnk;


@Service("dm_Loai_Hinh_XnkService")
@Transactional
public class dm_Loai_Hinh_XnkService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Loai_Hinh_Xnk> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Loai_Hinh_Xnk");
		return  query.list();
	}

	public List<dm_Loai_Hinh_Xnk> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Loai_Hinh_Xnk";
		else
			hql = "FROM dm_Loai_Hinh_Xnk Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Loai_Hinh_Xnk getOne(int Loaihinhxnk_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Hinh_Xnk obj = (dm_Loai_Hinh_Xnk) session.get(dm_Loai_Hinh_Xnk.class, Loaihinhxnk_id);
		return obj; 
	}

	public dm_Loai_Hinh_Xnk insert(dm_Loai_Hinh_Xnk obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Loaihinhxnk_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Hinh_Xnk obj = (dm_Loai_Hinh_Xnk) session.get(dm_Loai_Hinh_Xnk.class, Loaihinhxnk_id);
		session.delete(obj);
	}

	public void update(dm_Loai_Hinh_Xnk obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Hinh_Xnk existingObj = (dm_Loai_Hinh_Xnk) session.get(dm_Loai_Hinh_Xnk.class, obj.getLoaihinhxnk_id());
		existingObj.setLoaihinhxnk_id(obj.getLoaihinhxnk_id());
		existingObj.setLoaihinhxnk_ma(obj.getLoaihinhxnk_ma());
		existingObj.setLoaihinhxnk_ten(obj.getLoaihinhxnk_ten());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Hinh_Xnk obj = getOne(Integer.parseInt(fields.get("loaihinhxnk_id").toString()));
		
		obj.setLoaihinhxnk_ma(fields.get("loaihinhxnk_ma").toString());
		obj.setLoaihinhxnk_ten(fields.get("loaihinhxnk_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Hinh_Xnk obj = new dm_Loai_Hinh_Xnk();
		
		obj.setLoaihinhxnk_ma(fields.get("loaihinhxnk_ma").toString());
		obj.setLoaihinhxnk_ten(fields.get("loaihinhxnk_ten").toString());
		
		session.save(obj);
		return obj.getLoaihinhxnk_id();
	}
	
}