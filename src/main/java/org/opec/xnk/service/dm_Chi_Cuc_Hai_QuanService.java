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
import org.opec.xnk.domain.dm_Chi_Cuc_Hai_Quan;
import org.opec.xnk.util.NumberUtil;


@Service("dm_Chi_Cuc_Hai_QuanService")
@Transactional
public class dm_Chi_Cuc_Hai_QuanService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Chi_Cuc_Hai_Quan> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Chi_Cuc_Hai_Quan");
		return  query.list();
	}

	public List<dm_Chi_Cuc_Hai_Quan> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Chi_Cuc_Hai_Quan";
		else
			hql = "FROM dm_Chi_Cuc_Hai_Quan Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Chi_Cuc_Hai_Quan getOne(int Chicuchq_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Chi_Cuc_Hai_Quan obj = (dm_Chi_Cuc_Hai_Quan) session.get(dm_Chi_Cuc_Hai_Quan.class, Chicuchq_id);
		return obj; 
	}

	public dm_Chi_Cuc_Hai_Quan insert(dm_Chi_Cuc_Hai_Quan obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Chicuchq_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Chi_Cuc_Hai_Quan obj = (dm_Chi_Cuc_Hai_Quan) session.get(dm_Chi_Cuc_Hai_Quan.class, Chicuchq_id);
		session.delete(obj);
	}

	public void update(dm_Chi_Cuc_Hai_Quan obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Chi_Cuc_Hai_Quan existingObj = (dm_Chi_Cuc_Hai_Quan) session.get(dm_Chi_Cuc_Hai_Quan.class, obj.getChicuchq_id());
		existingObj.setChicuchq_id(obj.getChicuchq_id());
		existingObj.setChicuchq_ma(obj.getChicuchq_ma());
		existingObj.setChicuchq_ten(obj.getChicuchq_ten());
		existingObj.setTai_khoan(obj.getTai_khoan());
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
		dm_Chi_Cuc_Hai_Quan obj = getOne(Integer.parseInt(fields.get("chicuchp_id").toString()));
		
		obj.setChicuchq_ma(fields.get("chicuchp_ma").toString());
		obj.setChicuchq_ten(fields.get("chicuchp_ten").toString());
		obj.setTai_khoan(fields.get("tai_khoan").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		if(fields.keySet().contains("quocgia_id"))
			obj.setQuocgia_id(NumberUtil.getInterger(fields.get("quocgia_id")));
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Chi_Cuc_Hai_Quan obj = new dm_Chi_Cuc_Hai_Quan();
		
		obj.setChicuchq_ma(fields.get("chicuchp_ma").toString());
		obj.setChicuchq_ten(fields.get("chicuchp_ten").toString());
		obj.setTai_khoan(fields.get("tai_khoan").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		if(fields.keySet().contains("quocgia_id"))
			obj.setQuocgia_id(NumberUtil.getInterger(fields.get("quocgia_id")));
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		
		session.save(obj);
		return obj.getChicuchq_id();
	}
	
}