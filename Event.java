package com.example.bilal.myapp;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal on 30-Jul-17.
 */

public class Event {


    private String name;
    private String Event_date;
    private String Event_venue;
    private String Description;
    private String picture;
    private Drawable ImageId;
    public Event() {

    }

    public Event(String name, String Event_date, String description, String event_venue, String picture) {
        this.name = name;
        this.Event_date = Event_date;
        this.Description = description;
        this.Event_venue = event_venue;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvent_venue() {
        return Event_venue;
    }

    public void setEvent_venue(String event_venue) {
        this.Event_venue = event_venue;
    }

    public String getEvent_date() {
        return this.Event_date;
    }

    public void setEvent_date(String event_date) {
        this.Event_date = event_date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Drawable getImageId() {
        return ImageId;
    }

    public void setImageId(Drawable imageId) {
        ImageId = imageId;
    }
}

