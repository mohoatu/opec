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
@Table(name = "dm_trang_thai_thanh_toan")
public class dm_Trang_Thai_Thanh_Toan implements Serializable {
	@Id
	@Column(name= "trangthai_id")
	@GeneratedValue
	 private int trangthai_id;

	@Column(name = "trangthai_ten")
	 private String trangthai_ten;

	public dm_Trang_Thai_Thanh_Toan(){
	}
	public int getTrangthai_id(){
		return this.trangthai_id;
	}
	public void setTrangthai_id(int trangthai_id){
		this.trangthai_id = trangthai_id;
	}
	public String getTrangthai_ten(){
		return this.trangthai_ten;
	}
	public void setTrangthai_ten(String trangthai_ten){
		this.trangthai_ten = trangthai_ten;
	}
}