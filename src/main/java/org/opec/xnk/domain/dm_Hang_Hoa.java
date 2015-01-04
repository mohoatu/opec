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
@Table(name = "dm_hang_hoa")
public class dm_Hang_Hoa implements Serializable {
	@Id
	@Column(name= "hang_id")
	@GeneratedValue
	 private int hang_id;

	@Column(name = "ma_hang")
	 private String ma_hang;

	@Column(name = "ma_noi_bo")
	 private String ma_noi_bo;

	@Column(name = "code")
	 private String code;

	@Column(name = "ten_hang")
	 private String ten_hang;

	@Column(name = "don_vi_tinh")
	 private String don_vi_tinh;

	@Column(name = "phanloai_id")
	 private int phanloai_id;

	@Column(name = "nhasanxuat_id")
	 private int nhasanxuat_id;

	@Column(name = "ungdung_id")
	 private int ungdung_id;

	@Column(name = "ghi_chu")
	 private String ghi_chu;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="phanloai_id", referencedColumnName = "phanloai_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Phan_Loai_Hang_Hoa objLoaiHang;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="nhasanxuat_id", referencedColumnName = "nhasanxuat_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Nha_San_Xuat objNhaSanXuat;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="ungdung_id", referencedColumnName = "ungdung_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Ung_Dung objUngDung;
	

	
	
	public dm_Phan_Loai_Hang_Hoa getObjLoaiHang() {
		return objLoaiHang;
	}
	public void setObjLoaiHang(dm_Phan_Loai_Hang_Hoa objLoaiHang) {
		this.objLoaiHang = objLoaiHang;
	}
	public dm_Nha_San_Xuat getObjNhaSanXuat() {
		return objNhaSanXuat;
	}
	public void setObjNhaSanXuat(dm_Nha_San_Xuat objNhaSanXuat) {
		this.objNhaSanXuat = objNhaSanXuat;
	}
	public dm_Ung_Dung getObjUngDung() {
		return objUngDung;
	}
	public void setObjUngDung(dm_Ung_Dung objUngDung) {
		this.objUngDung = objUngDung;
	}
	public dm_Hang_Hoa(){
	}
	public int getHang_id(){
		return this.hang_id;
	}
	public void setHang_id(int hang_id){
		this.hang_id = hang_id;
	}
	public String getMa_hang(){
		return this.ma_hang;
	}
	public void setMa_hang(String ma_hang){
		this.ma_hang = ma_hang;
	}
	public String getMa_noi_bo(){
		return this.ma_noi_bo;
	}
	public void setMa_noi_bo(String ma_noi_bo){
		this.ma_noi_bo = ma_noi_bo;
	}
	public String getCode(){
		return this.code;
	}
	public void setCode(String code){
		this.code = code;
	}
	public String getTen_hang(){
		return this.ten_hang;
	}
	public void setTen_hang(String ten_hang){
		this.ten_hang = ten_hang;
	}
	public String getDon_vi_tinh(){
		return this.don_vi_tinh;
	}
	public void setDon_vi_tinh(String don_vi_tinh){
		this.don_vi_tinh = don_vi_tinh;
	}
	public int getPhanloai_id(){
		return this.phanloai_id;
	}
	public void setPhanloai_id(int phanloai_id){
		this.phanloai_id = phanloai_id;
	}
	public int getNhasanxuat_id(){
		return this.nhasanxuat_id;
	}
	public void setNhasanxuat_id(int nhasanxuat_id){
		this.nhasanxuat_id = nhasanxuat_id;
	}
	public int getUngdung_id(){
		return this.ungdung_id;
	}
	public void setUngdung_id(int ungdung_id){
		this.ungdung_id = ungdung_id;
	}
	public String getGhi_chu(){
		return this.ghi_chu;
	}
	public void setGhi_chu(String ghi_chu){
		this.ghi_chu = ghi_chu;
	}
}