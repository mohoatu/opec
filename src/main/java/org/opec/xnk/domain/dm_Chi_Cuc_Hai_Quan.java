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
@Table(name = "dm_chi_cuc_hai_quan")
public class dm_Chi_Cuc_Hai_Quan implements Serializable {
	@Id
	@Column(name= "chicuchq_id")
	@GeneratedValue
	 private int chicuchq_id;

	@Column(name = "chicuchq_ma")
	 private String chicuchq_ma;

	@Column(name = "chicuchq_ten")
	 private String chicuchq_ten;

	@Column(name = "tai_khoan")
	 private String tai_khoan;

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
	
	
	
	public dm_Chi_Cuc_Hai_Quan(){
	}
	
	
	
	public int getChicuchq_id(){
		return this.chicuchq_id;
	}
	public void setChicuchq_id(int chicuchq_id){
		this.chicuchq_id = chicuchq_id;
	}
	public String getChicuchq_ma(){
		return this.chicuchq_ma;
	}
	public void setChicuchq_ma(String chicuchq_ma){
		this.chicuchq_ma = chicuchq_ma;
	}
	public String getChicuchq_ten(){
		return this.chicuchq_ten;
	}
	public void setChicuchq_ten(String chicuchq_ten){
		this.chicuchq_ten = chicuchq_ten;
	}
	public String getTai_khoan(){
		return this.tai_khoan;
	}
	public void setTai_khoan(String tai_khoan){
		this.tai_khoan = tai_khoan;
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