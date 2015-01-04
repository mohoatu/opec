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
@Table(name = "sys_accounts_groups")
public class sys_Accounts_Groups implements Serializable {
	@Id
	@Column(name= "groups_id")
	 private String groups_id;

	@Column(name = "groups_name")
	 private String groups_name;

	@Column(name = "date_modify")
	 private Date date_modify;

	public sys_Accounts_Groups(){
	}
	public String getGroups_id(){
		return this.groups_id;
	}
	public void setGroups_id(String groups_id){
		this.groups_id = groups_id;
	}
	public String getGroups_name(){
		return this.groups_name;
	}
	public void setGroups_name(String groups_name){
		this.groups_name = groups_name;
	}
	public Date getDate_modify(){
		return this.date_modify;
	}
	public void setDate_modify(Date date_modify){
		this.date_modify = date_modify;
	}
}