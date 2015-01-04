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
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Target;



@Entity
@Table(name = "xnk_nk_hop_dong")
public class xnk_Nk_Hop_Dong implements Serializable {
	@Id
	@Column(name= "hopdong_id")
	@GeneratedValue
	 private int hopdong_id;

	@Column(name = "so_hop_dong")
	 private String so_hop_dong;

	@Column(name = "phapnhan_id")
	 private int phapnhan_id;

	@Column(name = "nhacungcap_id")
	 private int nhacungcap_id;

	@Column(name = "nhanvien_id")
	 private int nhanvien_id;

	@Column(name = "mucdoyc_id")
	 private int mucdoyc_id;

	@Column(name = "don_vi_tien_te")
	 private String don_vi_tien_te;

	@Column(name = "ngay_ky_hop_dong")
	 private Date ngay_ky_hop_dong;

	@Column(name = "ngay_duyet_hop_dong")
	 private Date ngay_duyet_hop_dong;

	@Column(name = "ngay_giao_hop_dong")
	 private Date ngay_giao_hop_dong;

	@Column(name = "ngay_thuc_hien_hop_dong")
	 private Date ngay_thuc_hien_hop_dong;

	@Column(name = "ngay_het_hieu_luc_hop_dong")
	 private Date ngay_het_hieu_luc_hop_dong;

	@Column(name = "ghi_chu")
	 private String ghi_chu;

	@Column(name = "user_modify")
	 private String user_modify;

	@Column(name = "date_modify")
	 private Date date_modify;

	@Column(name = "trangthai_hop_dong_id")
	 private int trangthai_hop_dong_id;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="phapnhan_id", referencedColumnName = "phapnhan_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Phap_Nhan objPhapNhan;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="nhacungcap_id", referencedColumnName = "nhacungcap_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Nha_Cung_Cap objNhaCungCap;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="nhanvien_id", referencedColumnName = "nhanvien_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Nhan_Vien objNhanVien;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="mucdoyc_id", referencedColumnName = "mucdoyc_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Muc_Do_Yeu_Cau objMucDoYeuCau;
	
	public xnk_Nk_Hop_Dong(){
	}
	public int getHopdong_id(){
		return this.hopdong_id;
	}
	public void setHopdong_id(int hopdong_id){
		this.hopdong_id = hopdong_id;
	}
	public String getSo_hop_dong(){
		return this.so_hop_dong;
	}
	public void setSo_hop_dong(String so_hop_dong){
		this.so_hop_dong = so_hop_dong;
	}
	public int getPhapnhan_id(){
		return this.phapnhan_id;
	}
	public void setPhapnhan_id(int phapnhan_id){
		this.phapnhan_id = phapnhan_id;
	}
	public int getNhacungcap_id(){
		return this.nhacungcap_id;
	}
	public void setNhacungcap_id(int nhacungcap_id){
		this.nhacungcap_id = nhacungcap_id;
	}
	public int getNhanvien_id(){
		return this.nhanvien_id;
	}
	public void setNhanvien_id(int nhanvien_id){
		this.nhanvien_id = nhanvien_id;
	}
	public int getMucdoyc_id(){
		return this.mucdoyc_id;
	}
	public void setMucdoyc_id(int mucdoyc_id){
		this.mucdoyc_id = mucdoyc_id;
	}
	public String getDon_vi_tien_te(){
		return this.don_vi_tien_te;
	}
	public void setDon_vi_tien_te(String don_vi_tien_te){
		this.don_vi_tien_te = don_vi_tien_te;
	}
	public Date getNgay_ky_hop_dong(){
		return this.ngay_ky_hop_dong;
	}
	public void setNgay_ky_hop_dong(Date ngay_ky_hop_dong){
		this.ngay_ky_hop_dong = ngay_ky_hop_dong;
	}
	public Date getNgay_duyet_hop_dong(){
		return this.ngay_duyet_hop_dong;
	}
	public void setNgay_duyet_hop_dong(Date ngay_duyet_hop_dong){
		this.ngay_duyet_hop_dong = ngay_duyet_hop_dong;
	}
	public Date getNgay_giao_hop_dong(){
		return this.ngay_giao_hop_dong;
	}
	public void setNgay_giao_hop_dong(Date ngay_giao_hop_dong){
		this.ngay_giao_hop_dong = ngay_giao_hop_dong;
	}
	public Date getNgay_thuc_hien_hop_dong(){
		return this.ngay_thuc_hien_hop_dong;
	}
	public void setNgay_thuc_hien_hop_dong(Date ngay_thuc_hien_hop_dong){
		this.ngay_thuc_hien_hop_dong = ngay_thuc_hien_hop_dong;
	}
	public Date getNgay_het_hieu_luc_hop_dong(){
		return this.ngay_het_hieu_luc_hop_dong;
	}
	public void setNgay_het_hieu_luc_hop_dong(Date ngay_het_hieu_luc_hop_dong){
		this.ngay_het_hieu_luc_hop_dong = ngay_het_hieu_luc_hop_dong;
	}
	public String getGhi_chu(){
		return this.ghi_chu;
	}
	public void setGhi_chu(String ghi_chu){
		this.ghi_chu = ghi_chu;
	}
	public String getUser_modify(){
		return this.user_modify;
	}
	public void setUser_modify(String user_modify){
		this.user_modify = user_modify;
	}
	public Date getDate_modify(){
		return this.date_modify;
	}
	public void setDate_modify(Date date_modify){
		this.date_modify = date_modify;
	}
	public dm_Phap_Nhan getObjPhapNhan() {
		return objPhapNhan;
	}
	public void setObjPhapNhan(dm_Phap_Nhan objPhapNhan) {
		this.objPhapNhan = objPhapNhan;
	}
	public dm_Nha_Cung_Cap getObjNhaCungCap() {
		return objNhaCungCap;
	}
	public void setObjNhaCungCap(dm_Nha_Cung_Cap objNhaCungCap) {
		this.objNhaCungCap = objNhaCungCap;
	}
	public dm_Nhan_Vien getObjNhanVien() {
		return objNhanVien;
	}
	public void setObjNhanVien(dm_Nhan_Vien objNhanVien) {
		this.objNhanVien = objNhanVien;
	}
	public dm_Muc_Do_Yeu_Cau getObjMucDoYeuCau() {
		return objMucDoYeuCau;
	}
	public void setObjMucDoYeuCau(dm_Muc_Do_Yeu_Cau objMucDoYeuCau) {
		this.objMucDoYeuCau = objMucDoYeuCau;
	}
	public int getTrangthai_hop_dong_id() {
		return trangthai_hop_dong_id;
	}
	public void setTrangthai_hop_dong_id(int trangthai_hop_dong_id) {
		this.trangthai_hop_dong_id = trangthai_hop_dong_id;
	}
	
	
	
	
}