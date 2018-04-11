package com.novawind.mourn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jeremy Xiong<br>
 * 2018-04-03 16:40
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "customerNumber")
    private String customerNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "pinyin")
    private String pinyin;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "company")
    private String company;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "phone")
    private String phone;
    @Column(name = "qq")
    private String qq;
    @Column(name = "wechat")
    private String wechat;

    public Long getId () {
        return id;
    }
    public void setId (Long id) {
        this.id = id;
    }
    public String getCustomerNumber () {
        return customerNumber;
    }
    public void setCustomerNumber (String customerNumber) {
        this.customerNumber = customerNumber;
    }
    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getPinyin () {
        return pinyin;
    }
    public void setPinyin (String pinyin) {
        this.pinyin = pinyin;
    }
    public String getGender () {
        return gender;
    }
    public void setGender (String gender) {
        this.gender = gender;
    }
    public Integer getAge () {
        return age;
    }
    public void setAge (Integer age) {
        this.age = age;
    }
    public String getCompany () {
        return company;
    }
    public void setCompany (String company) {
        this.company = company;
    }
    public String getOccupation () {
        return occupation;
    }
    public void setOccupation (String occupation) {
        this.occupation = occupation;
    }
    public String getPhone () {
        return phone;
    }
    public void setPhone (String phone) {
        this.phone = phone;
    }
    public String getQq () {
        return qq;
    }
    public void setQq (String qq) {
        this.qq = qq;
    }
    public String getWechat () {
        return wechat;
    }
    public void setWechat (String wechat) {
        this.wechat = wechat;
    }
}
