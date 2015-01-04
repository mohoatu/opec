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
@Table(name = "dm_quoc_gia")
public class dm_Quoc_Gia implements Serializable {
	@Id
	@Column(name= "quocgia_id")
	@GeneratedValue
	 private int quocgia_id;

	@Column(name = "quocgia_ten")
	 private String quocgia_ten;

	public dm_Quoc_Gia(){
	}
	public int getQuocgia_id(){
		return this.quocgia_id;
	}
	public void setQuocgia_id(int quocgia_id){
		this.quocgia_id = quocgia_id;
	}
	public String getQuocgia_ten(){
		return this.quocgia_ten;
	}
	public void setQuocgia_ten(String quocgia_ten){
		this.quocgia_ten = quocgia_ten;
	}
}