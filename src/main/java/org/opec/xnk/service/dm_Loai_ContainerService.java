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
import org.opec.xnk.domain.dm_Loai_Container;


@Service("dm_Loai_ContainerService")
@Transactional
public class dm_Loai_ContainerService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<dm_Loai_Container> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM dm_Loai_Container");
		return  query.list();
	}

	public List<dm_Loai_Container> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM dm_Loai_Container";
		else
			hql = "FROM dm_Loai_Container Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public dm_Loai_Container getOne(int Container_id) {
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Container obj = (dm_Loai_Container) session.get(dm_Loai_Container.class, Container_id);
		return obj; 
	}

	public dm_Loai_Container insert(dm_Loai_Container obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Container_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Container obj = (dm_Loai_Container) session.get(dm_Loai_Container.class, Container_id);
		session.delete(obj);
	}

	public void update(dm_Loai_Container obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Container existingObj = (dm_Loai_Container) session.get(dm_Loai_Container.class, obj.getContainer_id());
		existingObj.setContainer_id(obj.getContainer_id());
		existingObj.setContainer_ma(obj.getContainer_ma());
		existingObj.setContainer_ten(obj.getContainer_ten());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Container obj = getOne(Integer.parseInt(fields.get("container_id").toString()));
		
		obj.setContainer_ma(fields.get("container_ma").toString());
		obj.setContainer_ten(fields.get("container_ten").toString());
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		dm_Loai_Container obj = new dm_Loai_Container();
		
		obj.setContainer_ma(fields.get("container_ma").toString());
		obj.setContainer_ten(fields.get("container_ten").toString());
		
		session.save(obj);
		return obj.getContainer_id();
	}
}