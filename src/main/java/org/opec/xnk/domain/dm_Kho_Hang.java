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
@Table(name = "dm_kho_hang")
public class dm_Kho_Hang implements Serializable {
	@Id
	@Column(name= "kho_id")
	@GeneratedValue
	 private int kho_id;

	@Column(name = "ma_kho")
	 private String ma_kho;

	@Column(name = "ten_kho")
	 private String ten_kho;

	public dm_Kho_Hang(){
	}
	public int getKho_id(){
		return this.kho_id;
	}
	public void setKho_id(int kho_id){
		this.kho_id = kho_id;
	}
	public String getMa_kho(){
		return this.ma_kho;
	}
	public void setMa_kho(String ma_kho){
		this.ma_kho = ma_kho;
	}
	public String getTen_kho(){
		return this.ten_kho;
	}
	public void setTen_kho(String ten_kho){
		this.ten_kho = ten_kho;
	}
}