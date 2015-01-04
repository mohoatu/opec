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
import org.opec.xnk.domain.dm_Muc_Do_Yeu_Cau;


@Service("dm_Muc_Do_Yeu_CauService")
@Transactional
public class dm_Muc_Do_Yeu_CauService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Muc_Do_Yeu_Cau> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Muc_Do_Yeu_Cau");
		return  query.list();
	}

	public List<dm_Muc_Do_Yeu_Cau> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Muc_Do_Yeu_Cau";
		else
			hql = "FROM dm_Muc_Do_Yeu_Cau Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Muc_Do_Yeu_Cau getOne(int Mucdoyc_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Muc_Do_Yeu_Cau obj = (dm_Muc_Do_Yeu_Cau) session.get(dm_Muc_Do_Yeu_Cau.class, Mucdoyc_id);
		return obj; 
	}

	public dm_Muc_Do_Yeu_Cau insert(dm_Muc_Do_Yeu_Cau obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Mucdoyc_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Muc_Do_Yeu_Cau obj = (dm_Muc_Do_Yeu_Cau) session.get(dm_Muc_Do_Yeu_Cau.class, Mucdoyc_id);
		session.delete(obj);
	}

	public void update(dm_Muc_Do_Yeu_Cau obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Muc_Do_Yeu_Cau existingObj = (dm_Muc_Do_Yeu_Cau) session.get(dm_Muc_Do_Yeu_Cau.class, obj.getMucdoyc_id());
		existingObj.setMucdoyc_id(obj.getMucdoyc_id());
		existingObj.setMucdoyc_ma(obj.getMucdoyc_ma());
		existingObj.setMucdoyc_ten(obj.getMucdoyc_ten());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Muc_Do_Yeu_Cau obj = getOne(Integer.parseInt(fields.get("mucdoyc_id").toString()));
		
		obj.setMucdoyc_ma(fields.get("mucdoyc_ma").toString());
		obj.setMucdoyc_ten(fields.get("mucdoyc_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Muc_Do_Yeu_Cau obj = new dm_Muc_Do_Yeu_Cau();
		
		obj.setMucdoyc_ma(fields.get("mucdoyc_ma").toString());
		obj.setMucdoyc_ten(fields.get("mucdoyc_ten").toString());
		
		session.save(obj);
		return obj.getMucdoyc_id();
	}
}