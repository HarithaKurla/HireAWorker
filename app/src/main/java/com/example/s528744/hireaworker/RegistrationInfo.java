package com.example.s528744.hireaworker;

import java.util.Date;

/**
 * Created by s528744 on 11/16/2017.
 */

public class RegistrationInfo {

    public String fname;
    public String lname;
    public String email;
    public String usertype;
    public String address;
    public int zipcode;
    public String password;
    public String phonenumber;
    public String capability;
    public int experience;
    public int cost;
    public String objectId;
    public Date created;
    public Date updated;


    public RegistrationInfo() {

    }

    public RegistrationInfo(String fname, String phonenumber, int cost) {
        this.fname = fname;
        this.phonenumber = phonenumber;
        this.cost = cost;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "RegistrationInfo{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", usertype='" + usertype + '\'' +
                ", address='" + address + '\'' +
                ", zipcode=" + zipcode +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", capability='" + capability + '\'' +
                ", experience=" + experience +
                ", cost=" + cost +
                ", objectId='" + objectId + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
