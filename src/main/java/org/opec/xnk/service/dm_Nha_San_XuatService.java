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
import org.opec.xnk.domain.dm_Nha_San_Xuat;


@Service("dm_Nha_San_XuatService")
@Transactional
public class dm_Nha_San_XuatService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Nha_San_Xuat> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Nha_San_Xuat");
		return  query.list();
	}

	public List<dm_Nha_San_Xuat> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Nha_San_Xuat";
		else
			hql = "FROM dm_Nha_San_Xuat Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Nha_San_Xuat getOne(int Nhasanxuat_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Nha_San_Xuat obj = (dm_Nha_San_Xuat) session.get(dm_Nha_San_Xuat.class, Nhasanxuat_id);
		return obj; 
	}

	public dm_Nha_San_Xuat insert(dm_Nha_San_Xuat obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Nhasanxuat_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Nha_San_Xuat obj = (dm_Nha_San_Xuat) session.get(dm_Nha_San_Xuat.class, Nhasanxuat_id);
		session.delete(obj);
	}

	public void update(dm_Nha_San_Xuat obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Nha_San_Xuat existingObj = (dm_Nha_San_Xuat) session.get(dm_Nha_San_Xuat.class, obj.getNhasanxuat_id());
		existingObj.setNhasanxuat_id(obj.getNhasanxuat_id());
		existingObj.setNhasanxuat_ma(obj.getNhasanxuat_ma());
		existingObj.setNhasanxuat_ten(obj.getNhasanxuat_ten());
		existingObj.setDia_chi(obj.getDia_chi());
		existingObj.setNguoi_lien_he(obj.getNguoi_lien_he());
		existingObj.setDien_thoai(obj.getDien_thoai());
		existingObj.setFax(obj.getFax());
		existingObj.setQuocgia_id(obj.getQuocgia_id());
		existingObj.setGhi_chu(obj.getGhi_chu());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		
		dm_Nha_San_Xuat obj = getOne(Integer.parseInt(fields.get("nhasanxuat_id").toString()));
		obj.setNhasanxuat_ma(fields.get("nhasanxuat_ma").toString());
		obj.setNhasanxuat_ten(fields.get("nhasanxuat_ten").toString());
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
		
		dm_Nha_San_Xuat obj = new dm_Nha_San_Xuat();
		obj.setNhasanxuat_ma(fields.get("nhasanxuat_ma").toString());
		obj.setNhasanxuat_ten(fields.get("nhasanxuat_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setQuocgia_id(Integer.parseInt(fields.get("quocgia_id").toString()));
		
		session.save(obj);
		
		return obj.getNhasanxuat_id();
	} 
}