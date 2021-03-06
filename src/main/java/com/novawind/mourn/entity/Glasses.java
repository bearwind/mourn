package com.novawind.mourn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jeremy Xiong<br>
 * 2018-04-03 17:22
 */
@Entity
@Table(name = "Glasses")
public class Glasses {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "type")
    private String type;
    @Column(name = "degree")
    private String degree;

    public Long getId () {
        return id;
    }
    public void setId (Long id) {
        this.id = id;
    }
    public String getBrand () {
        return brand;
    }
    public void setBrand (String brand) {
        this.brand = brand;
    }
    public String getType () {
        return type;
    }
    public void setType (String type) {
        this.type = type;
    }
    public String getDegree () {
        return degree;
    }
    public void setDegree (String degree) {
        this.degree = degree;
    }
}
