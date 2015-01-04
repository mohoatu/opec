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
import org.opec.xnk.domain.dm_Khach_Hang_Noi_Dia;
import org.opec.xnk.util.NumberUtil;


@Service("dm_Khach_Hang_Noi_DiaService")
@Transactional
public class dm_Khach_Hang_Noi_DiaService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Khach_Hang_Noi_Dia> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Khach_Hang_Noi_Dia");
		return  query.list();
	}

	public List<dm_Khach_Hang_Noi_Dia> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Khach_Hang_Noi_Dia";
		else
			hql = "FROM dm_Khach_Hang_Noi_Dia Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Khach_Hang_Noi_Dia getOne(int Khachhangnoidia_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Khach_Hang_Noi_Dia obj = (dm_Khach_Hang_Noi_Dia) session.get(dm_Khach_Hang_Noi_Dia.class, Khachhangnoidia_id);
		return obj; 
	}

	public dm_Khach_Hang_Noi_Dia insert(dm_Khach_Hang_Noi_Dia obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Khachhangnoidia_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Khach_Hang_Noi_Dia obj = (dm_Khach_Hang_Noi_Dia) session.get(dm_Khach_Hang_Noi_Dia.class, Khachhangnoidia_id);
		session.delete(obj);
	}

	public void update(dm_Khach_Hang_Noi_Dia obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Khach_Hang_Noi_Dia existingObj = (dm_Khach_Hang_Noi_Dia) session.get(dm_Khach_Hang_Noi_Dia.class, obj.getKhachhangnoidia_id());
		existingObj.setKhachhangnoidia_id(obj.getKhachhangnoidia_id());
		existingObj.setKhachhangnoidia_ma(obj.getKhachhangnoidia_ma());
		existingObj.setKhachhangnoidia_ten(obj.getKhachhangnoidia_ten());
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
		dm_Khach_Hang_Noi_Dia obj = getOne(Integer.parseInt(fields.get("khachhangnoidia_id").toString()));
		
		obj.setKhachhangnoidia_ma(fields.get("khachhangnoidia_ma").toString());
		obj.setKhachhangnoidia_ten(fields.get("khachhangnoidia_ten").toString());
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
		dm_Khach_Hang_Noi_Dia obj = new dm_Khach_Hang_Noi_Dia();
		
		obj.setKhachhangnoidia_ma(fields.get("khachhangnoidia_ma").toString());
		obj.setKhachhangnoidia_ten(fields.get("khachhangnoidia_ten").toString());
		obj.setDia_chi(fields.get("dia_chi").toString());
		obj.setNguoi_lien_he(fields.get("nguoi_lien_he").toString());
		obj.setDien_thoai(fields.get("dien_thoai").toString());
		obj.setFax(fields.get("fax").toString());
		if(fields.keySet().contains("quocgia_id"))
				obj.setQuocgia_id(NumberUtil.getInterger(fields.get("quocgia_id")));
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		
		session.save(obj);
		return obj.getKhachhangnoidia_id();
	}
}