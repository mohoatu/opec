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
@Table(name = "dm_phong_ban")
public class dm_Phong_Ban implements Serializable {
	@Id
	@Column(name= "donvi_id")
	@GeneratedValue
	 private int donvi_id;

	@Column(name = "donvi_ma")
	 private String donvi_ma;

	@Column(name = "donvi_ten")
	 private String donvi_ten;

	public dm_Phong_Ban(){
	}
	public int getDonvi_id(){
		return this.donvi_id;
	}
	public void setDonvi_id(int donvi_id){
		this.donvi_id = donvi_id;
	}
	public String getDonvi_ma(){
		return this.donvi_ma;
	}
	public void setDonvi_ma(String donvi_ma){
		this.donvi_ma = donvi_ma;
	}
	public String getDonvi_ten(){
		return this.donvi_ten;
	}
	public void setDonvi_ten(String donvi_ten){
		this.donvi_ten = donvi_ten;
	}
}