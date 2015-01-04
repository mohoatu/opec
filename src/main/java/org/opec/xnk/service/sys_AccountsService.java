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
import org.opec.xnk.domain.sys_Accounts;


@Service("sys_AccountsService")
@Transactional

public class sys_AccountsService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	
	public List<sys_Accounts> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM sys_Accounts");
		return  query.list();
	}

	//Hàm kiểm tra CheckIn của một tài khoản: Khi đăng nhập sử dụng UserName và PW
	//	PW được mã hóa từ trong ứng dụng 
	
	public List<sys_Accounts> getAccountByUserNamePW(String UN, String PW) {
		logger.debug("Lấy tài khoản theo UN và PW");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM sys_Accounts Where (user_name = :fUN) And (password = :fPW)");
		query.setString("fUN", UN);
		query.setString("fPW", PW);
		return  query.list();
	}
	
	//Hàm kiểm tra xem tài khoản đã tồn tại hay chưa, nếu tồn tại rồi thì không được phép thay đổi
	
	public List<sys_Accounts> getAccountByUserName(String UN) {
		logger.debug("Lấy tài khoản theo UN và PW");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM sys_Accounts Where (user_name = :fUN)");
		query.setString("fUN", UN);		
		return  query.list();
	}
	
	//Hàm kiểm tra xem tài khoản đã tồn tại hay chưa, nếu tồn tại rồi thì không được phép thay đổi
		
	public int updatePassword(String UN, String PW) {
		logger.debug("Thay đổi mật khẩu đăng nhập");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "UPDATE sys_accounts set password = :password "  + 
	             	 "WHERE user_name = :user_name";
		Query query = session.createQuery(hql);
		query.setString("password", PW);
		query.setString("user_name", UN);
		int result = query.executeUpdate();					
		return  result;
	}
		
	
	
	public sys_Accounts getOne(int User_id) {
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts obj = (sys_Accounts) session.get(sys_Accounts.class, User_id);		
		return obj; 
	}

	
	public sys_Accounts insert(sys_Accounts obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	
	public void remove(int User_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		sys_Accounts obj = (sys_Accounts) session.get(sys_Accounts.class, User_id);
		session.delete(obj);
	}

	
	public sys_Accounts update(sys_Accounts obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts existingObj = (sys_Accounts) session.get(sys_Accounts.class, obj.getUser_id());
		existingObj.setUser_id(obj.getUser_id());
		existingObj.setUser_name(obj.getUser_name());
		existingObj.setFull_name(obj.getFull_name());
		existingObj.setPassword(obj.getPassword());
		existingObj.setIs_active(obj.getIs_active());
		existingObj.setIs_lock(obj.getIs_lock());
		existingObj.setIs_system(obj.getIs_system());
		existingObj.setGroups_id(obj.getGroups_id());
		existingObj.setDate_expire(obj.getDate_expire());
		existingObj.setEmail(obj.getEmail());
		existingObj.setPhone(obj.getPhone());
		existingObj.setNotes(obj.getNotes());
		existingObj.setDate_modify(obj.getDate_modify());
		session.save(existingObj);		
		return existingObj;
	}
	
	public void update(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts obj = getOne(Integer.parseInt(fields.get("user_id").toString()));
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		sys_Accounts obj = new sys_Accounts();
		
		session.save(obj);
		return obj.getUser_id();
	}
	
}