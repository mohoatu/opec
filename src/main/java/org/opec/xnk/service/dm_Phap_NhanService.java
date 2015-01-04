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
import org.opec.xnk.domain.dm_Phap_Nhan;


@Service("dm_Phap_NhanService")
@Transactional
public class dm_Phap_NhanService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Phap_Nhan> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Phap_Nhan");
		return  query.list();
	}

	public List<dm_Phap_Nhan> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Phap_Nhan";
		else
			hql = "FROM dm_Phap_Nhan Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Phap_Nhan getOne(int Phapnhan_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Phap_Nhan obj = (dm_Phap_Nhan) session.get(dm_Phap_Nhan.class, Phapnhan_id);
		return obj; 
	}

	public dm_Phap_Nhan insert(dm_Phap_Nhan obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Phapnhan_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Phap_Nhan obj = (dm_Phap_Nhan) session.get(dm_Phap_Nhan.class, Phapnhan_id);
		session.delete(obj);
	}

	public void update(dm_Phap_Nhan obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phap_Nhan existingObj = (dm_Phap_Nhan) session.get(dm_Phap_Nhan.class, obj.getPhapnhan_id());
		existingObj.setPhapnhan_id(obj.getPhapnhan_id());
		existingObj.setPhapnhan_ma(obj.getPhapnhan_ma());
		existingObj.setPhapnhan_ten(obj.getPhapnhan_ten());
		existingObj.setDia_chi(obj.getDia_chi());
		existingObj.setMa_so_thue(obj.getMa_so_thue());
		existingObj.setDien_thoai(obj.getDien_thoai());
		existingObj.setFax(obj.getFax());
		existingObj.setNguoi_lien_he(obj.getNguoi_lien_he());
		existingObj.setEmail(obj.getEmail());
		existingObj.setWebsite(obj.getWebsite());
		existingObj.setGhi_chu(obj.getGhi_chu());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phap_Nhan obj = getOne(Integer.parseInt(fields.get("phapnhan_id").toString()));
		
		obj.setPhapnhan_ma(fields.get("phapnhan_ma").toString());
		obj.setPhapnhan_ten(fields.get("phapnhan_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setMa_so_thue(fields.get("ma_so_thue").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setEmail(fields.get("email").toString());
		obj.setWebsite(fields.get("website").toString());
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phap_Nhan obj = new dm_Phap_Nhan();
		
		obj.setPhapnhan_ma(fields.get("phapnhan_ma").toString());
		obj.setPhapnhan_ten(fields.get("phapnhan_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setMa_so_thue(fields.get("ma_so_thue").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setEmail(fields.get("email").toString());
		obj.setWebsite(fields.get("website").toString());
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		
		session.save(obj);
		return obj.getPhapnhan_id();
	}
	
}