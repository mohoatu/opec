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
@Table(name = "dm_nha_cung_cap")
public class dm_Nha_Cung_Cap implements Serializable {
	@Id
	@Column(name= "nhacungcap_id")
	@GeneratedValue
	 private int nhacungcap_id;

	@Column(name = "nhacungcap_ma")
	 private String nhacungcap_ma;

	@Column(name = "nhacungcap_ten")
	 private String nhacungcap_ten;

	@Column(name = "dia_chi")
	 private String dia_chi;

	@Column(name = "nguoi_lien_he")
	 private String nguoi_lien_he;

	@Column(name = "dien_thoai")
	 private String dien_thoai;

	@Column(name = "fax")
	 private String fax;

	@Column(name = "quocgia_id")
	 private int quocgia_id;

	@Column(name = "ghi_chu")
	 private String ghi_chu;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="quocgia_id", referencedColumnName = "quocgia_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Quoc_Gia objQuocGia;
	
	public dm_Quoc_Gia getObjQuocGia() {
		return objQuocGia;
	}
	public void setObjQuocGia(dm_Quoc_Gia objQuocGia) {
		this.objQuocGia = objQuocGia;
	}
	
	
	public dm_Nha_Cung_Cap(){
	}
	public int getNhacungcap_id(){
		return this.nhacungcap_id;
	}
	public void setNhacungcap_id(int nhacungcap_id){
		this.nhacungcap_id = nhacungcap_id;
	}
	public String getNhacungcap_ma(){
		return this.nhacungcap_ma;
	}
	public void setNhacungcap_ma(String nhacungcap_ma){
		this.nhacungcap_ma = nhacungcap_ma;
	}
	public String getNhacungcap_ten(){
		return this.nhacungcap_ten;
	}
	public void setNhacungcap_ten(String nhacungcap_ten){
		this.nhacungcap_ten = nhacungcap_ten;
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
	public int getQuocgia_id(){
		return this.quocgia_id;
	}
	public void setQuocgia_id(int quocgia_id){
		this.quocgia_id = quocgia_id;
	}
	public String getGhi_chu(){
		return this.ghi_chu;
	}
	public void setGhi_chu(String ghi_chu){
		this.ghi_chu = ghi_chu;
	}
}