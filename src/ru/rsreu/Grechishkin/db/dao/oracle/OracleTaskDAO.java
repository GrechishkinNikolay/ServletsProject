package ru.rsreu.Grechishkin.db.dao.oracle;

import ru.rsreu.Grechishkin.db.dao.AbstractTaskDAO;
import ru.rsreu.Grechishkin.db.dto.Task;

import java.util.List;

public class OracleTaskDAO extends AbstractTaskDAO {
    public OracleTaskDAO() {
    }

    @Override
    public List<Task> getTasksByUserId(int userId) {
        return OracleManager.getUserTasksById(userId);
    }

/*    @Override
    public void addTask(int projectId, int numberOfPerformers, String text, int userId) {
        OracleManager.addTask(projectId, numberOfPerformers, text, userId);
    }*/

    @Override
    public void addTaskToUser(int taskId, int userId) {
        OracleManager.addTaskToUser(taskId, userId);
    }

    @Override
    public void addTask(int projectId, int performersNumber, String taskText) {
        OracleManager.addTask(projectId, performersNumber, taskText);
    }

    @Override
    public void deleteUsersTask(int taskId, int userId) {
        OracleManager.deleteUsersTask(taskId, userId);
    }

    @Override
    public List<Task> getTasksByProjectId(int projectId) {
        return OracleManager.getTasksByProjectId(projectId);
    }

    @Override
    public Task getTasksById(int taskId) {
        return OracleManager.getTaskById(taskId);
    }
}
