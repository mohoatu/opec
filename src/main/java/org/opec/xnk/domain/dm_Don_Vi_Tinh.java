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
@Table(name = "dm_don_vi_tinh")
public class dm_Don_Vi_Tinh implements Serializable {
	@Id
	@Column(name= "id")
	@GeneratedValue
	 private int id;

	@Column(name = "don_vi_tinh")
	 private String don_vi_tinh;

	public dm_Don_Vi_Tinh(){
	}
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getDon_vi_tinh(){
		return this.don_vi_tinh;
	}
	public void setDon_vi_tinh(String don_vi_tinh){
		this.don_vi_tinh = don_vi_tinh;
	}
}