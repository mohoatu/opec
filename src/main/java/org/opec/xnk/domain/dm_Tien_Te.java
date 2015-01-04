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
@Table(name = "dm_tien_te")
public class dm_Tien_Te implements Serializable {
	@Id
	@Column(name= "tiente_id")
	@GeneratedValue
	 private int tiente_id;

	@Column(name = "tiente_ma")
	 private String tiente_ma;

	public dm_Tien_Te(){
	}
	public int getTiente_id(){
		return this.tiente_id;
	}
	public void setTiente_id(int tiente_id){
		this.tiente_id = tiente_id;
	}
	public String getTiente_ma(){
		return this.tiente_ma;
	}
	public void setTiente_ma(String tiente_ma){
		this.tiente_ma = tiente_ma;
	}
}