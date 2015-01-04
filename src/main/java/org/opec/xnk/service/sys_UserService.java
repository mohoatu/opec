package org.opec.xnk.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opec.xnk.domain.sys_User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sys_UserService")
@Transactional
public class sys_UserService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<sys_User> getAll()
	{
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("FROM sys_User");
		return  query.list();
	}
}
