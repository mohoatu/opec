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
@Table(name = "dm_ung_dung")
public class dm_Ung_Dung implements Serializable {
	@Id
	@Column(name= "ungdung_id")
	@GeneratedValue
	 private int ungdung_id;

	@Column(name = "ungdung_ma")
	 private String ungdung_ma;

	@Column(name = "ungdung_ten")
	 private String ungdung_ten;

	public dm_Ung_Dung(){
	}
	public int getUngdung_id(){
		return this.ungdung_id;
	}
	public void setUngdung_id(int ungdung_id){
		this.ungdung_id = ungdung_id;
	}
	public String getUngdung_ma(){
		return this.ungdung_ma;
	}
	public void setUngdung_ma(String ungdung_ma){
		this.ungdung_ma = ungdung_ma;
	}
	public String getUngdung_ten(){
		return this.ungdung_ten;
	}
	public void setUngdung_ten(String ungdung_ten){
		this.ungdung_ten = ungdung_ten;
	}
}