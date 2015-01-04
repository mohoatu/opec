package org.opec.xnk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_menu")
public class sysUser_Menu {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="menu_id")
	private String menu_id;
	
	@Column(name="right")
	private String right;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	
}
