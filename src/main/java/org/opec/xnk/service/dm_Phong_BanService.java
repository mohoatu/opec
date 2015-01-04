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
import org.opec.xnk.domain.dm_Phong_Ban;


@Service("dm_Phong_BanService")
@Transactional
public class dm_Phong_BanService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Phong_Ban> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Phong_Ban");
		return  query.list();
	}

	public List<dm_Phong_Ban> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Phong_Ban";
		else
			hql = "FROM dm_Phong_Ban Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Phong_Ban getOne(int Donvi_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Phong_Ban obj = (dm_Phong_Ban) session.get(dm_Phong_Ban.class, Donvi_id);
		return obj; 
	}

	public dm_Phong_Ban insert(dm_Phong_Ban obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Donvi_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Phong_Ban obj = (dm_Phong_Ban) session.get(dm_Phong_Ban.class, Donvi_id);
		session.delete(obj);
	}

	public void update(dm_Phong_Ban obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phong_Ban existingObj = (dm_Phong_Ban) session.get(dm_Phong_Ban.class, obj.getDonvi_id());
		existingObj.setDonvi_id(obj.getDonvi_id());
		existingObj.setDonvi_ma(obj.getDonvi_ma());
		existingObj.setDonvi_ten(obj.getDonvi_ten());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phong_Ban obj = getOne(Integer.parseInt(fields.get("donvi_id").toString()));
		
		obj.setDonvi_ma(fields.get("donvi_ma").toString());
		obj.setDonvi_ten(fields.get("donvi_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phong_Ban obj = new dm_Phong_Ban();
		
		obj.setDonvi_ma(fields.get("donvi_ma").toString());
		obj.setDonvi_ten(fields.get("donvi_ten").toString());
		
		session.save(obj);
		return obj.getDonvi_id();
	}
	
}