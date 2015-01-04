package org.opec.xnk.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;



@Entity
@Table(name = "xnk_nk_ky_hau")
public class xnk_Nk_Ky_Hau implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "kyhau_id")
	@GeneratedValue
	 private int kyhau_id;

	@Column(name = "hopdong_id")
	 private int hopdong_id;

	@Column(name = "codehopdong_id")
	 private int codehopdong_id;
	
	@Column(name = "hang_id")
	 private int hang_id;

	@Column(name = "nganhang_id")
	 private int nganhang_id;

	@Column(name = "nhanvien_id")
	 private int nhanvien_id;
	
	@Column(name = "trangthai_id")
	 private int trangthai_id;

	@Column(name = "don_vi_tien_te")
	 private String don_vi_tien_te;

	@Column(name = "so_luong")
	private float so_luong;
	
	@Column(name = "so_ngay_tra_cham")
	private int so_ngay_tra_cham;

	@Column(name = "tien_thanh_toan_von_tu_co")
	private double tien_thanh_toan_von_tu_co;
	
	@Column(name = "so_tien_nhan_no")
	private double so_tien_nhan_no;
	
	@Column(name = "don_gia_ngoai_te")
	private float don_gia_ngoai_te;
	
	@Column(name = "tri_gia_ngoai_te")
	private float tri_gia_ngoai_te;
	
	@Column(name = "so_luong_thuc_te")
	private float so_luong_thuc_te;
	
	@Column(name = "gia_tri_thuc_te")
	private float gia_tri_thuc_te;
	
	@Column(name = "ngay_chung_tu_ve_ngan_hang")
	 private Date ngay_chung_tu_ve_ngan_hang;

	@Column(name = "thoi_han_thanh_toan")
	 private Date thoi_han_thanh_toan;
	
	@Column(name = "ngay_giao_hop_dong")
	 private Date ngay_giao_hop_dong;
	
	@Column(name = "ho_so_goc_da_chuyen")
	private boolean ho_so_goc_da_chuyen;

	@Column(name = "ghi_chu")
	 private String ghi_chu;

	@Column(name = "user_modify")
	 private String user_modify;

	@Column(name = "date_modify")
	 private Date date_modify;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="hopdong_id", referencedColumnName = "hopdong_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private xnk_Nk_Hop_Dong objHopDong;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="codehopdong_id", referencedColumnName = "code_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private xnk_Nk_Code_Hop_Dong objCodeHopDong;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="hang_id", referencedColumnName = "hang_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Hang_Hoa objHangHoa;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="nganhang_id", referencedColumnName = "nganhang_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Ngan_Hang objNganHang;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="nhanvien_id", referencedColumnName = "nhanvien_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Nhan_Vien objNhanVien;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="trangthai_id", referencedColumnName = "trangthai_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Trang_Thai_Thanh_Toan objTrangThaiThanhToan;
	
	public xnk_Nk_Ky_Hau(){
	}

	public int getKyhau_id() {
		return kyhau_id;
	}

	public void setKyhau_id(int kyhau_id) {
		this.kyhau_id = kyhau_id;
	}

	public int getHopdong_id() {
		return hopdong_id;
	}

	public void setHopdong_id(int hopdong_id) {
		this.hopdong_id = hopdong_id;
	}

	public int getCodehopdong_id() {
		return codehopdong_id;
	}

	public void setCodehopdong_id(int codehopdong_id) {
		this.codehopdong_id = codehopdong_id;
	}

	public int getHang_id() {
		return hang_id;
	}

	public void setHang_id(int hang_id) {
		this.hang_id = hang_id;
	}

	public int getNganhang_id() {
		return nganhang_id;
	}

	public void setNganhang_id(int nganhang_id) {
		this.nganhang_id = nganhang_id;
	}

	public int getNhanvien_id() {
		return nhanvien_id;
	}

	public void setNhanvien_id(int nhanvien_id) {
		this.nhanvien_id = nhanvien_id;
	}

	public int getTrangthai_id() {
		return trangthai_id;
	}

	public void setTrangthai_id(int trangthai_id) {
		this.trangthai_id = trangthai_id;
	}

	public String getDon_vi_tien_te() {
		return don_vi_tien_te;
	}

	public void setDon_vi_tien_te(String don_vi_tien_te) {
		this.don_vi_tien_te = don_vi_tien_te;
	}

	public float getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(float so_luong) {
		this.so_luong = so_luong;
	}

	public int getSo_ngay_tra_cham() {
		return so_ngay_tra_cham;
	}

	public void setSo_ngay_tra_cham(int so_ngay_tra_cham) {
		this.so_ngay_tra_cham = so_ngay_tra_cham;
	}

	public double getTien_thanh_toan_von_tu_co() {
		return tien_thanh_toan_von_tu_co;
	}

	public void setTien_thanh_toan_von_tu_co(double tien_thanh_toan_von_tu_co) {
		this.tien_thanh_toan_von_tu_co = tien_thanh_toan_von_tu_co;
	}

	public double getSo_tien_nhan_no() {
		return so_tien_nhan_no;
	}

	public void setSo_tien_nhan_no(double so_tien_nhan_no) {
		this.so_tien_nhan_no = so_tien_nhan_no;
	}

	public float getDon_gia_ngoai_te() {
		return don_gia_ngoai_te;
	}

	public void setDon_gia_ngoai_te(float don_gia_ngoai_te) {
		this.don_gia_ngoai_te = don_gia_ngoai_te;
	}

	public float getTri_gia_ngoai_te() {
		return tri_gia_ngoai_te;
	}

	public void setTri_gia_ngoai_te(float tri_gia_ngoai_te) {
		this.tri_gia_ngoai_te = tri_gia_ngoai_te;
	}

	public float getSo_luong_thuc_te() {
		return so_luong_thuc_te;
	}

	public void setSo_luong_thuc_te(float so_luong_thuc_te) {
		this.so_luong_thuc_te = so_luong_thuc_te;
	}

	public float getGia_tri_thuc_te() {
		return gia_tri_thuc_te;
	}

	public void setGia_tri_thuc_te(float gia_tri_thuc_te) {
		this.gia_tri_thuc_te = gia_tri_thuc_te;
	}

	public Date getNgay_chung_tu_ve_ngan_hang() {
		return ngay_chung_tu_ve_ngan_hang;
	}

	public void setNgay_chung_tu_ve_ngan_hang(Date ngay_chung_tu_ve_ngan_hang) {
		this.ngay_chung_tu_ve_ngan_hang = ngay_chung_tu_ve_ngan_hang;
	}

	public Date getThoi_han_thanh_toan() {
		return thoi_han_thanh_toan;
	}

	public void setThoi_han_thanh_toan(Date thoi_han_thanh_toan) {
		this.thoi_han_thanh_toan = thoi_han_thanh_toan;
	}

	public Date getNgay_giao_hop_dong() {
		return ngay_giao_hop_dong;
	}

	public void setNgay_giao_hop_dong(Date ngay_giao_hop_dong) {
		this.ngay_giao_hop_dong = ngay_giao_hop_dong;
	}

	public boolean isHo_so_goc_da_chuyen() {
		return ho_so_goc_da_chuyen;
	}

	public void setHo_so_goc_da_chuyen(boolean ho_so_goc_da_chuyen) {
		this.ho_so_goc_da_chuyen = ho_so_goc_da_chuyen;
	}

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

	public String getUser_modify() {
		return user_modify;
	}

	public void setUser_modify(String user_modify) {
		this.user_modify = user_modify;
	}

	public Date getDate_modify() {
		return date_modify;
	}

	public void setDate_modify(Date date_modify) {
		this.date_modify = date_modify;
	}

	public xnk_Nk_Hop_Dong getObjHopDong() {
		return objHopDong;
	}

	public void setObjHopDong(xnk_Nk_Hop_Dong objHopDong) {
		this.objHopDong = objHopDong;
	}

	public xnk_Nk_Code_Hop_Dong getObjCodeHopDong() {
		return objCodeHopDong;
	}

	public void setObjCodeHopDong(xnk_Nk_Code_Hop_Dong objCodeHopDong) {
		this.objCodeHopDong = objCodeHopDong;
	}

	public dm_Hang_Hoa getObjHangHoa() {
		return objHangHoa;
	}

	public void setObjHangHoa(dm_Hang_Hoa objHangHoa) {
		this.objHangHoa = objHangHoa;
	}

	public dm_Ngan_Hang getObjNganHang() {
		return objNganHang;
	}

	public void setObjNganHang(dm_Ngan_Hang objNganHang) {
		this.objNganHang = objNganHang;
	}

	public dm_Nhan_Vien getObjNhanVien() {
		return objNhanVien;
	}

	public void setObjNhanVien(dm_Nhan_Vien objNhanVien) {
		this.objNhanVien = objNhanVien;
	}

	public dm_Trang_Thai_Thanh_Toan getObjTrangThaiThanhToan() {
		return objTrangThaiThanhToan;
	}

	public void setObjTrangThaiThanhToan(
			dm_Trang_Thai_Thanh_Toan objTrangThaiThanhToan) {
		this.objTrangThaiThanhToan = objTrangThaiThanhToan;
	}

}