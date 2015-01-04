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
@Table(name = "dm_loai_container")
public class dm_Loai_Container implements Serializable {
	@Id
	@Column(name= "container_id")
	@GeneratedValue
	 private int container_id;

	@Column(name = "container_ma")
	 private String container_ma;

	@Column(name = "container_ten")
	 private String container_ten;

	public dm_Loai_Container(){
	}
	public int getContainer_id(){
		return this.container_id;
	}
	public void setContainer_id(int container_id){
		this.container_id = container_id;
	}
	public String getContainer_ma(){
		return this.container_ma;
	}
	public void setContainer_ma(String container_ma){
		this.container_ma = container_ma;
	}
	public String getContainer_ten(){
		return this.container_ten;
	}
	public void setContainer_ten(String container_ten){
		this.container_ten = container_ten;
	}
}