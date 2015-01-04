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
import org.opec.xnk.domain.dm_Nhan_Vien;
import org.opec.xnk.util.NumberUtil;


@Service("dm_Nhan_VienService")
@Transactional
public class dm_Nhan_VienService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Nhan_Vien> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Nhan_Vien");
		return  query.list();
	}

	public List<dm_Nhan_Vien> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Nhan_Vien";
		else
			hql = "FROM dm_Nhan_Vien Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Nhan_Vien getOne(int Nhanvien_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Nhan_Vien obj = (dm_Nhan_Vien) session.get(dm_Nhan_Vien.class, Nhanvien_id);
		return obj; 
	}

	public dm_Nhan_Vien insert(dm_Nhan_Vien obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Nhanvien_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Nhan_Vien obj = (dm_Nhan_Vien) session.get(dm_Nhan_Vien.class, Nhanvien_id);
		session.delete(obj);
	}

	public void update(dm_Nhan_Vien obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Nhan_Vien existingObj = (dm_Nhan_Vien) session.get(dm_Nhan_Vien.class, obj.getNhanvien_id());
		existingObj.setNhanvien_id(obj.getNhanvien_id());
		existingObj.setNhanvien_ma(obj.getNhanvien_ma());
		existingObj.setNhanvien_ten(obj.getNhanvien_ten());
		existingObj.setDien_thoai(obj.getDien_thoai());
		existingObj.setFax(obj.getFax());
		existingObj.setEmail(obj.getEmail());
		existingObj.setDonvi_id(obj.getDonvi_id());
		existingObj.setActive(obj.getActive());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Nhan_Vien obj = getOne(Integer.parseInt(fields.get("nhanvien_id").toString()));
		
		obj.setNhanvien_ma(fields.get("nhanvien_ma").toString());
		obj.setNhanvien_ten(fields.get("nhanvien_ten").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setEmail(fields.get("email").toString());
		if(fields.keySet().contains("donvi_id"))
			obj.setDonvi_id(NumberUtil.getInterger(fields.get("donvi_id")));
		//obj.setActive(Integer.parseInt(fields.get("active").toString()));
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Nhan_Vien obj = new dm_Nhan_Vien();
		
		obj.setNhanvien_ma(fields.get("nhanvien_ma").toString());
		obj.setNhanvien_ten(fields.get("nhanvien_ten").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setEmail(fields.get("email").toString());
		if(fields.keySet().contains("donvi_id"))
			obj.setDonvi_id(NumberUtil.getInterger(fields.get("donvi_id")));
		//obj.setActive(Integer.parseInt(fields.get("active").toString()));
		
		session.save(obj);
		return obj.getNhanvien_id();
	}
	
}