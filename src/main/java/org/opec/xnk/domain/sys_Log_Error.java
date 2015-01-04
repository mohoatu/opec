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
@Table(name = "sys_log_error")
public class sys_Log_Error implements Serializable {
	@Id
	@Column(name= "error_id")
	@GeneratedValue
	 private int error_id;

	@Column(name = "error_name")
	 private String error_name;

	@Column(name = "user_name")
	 private String user_name;

	@Column(name = "user_ip")
	 private String user_ip;

	@Column(name = "module")
	 private String module;

	@Column(name = "date_error")
	 private Date date_error;

	public sys_Log_Error(){
	}
	public int getError_id(){
		return this.error_id;
	}
	public void setError_id(int error_id){
		this.error_id = error_id;
	}
	public String getError_name(){
		return this.error_name;
	}
	public void setError_name(String error_name){
		this.error_name = error_name;
	}
	public String getUser_name(){
		return this.user_name;
	}
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	public String getUser_ip(){
		return this.user_ip;
	}
	public void setUser_ip(String user_ip){
		this.user_ip = user_ip;
	}
	public String getModule(){
		return this.module;
	}
	public void setModule(String module){
		this.module = module;
	}
	public Date getDate_error(){
		return this.date_error;
	}
	public void setDate_error(Date date_error){
		this.date_error = date_error;
	}
}