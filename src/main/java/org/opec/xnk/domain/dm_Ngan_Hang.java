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
import org.hibernate.annotations.Target;



@Entity
@Table(name = "dm_ngan_hang")
public class dm_Ngan_Hang implements Serializable {
	@Id
	@Column(name= "nganhang_id")
	@GeneratedValue
	 private int nganhang_id;

	@Column(name = "nganhang_ma")
	 private String nganhang_ma;

	@Column(name = "nganhang_ten")
	 private String nganhang_ten;

	@Column(name = "dia_chi")
	 private String dia_chi;

	@Column(name = "nguoi_lien_he")
	 private String nguoi_lien_he;

	@Column(name = "dien_thoai")
	 private String dien_thoai;

	@Column(name = "fax")
	 private String fax;

	@Column(name = "ghi_chu")
	 private String ghi_chu;

	public dm_Ngan_Hang(){
	}
	public int getNganhang_id(){
		return this.nganhang_id;
	}
	public void setNganhang_id(int nganhang_id){
		this.nganhang_id = nganhang_id;
	}
	public String getNganhang_ma(){
		return this.nganhang_ma;
	}
	public void setNganhang_ma(String nganhang_ma){
		this.nganhang_ma = nganhang_ma;
	}
	public String getNganhang_ten(){
		return this.nganhang_ten;
	}
	public void setNganhang_ten(String nganhang_ten){
		this.nganhang_ten = nganhang_ten;
	}
	public String getDia_chi(){
		return this.dia_chi;
	}
	public void setDia_chi(String dia_chi){
		this.dia_chi = dia_chi;
	}
	public String getNguoi_lien_he(){
		return this.nguoi_lien_he;
	}
	public void setNguoi_lien_he(String nguoi_lien_he){
		this.nguoi_lien_he = nguoi_lien_he;
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
	public String getGhi_chu(){
		return this.ghi_chu;
	}
	public void setGhi_chu(String ghi_chu){
		this.ghi_chu = ghi_chu;
	}
}