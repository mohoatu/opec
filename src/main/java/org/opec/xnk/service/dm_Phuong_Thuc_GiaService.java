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
import org.opec.xnk.domain.dm_Phuong_Thuc_Gia;


@Service("dm_Phuong_Thuc_GiaService")
@Transactional
public class dm_Phuong_Thuc_GiaService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Phuong_Thuc_Gia> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Phuong_Thuc_Gia");
		return  query.list();
	}

	public List<dm_Phuong_Thuc_Gia> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Phuong_Thuc_Gia";
		else
			hql = "FROM dm_Phuong_Thuc_Gia Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Phuong_Thuc_Gia getOne(int Phuongthucgia_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Phuong_Thuc_Gia obj = (dm_Phuong_Thuc_Gia) session.get(dm_Phuong_Thuc_Gia.class, Phuongthucgia_id);
		return obj; 
	}

	public dm_Phuong_Thuc_Gia insert(dm_Phuong_Thuc_Gia obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Phuongthucgia_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Phuong_Thuc_Gia obj = (dm_Phuong_Thuc_Gia) session.get(dm_Phuong_Thuc_Gia.class, Phuongthucgia_id);
		session.delete(obj);
	}

	public void update(dm_Phuong_Thuc_Gia obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phuong_Thuc_Gia existingObj = (dm_Phuong_Thuc_Gia) session.get(dm_Phuong_Thuc_Gia.class, obj.getPhuongthucgia_id());
		existingObj.setPhuongthucgia_id(obj.getPhuongthucgia_id());
		existingObj.setPhuongthucgia_ma(obj.getPhuongthucgia_ma());
		existingObj.setPhuongthucgia_ten(obj.getPhuongthucgia_ten());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phuong_Thuc_Gia obj = getOne(Integer.parseInt(fields.get("phuongthucgia_id").toString()));
		
		obj.setPhuongthucgia_ma(fields.get("phuongthucgia_ma").toString());
		obj.setPhuongthucgia_ten(fields.get("phuongthucgia_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phuong_Thuc_Gia obj = new dm_Phuong_Thuc_Gia();
		
		obj.setPhuongthucgia_ma(fields.get("phuongthucgia_ma").toString());
		obj.setPhuongthucgia_ten(fields.get("phuongthucgia_ten").toString());
		
		session.save(obj);
		return obj.getPhuongthucgia_id();
	}
}