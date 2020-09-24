package ru.rsreu.Grechishkin.db;

import ru.rsreu.Grechishkin.db.dto.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class db2 {
    /*private static final List<User> USERS = new ArrayList<User>();
    private static final List<Task> PROJECT1_TASKS = new ArrayList<Task>();
    private static final List<Task> PROJECT2_TASKS = new ArrayList<Task>();
    private static final List<Task> USER1_TASKS = new ArrayList<Task>();
    private static final List<Task> USER2_TASKS = new ArrayList<Task>();
    private static final List<Community> COMMUNITIES = new ArrayList<Community>();
    private static final List<Community> USER1_COMMUNITIES = new ArrayList<Community>();
    private static final List<Community> USER2_COMMUNITIES = new ArrayList<Community>();
    private static final List<Comment> COMMENTS = new ArrayList<Comment>();
    private static final List<Project> PROJECTS = new ArrayList<Project>();
    static {
        final Task task1 = new Task(1, "Задача №1 - сделать то-то", 2);
        final Task task2 = new Task(2, "Задача №2 - сделать что-то другое", 7);
        final Task task3 = new Task(3, "Задача №3 - сделать следующее", 6);
        final Task task4 = new Task(4, "Задача №4", 3);
        final Task task5 = new Task(5, "Задача №5", 8);
        PROJECT1_TASKS.add(task1);
        PROJECT1_TASKS.add(task2);
        PROJECT1_TASKS.add(task3);
        PROJECT1_TASKS.add(task4);
        PROJECT1_TASKS.add(task5);
        USER1_TASKS.add(task1);
        USER1_TASKS.add(task2);
        USER1_TASKS.add(task3);
        USER1_TASKS.add(task4);
        PROJECT1_TASKS.add(task5);
        PROJECT2_TASKS.add(task1);
        PROJECT2_TASKS.add(task2);
        PROJECT2_TASKS.add(task3);
        final Timestamp time1 = new Timestamp(2020,3,10,12,15,40,0);
        final Timestamp time2 = new Timestamp(2020,3,10,12,18,0,0);
        final Timestamp time3 = new Timestamp(2020,3,10,12,20,4,0);
        final Comment comment1 = new Comment(1, "Текст первого комментария", time1);
        final Comment comment2 = new Comment(2, "Текст второго комментария", time1);
        final Comment comment3 = new Comment(3, "Текст третьего комментария", time2);
        final Comment comment4 = new Comment(4, "Текст четвертого комментария", time2);
        final Comment comment5 = new Comment(5, "Текст пятого комментария", time3);
        COMMENTS.add(comment1);
        COMMENTS.add(comment2);
        COMMENTS.add(comment3);
        COMMENTS.add(comment4);
        COMMENTS.add(comment5);
        final Project project1 = new Project(1,"Проект 1", "Описение первого проекта", PROJECT1_TASKS, COMMENTS);
        final Project project2 = new Project(1,"Проект 2", "Описение второрго проекта", PROJECT2_TASKS, COMMENTS);
        PROJECTS.add(project1);
        PROJECTS.add(project2);
        final Community community1 = new Community(1, "Сообщество №1", PROJECTS, USERS);
        final Community community2 = new Community(2, "Сообщество №2", PROJECTS,  USERS);
        COMMUNITIES.add(community1);
        COMMUNITIES.add(community2);
        USER2_COMMUNITIES.add(community1);
        USER2_COMMUNITIES.add(community2);
        USER1_COMMUNITIES.add(community1);
        USER1_COMMUNITIES.add(community2);
        final User user1 = new User(1,"Антон", "Чехов", "pass", "chehov@mail.ru",USER1_TASKS);
        final User user2 = new User(2,"Владимир", "Высоцкий", "pass2", "vis@mail.ru",USER2_TASKS);
        final User user3 = new User(3,"Админ", "Админович", "qwerr", "admin", PROJECT1_TASKS);
        USERS.add(user1);
        USERS.add(user2);
        USERS.add(user3);
    }
    static private User getUserByID(long id) {
        for (User user: USERS) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    static private Task getTaskByID(long id) {
        for (Task task : PROJECT1_TASKS) {
            if (id == task.getId()) {
                return task;
            }
        }
        return null;
    }
    static private List<User> getUsersByTaskIDandCommunity(int id, Community community) {
        List<User> users = new ArrayList<User>();
        for (User user : community.getUsers()) {
            for (Task task : user.getTasks()) {
                if (task.getId() == id) {
                    users.add(user);
                }
            }
        }
        return users;
    }
    static private Community getCommunityByID(long id) {
        for (Community community: COMMUNITIES) {
            if (community.getId() == id) {
                return community;
            }
        }
        return null;
    }*/
}
