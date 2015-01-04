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
@Table(name = "dm_phuong_thuc_gia")
public class dm_Phuong_Thuc_Gia implements Serializable {
	@Id
	@Column(name= "phuongthucgia_id")
	@GeneratedValue
	 private int phuongthucgia_id;

	@Column(name = "phuongthucgia_ma")
	 private String phuongthucgia_ma;

	@Column(name = "phuongthucgia_ten")
	 private String phuongthucgia_ten;

	public dm_Phuong_Thuc_Gia(){
	}
	public int getPhuongthucgia_id(){
		return this.phuongthucgia_id;
	}
	public void setPhuongthucgia_id(int phuongthucgia_id){
		this.phuongthucgia_id = phuongthucgia_id;
	}
	public String getPhuongthucgia_ma(){
		return this.phuongthucgia_ma;
	}
	public void setPhuongthucgia_ma(String phuongthucgia_ma){
		this.phuongthucgia_ma = phuongthucgia_ma;
	}
	public String getPhuongthucgia_ten(){
		return this.phuongthucgia_ten;
	}
	public void setPhuongthucgia_ten(String phuongthucgia_ten){
		this.phuongthucgia_ten = phuongthucgia_ten;
	}
}