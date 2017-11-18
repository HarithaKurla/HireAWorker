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
    public String Cost_Per_Hour;
    public String PhoneNumber;
    public String Capability;
    public int Experience;
    public String objectId;
    public Date created;
    public Date updated;


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
                ", Cost_Per_Hour='" + Cost_Per_Hour + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Capability='" + Capability + '\'' +
                ", Experience=" + Experience +
                ", objectId='" + objectId + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
