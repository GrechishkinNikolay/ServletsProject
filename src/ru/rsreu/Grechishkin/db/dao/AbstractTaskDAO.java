package ru.rsreu.Grechishkin.db.dao;

import ru.rsreu.Grechishkin.db.dto.Task;

import java.util.List;

public abstract class AbstractTaskDAO {
    public abstract List<Task> getTasksByUserId(int userId);
//    public abstract void addTask(int projectId, int numberOfPerformers, String text, int userId);
    public abstract void addTaskToUser(int taskId, int userId);
    public abstract void addTask(int projectId, int performersNumber, String taskText);
    public abstract void deleteUsersTask(int taskId, int userId);
    public abstract List<Task> getTasksByProjectId(int projectId);
    public abstract Task getTasksById(int taskId);
}
