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
import org.opec.xnk.domain.dm_Ung_Dung;


@Service("dm_Ung_DungService")
@Transactional
public class dm_Ung_DungService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Ung_Dung> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Ung_Dung");
		return  query.list();
	}

	public List<dm_Ung_Dung> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Ung_Dung";
		else
			hql = "FROM dm_Ung_Dung Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Ung_Dung getOne(int Ungdung_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Ung_Dung obj = (dm_Ung_Dung) session.get(dm_Ung_Dung.class, Ungdung_id);
		return obj; 
	}

	public dm_Ung_Dung insert(dm_Ung_Dung obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Ungdung_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Ung_Dung obj = (dm_Ung_Dung) session.get(dm_Ung_Dung.class, Ungdung_id);
		session.delete(obj);
	}

	public void update(dm_Ung_Dung obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Ung_Dung existingObj = (dm_Ung_Dung) session.get(dm_Ung_Dung.class, obj.getUngdung_id());
		existingObj.setUngdung_id(obj.getUngdung_id());
		existingObj.setUngdung_ma(obj.getUngdung_ma());
		existingObj.setUngdung_ten(obj.getUngdung_ten());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Ung_Dung obj = getOne(Integer.parseInt(fields.get("ungdung_id").toString()));
		
		obj.setUngdung_ma(fields.get("ungdung_ma").toString());
		obj.setUngdung_ten(fields.get("ungdung_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Ung_Dung obj = new dm_Ung_Dung();
		
		obj.setUngdung_ma(fields.get("ungdung_ma").toString());
		obj.setUngdung_ten(fields.get("ungdung_ten").toString());
		
		session.save(obj);
		return obj.getUngdung_id();
	}
}