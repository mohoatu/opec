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
@Table(name = "xnk_nk_giao_nhan")
public class xnk_Nk_Giao_Nhan implements Serializable {
	@Id
	@Column(name= "giaonhan_id")
	@GeneratedValue
	private int giaonhan_id;

	@Column(name = "code_id")
	private String code_id;

	@Column(name = "donvivantai_id")
	private int donvivantai_id;

	@Column(name = "khachhang_id")
	private int khachhang_id;

	@Column(name = "dia_chi_giao_nhan")
	private String dia_chi_giao_nhan;

	@Column(name = "so_luong_yeu_cau")
	private int so_luong_yeu_cau;

	@Column(name = "ngay_yeu_cau_giao_cont")
	private Date ngay_yeu_cau_giao_cont;

	@Column(name = "so_luong_cont_yeu_cau")
	private int so_luong_cont_yeu_cau;

	@Column(name = "ngay_thuc_te_giao_cont")
	private Date ngay_thuc_te_giao_cont;

	@Column(name = "so_luong_cont_giao_thuc_te")
	private int so_luong_cont_giao_thuc_te;

	@Column(name = "da_hoan_thanh_giao")
	private Boolean da_hoan_thanh_giao;

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
	
	public xnk_Nk_Giao_Nhan(){
		
	}
		
	
}