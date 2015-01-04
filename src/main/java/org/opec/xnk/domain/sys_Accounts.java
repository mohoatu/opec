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
import org.hibernate.annotations.Target;



@Entity
@Table(name = "sys_accounts")
public class sys_Accounts implements Serializable {
	@Id
	@Column(name= "user_id")
	@GeneratedValue
	 private int user_id;

	@Column(name = "user_name")
	 private String user_name;

	@Column(name = "full_name")
	 private String full_name;

	@Column(name = "password")
	 private String password;

	@Column(name = "is_active")
	 private int is_active;

	@Column(name = "is_lock")
	 private int is_lock;

	@Column(name = "is_system")
	 private int is_system;

	@Column(name = "groups_id")
	 private String groups_id;

	@Column(name = "date_expire")
	 private Date date_expire;

	@Column(name = "email")
	 private String email;

	@Column(name = "phone")
	 private String phone;

	@Column(name = "notes")
	 private String notes;

	@Column(name = "date_modify")
	 private Date date_modify;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name="groups_id", referencedColumnName = "groups_id", insertable=false, updatable = false)
	private sys_Accounts_Groups objAccountGroup; 
	
	
	
	public sys_Accounts(){
	}
	public int getUser_id(){
		return this.user_id;
	}
	public void setUser_id(int user_id){
		this.user_id = user_id;
	}
	public String getUser_name(){
		return this.user_name;
	}
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	public String getFull_name(){
		return this.full_name;
	}
	public void setFull_name(String full_name){
		this.full_name = full_name;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public int getIs_active(){
		return this.is_active;
	}
	public void setIs_active(int is_active){
		this.is_active = is_active;
	}
	public int getIs_lock(){
		return this.is_lock;
	}
	public void setIs_lock(int is_lock){
		this.is_lock = is_lock;
	}
	public int getIs_system(){
		return this.is_system;
	}
	public void setIs_system(int is_system){
		this.is_system = is_system;
	}
	public String getGroups_id(){
		return this.groups_id;
	}
	public void setGroups_id(String groups_id){
		this.groups_id = groups_id;
	}
	public Date getDate_expire(){
		return this.date_expire;
	}
	public void setDate_expire(Date date_expire){
		this.date_expire = date_expire;
	}
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getNotes(){
		return this.notes;
	}
	public void setNotes(String notes){
		this.notes = notes;
	}
	public Date getDate_modify(){
		return this.date_modify;
	}
	public void setDate_modify(Date date_modify){
		this.date_modify = date_modify;
	}
	public sys_Accounts_Groups getObjAccountGroup() {
		return objAccountGroup;
	}
	public void setObjAccountGroup(sys_Accounts_Groups objAccountGroup) {
		this.objAccountGroup = objAccountGroup;
	}
	
	
}