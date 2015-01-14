package org.opec.xnk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "xnk_nk_ngan_hang")
public class XnkNkNganHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "thanhtoan_id")
	@GeneratedValue
	private int thanhtoan_id;

	@Column(name = "code_id")
	private String code_id;

	@Column(name = "thanhtoan_thu_tu")
	private int thanhtoan_thu_tu;

	@Column(name = "phuongthuctt_id")
	private int phuongthuctt_id;

	@Column(name = "ngay_han_mo")
	private Date ngay_han_mo;

	@Column(name = "so_ngay_tra_cham")
	private int so_ngay_tra_cham;

	@Column(name = "nganhang_id")
	private String nganhang_id;

	@Column(name = "ngay_han_muc_vay")
	private Date ngay_han_muc_vay;

	@Column(name = "so_tien_vay_no")
	private double so_tien_vay_no;

	@Column(name = "lai_suat_vay_no")
	private double lai_suat_vay_no;

	@Column(name = "ngay_chung_tu_gui_ngan_hang")
	private Date ngay_chung_tu_gui_ngan_hang;

	@Column(name = "so_luong_hang_thuc_te")
	private double so_luong_hang_thuc_te;
	
	@Column(name = "tri_gia_thuc_te")
	private double tri_gia_thuc_te;

	@Column(name = "so_tien_tu_thanh_toan")
	private double so_tien_tu_thanh_toan;
	
	@Column(name = "so_tien_ky_no")
	private double so_tien_ky_no;
	
	@Column(name = "ngay_thanh_toan_thuc_te")
	private Date ngay_thanh_toan_thuc_te;
	
	@Column(name = "so_tien_thanh_toan_thuc_te")
	private double so_tien_thanh_toan_thuc_te;
	
	@Column(name = "trangthai_thanh_toan_id")
	private int trangthai_thanh_toan_id;
	
	@Column(name = "so_lc")
	private String so_lc;
	
	@Column(name = "ngay_mo_lc")
	private Date ngay_mo_lc;
	
	@Column(name = "ghi_chu")
	private String ghi_chu;
	
	
	public XnkNkNganHang(){
		
	}

	public int getThanhtoan_id() {
		return thanhtoan_id;
	}

	public void setThanhtoan_id(int thanhtoan_id) {
		this.thanhtoan_id = thanhtoan_id;
	}

	public String getCode_id() {
		return code_id;
	}

	public void setCode_id(String code_id) {
		this.code_id = code_id;
	}

	public int getThanhtoan_thu_tu() {
		return thanhtoan_thu_tu;
	}

	public void setThanhtoan_thu_tu(int thanhtoan_thu_tu) {
		this.thanhtoan_thu_tu = thanhtoan_thu_tu;
	}

	public int getPhuongthuctt_id() {
		return phuongthuctt_id;
	}

	public void setPhuongthuctt_id(int phuongthuctt_id) {
		this.phuongthuctt_id = phuongthuctt_id;
	}

	public Date getNgay_han_mo() {
		return ngay_han_mo;
	}

	public void setNgay_han_mo(Date ngay_han_mo) {
		this.ngay_han_mo = ngay_han_mo;
	}

	public int getSo_ngay_tra_cham() {
		return so_ngay_tra_cham;
	}

	public void setSo_ngay_tra_cham(int so_ngay_tra_cham) {
		this.so_ngay_tra_cham = so_ngay_tra_cham;
	}

	public String getNganhang_id() {
		return nganhang_id;
	}

	public void setNganhang_id(String nganhang_id) {
		this.nganhang_id = nganhang_id;
	}

	public Date getNgay_han_muc_vay() {
		return ngay_han_muc_vay;
	}

	public void setNgay_han_muc_vay(Date ngay_han_muc_vay) {
		this.ngay_han_muc_vay = ngay_han_muc_vay;
	}

	public double getSo_tien_vay_no() {
		return so_tien_vay_no;
	}

	public void setSo_tien_vay_no(double so_tien_vay_no) {
		this.so_tien_vay_no = so_tien_vay_no;
	}

	public double getLai_suat_vay_no() {
		return lai_suat_vay_no;
	}

	public void setLai_suat_vay_no(double lai_suat_vay_no) {
		this.lai_suat_vay_no = lai_suat_vay_no;
	}

	public Date getNgay_chung_tu_gui_ngan_hang() {
		return ngay_chung_tu_gui_ngan_hang;
	}

	public void setNgay_chung_tu_gui_ngan_hang(Date ngay_chung_tu_gui_ngan_hang) {
		this.ngay_chung_tu_gui_ngan_hang = ngay_chung_tu_gui_ngan_hang;
	}

	public double getSo_luong_hang_thuc_te() {
		return so_luong_hang_thuc_te;
	}

	public void setSo_luong_hang_thuc_te(double so_luong_hang_thuc_te) {
		this.so_luong_hang_thuc_te = so_luong_hang_thuc_te;
	}

	public double getTri_gia_thuc_te() {
		return tri_gia_thuc_te;
	}

	public void setTri_gia_thuc_te(double tri_gia_thuc_te) {
		this.tri_gia_thuc_te = tri_gia_thuc_te;
	}

	public double getSo_tien_tu_thanh_toan() {
		return so_tien_tu_thanh_toan;
	}

	public void setSo_tien_tu_thanh_toan(double so_tien_tu_thanh_toan) {
		this.so_tien_tu_thanh_toan = so_tien_tu_thanh_toan;
	}

	public double getSo_tien_ky_no() {
		return so_tien_ky_no;
	}

	public void setSo_tien_ky_no(double so_tien_ky_no) {
		this.so_tien_ky_no = so_tien_ky_no;
	}

	public Date getNgay_thanh_toan_thuc_te() {
		return ngay_thanh_toan_thuc_te;
	}

	public void setNgay_thanh_toan_thuc_te(Date ngay_thanh_toan_thuc_te) {
		this.ngay_thanh_toan_thuc_te = ngay_thanh_toan_thuc_te;
	}

	public double getSo_tien_thanh_toan_thuc_te() {
		return so_tien_thanh_toan_thuc_te;
	}

	public void setSo_tien_thanh_toan_thuc_te(double so_tien_thanh_toan_thuc_te) {
		this.so_tien_thanh_toan_thuc_te = so_tien_thanh_toan_thuc_te;
	}


	public int getTrangthai_thanh_toan_id() {
		return trangthai_thanh_toan_id;
	}

	public void setTrangthai_thanh_toan_id(int trangthai_thanh_toan_id) {
		this.trangthai_thanh_toan_id = trangthai_thanh_toan_id;
	}

	public String getSo_lc() {
		return so_lc;
	}

	public void setSo_lc(String so_lc) {
		this.so_lc = so_lc;
	}

	public Date getNgay_mo_lc() {
		return ngay_mo_lc;
	}

	public void setNgay_mo_lc(Date ngay_mo_lc) {
		this.ngay_mo_lc = ngay_mo_lc;
	}

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

}