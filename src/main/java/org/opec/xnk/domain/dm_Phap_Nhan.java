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
@Table(name = "dm_phap_nhan")
public class dm_Phap_Nhan implements Serializable {
	@Id
	@Column(name= "phapnhan_id")
	@GeneratedValue
	 private int phapnhan_id;

	@Column(name = "phapnhan_ma")
	 private String phapnhan_ma;

	@Column(name = "phapnhan_ten")
	 private String phapnhan_ten;

	@Column(name = "dia_chi")
	 private String dia_chi;

	@Column(name = "ma_so_thue")
	 private String ma_so_thue;

	@Column(name = "dien_thoai")
	 private String dien_thoai;

	@Column(name = "fax")
	 private String fax;

	@Column(name = "nguoi_lien_he")
	 private String nguoi_lien_he;

	@Column(name = "email")
	 private String email;

	@Column(name = "website")
	 private String website;

	@Column(name = "ghi_chu")
	 private String ghi_chu;

	public dm_Phap_Nhan(){
	}
	public int getPhapnhan_id(){
		return this.phapnhan_id;
	}
	public void setPhapnhan_id(int phapnhan_id){
		this.phapnhan_id = phapnhan_id;
	}
	public String getPhapnhan_ma(){
		return this.phapnhan_ma;
	}
	public void setPhapnhan_ma(String phapnhan_ma){
		this.phapnhan_ma = phapnhan_ma;
	}
	public String getPhapnhan_ten(){
		return this.phapnhan_ten;
	}
	public void setPhapnhan_ten(String phapnhan_ten){
		this.phapnhan_ten = phapnhan_ten;
	}
	public String getDia_chi(){
		return this.dia_chi;
	}
	public void setDia_chi(String dia_chi){
		this.dia_chi = dia_chi;
	}
	public String getMa_so_thue(){
		return this.ma_so_thue;
	}
	public void setMa_so_thue(String ma_so_thue){
		this.ma_so_thue = ma_so_thue;
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
	public String getNguoi_lien_he(){
		return this.nguoi_lien_he;
	}
	public void setNguoi_lien_he(String nguoi_lien_he){
		this.nguoi_lien_he = nguoi_lien_he;
	}
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getWebsite(){
		return this.website;
	}
	public void setWebsite(String website){
		this.website = website;
	}
	public String getGhi_chu(){
		return this.ghi_chu;
	}
	public void setGhi_chu(String ghi_chu){
		this.ghi_chu = ghi_chu;
	}
}