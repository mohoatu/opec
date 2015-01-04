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
import org.opec.xnk.domain.dm_Loai_Chi_Phi;


@Service("dm_Loai_Chi_PhiService")
@Transactional
public class dm_Loai_Chi_PhiService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Loai_Chi_Phi> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Loai_Chi_Phi");
		return  query.list();
	}

	public List<dm_Loai_Chi_Phi> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Loai_Chi_Phi";
		else
			hql = "FROM dm_Loai_Chi_Phi Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Loai_Chi_Phi getOne(int Loaichiphi_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Chi_Phi obj = (dm_Loai_Chi_Phi) session.get(dm_Loai_Chi_Phi.class, Loaichiphi_id);
		return obj; 
	}

	public dm_Loai_Chi_Phi insert(dm_Loai_Chi_Phi obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Loaichiphi_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Chi_Phi obj = (dm_Loai_Chi_Phi) session.get(dm_Loai_Chi_Phi.class, Loaichiphi_id);
		session.delete(obj);
	}

	public void update(dm_Loai_Chi_Phi obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Chi_Phi existingObj = (dm_Loai_Chi_Phi) session.get(dm_Loai_Chi_Phi.class, obj.getLoaichiphi_id());
		existingObj.setLoaichiphi_id(obj.getLoaichiphi_id());
		existingObj.setLoaichiphi_ma(obj.getLoaichiphi_ma());
		existingObj.setLoaichiphi_ten(obj.getLoaichiphi_ten());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Chi_Phi obj = getOne(Integer.parseInt(fields.get("loaichiphi_id").toString()));
		
		obj.setLoaichiphi_ma(fields.get("loaichiphi_ma").toString());
		obj.setLoaichiphi_ten(fields.get("loaichiphi_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Chi_Phi obj = new dm_Loai_Chi_Phi();
		
		obj.setLoaichiphi_ma(fields.get("loaichiphi_ma").toString());
		obj.setLoaichiphi_ten(fields.get("loaichiphi_ten").toString());
		
		session.save(obj);
		return obj.getLoaichiphi_id();
	}
	
}