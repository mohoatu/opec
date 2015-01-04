package org.opec.xnk.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.opec.xnk.domain.xnk_Nk_Code_Hop_Dong;
import org.opec.xnk.util.DateUtil;


@Service("xnk_Nk_Code_Hop_DongService")
@Transactional
public class xnk_Nk_Code_Hop_DongService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public List<xnk_Nk_Code_Hop_Dong> getAll() {
		logger.debug("Lay toan bo ban ghi cua bang du lieu");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM xnk_Nk_Code_Hop_Dong");
		return  query.list();
	}
	
	public List<xnk_Nk_Code_Hop_Dong> getDaThongQuan() {
		logger.debug("Da Thong Quan");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM xnk_Nk_Code_Hop_Dong WHERE loaihinhxnk_id <> 0 "
						+ "and thongquan_so_to_khai is not null and thongquan_ngay is not null " 
						+ "and thongquan_phanluong_id is not null and chicuchq_id is not null "
						+ "and donvi_lap_to_khai_id is not null");
		return  query.list();
	}
	
	public List<xnk_Nk_Code_Hop_Dong> getChuaThongQuan() {
		logger.debug("Chua Thong Quan");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM xnk_Nk_Code_Hop_Dong WHERE loaihinhxnk_id = 0 "
				+ "or thongquan_so_to_khai is null or thongquan_ngay is null " 
				+ "or thongquan_phanluong_id is null or chicuchq_id is null "
				+ "or donvi_lap_to_khai_id is null");
		return  query.list();
	}
	

	public List<xnk_Nk_Code_Hop_Dong> getByQuery(String fFilterDefault) {
		logger.debug("Lay toan bo ban ghi cua bang du lieu theo dieu kien Where");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		String hql = "";
		if (fFilterDefault == "")
			hql = "FROM xnk_Nk_Code_Hop_Dong";
		else
			hql = "FROM xnk_Nk_Code_Hop_Dong Where  " + fFilterDefault;
		Query query = session.createQuery(hql);
		return  query.list();
	}

	public xnk_Nk_Code_Hop_Dong getOne(int Code_id) {
		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Code_Hop_Dong obj = (xnk_Nk_Code_Hop_Dong) session.get(xnk_Nk_Code_Hop_Dong.class, Code_id);
		return obj; 
	}

	public xnk_Nk_Code_Hop_Dong insert(xnk_Nk_Code_Hop_Dong obj) {
		logger.debug("Them doi tuong moi");

		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
		return obj; 
	}

	public void remove(int Code_id) {
		logger.debug("Xoa doi tuong");

		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Code_Hop_Dong obj = (xnk_Nk_Code_Hop_Dong) session.get(xnk_Nk_Code_Hop_Dong.class, Code_id);
		session.delete(obj);
	}

	public void update(xnk_Nk_Code_Hop_Dong obj) {
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Code_Hop_Dong existingObj = (xnk_Nk_Code_Hop_Dong) session.get(xnk_Nk_Code_Hop_Dong.class, obj.getCode_id());
		existingObj.setCode_id(obj.getCode_id());
		existingObj.setCode(obj.getCode());
		existingObj.setHopdong_id(obj.getHopdong_id());
		existingObj.setHang_id(obj.getHang_id());
		existingObj.setNgay_hen_giao_hang(obj.getNgay_hen_giao_hang());
		existingObj.setSo_luong_hang_du_kien(obj.getSo_luong_hang_du_kien());
		existingObj.setDon_vi_tinh(obj.getDon_vi_tinh());
		existingObj.setDon_gia_ngoai_te(obj.getDon_gia_ngoai_te());
		existingObj.setTri_gia_ngoai_te(obj.getTri_gia_ngoai_te());
		existingObj.setTy_gia_ngoai_te(obj.getTy_gia_ngoai_te());
		existingObj.setTri_gia_vnd(obj.getTri_gia_vnd());
		existingObj.setDung_sai(obj.getDung_sai());
		existingObj.setContainer_id(obj.getContainer_id());
		existingObj.setSo_luong_container(obj.getSo_luong_container());
		existingObj.setPhuongthucgia_id(obj.getPhuongthucgia_id());
		existingObj.setSo_lan_thanh_toan(obj.getSo_lan_thanh_toan());
		existingObj.setCangnhap_id(obj.getCangnhap_id());
		existingObj.setCangxuat_id(obj.getCangxuat_id());
		existingObj.setSo_bill(obj.getSo_bill());
		existingObj.setNgay_bill(obj.getNgay_bill());
		existingObj.setNgay_etd(obj.getNgay_etd());
		existingObj.setNgay_eta(obj.getNgay_eta());
		existingObj.setHangtau_id(obj.getHangtau_id());
		existingObj.setDvvantai_id(obj.getDvvantai_id());
		existingObj.setNgay_cap_cang(obj.getNgay_cap_cang());
		existingObj.setSo_dem(obj.getSo_dem());
		existingObj.setSo_det(obj.getSo_det());
		existingObj.setNgay_het_han_luu_cont(obj.getNgay_het_han_luu_cont());
		existingObj.setNgay_het_han_luu_vo(obj.getNgay_het_han_luu_vo());
		existingObj.setSo_ngay_luu_bai(obj.getSo_ngay_luu_bai());
		existingObj.setNgay_het_han_luu_bai(obj.getNgay_het_han_luu_bai());
		existingObj.setDia_diem_tra_rong(obj.getDia_diem_tra_rong());
		existingObj.setLocal_charge(obj.getLocal_charge());
		existingObj.setPallet(obj.getPallet());
		existingObj.setPallet_loai(obj.getPallet_loai());
		existingObj.setPallet_so_luong(obj.getPallet_so_luong());
		existingObj.setThongquan_so_to_khai(obj.getThongquan_so_to_khai());
		existingObj.setThongquan_ngay(obj.getThongquan_ngay());
		existingObj.setThongquan_phanluong_id(obj.getThongquan_phanluong_id());
		existingObj.setChicuchq_id(obj.getChicuchq_id());
		existingObj.setDonvi_lap_to_khai_id(obj.getDonvi_lap_to_khai_id());
		existingObj.setSo_luong_thuc_te(obj.getSo_luong_thuc_te());
		existingObj.setDon_gia_thuc_te(obj.getDon_gia_thuc_te());
		existingObj.setTri_gia_thuc_te(obj.getTri_gia_thuc_te());
		existingObj.setChi_phi_van_tai_bien(obj.getChi_phi_van_tai_bien());
		existingObj.setChi_phi_bao_hiem(obj.getChi_phi_bao_hiem());
		existingObj.setTy_gia_thu_thue(obj.getTy_gia_thu_thue());
		existingObj.setThue_suat_nhap_khau(obj.getThue_suat_nhap_khau());
		existingObj.setThue_suat_vat(obj.getThue_suat_vat());
		existingObj.setTien_thue_nhap_khau(obj.getTien_thue_nhap_khau());
		existingObj.setTien_thue_vat(obj.getTien_thue_vat());
		existingObj.setSo_thue_phai_nop(obj.getSo_thue_phai_nop());
		existingObj.setNgay_han_muc_nop_thue(obj.getNgay_han_muc_nop_thue());
		existingObj.setSo_thue_thuc_te(obj.getSo_thue_thuc_te());
		existingObj.setNgay_nop_thue_thuc_te(obj.getNgay_nop_thue_thuc_te());
		existingObj.setNguoi_nop_thue(obj.getNguoi_nop_thue());
		existingObj.setTrangthai_giao_hang_id(obj.getTrangthai_giao_hang_id());
		existingObj.setTrangthai_thanh_toan_id(obj.getTrangthai_thanh_toan_id());
		existingObj.setTrangthai_code_id(obj.getTrangthai_code_id());
		existingObj.setGhi_chu(obj.getGhi_chu());
		session.save(existingObj);
	}
	
	public void update(Map<String, Object> fields)
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Code_Hop_Dong obj = getOne(Integer.parseInt(fields.get("code_id").toString()));
		
		if(fields.keySet().contains("code"))
			obj.setCode(fields.get("code").toString());
		
		if(fields.keySet().contains("hopdong_id"))
			obj.setHopdong_id(Integer.parseInt(fields.get("hopdong_id").toString()));
		
		if(fields.keySet().contains("hang_id"))
			obj.setHang_id(Integer.parseInt(fields.get("hang_id").toString()));
		
		if(fields.keySet().contains("so_luong_hang_du_kien"))
			obj.setSo_luong_hang_du_kien(Double.parseDouble(fields.get("so_luong_hang_du_kien").toString()));
		
		if(fields.keySet().contains("don_vi_tinh"))
			obj.setDon_vi_tinh(fields.get("don_vi_tinh").toString());
		
		//
		// Don gia ....
		if(fields.keySet().contains("don_gia_ngoai_te"))
			obj.setDon_gia_ngoai_te(Double.parseDouble(fields.get("don_gia_ngoai_te").toString()));
		
		if(fields.keySet().contains("ty_gia_ngoai_te"))
			obj.setTy_gia_ngoai_te(Double.parseDouble(fields.get("ty_gia_ngoai_te").toString()));
		
		if(fields.keySet().contains("tri_gia_ngoai_te"))
			obj.setTri_gia_ngoai_te(Double.parseDouble(fields.get("tri_gia_ngoai_te").toString()));
		
		if(fields.keySet().contains("tri_gia_vnd"))
			obj.setTri_gia_vnd(Double.parseDouble(fields.get("tri_gia_vnd").toString()));
		
		if(fields.keySet().contains("dung_sai"))
			obj.setDung_sai(Double.parseDouble(fields.get("dung_sai").toString()));
		
		if(fields.keySet().contains("phuongthucgia_id"))
			obj.setPhuongthucgia_id(Integer.parseInt(fields.get("phuongthucgia_id").toString()));
		
		if(fields.keySet().contains("so_lan_thanh_toan"))
			obj.setSo_lan_thanh_toan(Integer.parseInt(fields.get("so_lan_thanh_toan").toString()));
		
		//
		// Container
		if(fields.keySet().contains("container_id"))
			obj.setContainer_id(Integer.parseInt(fields.get("container_id").toString()));
		
		if(fields.keySet().contains("so_luong_container"))
			obj.setSo_luong_container(Integer.parseInt(fields.get("so_luong_container").toString()));
		
		//
		// Van tai
		if(fields.keySet().contains("cangnhap_id"))
			obj.setCangnhap_id(Integer.parseInt(fields.get("cangnhap_id").toString()));
		
		if(fields.keySet().contains("cangxuat_id"))
			obj.setCangxuat_id(Integer.parseInt(fields.get("cangxuat_id").toString()));
		
		if(fields.keySet().contains("hangtau_id"))
			obj.setHangtau_id(Integer.parseInt(fields.get("hangtau_id").toString()));
		
		if(fields.keySet().contains("dvvantai_id"))
			obj.setDvvantai_id(Integer.parseInt(fields.get("dvvantai_id").toString()));
		
		if(fields.keySet().contains("so_bill"))
			obj.setSo_bill(fields.get("so_bill").toString());
		
		if(fields.keySet().contains("so_dem"))
			obj.setSo_dem(Integer.parseInt(fields.get("so_dem").toString()));
		
		if(fields.keySet().contains("so_det"))
			obj.setSo_det(Integer.parseInt(fields.get("so_det").toString()));
		
		if(fields.keySet().contains("so_ngay_luu_bai"))
			obj.setSo_ngay_luu_bai(Integer.parseInt(fields.get("so_ngay_luu_bai").toString()));
		
		if(fields.keySet().contains("dia_diem_tra_rong"))
			obj.setDia_diem_tra_rong(fields.get("dia_diem_tra_rong").toString());
		
		if(fields.keySet().contains("local_charge"))
			obj.setLocal_charge(Integer.parseInt(fields.get("local_charge").toString()));
		
		if(fields.keySet().contains("pallet") && (fields.get("pallet") != null))
			obj.setPallet(Boolean.parseBoolean(fields.get("pallet").toString()));
		
		if(fields.keySet().contains("pallet_loai"))
			obj.setPallet_loai(fields.get("pallet_loai").toString());
		
		if(fields.keySet().contains("pallet_so_luong"))
			obj.setPallet_so_luong(Integer.parseInt(fields.get("pallet_so_luong").toString()));
		
		if(fields.keySet().contains("dvvantai_id"))
			obj.setDvvantai_id(Integer.parseInt(fields.get("dvvantai_id").toString()));
		
		//
		// Thong quan
		if(fields.keySet().contains("loaihinhxnk_id"))
			obj.setLoaihinhxnk_id(Integer.parseInt(fields.get("loaihinhxnk_id").toString()));
		
		if(fields.keySet().contains("chicuchq_id"))
			obj.setChicuchq_id(Integer.parseInt(fields.get("chicuchq_id").toString()));
		
		if(fields.keySet().contains("donvi_lap_to_khai_id"))
			obj.setDonvi_lap_to_khai_id(Integer.parseInt(fields.get("donvi_lap_to_khai_id").toString()));
		
		if(fields.keySet().contains("thongquan_so_to_khai"))
			obj.setThongquan_so_to_khai(fields.get("thongquan_so_to_khai").toString());
		
		if(fields.keySet().contains("thongquan_phanluong_id"))
			obj.setThongquan_phanluong_id(fields.get("thongquan_phanluong_id").toString());
				//thongquan_ngay 
		// Thue
		if(fields.keySet().contains("thue_suat_nhap_khau"))
			obj.setThue_suat_nhap_khau(Double.parseDouble(fields.get("thue_suat_nhap_khau").toString()));
		
		if(fields.keySet().contains("thue_suat_vat"))
			obj.setThue_suat_vat(Double.parseDouble(fields.get("thue_suat_vat").toString()));
		
		if(fields.keySet().contains("chi_phi_van_tai_bien"))
			obj.setChi_phi_van_tai_bien(Double.parseDouble(fields.get("chi_phi_van_tai_bien").toString()));
		
		if(fields.keySet().contains("chi_phi_bao_hiem"))
			obj.setChi_phi_bao_hiem(Double.parseDouble(fields.get("chi_phi_bao_hiem").toString()));
		
		if(fields.keySet().contains("ty_gia_thu_thue"))
			obj.setTy_gia_thu_thue(Double.parseDouble(fields.get("ty_gia_thu_thue").toString()));
		
		if(fields.keySet().contains("so_thue_phai_nop"))
			obj.setSo_thue_phai_nop(Double.parseDouble(fields.get("so_thue_phai_nop").toString()));
		
		if(fields.keySet().contains("tien_thue_nhap_khau"))
			obj.setTien_thue_nhap_khau(Double.parseDouble(fields.get("tien_thue_nhap_khau").toString()));
		
		if(fields.keySet().contains("tien_thue_vat"))
			obj.setTien_thue_vat(Double.parseDouble(fields.get("tien_thue_vat").toString()));
		
		if(fields.keySet().contains("so_thue_thuc_te"))
			obj.setSo_thue_thuc_te(Double.parseDouble(fields.get("so_thue_thuc_te").toString()));
		
		if(fields.keySet().contains("nguoi_nop_thue") && (fields.get("nguoi_nop_thue") != null))
			obj.setNguoi_nop_thue(fields.get("nguoi_nop_thue").toString());
		
		
		
		// Cac truong ngay thang
		if(fields.keySet().contains("ngay_hen_giao_hang"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_hen_giao_hang"));
			obj.setNgay_hen_giao_hang(DateUtil.addDays(date, 1));
		}
		
		
		if(fields.keySet().contains("ngay_cap_cang"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_cap_cang"));
			obj.setNgay_cap_cang(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_het_han_luu_cont"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_het_han_luu_cont"));
			obj.setNgay_het_han_luu_cont(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_het_han_luu_vo"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_het_han_luu_vo"));
			obj.setNgay_het_han_luu_vo(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_het_han_luu_bai"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_het_han_luu_bai"));
			obj.setNgay_het_han_luu_bai(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("thongquan_ngay"))
		{
			Date date = DateUtil.getDate(fields.get("thongquan_ngay"));
			obj.setThongquan_ngay(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_han_muc_nop_thue"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_han_muc_nop_thue"));
			obj.setNgay_han_muc_nop_thue(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_nop_thue_thuc_te"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_nop_thue_thuc_te"));
			obj.setNgay_nop_thue_thuc_te(DateUtil.addDays(date, 1));
		}
		
		
		if(fields.keySet().contains("ngay_bill"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_bill"));
			obj.setNgay_bill(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_etd"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_etd"));
			obj.setNgay_etd(DateUtil.addDays(date, 1));
		}
		
		
		if(fields.keySet().contains("ngay_eta"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_eta"));
			obj.setNgay_eta(DateUtil.addDays(date, 1));
		}
		
		
		session.save(obj);
	}
	
	public Integer insert(Map<String, Object> fields) 
	{
		logger.debug("Sua doi tuong");
		Session session = sessionFactory.getCurrentSession();
		xnk_Nk_Code_Hop_Dong obj = new xnk_Nk_Code_Hop_Dong();
		
		if(fields.keySet().contains("code"))
			obj.setCode(fields.get("code").toString());
		
		if(fields.keySet().contains("hopdong_id"))
			obj.setHopdong_id(Integer.parseInt(fields.get("hopdong_id").toString()));
		
		if(fields.keySet().contains("hang_id"))
			obj.setHang_id(Integer.parseInt(fields.get("hang_id").toString()));
		
		if(fields.keySet().contains("so_luong_hang_du_kien"))
			obj.setSo_luong_hang_du_kien(Double.parseDouble(fields.get("so_luong_hang_du_kien").toString()));
		
		if(fields.keySet().contains("don_vi_tinh"))
			obj.setDon_vi_tinh(fields.get("don_vi_tinh").toString());
		
		//
		// Don gia ....
		if(fields.keySet().contains("don_gia_ngoai_te"))
			obj.setDon_gia_ngoai_te(Double.parseDouble(fields.get("don_gia_ngoai_te").toString()));
		
		if(fields.keySet().contains("ty_gia_ngoai_te"))
			obj.setTy_gia_ngoai_te(Double.parseDouble(fields.get("ty_gia_ngoai_te").toString()));
		
		if(fields.keySet().contains("tri_gia_ngoai_te"))
			obj.setTri_gia_ngoai_te(Double.parseDouble(fields.get("tri_gia_ngoai_te").toString()));
		
		if(fields.keySet().contains("tri_gia_vnd"))
			obj.setTri_gia_vnd(Double.parseDouble(fields.get("tri_gia_vnd").toString()));
		
		if(fields.keySet().contains("dung_sai"))
			obj.setDung_sai(Double.parseDouble(fields.get("dung_sai").toString()));
		
		if(fields.keySet().contains("phuongthucgia_id"))
			obj.setPhuongthucgia_id(Integer.parseInt(fields.get("phuongthucgia_id").toString()));
		
		if(fields.keySet().contains("so_lan_thanh_toan"))
			obj.setSo_lan_thanh_toan(Integer.parseInt(fields.get("so_lan_thanh_toan").toString()));
		
		//
		// Container
		if(fields.keySet().contains("container_id"))
			obj.setContainer_id(Integer.parseInt(fields.get("container_id").toString()));
		
		if(fields.keySet().contains("so_luong_container"))
			obj.setSo_luong_container(Integer.parseInt(fields.get("so_luong_container").toString()));
		
		//
		// Van tai
		if(fields.keySet().contains("cangnhap_id"))
			obj.setCangnhap_id(Integer.parseInt(fields.get("cangnhap_id").toString()));
		
		if(fields.keySet().contains("cangxuat_id"))
			obj.setCangxuat_id(Integer.parseInt(fields.get("cangxuat_id").toString()));
		
		if(fields.keySet().contains("hangtau_id"))
			obj.setHangtau_id(Integer.parseInt(fields.get("hangtau_id").toString()));
		
		if(fields.keySet().contains("dvvantai_id"))
			obj.setDvvantai_id(Integer.parseInt(fields.get("dvvantai_id").toString()));
		
		//
		// Thong quan
		if(fields.keySet().contains("loaihinhxnk_id"))
			obj.setLoaihinhxnk_id(Integer.parseInt(fields.get("loaihinhxnk_id").toString()));
		
		if(fields.keySet().contains("chicuchq_id"))
			obj.setChicuchq_id(Integer.parseInt(fields.get("chicuchq_id").toString()));
		
		if(fields.keySet().contains("donvi_lap_to_khai_id"))
			obj.setDonvi_lap_to_khai_id(Integer.parseInt(fields.get("donvi_lap_to_khai_id").toString()));
		
		if(fields.keySet().contains("thongquan_so_to_khai"))
			obj.setThongquan_so_to_khai(fields.get("thongquan_so_to_khai").toString());
		
		// Thue
		
		
		
		// Cac truong ngay thang
		if(fields.keySet().contains("ngay_hen_giao_hang"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_hen_giao_hang"));
			obj.setNgay_hen_giao_hang(DateUtil.addDays(date, 1));
		}
		
		
		if(fields.keySet().contains("ngay_cap_cang"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_cap_cang"));
			obj.setNgay_cap_cang(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_het_han_luu_cont"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_het_han_luu_cont"));
			obj.setNgay_het_han_luu_cont(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_het_han_luu_vo"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_het_han_luu_vo"));
			obj.setNgay_het_han_luu_vo(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_het_han_luu_bai"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_het_han_luu_bai"));
			obj.setNgay_het_han_luu_bai(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("thongquan_ngay"))
		{
			Date date = DateUtil.getDate(fields.get("thongquan_ngay"));
			obj.setThongquan_ngay(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_han_muc_nop_thue"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_han_muc_nop_thue"));
			obj.setNgay_han_muc_nop_thue(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_nop_thue_thuc_te"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_nop_thue_thuc_te"));
			obj.setNgay_nop_thue_thuc_te(DateUtil.addDays(date, 1));
		}
		
		
		if(fields.keySet().contains("ngay_bill"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_bill"));
			obj.setNgay_bill(DateUtil.addDays(date, 1));
		}
		
		if(fields.keySet().contains("ngay_etd"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_etd"));
			obj.setNgay_etd(DateUtil.addDays(date, 1));
		}
		
		
		if(fields.keySet().contains("ngay_eta"))
		{
			Date date = DateUtil.getDate(fields.get("ngay_eta"));
			obj.setNgay_eta(DateUtil.addDays(date, 1));
		}
				
		session.save(obj);
		return obj.getCode_id();
	}
	
}