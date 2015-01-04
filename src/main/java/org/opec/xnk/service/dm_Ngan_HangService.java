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
import org.opec.xnk.domain.dm_Ngan_Hang;


@Service("dm_Ngan_HangService")
@Transactional
public class dm_Ngan_HangService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Ngan_Hang> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Ngan_Hang");
		return  query.list();
	}

	public List<dm_Ngan_Hang> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Ngan_Hang";
		else
			hql = "FROM dm_Ngan_Hang Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Ngan_Hang getOne(int Nganhang_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Ngan_Hang obj = (dm_Ngan_Hang) session.get(dm_Ngan_Hang.class, Nganhang_id);
		return obj; 
	}

	public dm_Ngan_Hang insert(dm_Ngan_Hang obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Nganhang_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Ngan_Hang obj = (dm_Ngan_Hang) session.get(dm_Ngan_Hang.class, Nganhang_id);
		session.delete(obj);
	}

	public void update(dm_Ngan_Hang obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Ngan_Hang existingObj = (dm_Ngan_Hang) session.get(dm_Ngan_Hang.class, obj.getNganhang_id());
		existingObj.setNganhang_id(obj.getNganhang_id());
		existingObj.setNganhang_ma(obj.getNganhang_ma());
		existingObj.setNganhang_ten(obj.getNganhang_ten());
		existingObj.setDia_chi(obj.getDia_chi());
		existingObj.setNguoi_lien_he(obj.getNguoi_lien_he());
		existingObj.setDien_thoai(obj.getDien_thoai());
		existingObj.setFax(obj.getFax());
		existingObj.setGhi_chu(obj.getGhi_chu());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Ngan_Hang obj = getOne(Integer.parseInt(fields.get("nganhang_id").toString()));
		
		obj.setNganhang_ma(fields.get("nganhang_ma").toString());
		obj.setNganhang_ten(fields.get("nganhang_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Ngan_Hang obj = new dm_Ngan_Hang();
		
		obj.setNganhang_ma(fields.get("nganhang_ma").toString());
		obj.setNganhang_ten(fields.get("nganhang_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		
		session.save(obj);
		return obj.getNganhang_id();
	}
	
}