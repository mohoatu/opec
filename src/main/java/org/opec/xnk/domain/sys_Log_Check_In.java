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
@Table(name = "sys_log_check_in")
public class sys_Log_Check_In implements Serializable {
	@Id
	@Column(name= "log_id")
	@GeneratedValue
	 private int log_id;

	@Column(name = "user_name")
	 private String user_name;

	@Column(name = "check_in")
	 private Date check_in;

	public sys_Log_Check_In(){
	}
	public int getLog_id(){
		return this.log_id;
	}
	public void setLog_id(int log_id){
		this.log_id = log_id;
	}
	public String getUser_name(){
		return this.user_name;
	}
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	public Date getCheck_in(){
		return this.check_in;
	}
	public void setCheck_in(Date check_in){
		this.check_in = check_in;
	}
}