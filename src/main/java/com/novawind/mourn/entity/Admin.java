package com.novawind.mourn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*  
* @author Jeremy Xiong<br>
* 2017-11-30 09:47:50
*/
@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "salt")
	private String salt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt () {
		return salt;
	}
	public void setSalt (String salt) {
		this.salt = salt;
	}

	@Override
	public String toString () {
		return "Admin{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				'}';
	}
}

