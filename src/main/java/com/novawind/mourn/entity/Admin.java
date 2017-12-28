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
	@Column(name = "token")
	private String token;
	@Column(name = "series")
	private String series;
	@Column(name = "expireTime")
	private Long expireTime;
	
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
	public String getToken () {
		return token;
	}
	public void setToken (String token) {
		this.token = token;
	}
	public String getSeries () {
		return series;
	}
	public void setSeries (String series) {
		this.series = series;
	}
	public Long getExpireTime () {
		return expireTime;
	}
	public void setExpireTime (Long expireTime) {
		this.expireTime = expireTime;
	}

	@Override
	public String toString () {
		return "Admin{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", token='" + token + '\'' +
				", series='" + series + '\'' +
				", expireTime='" + expireTime + '\'' +
				'}';
	}
}

