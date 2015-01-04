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
@Table(name = "dm_phan_loai_hang_hoa")
public class dm_Phan_Loai_Hang_Hoa implements Serializable {
	@Id
	@Column(name= "phanloai_id")
	@GeneratedValue
	 private int phanloai_id;

	@Column(name = "phanloai_ma")
	 private String phanloai_ma;

	@Column(name = "phanloai_ten")
	 private String phanloai_ten;

	public dm_Phan_Loai_Hang_Hoa(){
	}
	public int getPhanloai_id(){
		return this.phanloai_id;
	}
	public void setPhanloai_id(int phanloai_id){
		this.phanloai_id = phanloai_id;
	}
	public String getPhanloai_ma(){
		return this.phanloai_ma;
	}
	public void setPhanloai_ma(String phanloai_ma){
		this.phanloai_ma = phanloai_ma;
	}
	public String getPhanloai_ten(){
		return this.phanloai_ten;
	}
	public void setPhanloai_ten(String phanloai_ten){
		this.phanloai_ten = phanloai_ten;
	}
}