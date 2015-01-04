package org.opec.xnk.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.opec.xnk.domain.xnk_Nk_Ngan_Hang;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import org.opec.xnk.domain.xnk_Nk_Ngan_Hang;


@Service("xnk_Nk_Ngan_HangService")
@Transactional
public class xnk_Nk_Ngan_HangService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	
	public List<xnk_Nk_Ngan_Hang> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM xnk_Nk_Ngan_Hang");
		return  query.list();
	}

	/*
	public List<xnk_Nk_Ngan_Hang> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM xnk_Nk_Ngan_Hang";
		else
			hql = "FROM xnk_Nk_Ngan_Hang Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public xnk_Nk_Ngan_Hang getOne(int Thanhtoan_id) {
		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Ngan_Hang obj = (xnk_Nk_Ngan_Hang) session.get(xnk_Nk_Ngan_Hang.class, Thanhtoan_id);
		return obj; 
	}

	public xnk_Nk_Ngan_Hang insert(xnk_Nk_Ngan_Hang obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Thanhtoan_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Ngan_Hang obj = (xnk_Nk_Ngan_Hang) session.get(xnk_Nk_Ngan_Hang.class, Thanhtoan_id);
		session.delete(obj);
	}

	public void update(xnk_Nk_Ngan_Hang obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Ngan_Hang existingObj = (xnk_Nk_Ngan_Hang) session.get(xnk_Nk_Ngan_Hang.class, obj.getThanhtoan_id());
		existingObj.setThanhtoan_id(obj.getThanhtoan_id());
		existingObj.setThanhtoan_thu_tu(obj.getThanhtoan_thu_tu());
		existingObj.setPhuongthuctt_id(obj.getPhuongthuctt_id());
		existingObj.setNgay_han_mo(obj.getNgay_han_mo());
		existingObj.setSo_ngay_tra_cham(obj.getSo_ngay_tra_cham());
		existingObj.setNganhang_id(obj.getNganhang_id());
		existingObj.setNgay_han_muc_vay(obj.getNgay_han_muc_vay());
		existingObj.setSo_tien_vay_no(obj.getSo_tien_vay_no());
		existingObj.setLai_suat_vay_no(obj.getLai_suat_vay_no());
		existingObj.setNgay_chung_tu_gui_ngan_hang(obj.getNgay_chung_tu_gui_ngan_hang());
		existingObj.setSo_luong_hang_thuc_te(obj.getSo_luong_hang_thuc_te());
		existingObj.setTri_gia_thuc_te(obj.getTri_gia_thuc_te());
		existingObj.setSo_tien_tu_thanh_toan(obj.getSo_tien_tu_thanh_toan());
		existingObj.setSo_tien_ky_no(obj.getSo_tien_ky_no());
		existingObj.setNgay_thanh_toan_thuc_te(obj.getNgay_thanh_toan_thuc_te());
		existingObj.setSo_tien_thanh_toan_thuc_te(obj.getSo_tien_thanh_toan_thuc_te());
		existingObj.setGhi_chu(obj.getGhi_chu());
		existingObj.setTrangthai_thanh_toan_id(obj.getTrangthai_thanh_toan_id());
		session.save(existingObj);
	}
	*/
	
}