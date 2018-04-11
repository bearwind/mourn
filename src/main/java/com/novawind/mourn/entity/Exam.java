package com.novawind.mourn.entity;

import javax.persistence.*;

/**
 * @author Jeremy Xiong<br>
 * 2018-04-03 16:44
 */
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "customerId")
    private Long customerId;
    @Column(name = "distance")
    private String distance;
    @Column(name = "leftDegree1")
    private String leftDegree1;
    @Column(name = "rightDegree1")
    private String rightDegree1;
    @Column(name = "leftDegree2")
    private String leftDegree2;
    @Column(name = "rightDegree2")
    private String rightDegree2;
    @Column(name = "leftView")
    private String leftView;
    @Column(name = "rightView")
    private String rightView;
    @Column(name = "correctLeft")
    private String correctLeft;
    @Column(name = "correctRight")
    private String correctRight;
    @Column(name = "examer")
    private String examer;
    @Column(name = "maker")
    private String maker;
    @Column(name = "frameId")
    private Long frameId;
    @Column(name = "glassesId")
    private Long glassesId;
    @Column(name = "payment")
    private String payment;
    @Column(name = "date")
    private String date;
    @Column(name = "mark")
    private String mark;

    public Long getId () {
        return id;
    }
    public void setId (Long id) {
        this.id = id;
    }
    public Long getCustomerId () {
        return customerId;
    }
    public void setCustomerId (Long customerId) {
        this.customerId = customerId;
    }
    public String getDistance () {
        return distance;
    }
    public void setDistance (String distance) {
        this.distance = distance;
    }
    public String getLeftDegree1 () {
        return leftDegree1;
    }
    public void setLeftDegree1 (String leftDegree1) {
        this.leftDegree1 = leftDegree1;
    }
    public String getRightDegree1 () {
        return rightDegree1;
    }
    public void setRightDegree1 (String rightDegree1) {
        this.rightDegree1 = rightDegree1;
    }
    public String getLeftDegree2 () {
        return leftDegree2;
    }
    public void setLeftDegree2 (String leftDegree2) {
        this.leftDegree2 = leftDegree2;
    }
    public String getRightDegree2 () {
        return rightDegree2;
    }
    public void setRightDegree2 (String rightDegree2) {
        this.rightDegree2 = rightDegree2;
    }
    public String getLeftView () {
        return leftView;
    }
    public void setLeftView (String leftView) {
        this.leftView = leftView;
    }
    public String getRightView () {
        return rightView;
    }
    public void setRightView (String rightView) {
        this.rightView = rightView;
    }
    public String getCorrectLeft () {
        return correctLeft;
    }
    public void setCorrectLeft (String correctLeft) {
        this.correctLeft = correctLeft;
    }
    public String getCorrectRight () {
        return correctRight;
    }
    public void setCorrectRight (String correctRight) {
        this.correctRight = correctRight;
    }
    public String getExamer () {
        return examer;
    }
    public void setExamer (String examer) {
        this.examer = examer;
    }
    public String getMaker () {
        return maker;
    }
    public void setMaker (String maker) {
        this.maker = maker;
    }
    public Long getFrameId () {
        return frameId;
    }
    public void setFrameId (Long frameId) {
        this.frameId = frameId;
    }
    public Long getGlassesId () {
        return glassesId;
    }
    public void setGlassesId (Long glassesId) {
        this.glassesId = glassesId;
    }
    public String getPayment () {
        return payment;
    }
    public void setPayment (String payment) {
        this.payment = payment;
    }
    public String getDate () {
        return date;
    }
    public void setDate (String date) {
        this.date = date;
    }
    public String getMark () {
        return mark;
    }
    public void setMark (String mark) {
        this.mark = mark;
    }
}
