package org.opec.xnk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "dm_trang_thai_hop_dong")
public class dm_Trang_Thai_Hop_Dong {
	
	@Id
	@Column(name= "trangthai_id")
	@GeneratedValue
	private int trangthai_id;

	@Column(name = "trangthai_ten")
	private String trangthai_ten;

	public int getTrangthai_id() {
		return trangthai_id;
	}

	public void setTrangthai_id(int trangthai_id) {
		this.trangthai_id = trangthai_id;
	}

	public String getTrangthai_ten() {
		return trangthai_ten;
	}

	public void setTrangthai_ten(String trangthai_ten) {
		this.trangthai_ten = trangthai_ten;
	}
	
	
}
