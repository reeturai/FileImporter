/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leaapfrog.FileImporter.entity;


public class Advertise {
    private int id;
    private String title;
    private int disount,day;

    public Advertise() {
    }

    public Advertise(int id, String title, int disount, int day) {
        this.id = id;
        this.title = title;
        this.disount = disount;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDisount() {
        return disount;
    }

    public void setDisount(int disount) {
        this.disount = disount;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    
   
}
