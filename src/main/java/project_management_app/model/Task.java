/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management_app.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author tekane
 */
@Entity
public class Task {
    private long  id;
    private String date;
    private String startTime;
    private String stopTime;
    private String description;
    private User user;

    public Task() {
    }
    
    public Task(long id, String date, String startTime, String stopTime, String description, User user) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
        this.user = user;
    }

    public Task(String date, String startTime, String stopTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    //@NotEmpty
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @NotEmpty
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @NotEmpty
    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }
    @NotEmpty
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_EMAIL")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
