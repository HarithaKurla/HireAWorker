package com.example.s528744.hireaworker;

import java.util.Date;

/**
 * Created by s528744 on 11/16/2017.
 */

public class RegistrationInfo {

    public String F_Name;
    public String L_Name;
    public String Email;
    public String User_Type;
    public String Address;
    public int Zipcode;
    public String Password;
    public String PhoneNumber;
    public String Capability;
    public int Experience;
    public String objectId;
    public Date created;
    public Date updated;

    public RegistrationInfo(String f_Name, String phoneNumber) {
        F_Name = f_Name;
        PhoneNumber = phoneNumber;

    }

    public RegistrationInfo() {

    }

    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setL_Name(String l_Name) {
        L_Name = l_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUser_Type() {
        return User_Type;
    }

    public void setUser_Type(String user_Type) {
        User_Type = user_Type;
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



    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
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

    @Override
    public String toString() {
        return "RegistrationInfo{" +
                "F_Name='" + F_Name + '\'' +
                ", L_Name='" + L_Name + '\'' +
                ", Email='" + Email + '\'' +
                ", User_Type='" + User_Type + '\'' +
                ", Address='" + Address + '\'' +
                ", Zipcode=" + Zipcode +
                ", Password='" + Password + '\'' +

                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Capability='" + Capability + '\'' +
                ", Experience=" + Experience +
                ", objectId='" + objectId + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
