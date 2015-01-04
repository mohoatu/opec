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
import org.opec.xnk.domain.dm_Don_Vi_Van_Tai_Duong_Bo;


@Service("dm_Don_Vi_Van_Tai_Duong_BoService")
@Transactional
public class dm_Don_Vi_Van_Tai_Duong_BoService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Don_Vi_Van_Tai_Duong_Bo> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Don_Vi_Van_Tai_Duong_Bo");
		return  query.list();
	}

	public List<dm_Don_Vi_Van_Tai_Duong_Bo> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Don_Vi_Van_Tai_Duong_Bo";
		else
			hql = "FROM dm_Don_Vi_Van_Tai_Duong_Bo Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Don_Vi_Van_Tai_Duong_Bo getOne(int Forwarder_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Van_Tai_Duong_Bo obj = (dm_Don_Vi_Van_Tai_Duong_Bo) session.get(dm_Don_Vi_Van_Tai_Duong_Bo.class, Forwarder_id);
		return obj; 
	}

	public dm_Don_Vi_Van_Tai_Duong_Bo insert(dm_Don_Vi_Van_Tai_Duong_Bo obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Forwarder_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Van_Tai_Duong_Bo obj = (dm_Don_Vi_Van_Tai_Duong_Bo) session.get(dm_Don_Vi_Van_Tai_Duong_Bo.class, Forwarder_id);
		session.delete(obj);
	}

	public void update(dm_Don_Vi_Van_Tai_Duong_Bo obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Van_Tai_Duong_Bo existingObj = (dm_Don_Vi_Van_Tai_Duong_Bo) session.get(dm_Don_Vi_Van_Tai_Duong_Bo.class, obj.getForwarder_id());
		existingObj.setForwarder_id(obj.getForwarder_id());
		existingObj.setForwarder_ma(obj.getForwarder_ma());
		existingObj.setForwarder_ten(obj.getForwarder_ten());
		existingObj.setDia_chi(obj.getDia_chi());
		existingObj.setNguoi_lien_he(obj.getNguoi_lien_he());
		existingObj.setDien_thoai(obj.getDien_thoai());
		existingObj.setFax(obj.getFax());
		existingObj.setQuocgia_id(obj.getQuocgia_id());
		existingObj.setGhi_chu(obj.getGhi_chu());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Van_Tai_Duong_Bo obj = getOne(Integer.parseInt(fields.get("forwarder_id").toString()));
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Van_Tai_Duong_Bo obj = new dm_Don_Vi_Van_Tai_Duong_Bo();
		
		session.save(obj);
		return obj.getForwarder_id();
	}
	
}