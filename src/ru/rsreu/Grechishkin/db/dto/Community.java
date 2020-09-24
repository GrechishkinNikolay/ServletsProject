package ru.rsreu.Grechishkin.db.dto;

import java.util.List;

public class Community {
    private int id;
    private String name;
    private List<Project> projects;
    private List<User> users;


    public Community(int id, String name, List<Project> projects, List<User> users) {
        this.id = id;
        this.name = name;
        this.projects = projects;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
