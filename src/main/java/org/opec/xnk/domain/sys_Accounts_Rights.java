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
@Table(name = "sys_accounts_rights")
public class sys_Accounts_Rights implements Serializable {
	@Id
	@Column(name= "rights_id")
	@GeneratedValue
	 private int rights_id;

	@Column(name = "user_name")
	 private String user_name;

	@Column(name = "menu_id")
	 private String menu_id;

	@Column(name = "is_insert")
	 private int is_insert;

	@Column(name = "is_delete")
	 private int is_delete;

	@Column(name = "is_update")
	 private int is_update;

	@Column(name = "is_select")
	 private int is_select;

	@Column(name = "user_modify")
	 private String user_modify;

	@Column(name = "date_modify")
	 private Date date_modify;

	public sys_Accounts_Rights(){
	}
	public int getRights_id(){
		return this.rights_id;
	}
	public void setRights_id(int rights_id){
		this.rights_id = rights_id;
	}
	public String getUser_name(){
		return this.user_name;
	}
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	public String getMenu_id(){
		return this.menu_id;
	}
	public void setMenu_id(String menu_id){
		this.menu_id = menu_id;
	}
	public int getIs_insert(){
		return this.is_insert;
	}
	public void setIs_insert(int is_insert){
		this.is_insert = is_insert;
	}
	public int getIs_delete(){
		return this.is_delete;
	}
	public void setIs_delete(int is_delete){
		this.is_delete = is_delete;
	}
	public int getIs_update(){
		return this.is_update;
	}
	public void setIs_update(int is_update){
		this.is_update = is_update;
	}
	public int getIs_select(){
		return this.is_select;
	}
	public void setIs_select(int is_select){
		this.is_select = is_select;
	}
	public String getUser_modify(){
		return this.user_modify;
	}
	public void setUser_modify(String user_modify){
		this.user_modify = user_modify;
	}
	public Date getDate_modify(){
		return this.date_modify;
	}
	public void setDate_modify(Date date_modify){
		this.date_modify = date_modify;
	}
}