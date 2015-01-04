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
@Table(name = "dm_khach_hang_noi_dia")
public class dm_Khach_Hang_Noi_Dia implements Serializable {
	@Id
	@Column(name= "khachhangnoidia_id")
	@GeneratedValue
	 private int khachhangnoidia_id;

	@Column(name = "khachhangnoidia_ma")
	 private String khachhangnoidia_ma;

	@Column(name = "khachhangnoidia_ten")
	 private String khachhangnoidia_ten;

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
	
	
	public dm_Khach_Hang_Noi_Dia(){
	}
	public int getKhachhangnoidia_id(){
		return this.khachhangnoidia_id;
	}
	public void setKhachhangnoidia_id(int khachhangnoidia_id){
		this.khachhangnoidia_id = khachhangnoidia_id;
	}
	public String getKhachhangnoidia_ma(){
		return this.khachhangnoidia_ma;
	}
	public void setKhachhangnoidia_ma(String khachhangnoidia_ma){
		this.khachhangnoidia_ma = khachhangnoidia_ma;
	}
	public String getKhachhangnoidia_ten(){
		return this.khachhangnoidia_ten;
	}
	public void setKhachhangnoidia_ten(String khachhangnoidia_ten){
		this.khachhangnoidia_ten = khachhangnoidia_ten;
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