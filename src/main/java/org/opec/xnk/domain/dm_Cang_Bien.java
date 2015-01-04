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
@Table(name = "dm_cang_bien")
public class dm_Cang_Bien implements Serializable {
	@Id
	@Column(name= "cangbien_id")
	@GeneratedValue
	 private int cangbien_id;

	@Column(name = "cangbien_ma")
	 private String cangbien_ma;

	@Column(name = "cangbien_ten")
	 private String cangbien_ten;

	@Column(name = "dia_chi")
	 private String dia_chi;

	@Column(name = "nguoi_lien_he")
	 private String nguoi_lien_he;

	@Column(name = "dien_thoai")
	 private String dien_thoai;

	@Column(name = "fax")
	 private String fax;

	@Column(name = "email")
	 private String email;

	@Column(name = "ma_so_thue")
	 private String ma_so_thue;

	@Column(name = "quocgia_id")
	 private int quocgia_id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="quocgia_id", referencedColumnName = "quocgia_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Quoc_Gia objQuocGia;
	
	public dm_Quoc_Gia getObjQuocGia() {
		return objQuocGia;
	}
	public void setObjQuocGia(dm_Quoc_Gia objQuocGia) {
		this.objQuocGia = objQuocGia;
	}
	
	
	public int getQuocgia_id(){
		return this.quocgia_id;
	}
	public void setQuocgia_id(int quocgia_id){
		this.quocgia_id = quocgia_id;
	}
	
	
	public dm_Cang_Bien(){
	}
	public int getCangbien_id(){
		return this.cangbien_id;
	}
	public void setCangbien_id(int cangbien_id){
		this.cangbien_id = cangbien_id;
	}
	public String getCangbien_ma(){
		return this.cangbien_ma;
	}
	public void setCangbien_ma(String cangbien_ma){
		this.cangbien_ma = cangbien_ma;
	}
	public String getCangbien_ten(){
		return this.cangbien_ten;
	}
	public void setCangbien_ten(String cangbien_ten){
		this.cangbien_ten = cangbien_ten;
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
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getMa_so_thue(){
		return this.ma_so_thue;
	}
	public void setMa_so_thue(String ma_so_thue){
		this.ma_so_thue = ma_so_thue;
	}
	
}