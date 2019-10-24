package com.javabycode.springmvc.model;

import javax.persistence.Embeddable;

@Embeddable
public class Skills {

    public Skills() {}
    private String position;

    private String softskills;

    private String hardskills;

    public Skills(String position, String softskills, String hardskills) {
        this.position = position;
        this.softskills = softskills;
        this.hardskills = hardskills;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSoftskills() {
        return softskills;
    }

    public void setSoftskills(String softskills) {
        this.softskills = softskills;
    }

    public String getHardskills() {
        return hardskills;
    }

    public void setHardskills(String hardskills) {
        this.hardskills = hardskills;
    }
}
