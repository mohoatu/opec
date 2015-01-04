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
import org.opec.xnk.domain.dm_Thue_Suat;


@Service("dm_Thue_SuatService")
@Transactional
public class dm_Thue_SuatService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Thue_Suat> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Thue_Suat");
		return  query.list();
	}

	public List<dm_Thue_Suat> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Thue_Suat";
		else
			hql = "FROM dm_Thue_Suat Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Thue_Suat getOne(int Thuesuat_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Thue_Suat obj = (dm_Thue_Suat) session.get(dm_Thue_Suat.class, Thuesuat_id);
		return obj; 
	}

	public dm_Thue_Suat insert(dm_Thue_Suat obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Thuesuat_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Thue_Suat obj = (dm_Thue_Suat) session.get(dm_Thue_Suat.class, Thuesuat_id);
		session.delete(obj);
	}

	public void update(dm_Thue_Suat obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Thue_Suat existingObj = (dm_Thue_Suat) session.get(dm_Thue_Suat.class, obj.getThuesuat_id());
		existingObj.setThuesuat_id(obj.getThuesuat_id());
		existingObj.setThuesuat_ten(obj.getThuesuat_ten());
		existingObj.setTy_le_thue_suat(obj.getTy_le_thue_suat());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Thue_Suat obj = getOne(Integer.parseInt(fields.get("thuesuat_id").toString()));
		
		obj.setThuesuat_ten(fields.get("thuesuat_ten").toString());
		obj.setTy_le_thue_suat(Double.parseDouble(fields.get("ty_le_thue_suat").toString()));
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Thue_Suat obj = new dm_Thue_Suat();
		
		obj.setThuesuat_ten(fields.get("thuesuat_ten").toString());
		obj.setTy_le_thue_suat(Double.parseDouble(fields.get("ty_le_thue_suat").toString()));
		
		session.save(obj);
		return obj.getThuesuat_id();
	}
	
}