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
@Table(name = "dm_phuong_thuc_thanh_toan")
public class dm_Phuong_Thuc_Thanh_Toan implements Serializable {
	@Id
	@Column(name= "phuongthuctt_id")
	@GeneratedValue
	 private int phuongthuctt_id;

	@Column(name = "phuongthuctt_ma")
	 private String phuongthuctt_ma;

	@Column(name = "phuongthuctt_ten")
	 private String phuongthuctt_ten;

	public dm_Phuong_Thuc_Thanh_Toan(){
	}
	public int getPhuongthuctt_id(){
		return this.phuongthuctt_id;
	}
	public void setPhuongthuctt_id(int phuongthuctt_id){
		this.phuongthuctt_id = phuongthuctt_id;
	}
	public String getPhuongthuctt_ma(){
		return this.phuongthuctt_ma;
	}
	public void setPhuongthuctt_ma(String phuongthuctt_ma){
		this.phuongthuctt_ma = phuongthuctt_ma;
	}
	public String getPhuongthuctt_ten(){
		return this.phuongthuctt_ten;
	}
	public void setPhuongthuctt_ten(String phuongthuctt_ten){
		this.phuongthuctt_ten = phuongthuctt_ten;
	}
}