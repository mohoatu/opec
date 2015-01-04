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
@Table(name = "dm_loai_hinh_xnk")
public class dm_Loai_Hinh_Xnk implements Serializable {
	@Id
	@Column(name= "loaihinhxnk_id")
	@GeneratedValue
	 private int loaihinhxnk_id;

	@Column(name = "loaihinhxnk_ma")
	 private String loaihinhxnk_ma;

	@Column(name = "loaihinhxnk_ten")
	 private String loaihinhxnk_ten;

	public dm_Loai_Hinh_Xnk(){
	}
	public int getLoaihinhxnk_id(){
		return this.loaihinhxnk_id;
	}
	public void setLoaihinhxnk_id(int loaihinhxnk_id){
		this.loaihinhxnk_id = loaihinhxnk_id;
	}
	public String getLoaihinhxnk_ma(){
		return this.loaihinhxnk_ma;
	}
	public void setLoaihinhxnk_ma(String loaihinhxnk_ma){
		this.loaihinhxnk_ma = loaihinhxnk_ma;
	}
	public String getLoaihinhxnk_ten(){
		return this.loaihinhxnk_ten;
	}
	public void setLoaihinhxnk_ten(String loaihinhxnk_ten){
		this.loaihinhxnk_ten = loaihinhxnk_ten;
	}
}