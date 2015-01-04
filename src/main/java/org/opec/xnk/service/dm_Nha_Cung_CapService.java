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
import org.opec.xnk.domain.dm_Nha_Cung_Cap;


@Service("dm_Nha_Cung_CapService")
@Transactional
public class dm_Nha_Cung_CapService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Nha_Cung_Cap> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Nha_Cung_Cap");
		return  query.list();
	}

	public List<dm_Nha_Cung_Cap> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Nha_Cung_Cap";
		else
			hql = "FROM dm_Nha_Cung_Cap Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Nha_Cung_Cap getOne(int Nhacungcap_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Nha_Cung_Cap obj = (dm_Nha_Cung_Cap) session.get(dm_Nha_Cung_Cap.class, Nhacungcap_id);
		return obj; 
	}

	public dm_Nha_Cung_Cap insert(dm_Nha_Cung_Cap obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Nhacungcap_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Nha_Cung_Cap obj = (dm_Nha_Cung_Cap) session.get(dm_Nha_Cung_Cap.class, Nhacungcap_id);
		session.delete(obj);
	}

	public dm_Nha_Cung_Cap update(dm_Nha_Cung_Cap obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Nha_Cung_Cap existingObj = (dm_Nha_Cung_Cap) session.get(dm_Nha_Cung_Cap.class, obj.getNhacungcap_id());
		existingObj.setNhacungcap_id(obj.getNhacungcap_id());
		existingObj.setNhacungcap_ma(obj.getNhacungcap_ma());
		existingObj.setNhacungcap_ten(obj.getNhacungcap_ten());
		existingObj.setDia_chi(obj.getDia_chi());
		existingObj.setNguoi_lien_he(obj.getNguoi_lien_he());
		existingObj.setDien_thoai(obj.getDien_thoai());
		existingObj.setFax(obj.getFax());
		//existingObj.setQuocgia_id(obj.getQuocgia_id());
		existingObj.setGhi_chu(obj.getGhi_chu());
		session.save(existingObj);
		
		return existingObj;
	}
	
	public void update(Map<String, Object> fields) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		
		dm_Nha_Cung_Cap obj = getOne(Integer.parseInt(fields.get("nhacungcap_id").toString()));
		obj.setNhacungcap_ma(fields.get("nhacungcap_ma").toString());
		obj.setNhacungcap_ten(fields.get("nhacungcap_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setQuocgia_id(Integer.parseInt(fields.get("quocgia_id").toString()));
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		
		dm_Nha_Cung_Cap obj = new dm_Nha_Cung_Cap();
		obj.setNhacungcap_ma(fields.get("nhacungcap_ma").toString());
		obj.setNhacungcap_ten(fields.get("nhacungcap_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setQuocgia_id(Integer.parseInt(fields.get("quocgia_id").toString()));
		
		session.save(obj);
		
		return obj.getNhacungcap_id();
	}
}