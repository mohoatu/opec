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
import org.opec.xnk.domain.dm_Don_Vi_Van_Tai;
import org.opec.xnk.util.NumberUtil;


@Service("dm_Don_Vi_Van_TaiService")
@Transactional
public class dm_Don_Vi_Van_TaiService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Don_Vi_Van_Tai> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Don_Vi_Van_Tai");
		return  query.list();
	}

	public List<dm_Don_Vi_Van_Tai> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Don_Vi_Van_Tai";
		else
			hql = "FROM dm_Don_Vi_Van_Tai Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Don_Vi_Van_Tai getOne(int Dvvantai_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Van_Tai obj = (dm_Don_Vi_Van_Tai) session.get(dm_Don_Vi_Van_Tai.class, Dvvantai_id);
		return obj; 
	}

	public dm_Don_Vi_Van_Tai insert(dm_Don_Vi_Van_Tai obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Dvvantai_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Van_Tai obj = (dm_Don_Vi_Van_Tai) session.get(dm_Don_Vi_Van_Tai.class, Dvvantai_id);
		session.delete(obj);
	}

	public void update(dm_Don_Vi_Van_Tai obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Van_Tai existingObj = (dm_Don_Vi_Van_Tai) session.get(dm_Don_Vi_Van_Tai.class, obj.getDvvantai_id());
		existingObj.setDvvantai_id(obj.getDvvantai_id());
		existingObj.setDvvantai_ma(obj.getDvvantai_ma());
		existingObj.setDvvantai_ten(obj.getDvvantai_ten());
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
		dm_Don_Vi_Van_Tai obj = getOne(Integer.parseInt(fields.get("dvvantai_id").toString()));
		
		save(fields, obj);
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Don_Vi_Van_Tai obj = new dm_Don_Vi_Van_Tai();
		
		save(fields, obj);
		
		session.save(obj);
		return obj.getDvvantai_id();
	}
	
	public void save(Map<String, Object> fields, dm_Don_Vi_Van_Tai obj)
	{
		//obj.setDvvantai_id(obj.getDvvantai_id());
		obj.setDvvantai_ma(fields.get("dvvantai_ma").toString());
		obj.setDvvantai_ten(fields.get("dvvantai_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		if(fields.keySet().contains("quocgia_id"))
			obj.setQuocgia_id(NumberUtil.getInterger(fields.get("quocgia_id")));
		obj.setGhi_chu(fields.get("ghi_chu").toString());
	}
	
}