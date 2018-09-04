package com.oauth;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_role")
public class AppRole implements Serializable {

	@Id
	@Column(name = "role_id")
	private int id;

	@Column(name = "role_name")
	private String roleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "AppRole [id=" + id + ", roleName=" + roleName + "]";
	}

}
