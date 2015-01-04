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
@Table(name = "dm_nhan_vien")
public class dm_Nhan_Vien implements Serializable {
	@Id
	@Column(name= "nhanvien_id")
	@GeneratedValue
	 private int nhanvien_id;

	@Column(name = "nhanvien_ma")
	 private String nhanvien_ma;

	@Column(name = "nhanvien_ten")
	 private String nhanvien_ten;

	@Column(name = "dien_thoai")
	 private String dien_thoai;

	@Column(name = "fax")
	 private String fax;

	@Column(name = "email")
	 private String email;

	@Column(name = "donvi_id")
	 private int donvi_id;

	@Column(name = "active")
	 private int active;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="donvi_id", referencedColumnName = "donvi_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Phong_Ban objDonVi;
	
	
	
	public dm_Phong_Ban getObjDonVi() {
		return objDonVi;
	}
	public void setObjDonVi(dm_Phong_Ban objDonVi) {
		this.objDonVi = objDonVi;
	}
	
	
	
	public dm_Nhan_Vien(){
	}
	public int getNhanvien_id(){
		return this.nhanvien_id;
	}
	public void setNhanvien_id(int nhanvien_id){
		this.nhanvien_id = nhanvien_id;
	}
	public String getNhanvien_ma(){
		return this.nhanvien_ma;
	}
	public void setNhanvien_ma(String nhanvien_ma){
		this.nhanvien_ma = nhanvien_ma;
	}
	public String getNhanvien_ten(){
		return this.nhanvien_ten;
	}
	public void setNhanvien_ten(String nhanvien_ten){
		this.nhanvien_ten = nhanvien_ten;
	}
	public String getDien_thoai(){
		return this.dien_thoai;
	}
	public void setDien_thoai(String dien_thoai){
		this.dien_thoai = dien_thoai;
	}
	public String getFax(){
		return this.fax;
	}
	public void setFax(String fax){
		this.fax = fax;
	}
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public int getDonvi_id(){
		return this.donvi_id;
	}
	public void setDonvi_id(int donvi_id){
		this.donvi_id = donvi_id;
	}
	public int getActive(){
		return this.active;
	}
	public void setActive(int active){
		this.active = active;
	}
}