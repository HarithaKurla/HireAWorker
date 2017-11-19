package com.example.s528744.hireaworker;

import java.util.Date;

/**
 * Created by s528744 on 11/16/2017.
 */

public class RegistrationInfo {

    public String Fname;
    public String Lname;
    public String Email;
    public String Usertype;
    public String Address;
    public int Zipcode;
    public String Password;
    public String Phonenumber;
    public String Capability;
    public int Experience;
    public int Cost;
    public String objectId;
    public Date created;
    public Date updated;


    public RegistrationInfo() {

    }

    public RegistrationInfo(String fname, String phonenumber, int cost) {
        Fname = fname;
        Phonenumber = phonenumber;
        Cost = cost;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsertype() {
        return Usertype;
    }

    public void setUsertype(String usertype) {
        Usertype = usertype;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getZipcode() {
        return Zipcode;
    }

    public void setZipcode(int zipcode) {
        Zipcode = zipcode;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getCapability() {
        return Capability;
    }

    public void setCapability(String capability) {
        Capability = capability;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    @Override
    public String toString() {
        return "RegistrationInfo{" +
                "Fname='" + Fname + '\'' +
                ", Lname='" + Lname + '\'' +
                ", Email='" + Email + '\'' +
                ", Usertype='" + Usertype + '\'' +
                ", Address='" + Address + '\'' +
                ", Zipcode=" + Zipcode +
                ", Password='" + Password + '\'' +
                ", Phonenumber='" + Phonenumber + '\'' +
                ", Capability='" + Capability + '\'' +
                ", Experience=" + Experience +
                ", Cost=" + Cost +
                ", objectId='" + objectId + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
