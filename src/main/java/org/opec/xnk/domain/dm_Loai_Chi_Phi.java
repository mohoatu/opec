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
@Table(name = "dm_loai_chi_phi")
public class dm_Loai_Chi_Phi implements Serializable {
	@Id
	@Column(name= "loaichiphi_id")
	@GeneratedValue
	 private int loaichiphi_id;

	@Column(name = "loaichiphi_ma")
	 private String loaichiphi_ma;

	@Column(name = "loaichiphi_ten")
	 private String loaichiphi_ten;

	public dm_Loai_Chi_Phi(){
	}
	public int getLoaichiphi_id(){
		return this.loaichiphi_id;
	}
	public void setLoaichiphi_id(int loaichiphi_id){
		this.loaichiphi_id = loaichiphi_id;
	}
	public String getLoaichiphi_ma(){
		return this.loaichiphi_ma;
	}
	public void setLoaichiphi_ma(String loaichiphi_ma){
		this.loaichiphi_ma = loaichiphi_ma;
	}
	public String getLoaichiphi_ten(){
		return this.loaichiphi_ten;
	}
	public void setLoaichiphi_ten(String loaichiphi_ten){
		this.loaichiphi_ten = loaichiphi_ten;
	}
}