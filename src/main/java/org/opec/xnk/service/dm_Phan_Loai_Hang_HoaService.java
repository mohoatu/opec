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
import org.opec.xnk.domain.dm_Phan_Loai_Hang_Hoa;


@Service("dm_Phan_Loai_Hang_HoaService")
@Transactional
public class dm_Phan_Loai_Hang_HoaService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Phan_Loai_Hang_Hoa> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Phan_Loai_Hang_Hoa");
		return  query.list();
	}

	public List<dm_Phan_Loai_Hang_Hoa> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Phan_Loai_Hang_Hoa";
		else
			hql = "FROM dm_Phan_Loai_Hang_Hoa Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Phan_Loai_Hang_Hoa getOne(int Phanloai_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Phan_Loai_Hang_Hoa obj = (dm_Phan_Loai_Hang_Hoa) session.get(dm_Phan_Loai_Hang_Hoa.class, Phanloai_id);
		return obj; 
	}

	public dm_Phan_Loai_Hang_Hoa insert(dm_Phan_Loai_Hang_Hoa obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Phanloai_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Phan_Loai_Hang_Hoa obj = (dm_Phan_Loai_Hang_Hoa) session.get(dm_Phan_Loai_Hang_Hoa.class, Phanloai_id);
		session.delete(obj);
	}

	public void update(dm_Phan_Loai_Hang_Hoa obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phan_Loai_Hang_Hoa existingObj = (dm_Phan_Loai_Hang_Hoa) session.get(dm_Phan_Loai_Hang_Hoa.class, obj.getPhanloai_id());
		existingObj.setPhanloai_id(obj.getPhanloai_id());
		existingObj.setPhanloai_ma(obj.getPhanloai_ma());
		existingObj.setPhanloai_ten(obj.getPhanloai_ten());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phan_Loai_Hang_Hoa obj = getOne(Integer.parseInt(fields.get("phanloai_id").toString()));
		
		obj.setPhanloai_ma(fields.get("phanloai_ma").toString());
		obj.setPhanloai_ten(fields.get("phanloai_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Phan_Loai_Hang_Hoa obj = new dm_Phan_Loai_Hang_Hoa();
		
		obj.setPhanloai_ma(fields.get("phanloai_ma").toString());
		obj.setPhanloai_ten(fields.get("phanloai_ten").toString());
		
		session.save(obj);
		return obj.getPhanloai_id();
	}
	
}