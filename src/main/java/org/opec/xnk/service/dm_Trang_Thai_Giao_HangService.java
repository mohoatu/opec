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
import org.opec.xnk.domain.dm_Trang_Thai_Giao_Hang;


@Service("dm_Trang_Thai_Giao_HangService")
@Transactional
public class dm_Trang_Thai_Giao_HangService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Trang_Thai_Giao_Hang> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Trang_Thai_Giao_Hang");
		return  query.list();
	}

	public List<dm_Trang_Thai_Giao_Hang> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Trang_Thai_Giao_Hang";
		else
			hql = "FROM dm_Trang_Thai_Giao_Hang Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Trang_Thai_Giao_Hang getOne(int Trangthai_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Trang_Thai_Giao_Hang obj = (dm_Trang_Thai_Giao_Hang) session.get(dm_Trang_Thai_Giao_Hang.class, Trangthai_id);
		return obj; 
	}

	public dm_Trang_Thai_Giao_Hang insert(dm_Trang_Thai_Giao_Hang obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Trangthai_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Trang_Thai_Giao_Hang obj = (dm_Trang_Thai_Giao_Hang) session.get(dm_Trang_Thai_Giao_Hang.class, Trangthai_id);
		session.delete(obj);
	}

	public void update(dm_Trang_Thai_Giao_Hang obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Trang_Thai_Giao_Hang existingObj = (dm_Trang_Thai_Giao_Hang) session.get(dm_Trang_Thai_Giao_Hang.class, obj.getTrangthai_id());
		existingObj.setTrangthai_id(obj.getTrangthai_id());
		existingObj.setTrangthai_ten(obj.getTrangthai_ten());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Trang_Thai_Giao_Hang obj = getOne(Integer.parseInt(fields.get("trangthai_id").toString()));
		
		obj.setTrangthai_ten(fields.get("trangthai_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Trang_Thai_Giao_Hang obj = new dm_Trang_Thai_Giao_Hang();
		
		obj.setTrangthai_ten(fields.get("trangthai_ten").toString());
		
		session.save(obj);
		return obj.getTrangthai_id();
	}
	
}