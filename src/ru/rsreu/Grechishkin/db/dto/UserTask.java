package ru.rsreu.Grechishkin.db.dto;

public class UserTask {

    private int TaskId;
    private int UserId;

    public UserTask(int taskId, int userId) {
        TaskId = taskId;
        UserId = userId;
    }

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int taskId) {
        TaskId = taskId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
