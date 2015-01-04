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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Target;



@Entity
@Table(name = "xnk_nk_chi_phi")
public class xnk_Nk_Chi_Phi implements Serializable {
	@Id
	@Column(name= "chiphi_id")
	@GeneratedValue
	private int chiphi_id;

	@Column(name = "code_id")
	private String code_id;

	@Column(name = "donvivantai_id")
	private int donvivantai_id;

	@Column(name = "ten_chi_phi")
	private String ten_chi_phi;

	@Column(name = "thanh_tien")
	private double thanh_tien;

	@Column(name = "ten_don_vi_thanh_toan")
	private String ten_don_vi_thanh_toan;

	@Column(name = "da_chi_tra")
	private Boolean da_chi_tra;

	@Column(name = "loai_chi_phi_id")
	private int loai_chi_phi_id;

	@Column(name = "ghi_chu")
	private String ghi_chu;

	/*
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="phapnhan_id", referencedColumnName = "phapnhan_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Phap_Nhan objPhapNhan;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="nhacungcap_id", referencedColumnName = "nhacungcap_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Nha_Cung_Cap objNhaCungCap;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="nhanvien_id", referencedColumnName = "nhanvien_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Nhan_Vien objNhanVien;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="mucdoyc_id", referencedColumnName = "mucdoyc_id", insertable=false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private dm_Muc_Do_Yeu_Cau objMucDoYeuCau;
	*/
	
	public xnk_Nk_Chi_Phi(){
		
	}
		
	
}