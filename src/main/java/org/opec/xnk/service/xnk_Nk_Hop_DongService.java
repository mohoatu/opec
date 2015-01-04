package org.opec.xnk.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.opec.xnk.domain.xnk_Nk_Hop_Dong;
import org.opec.xnk.util.DateUtil;


@Service("xnk_Nk_Hop_DongService")
@Transactional
public class xnk_Nk_Hop_DongService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<xnk_Nk_Hop_Dong> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM xnk_Nk_Hop_Dong");
		return  query.list();
	}

	public List<xnk_Nk_Hop_Dong> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM xnk_Nk_Hop_Dong";
		else
			hql = "FROM xnk_Nk_Hop_Dong Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public xnk_Nk_Hop_Dong getOne(int Hopdong_id) {
		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Hop_Dong obj = (xnk_Nk_Hop_Dong) session.get(xnk_Nk_Hop_Dong.class, Hopdong_id);
		return obj; 
	}

	public xnk_Nk_Hop_Dong insert(xnk_Nk_Hop_Dong obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Hopdong_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Hop_Dong obj = (xnk_Nk_Hop_Dong) session.get(xnk_Nk_Hop_Dong.class, Hopdong_id);
		session.delete(obj);
	}

	public void update(xnk_Nk_Hop_Dong obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Hop_Dong existingObj = (xnk_Nk_Hop_Dong) session.get(xnk_Nk_Hop_Dong.class, obj.getHopdong_id());
		existingObj.setHopdong_id(obj.getHopdong_id());
		existingObj.setSo_hop_dong(obj.getSo_hop_dong());
		existingObj.setPhapnhan_id(obj.getPhapnhan_id());
		existingObj.setNhacungcap_id(obj.getNhacungcap_id());
		existingObj.setNhanvien_id(obj.getNhanvien_id());
		existingObj.setMucdoyc_id(obj.getMucdoyc_id());
		existingObj.setDon_vi_tien_te(obj.getDon_vi_tien_te());
		existingObj.setNgay_ky_hop_dong(obj.getNgay_ky_hop_dong());
		existingObj.setNgay_duyet_hop_dong(obj.getNgay_duyet_hop_dong());
		existingObj.setNgay_giao_hop_dong(obj.getNgay_giao_hop_dong());
		existingObj.setNgay_thuc_hien_hop_dong(obj.getNgay_thuc_hien_hop_dong());
		existingObj.setNgay_het_hieu_luc_hop_dong(obj.getNgay_het_hieu_luc_hop_dong());
		existingObj.setGhi_chu(obj.getGhi_chu());
		existingObj.setTrangthai_hop_dong_id(obj.getTrangthai_hop_dong_id());
		existingObj.setUser_modify(obj.getUser_modify());
		existingObj.setDate_modify(obj.getDate_modify());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields)
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		
		xnk_Nk_Hop_Dong obj = getOne(Integer.parseInt(fields.get("hopdong_id").toString()));
		obj.setSo_hop_dong(fields.get("so_hop_dong").toString());
		obj.setPhapnhan_id(Integer.parseInt(fields.get("phapnhan_id").toString()));
		obj.setNhacungcap_id(Integer.parseInt(fields.get("nhacungcap_id").toString()));
		obj.setNhanvien_id(Integer.parseInt(fields.get("nhanvien_id").toString()));
		obj.setMucdoyc_id(Integer.parseInt(fields.get("mucdoyc_id").toString()));
		obj.setDon_vi_tien_te(fields.get("don_vi_tien_te").toString());
		
		if(fields.keySet().contains("ngay_ky_hop_dong"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_ky_hop_dong"));
			obj.setNgay_ky_hop_dong(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_giao_hop_dong"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_giao_hop_dong"));
			obj.setNgay_giao_hop_dong(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_thuc_hien_hop_dong"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_thuc_hien_hop_dong"));
			obj.setNgay_thuc_hien_hop_dong(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_het_hieu_luc_hop_dong"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_het_hieu_luc_hop_dong"));
			obj.setNgay_het_hieu_luc_hop_dong(DateUtil.addDays(date, 1));
		}
		
		
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		//obj.setTrangthai_hop_dong_id(Integer.parseInt(fields.get("trangthai_hop_dong_id").toString()));
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields)
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		
		xnk_Nk_Hop_Dong obj = new xnk_Nk_Hop_Dong();
		
		obj.setSo_hop_dong(fields.get("so_hop_dong").toString());
		obj.setPhapnhan_id(Integer.parseInt(fields.get("phapnhan_id").toString()));
		obj.setNhacungcap_id(Integer.parseInt(fields.get("nhacungcap_id").toString()));
		obj.setNhanvien_id(Integer.parseInt(fields.get("nhanvien_id").toString()));
		obj.setMucdoyc_id(Integer.parseInt(fields.get("mucdoyc_id").toString()));
		obj.setDon_vi_tien_te(fields.get("don_vi_tien_te").toString());
		
		if(fields.keySet().contains("ngay_ky_hop_dong"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_ky_hop_dong"));
			obj.setNgay_ky_hop_dong(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_giao_hop_dong"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_giao_hop_dong"));
			obj.setNgay_giao_hop_dong(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_thuc_hien_hop_dong"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_thuc_hien_hop_dong"));
			obj.setNgay_thuc_hien_hop_dong(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_het_hieu_luc_hop_dong"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_het_hieu_luc_hop_dong"));
			obj.setNgay_het_hieu_luc_hop_dong(DateUtil.addDays(date, 1));
		}
		
		obj.setGhi_chu(fields.get("ghi_chu").toString());
		//obj.setTrangthai_hop_dong_id(Integer.parseInt(fields.get("trangthai_hop_dong_id").toString()));
		
		session.save(obj);
		
		return obj.getHopdong_id();
	}
}