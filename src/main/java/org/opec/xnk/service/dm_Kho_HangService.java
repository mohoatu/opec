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
import org.opec.xnk.domain.dm_Kho_Hang;


@Service("dm_Kho_HangService")
@Transactional
public class dm_Kho_HangService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Kho_Hang> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Kho_Hang");
		return  query.list();
	}

	public List<dm_Kho_Hang> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Kho_Hang";
		else
			hql = "FROM dm_Kho_Hang Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Kho_Hang getOne(int Kho_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Kho_Hang obj = (dm_Kho_Hang) session.get(dm_Kho_Hang.class, Kho_id);
		return obj; 
	}

	public dm_Kho_Hang insert(dm_Kho_Hang obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Kho_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Kho_Hang obj = (dm_Kho_Hang) session.get(dm_Kho_Hang.class, Kho_id);
		session.delete(obj);
	}

	public void update(dm_Kho_Hang obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Kho_Hang existingObj = (dm_Kho_Hang) session.get(dm_Kho_Hang.class, obj.getKho_id());
		existingObj.setKho_id(obj.getKho_id());
		existingObj.setMa_kho(obj.getMa_kho());
		existingObj.setTen_kho(obj.getTen_kho());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Kho_Hang obj = getOne(Integer.parseInt(fields.get("kho_id").toString()));
		
		
		obj.setMa_kho(fields.get("ma_kho").toString());
		obj.setTen_kho(fields.get("ten_kho").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) {
		logger.debug("Them doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Kho_Hang obj = new dm_Kho_Hang();
				
		obj.setMa_kho(fields.get("ma_kho").toString());
		obj.setTen_kho(fields.get("ten_kho").toString());
		
		session.save(obj);
		
		return obj.getKho_id();
	}
}