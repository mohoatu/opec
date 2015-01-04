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
import org.opec.xnk.domain.dm_Hang_Hoa;
import org.opec.xnk.util.NumberUtil;


@Service("dm_Hang_HoaService")
@Transactional
public class dm_Hang_HoaService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Hang_Hoa> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Hang_Hoa");
		return  query.list();
	}

	public List<dm_Hang_Hoa> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Hang_Hoa";
		else
			hql = "FROM dm_Hang_Hoa Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Hang_Hoa getOne(int Hang_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Hang_Hoa obj = (dm_Hang_Hoa) session.get(dm_Hang_Hoa.class, Hang_id);
		return obj; 
	}

	public dm_Hang_Hoa insert(dm_Hang_Hoa obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Hang_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Hang_Hoa obj = (dm_Hang_Hoa) session.get(dm_Hang_Hoa.class, Hang_id);
		session.delete(obj);
	}

	public void update(dm_Hang_Hoa obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Hang_Hoa existingObj = (dm_Hang_Hoa) session.get(dm_Hang_Hoa.class, obj.getHang_id());
		existingObj.setHang_id(obj.getHang_id());
		existingObj.setMa_hang(obj.getMa_hang());
		existingObj.setMa_noi_bo(obj.getMa_noi_bo());
		existingObj.setCode(obj.getCode());
		existingObj.setTen_hang(obj.getTen_hang());
		existingObj.setDon_vi_tinh(obj.getDon_vi_tinh());
		existingObj.setPhanloai_id(obj.getPhanloai_id());
		existingObj.setNhasanxuat_id(obj.getNhasanxuat_id());
		existingObj.setUngdung_id(obj.getUngdung_id());
		existingObj.setGhi_chu(obj.getGhi_chu());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Hang_Hoa obj = getOne(Integer.parseInt(fields.get("hang_id").toString()));
		
		obj.setMa_hang(fields.get("ma_hang").toString());
		obj.setMa_noi_bo(fields.get("ma_noi_bo").toString());
		obj.setCode(fields.get("code").toString());
		obj.setTen_hang(fields.get("ten_hang").toString());
		obj.setDon_vi_tinh(fields.get("don_vi_tinh").toString());
		
		if(fields.keySet().contains("phanloai_id"))
			obj.setPhanloai_id(NumberUtil.getInterger(fields.get("phanloai_id")));
		
		if(fields.keySet().contains("nhasanxuat_id"))
			obj.setNhasanxuat_id(NumberUtil.getInterger(fields.get("nhasanxuat_id")));
		
		if(fields.keySet().contains("ungdung_id"))
			obj.setUngdung_id(NumberUtil.getInterger(fields.get("ungdung_id")));
		
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Hang_Hoa obj = new dm_Hang_Hoa();
		
		obj.setMa_hang(fields.get("ma_hang").toString());
		obj.setMa_noi_bo(fields.get("ma_noi_bo").toString());
		obj.setCode(fields.get("code").toString());
		obj.setTen_hang(fields.get("ten_hang").toString());
		obj.setDon_vi_tinh(fields.get("don_vi_tinh").toString());
		
		if(fields.keySet().contains("phanloai_id"))
			obj.setPhanloai_id(NumberUtil.getInterger(fields.get("phanloai_id")));
		
		if(fields.keySet().contains("nhasanxuat_id"))
			obj.setNhasanxuat_id(NumberUtil.getInterger(fields.get("nhasanxuat_id")));
		
		if(fields.keySet().contains("ungdung_id"))
			obj.setUngdung_id(NumberUtil.getInterger(fields.get("ungdung_id")));
		
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		
		session.save(obj);
		return obj.getHang_id();
	}
	
	
}