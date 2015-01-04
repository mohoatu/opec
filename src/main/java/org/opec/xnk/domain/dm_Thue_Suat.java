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
@Table(name = "dm_thue_suat")
public class dm_Thue_Suat implements Serializable {
	@Id
	@Column(name= "thuesuat_id")
	@GeneratedValue
	 private int thuesuat_id;

	@Column(name = "thuesuat_ten")
	 private String thuesuat_ten;

	@Column(name = "ty_le_thue_suat")
	 private double ty_le_thue_suat;

	public dm_Thue_Suat(){
	}
	public int getThuesuat_id(){
		return this.thuesuat_id;
	}
	public void setThuesuat_id(int thuesuat_id){
		this.thuesuat_id = thuesuat_id;
	}
	public String getThuesuat_ten(){
		return this.thuesuat_ten;
	}
	public void setThuesuat_ten(String thuesuat_ten){
		this.thuesuat_ten = thuesuat_ten;
	}
	public double getTy_le_thue_suat(){
		return this.ty_le_thue_suat;
	}
	public void setTy_le_thue_suat(double ty_le_thue_suat){
		this.ty_le_thue_suat = ty_le_thue_suat;
	}
}