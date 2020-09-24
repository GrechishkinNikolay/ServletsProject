package ru.rsreu.Grechishkin.db.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Comment {
    private int id;
    private String text;
    private Timestamp dateTime;

    public Comment(int id, String text, Timestamp dateTime) {
        this.id = id;
        this.text = text;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}
