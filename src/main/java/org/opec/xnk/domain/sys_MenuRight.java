package org.opec.xnk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class sys_MenuRight {
	
	@Column(name="id")
	@NotFound(action=NotFoundAction.IGNORE)
	private String id;
	
	@Id
	@Column(name="menu_id")
	private String menu_id;
	
	@Column(name="parentid")
	private String parentid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="func")
	private String func;
	
	@Column(name="right")
	private String right;
	
	@Column(name="user_id")
	@NotFound(action=NotFoundAction.IGNORE)
	private String user_id;
	
	@Column(name="r", insertable = false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private Boolean r;
	
	@Column(name="w", insertable = false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private Boolean w;
	
	@Column(name="d", insertable = false, updatable = false)
	@NotFound(action=NotFoundAction.IGNORE)
	private Boolean d;

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

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Boolean getR() {
		return true;
	}

	public void setR(Boolean r) {
		this.r = r;
	}

	public Boolean getW() {
		return true;
	}

	public void setW(Boolean w) {
		this.w = w;
	}

	public Boolean getD() {
		return true;
	}

	public void setD(Boolean d) {
		this.d = d;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	
	
}
