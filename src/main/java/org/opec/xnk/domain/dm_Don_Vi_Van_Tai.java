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
@Table(name = "dm_don_vi_van_tai")
public class dm_Don_Vi_Van_Tai implements Serializable {
	@Id
	@Column(name= "dvvantai_id")
	@GeneratedValue
	 private int dvvantai_id;

	@Column(name = "dvvantai_ma")
	 private String dvvantai_ma;

	@Column(name = "dvvantai_ten")
	 private String dvvantai_ten;

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
	
	
	
	
	public dm_Don_Vi_Van_Tai(){
	}
	public int getDvvantai_id(){
		return this.dvvantai_id;
	}
	public void setDvvantai_id(int dvvantai_id){
		this.dvvantai_id = dvvantai_id;
	}
	public String getDvvantai_ma(){
		return this.dvvantai_ma;
	}
	public void setDvvantai_ma(String dvvantai_ma){
		this.dvvantai_ma = dvvantai_ma;
	}
	public String getDvvantai_ten(){
		return this.dvvantai_ten;
	}
	public void setDvvantai_ten(String dvvantai_ten){
		this.dvvantai_ten = dvvantai_ten;
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