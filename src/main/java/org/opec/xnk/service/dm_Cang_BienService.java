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
import org.opec.xnk.domain.dm_Cang_Bien;
import org.opec.xnk.util.NumberUtil;


@Service("dm_Cang_BienService")
@Transactional
public class dm_Cang_BienService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Cang_Bien> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Cang_Bien");
		return  query.list();
	}

	public List<dm_Cang_Bien> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Cang_Bien";
		else
			hql = "FROM dm_Cang_Bien Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Cang_Bien getOne(int Cangbien_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Cang_Bien obj = (dm_Cang_Bien) session.get(dm_Cang_Bien.class, Cangbien_id);
		return obj; 
	}

	public dm_Cang_Bien insert(dm_Cang_Bien obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Cangbien_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Cang_Bien obj = (dm_Cang_Bien) session.get(dm_Cang_Bien.class, Cangbien_id);
		session.delete(obj);
	}

	public void update(dm_Cang_Bien obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Cang_Bien existingObj = (dm_Cang_Bien) session.get(dm_Cang_Bien.class, obj.getCangbien_id());
		existingObj.setCangbien_id(obj.getCangbien_id());
		existingObj.setCangbien_ma(obj.getCangbien_ma());
		existingObj.setCangbien_ten(obj.getCangbien_ten());
		existingObj.setDia_chi(obj.getDia_chi());
		existingObj.setNguoi_lien_he(obj.getNguoi_lien_he());
		existingObj.setDien_thoai(obj.getDien_thoai());
		existingObj.setFax(obj.getFax());
		existingObj.setEmail(obj.getEmail());
		existingObj.setMa_so_thue(obj.getMa_so_thue());
		existingObj.setQuocgia_id(obj.getQuocgia_id());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Cang_Bien obj = getOne(Integer.parseInt(fields.get("cangbien_id").toString()));
		
		obj.setCangbien_ma(fields.get("cangbien_ma").toString());
		obj.setCangbien_ten(fields.get("cangbien_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setEmail(fields.get("email").toString());
		obj.setMa_so_thue(fields.get("ma_so_thue").toString());
		if(fields.keySet().contains("quocgia_id"))
			obj.setQuocgia_id(NumberUtil.getInterger(fields.get("quocgia_id")));
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Cang_Bien obj = new dm_Cang_Bien();
		
		obj.setCangbien_ma(fields.get("cangbien_ma").toString());
		obj.setCangbien_ten(fields.get("cangbien_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setEmail(fields.get("email").toString());
		obj.setMa_so_thue(fields.get("ma_so_thue").toString());
		if(fields.keySet().contains("quocgia_id"))
			obj.setQuocgia_id(NumberUtil.getInterger(fields.get("quocgia_id")));
		
		session.save(obj);
		return obj.getCangbien_id();
	}
	
}