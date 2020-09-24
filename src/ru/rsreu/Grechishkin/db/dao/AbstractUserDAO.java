package ru.rsreu.Grechishkin.db.dao;

import ru.rsreu.Grechishkin.db.dto.Task;
import ru.rsreu.Grechishkin.db.dto.User;

import java.util.List;

public abstract class AbstractUserDAO {
    public abstract List<User> getAllUsers();
    public abstract List<User> getUsersByCommunityId(int communityId);
    public abstract List<User> getUsersByTaskId(int taskId);
    public abstract User getUserById(int userId);
    public abstract void addUserToCommunity(int communityId, int userId, int userCodeGroup,int  isBlocked);
}
