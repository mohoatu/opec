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
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Target;



@Entity
@Table(name = "xnk_nk_code_hop_dong")
public class xnk_Nk_Code_Hop_Dong implements Serializable {
	@Id
	@Column(name= "code_id")
	@GeneratedValue
	 private int code_id;

	@Column(name = "code")
	 private String code;

	@Column(name = "hopdong_id")
	 private int hopdong_id;

	@Column(name = "hang_id")
	 private int hang_id;

	@Column(name = "ngay_hen_giao_hang")
	 private Date ngay_hen_giao_hang;

	@Column(name = "so_luong_hang_du_kien")
	 private double so_luong_hang_du_kien;

	@Column(name = "don_vi_tinh")
	 private String don_vi_tinh;

	@Column(name = "don_gia_ngoai_te")
	 private double don_gia_ngoai_te;

	@Column(name = "tri_gia_ngoai_te")
	 private double tri_gia_ngoai_te;

	@Column(name = "ty_gia_ngoai_te")
	 private double ty_gia_ngoai_te;

	@Column(name = "tri_gia_vnd")
	 private double tri_gia_vnd;

	@Column(name = "dung_sai")
	 private double dung_sai;

	@Column(name = "container_id")
	 private int container_id;

	@Column(name = "so_luong_container")
	 private int so_luong_container;

	@Column(name = "phuongthucgia_id")
	 private int phuongthucgia_id;

	@Column(name = "phuongthuctt_id")
	 private int phuongthuctt_id;
	
	@Column(name = "so_lan_thanh_toan")
	 private int so_lan_thanh_toan;

	@Column(name = "cangnhap_id")
	 private int cangnhap_id;

	@Column(name = "cangxuat_id")
	 private int cangxuat_id;

	@Column(name = "so_bill")
	 private String so_bill;

	@Column(name = "ngay_bill")
	 private Date ngay_bill;

	@Column(name = "ngay_etd")
	 private Date ngay_etd;

	@Column(name = "ngay_eta")
	 private Date ngay_eta;

	@Column(name = "hangtau_id")
	 private int hangtau_id;

	@Column(name = "dvvantai_id")
	 private int dvvantai_id;

	@Column(name = "ngay_cap_cang")
	 private Date ngay_cap_cang;

	@Column(name = "so_dem")
	 private int so_dem;

	@Column(name = "so_det")
	 private int so_det;

	@Column(name = "ngay_het_han_luu_cont")
	 private Date ngay_het_han_luu_cont;

	@Column(name = "ngay_het_han_luu_vo")
	 private Date ngay_het_han_luu_vo;

	@Column(name = "so_ngay_luu_bai")
	 private int so_ngay_luu_bai;

	@Column(name = "ngay_het_han_luu_bai")
	 private Date ngay_het_han_luu_bai;

	@Column(name = "dia_diem_tra_rong")
	 private String dia_diem_tra_rong;

	@Column(name = "local_charge")
	 private int local_charge;

	@Column(name = "pallet")
	 private Boolean pallet;

	@Column(name = "pallet_loai")
	 private String pallet_loai;

	@Column(name = "pallet_so_luong")
	 private int pallet_so_luong;
	
	@Column(name = "loaihinhxnk_id")
	private int loaihinhxnk_id;

	@Column(name = "thongquan_so_to_khai")
	 private String thongquan_so_to_khai;

	@Column(name = "thongquan_ngay")
	 private Date thongquan_ngay;

	@Column(name = "thongquan_phanluong_id")
	 private String thongquan_phanluong_id;

	@Column(name = "chicuchq_id")
	 private int chicuchq_id;

	@Column(name = "donvi_lap_to_khai_id")
	 private int donvi_lap_to_khai_id;

	@Column(name = "so_luong_thuc_te")
	 private double so_luong_thuc_te;

	@Column(name = "don_gia_thuc_te")
	 private double don_gia_thuc_te;

	@Column(name = "tri_gia_thuc_te")
	 private double tri_gia_thuc_te;

	@Column(name = "chi_phi_van_tai_bien")
	 private double chi_phi_van_tai_bien;

	@Column(name = "chi_phi_bao_hiem")
	 private double chi_phi_bao_hiem;

	@Column(name = "ty_gia_thu_thue")
	 private double ty_gia_thu_thue;

	@Column(name = "thue_suat_nhap_khau")
	 private double thue_suat_nhap_khau;

	@Column(name = "thue_suat_vat")
	 private double thue_suat_vat;

	@Column(name = "tien_thue_nhap_khau")
	 private double tien_thue_nhap_khau;

	@Column(name = "tien_thue_vat")
	 private double tien_thue_vat;

	@Column(name = "so_thue_phai_nop")
	 private double so_thue_phai_nop;

	@Column(name = "ngay_han_muc_nop_thue")
	 private Date ngay_han_muc_nop_thue;

	@Column(name = "so_thue_thuc_te")
	 private double so_thue_thuc_te;

	@Column(name = "ngay_nop_thue_thuc_te")
	 private Date ngay_nop_thue_thuc_te;

	@Column(name = "nguoi_nop_thue")
	 private String nguoi_nop_thue;

	@Column(name = "trangthai_giao_hang_id")
	 private int trangthai_giao_hang_id;

	@Column(name = "trangthai_thanh_toan_id")
	 private int trangthai_thanh_toan_id;

	@Column(name = "trangthai_code_id")
	 private int trangthai_code_id;

	@Column(name = "ghi_chu")
	 private String ghi_chu;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="hopdong_id", referencedColumnName = "hopdong_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private xnk_Nk_Hop_Dong objHopDong;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="cangnhap_id", referencedColumnName = "cangbien_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Cang_Bien objCangNhap;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="cangxuat_id", referencedColumnName = "cangbien_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Cang_Bien objCangXuat;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="hang_id", referencedColumnName = "hang_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Hang_Hoa objHangHoa;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="phuongthucgia_id", referencedColumnName = "phuongthucgia_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Phuong_Thuc_Gia objPhuongThucGia;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="phuongthuctt_id", referencedColumnName = "phuongthuctt_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Phuong_Thuc_Thanh_Toan objPhuongThucThanhToan;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="container_id", referencedColumnName = "container_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Loai_Container objLoaiContainer;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="hangtau_id", referencedColumnName = "hangtau_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Hang_Tau_Bien objHangTauBien;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="dvvantai_id", referencedColumnName = "dvvantai_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Don_Vi_Van_Tai objDonViVanTai;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="loaihinhxnk_id", referencedColumnName = "loaihinhxnk_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Loai_Hinh_Xnk objLoaiHinhXnk;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="chicuchq_id", referencedColumnName = "chicuchq_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Chi_Cuc_Hai_Quan objChiCucHq;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="donvi_lap_to_khai_id", referencedColumnName = "dvvantai_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Don_Vi_Van_Tai objDonViLapToKhai;

	public xnk_Nk_Code_Hop_Dong(){
	}
	public int getCode_id(){
		return this.code_id;
	}
	public void setCode_id(int code_id){
		this.code_id = code_id;
	}
	public String getCode(){
		return this.code;
	}
	public void setCode(String code){
		this.code = code;
	}
	public int getHopdong_id(){
		return this.hopdong_id;
	}
	public void setHopdong_id(int hopdong_id){
		this.hopdong_id = hopdong_id;
	}
	public int getHang_id(){
		return this.hang_id;
	}
	public void setHang_id(int hang_id){
		this.hang_id = hang_id;
	}
	public Date getNgay_hen_giao_hang(){
		return this.ngay_hen_giao_hang;
	}
	public void setNgay_hen_giao_hang(Date ngay_hen_giao_hang){
		this.ngay_hen_giao_hang = ngay_hen_giao_hang;
	}
	public double getSo_luong_hang_du_kien(){
		return this.so_luong_hang_du_kien;
	}
	public void setSo_luong_hang_du_kien(double so_luong_hang_du_kien){
		this.so_luong_hang_du_kien = so_luong_hang_du_kien;
	}
	public String getDon_vi_tinh(){
		return this.don_vi_tinh;
	}
	public void setDon_vi_tinh(String don_vi_tinh){
		this.don_vi_tinh = don_vi_tinh;
	}
	public double getDon_gia_ngoai_te(){
		return this.don_gia_ngoai_te;
	}
	public void setDon_gia_ngoai_te(double don_gia_ngoai_te){
		this.don_gia_ngoai_te = don_gia_ngoai_te;
	}
	public double getTri_gia_ngoai_te(){
		return this.tri_gia_ngoai_te;
	}
	public void setTri_gia_ngoai_te(double tri_gia_ngoai_te){
		this.tri_gia_ngoai_te = tri_gia_ngoai_te;
	}
	public double getTy_gia_ngoai_te(){
		return this.ty_gia_ngoai_te;
	}
	public void setTy_gia_ngoai_te(double ty_gia_ngoai_te){
		this.ty_gia_ngoai_te = ty_gia_ngoai_te;
	}
	public double getTri_gia_vnd(){
		return this.tri_gia_vnd;
	}
	public void setTri_gia_vnd(double tri_gia_vnd){
		this.tri_gia_vnd = tri_gia_vnd;
	}
	public double getDung_sai(){
		return this.dung_sai;
	}
	public void setDung_sai(double dung_sai){
		this.dung_sai = dung_sai;
	}
	public int getContainer_id(){
		return this.container_id;
	}
	public void setContainer_id(int container_id){
		this.container_id = container_id;
	}
	public int getSo_luong_container(){
		return this.so_luong_container;
	}
	public void setSo_luong_container(int so_luong_container){
		this.so_luong_container = so_luong_container;
	}
	public int getPhuongthucgia_id(){
		return this.phuongthucgia_id;
	}
	public void setPhuongthucgia_id(int phuongthucgia_id){
		this.phuongthucgia_id = phuongthucgia_id;
	}
	public int getPhuongthuctt_id() {
		return phuongthuctt_id;
	}
	public void setPhuongthuctt_id(int phuongthuctt_id) {
		this.phuongthuctt_id = phuongthuctt_id;
	}
	public int getSo_lan_thanh_toan(){
		return this.so_lan_thanh_toan;
	}
	public void setSo_lan_thanh_toan(int so_lan_thanh_toan){
		this.so_lan_thanh_toan = so_lan_thanh_toan;
	}
	public int getCangnhap_id(){
		return this.cangnhap_id;
	}
	public void setCangnhap_id(int cangnhap_id){
		this.cangnhap_id = cangnhap_id;
	}
	public int getCangxuat_id(){
		return this.cangxuat_id;
	}
	public void setCangxuat_id(int cangxuat_id){
		this.cangxuat_id = cangxuat_id;
	}
	public String getSo_bill(){
		return this.so_bill;
	}
	public void setSo_bill(String so_bill){
		this.so_bill = so_bill;
	}
	public Date getNgay_bill(){
		return this.ngay_bill;
	}
	public void setNgay_bill(Date ngay_bill){
		this.ngay_bill = ngay_bill;
	}
	public Date getNgay_etd(){
		return this.ngay_etd;
	}
	public void setNgay_etd(Date ngay_etd){
		this.ngay_etd = ngay_etd;
	}
	public Date getNgay_eta(){
		return this.ngay_eta;
	}
	public void setNgay_eta(Date ngay_eta){
		this.ngay_eta = ngay_eta;
	}
	public int getHangtau_id(){
		return this.hangtau_id;
	}
	public void setHangtau_id(int hangtau_id){
		this.hangtau_id = hangtau_id;
	}
	public int getDvvantai_id(){
		return this.dvvantai_id;
	}
	public void setDvvantai_id(int dvvantai_id){
		this.dvvantai_id = dvvantai_id;
	}
	public Date getNgay_cap_cang(){
		return this.ngay_cap_cang;
	}
	public void setNgay_cap_cang(Date ngay_cap_cang){
		this.ngay_cap_cang = ngay_cap_cang;
	}
	public int getSo_dem(){
		return this.so_dem;
	}
	public void setSo_dem(int so_dem){
		this.so_dem = so_dem;
	}
	public int getSo_det(){
		return this.so_det;
	}
	public void setSo_det(int so_det){
		this.so_det = so_det;
	}
	public Date getNgay_het_han_luu_cont(){
		return this.ngay_het_han_luu_cont;
	}
	public void setNgay_het_han_luu_cont(Date ngay_het_han_luu_cont){
		this.ngay_het_han_luu_cont = ngay_het_han_luu_cont;
	}
	public Date getNgay_het_han_luu_vo(){
		return this.ngay_het_han_luu_vo;
	}
	public void setNgay_het_han_luu_vo(Date ngay_het_han_luu_vo){
		this.ngay_het_han_luu_vo = ngay_het_han_luu_vo;
	}
	public int getSo_ngay_luu_bai(){
		return this.so_ngay_luu_bai;
	}
	public void setSo_ngay_luu_bai(int so_ngay_luu_bai){
		this.so_ngay_luu_bai = so_ngay_luu_bai;
	}
	public Date getNgay_het_han_luu_bai(){
		return this.ngay_het_han_luu_bai;
	}
	public void setNgay_het_han_luu_bai(Date ngay_het_han_luu_bai){
		this.ngay_het_han_luu_bai = ngay_het_han_luu_bai;
	}
	public String getDia_diem_tra_rong(){
		return this.dia_diem_tra_rong;
	}
	public void setDia_diem_tra_rong(String dia_diem_tra_rong){
		this.dia_diem_tra_rong = dia_diem_tra_rong;
	}
	public int getLocal_charge(){
		return this.local_charge;
	}
	public void setLocal_charge(int local_charge){
		this.local_charge = local_charge;
	}
	public Boolean getPallet(){
		return this.pallet;
	}
	public void setPallet(Boolean pallet){
		this.pallet = pallet;
	}
	public String getPallet_loai(){
		return this.pallet_loai;
	}
	public void setPallet_loai(String pallet_loai){
		this.pallet_loai = pallet_loai;
	}
	public int getPallet_so_luong(){
		return this.pallet_so_luong;
	}
	public void setPallet_so_luong(int pallet_so_luong){
		this.pallet_so_luong = pallet_so_luong;
	}
	public String getThongquan_so_to_khai(){
		return this.thongquan_so_to_khai;
	}
	public void setThongquan_so_to_khai(String thongquan_so_to_khai){
		this.thongquan_so_to_khai = thongquan_so_to_khai;
	}
	public Date getThongquan_ngay(){
		return this.thongquan_ngay;
	}
	public void setThongquan_ngay(Date thongquan_ngay){
		this.thongquan_ngay = thongquan_ngay;
	}
	public String getThongquan_phanluong_id(){
		return this.thongquan_phanluong_id;
	}
	public void setThongquan_phanluong_id(String thongquan_phanluong_id){
		this.thongquan_phanluong_id = thongquan_phanluong_id;
	}
	public int getChicuchq_id(){
		return this.chicuchq_id;
	}
	public void setChicuchq_id(int chicuchq_id){
		this.chicuchq_id = chicuchq_id;
	}
	public int getDonvi_lap_to_khai_id(){
		return this.donvi_lap_to_khai_id;
	}
	public void setDonvi_lap_to_khai_id(int donvi_lap_to_khai_id){
		this.donvi_lap_to_khai_id = donvi_lap_to_khai_id;
	}
	public double getSo_luong_thuc_te(){
		return this.so_luong_thuc_te;
	}
	public void setSo_luong_thuc_te(double so_luong_thuc_te){
		this.so_luong_thuc_te = so_luong_thuc_te;
	}
	public double getDon_gia_thuc_te(){
		return this.don_gia_thuc_te;
	}
	public void setDon_gia_thuc_te(double don_gia_thuc_te){
		this.don_gia_thuc_te = don_gia_thuc_te;
	}
	public double getTri_gia_thuc_te(){
		return this.tri_gia_thuc_te;
	}
	public void setTri_gia_thuc_te(double tri_gia_thuc_te){
		this.tri_gia_thuc_te = tri_gia_thuc_te;
	}
	public double getChi_phi_van_tai_bien(){
		return this.chi_phi_van_tai_bien;
	}
	public void setChi_phi_van_tai_bien(double chi_phi_van_tai_bien){
		this.chi_phi_van_tai_bien = chi_phi_van_tai_bien;
	}
	public double getChi_phi_bao_hiem(){
		return this.chi_phi_bao_hiem;
	}
	public void setChi_phi_bao_hiem(double chi_phi_bao_hiem){
		this.chi_phi_bao_hiem = chi_phi_bao_hiem;
	}
	public double getTy_gia_thu_thue(){
		return this.ty_gia_thu_thue;
	}
	public void setTy_gia_thu_thue(double ty_gia_thu_thue){
		this.ty_gia_thu_thue = ty_gia_thu_thue;
	}
	public double getThue_suat_nhap_khau(){
		return this.thue_suat_nhap_khau;
	}
	public void setThue_suat_nhap_khau(double thue_suat_nhap_khau){
		this.thue_suat_nhap_khau = thue_suat_nhap_khau;
	}
	public double getThue_suat_vat(){
		return this.thue_suat_vat;
	}
	public void setThue_suat_vat(double thue_suat_vat){
		this.thue_suat_vat = thue_suat_vat;
	}
	public double getTien_thue_nhap_khau(){
		return this.tien_thue_nhap_khau;
	}
	public void setTien_thue_nhap_khau(double tien_thue_nhap_khau){
		this.tien_thue_nhap_khau = tien_thue_nhap_khau;
	}
	public double getTien_thue_vat(){
		return this.tien_thue_vat;
	}
	public void setTien_thue_vat(double tien_thue_vat){
		this.tien_thue_vat = tien_thue_vat;
	}
	public double getSo_thue_phai_nop(){
		return this.so_thue_phai_nop;
	}
	public void setSo_thue_phai_nop(double so_thue_phai_nop){
		this.so_thue_phai_nop = so_thue_phai_nop;
	}
	public Date getNgay_han_muc_nop_thue(){
		return this.ngay_han_muc_nop_thue;
	}
	public void setNgay_han_muc_nop_thue(Date ngay_han_muc_nop_thue){
		this.ngay_han_muc_nop_thue = ngay_han_muc_nop_thue;
	}
	public double getSo_thue_thuc_te(){
		return this.so_thue_thuc_te;
	}
	public void setSo_thue_thuc_te(double so_thue_thuc_te){
		this.so_thue_thuc_te = so_thue_thuc_te;
	}
	public Date getNgay_nop_thue_thuc_te(){
		return this.ngay_nop_thue_thuc_te;
	}
	public void setNgay_nop_thue_thuc_te(Date ngay_nop_thue_thuc_te){
		this.ngay_nop_thue_thuc_te = ngay_nop_thue_thuc_te;
	}
	public String getNguoi_nop_thue(){
		return this.nguoi_nop_thue;
	}
	public void setNguoi_nop_thue(String nguoi_nop_thue){
		this.nguoi_nop_thue = nguoi_nop_thue;
	}
	public int getTrangthai_giao_hang_id(){
		return this.trangthai_giao_hang_id;
	}
	public void setTrangthai_giao_hang_id(int trangthai_giao_hang_id){
		this.trangthai_giao_hang_id = trangthai_giao_hang_id;
	}
	public int getTrangthai_thanh_toan_id(){
		return this.trangthai_thanh_toan_id;
	}
	public void setTrangthai_thanh_toan_id(int trangthai_thanh_toan_id){
		this.trangthai_thanh_toan_id = trangthai_thanh_toan_id;
	}
	public int getTrangthai_code_id(){
		return this.trangthai_code_id;
	}
	public void setTrangthai_code_id(int trangthai_code_id){
		this.trangthai_code_id = trangthai_code_id;
	}
	public String getGhi_chu(){
		return this.ghi_chu;
	}
	public void setGhi_chu(String ghi_chu){
		this.ghi_chu = ghi_chu;
	}
	public xnk_Nk_Hop_Dong getObjHopDong() {
		return objHopDong;
	}
	public void setObjHopDong(xnk_Nk_Hop_Dong objHopDong) {
		this.objHopDong = objHopDong;
	}
	public dm_Cang_Bien getObjCangNhap() {
		return objCangNhap;
	}
	public void setObjCangNhap(dm_Cang_Bien objCangNhap) {
		this.objCangNhap = objCangNhap;
	}
	public dm_Hang_Hoa getObjHangHoa() {
		return objHangHoa;
	}
	public void setObjHangHoa(dm_Hang_Hoa objHangHoa) {
		this.objHangHoa = objHangHoa;
	}
	public dm_Phuong_Thuc_Gia getObjPhuongThucGia() {
		return objPhuongThucGia;
	}
	public void setObjPhuongThucGia(dm_Phuong_Thuc_Gia objPhuongThucGia) {
		this.objPhuongThucGia = objPhuongThucGia;
	}
	public dm_Phuong_Thuc_Thanh_Toan getObjPhuongThucThanhToan() {
		return objPhuongThucThanhToan;
	}
	public void setObjPhuongThucThanhToan(
			dm_Phuong_Thuc_Thanh_Toan objPhuongThucThanhToan) {
		this.objPhuongThucThanhToan = objPhuongThucThanhToan;
	}
	public dm_Loai_Container getObjLoaiContainer() {
		return objLoaiContainer;
	}
	public void setObjLoaiContainer(dm_Loai_Container objLoaiContainer) {
		this.objLoaiContainer = objLoaiContainer;
	}
	public dm_Hang_Tau_Bien getObjHangTauBien() {
		return objHangTauBien;
	}
	public void setObjHangTauBien(dm_Hang_Tau_Bien objHangTauBien) {
		this.objHangTauBien = objHangTauBien;
	}
	public dm_Cang_Bien getObjCangXuat() {
		return objCangXuat;
	}
	public void setObjCangXuat(dm_Cang_Bien objCangXuat) {
		this.objCangXuat = objCangXuat;
	}
	public dm_Don_Vi_Van_Tai getObjDonViVanTai() {
		return objDonViVanTai;
	}
	public void setObjDonViVanTai(dm_Don_Vi_Van_Tai objDonViVanTai) {
		this.objDonViVanTai = objDonViVanTai;
	}
	public int getLoaihinhxnk_id() {
		return loaihinhxnk_id;
	}
	public void setLoaihinhxnk_id(int loaihinhxnk_id) {
		this.loaihinhxnk_id = loaihinhxnk_id;
	}
	public dm_Loai_Hinh_Xnk getObjLoaiHinhXnk() {
		return objLoaiHinhXnk;
	}
	public void setObjLoaiHinhXnk(dm_Loai_Hinh_Xnk objLoaiHinhXnk) {
		this.objLoaiHinhXnk = objLoaiHinhXnk;
	}
	public dm_Chi_Cuc_Hai_Quan getObjChiCucHq() {
		return objChiCucHq;
	}
	public void setObjChiCucHq(dm_Chi_Cuc_Hai_Quan objChiCucHq) {
		this.objChiCucHq = objChiCucHq;
	}
	public dm_Don_Vi_Van_Tai getObjDonViLapToKhai() {
		return objDonViLapToKhai;
	}
	public void setObjDonViLapToKhai(dm_Don_Vi_Van_Tai objDonViLapToKhai) {
		this.objDonViLapToKhai = objDonViLapToKhai;
	}
	
	
}