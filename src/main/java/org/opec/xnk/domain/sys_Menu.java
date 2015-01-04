package org.opec.xnk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_menu")
public class sys_Menu {

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="parentid")
	private String parentid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="func")
	private String func;
	
	@Column(name="subMenuWidth")
	private String subMenuWidth;
	
	@Column(name="fullscreen")
	private Boolean fullscreen;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public String getSubMenuWidth() {
		return subMenuWidth;
	}

	public void setSubMenuWidth(String subMenuWidth) {
		this.subMenuWidth = subMenuWidth;
	}

	public Boolean getFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(Boolean fullscreen) {
		this.fullscreen = fullscreen;
	}
		
}
