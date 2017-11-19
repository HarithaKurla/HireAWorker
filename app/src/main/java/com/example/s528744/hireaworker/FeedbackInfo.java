package com.example.s528744.hireaworker;

import java.util.Date;

/**
 * Created by S528744 on 11/18/2017.
 */

public class FeedbackInfo {

    public String phonenumber;
    public String feedback;
    public String objectId;
    public Date created;
    public Date updated;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "FeedbackInfo{" +
                "phonenumber='" + phonenumber + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
