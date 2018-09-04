package com.oauth;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class AppUserRole implements Serializable {

	@Id
	@Column(name = "role_id")
	private int id;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private AppUser appUser;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private AppUserRole userRole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public AppUserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(AppUserRole userRole) {
		this.userRole = userRole;
	}
	
	

}
