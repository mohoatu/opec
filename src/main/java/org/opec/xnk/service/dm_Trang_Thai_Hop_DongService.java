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
import org.opec.xnk.domain.dm_Trang_Thai_Hop_Dong;


@Service("dm_Trang_Thai_Hop_DongService")
@Transactional
public class dm_Trang_Thai_Hop_DongService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<dm_Trang_Thai_Hop_Dong> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Trang_Thai_Hop_Dong");
		return  query.list();
	}

	public List<dm_Trang_Thai_Hop_Dong> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Trang_Thai_Hop_Dong";
		else
			hql = "FROM dm_Trang_Thai_Hop_Dong Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Trang_Thai_Hop_Dong getOne(int Trangthai_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Trang_Thai_Hop_Dong obj = (dm_Trang_Thai_Hop_Dong) session.get(dm_Trang_Thai_Hop_Dong.class, Trangthai_id);
		return obj; 
	}

	public dm_Trang_Thai_Hop_Dong insert(dm_Trang_Thai_Hop_Dong obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Trangthai_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Trang_Thai_Hop_Dong obj = (dm_Trang_Thai_Hop_Dong) session.get(dm_Trang_Thai_Hop_Dong.class, Trangthai_id);
		session.delete(obj);
	}

	public void update(dm_Trang_Thai_Hop_Dong obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Trang_Thai_Hop_Dong existingObj = (dm_Trang_Thai_Hop_Dong) session.get(dm_Trang_Thai_Hop_Dong.class, obj.getTrangthai_id());
		existingObj.setTrangthai_id(obj.getTrangthai_id());
		existingObj.setTrangthai_ten(obj.getTrangthai_ten());
		session.save(existingObj);
	}

	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Trang_Thai_Hop_Dong obj = getOne(Integer.parseInt(fields.get("trangthai_id").toString()));
		
		obj.setTrangthai_ten(fields.get("trangthai_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Trang_Thai_Hop_Dong obj = new dm_Trang_Thai_Hop_Dong();
		
		obj.setTrangthai_ten(fields.get("trangthai_ten").toString());
		
		session.save(obj);
		return obj.getTrangthai_id();
	}
}