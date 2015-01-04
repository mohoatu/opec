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
import org.opec.xnk.domain.dm_Phuong_Thuc_Thanh_Toan;


@Service("dm_Phuong_Thuc_Thanh_ToanService")
@Transactional
public class dm_Phuong_Thuc_Thanh_ToanService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Phuong_Thuc_Thanh_Toan> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Phuong_Thuc_Thanh_Toan");
		return  query.list();
	}

	public List<dm_Phuong_Thuc_Thanh_Toan> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Phuong_Thuc_Thanh_Toan";
		else
			hql = "FROM dm_Phuong_Thuc_Thanh_Toan Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Phuong_Thuc_Thanh_Toan getOne(int Phuongthuctt_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Phuong_Thuc_Thanh_Toan obj = (dm_Phuong_Thuc_Thanh_Toan) session.get(dm_Phuong_Thuc_Thanh_Toan.class, Phuongthuctt_id);
		return obj; 
	}

	public dm_Phuong_Thuc_Thanh_Toan insert(dm_Phuong_Thuc_Thanh_Toan obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Phuongthuctt_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Phuong_Thuc_Thanh_Toan obj = (dm_Phuong_Thuc_Thanh_Toan) session.get(dm_Phuong_Thuc_Thanh_Toan.class, Phuongthuctt_id);
		session.delete(obj);
	}

	public void update(dm_Phuong_Thuc_Thanh_Toan obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phuong_Thuc_Thanh_Toan existingObj = (dm_Phuong_Thuc_Thanh_Toan) session.get(dm_Phuong_Thuc_Thanh_Toan.class, obj.getPhuongthuctt_id());
		existingObj.setPhuongthuctt_id(obj.getPhuongthuctt_id());
		existingObj.setPhuongthuctt_ma(obj.getPhuongthuctt_ma());
		existingObj.setPhuongthuctt_ten(obj.getPhuongthuctt_ten());
		session.save(existingObj);
	}
	
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phuong_Thuc_Thanh_Toan obj = getOne(Integer.parseInt(fields.get("phuongthuctt_id").toString()));
		
		obj.setPhuongthuctt_ma(fields.get("phuongthuctt_ma").toString());
		obj.setPhuongthuctt_ten(fields.get("phuongthuctt_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phuong_Thuc_Thanh_Toan obj = new dm_Phuong_Thuc_Thanh_Toan();
		
		obj.setPhuongthuctt_ma(fields.get("phuongthuctt_ma").toString());
		obj.setPhuongthuctt_ten(fields.get("phuongthuctt_ten").toString());
		
		session.save(obj);
		return obj.getPhuongthuctt_id();
	}
	
}