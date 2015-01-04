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
@Table(name = "dm_muc_do_yeu_cau")
public class dm_Muc_Do_Yeu_Cau implements Serializable {
	@Id
	@Column(name= "mucdoyc_id")
	@GeneratedValue
	 private int mucdoyc_id;

	@Column(name = "mucdoyc_ma")
	 private String mucdoyc_ma;

	@Column(name = "mucdoyc_ten")
	 private String mucdoyc_ten;

	public dm_Muc_Do_Yeu_Cau(){
	}
	public int getMucdoyc_id(){
		return this.mucdoyc_id;
	}
	public void setMucdoyc_id(int mucdoyc_id){
		this.mucdoyc_id = mucdoyc_id;
	}
	public String getMucdoyc_ma(){
		return this.mucdoyc_ma;
	}
	public void setMucdoyc_ma(String mucdoyc_ma){
		this.mucdoyc_ma = mucdoyc_ma;
	}
	public String getMucdoyc_ten(){
		return this.mucdoyc_ten;
	}
	public void setMucdoyc_ten(String mucdoyc_ten){
		this.mucdoyc_ten = mucdoyc_ten;
	}
}