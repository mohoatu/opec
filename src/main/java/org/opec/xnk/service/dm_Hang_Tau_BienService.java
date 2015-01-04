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
import org.opec.xnk.domain.dm_Hang_Tau_Bien;
import org.opec.xnk.util.NumberUtil;


@Service("dm_Hang_Tau_BienService")
@Transactional
public class dm_Hang_Tau_BienService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Hang_Tau_Bien> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Hang_Tau_Bien");
		return  query.list();
	}

	public List<dm_Hang_Tau_Bien> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Hang_Tau_Bien";
		else
			hql = "FROM dm_Hang_Tau_Bien Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Hang_Tau_Bien getOne(int Hangtau_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Hang_Tau_Bien obj = (dm_Hang_Tau_Bien) session.get(dm_Hang_Tau_Bien.class, Hangtau_id);
		return obj; 
	}

	public dm_Hang_Tau_Bien insert(dm_Hang_Tau_Bien obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Hangtau_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Hang_Tau_Bien obj = (dm_Hang_Tau_Bien) session.get(dm_Hang_Tau_Bien.class, Hangtau_id);
		session.delete(obj);
	}

	public void update(dm_Hang_Tau_Bien obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Hang_Tau_Bien existingObj = (dm_Hang_Tau_Bien) session.get(dm_Hang_Tau_Bien.class, obj.getHangtau_id());
		existingObj.setHangtau_id(obj.getHangtau_id());
		existingObj.setHangtau_ma(obj.getHangtau_ma());
		existingObj.setHangtau_ten(obj.getHangtau_ten());
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
		dm_Hang_Tau_Bien obj = getOne(Integer.parseInt(fields.get("hangtau_id").toString()));
		
		obj.setHangtau_ma(fields.get("hangtau_ma").toString());
		obj.setHangtau_ten(fields.get("hangtau_ten").toString());
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
		dm_Hang_Tau_Bien obj = new dm_Hang_Tau_Bien();
		
		obj.setHangtau_ma(fields.get("hangtau_ma").toString());
		obj.setHangtau_ten(fields.get("hangtau_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		if(fields.keySet().contains("quocgia_id"))
			obj.setQuocgia_id(NumberUtil.getInterger(fields.get("quocgia_id")));
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		
		session.save(obj);
		return obj.getHangtau_id();
	}
}