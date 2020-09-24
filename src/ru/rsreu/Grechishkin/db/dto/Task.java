package ru.rsreu.Grechishkin.db.dto;

public class Task {
    private int id;
    private String text;
    private int performersNumber;

    public Task(int id, String text, int performersNumber) {
        this.id = id;
        this.text = text;
        this.performersNumber = performersNumber;
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

    public int getPerformersNumber() {
        return performersNumber;
    }

    public void setPerformersNumber(int performersNumber) {
        this.performersNumber = performersNumber;
    }
}
