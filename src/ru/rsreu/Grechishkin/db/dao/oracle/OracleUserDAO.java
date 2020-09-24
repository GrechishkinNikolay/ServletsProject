package ru.rsreu.Grechishkin.db.dao.oracle;

import ru.rsreu.Grechishkin.db.dao.AbstractUserDAO;
import ru.rsreu.Grechishkin.db.dto.User;

import java.util.List;

public class OracleUserDAO extends AbstractUserDAO {
    public OracleUserDAO() {
    }

    @Override
    public List<User> getAllUsers() {
        return OracleManager.getAllUsers();
    }

    @Override
    public List<User> getUsersByCommunityId(int communityId) {
        return OracleManager.getUsersByCommunityId(communityId);
    }

    @Override
    public List<User> getUsersByTaskId(int taskId) {
        return OracleManager.getUsersByTaskId(taskId);
    }

    @Override
    public User getUserById(int userId) {
        return OracleManager.getUserById(userId);
    }

    @Override
    public void addUserToCommunity(int communityId, int userId, int userCodeGroup, int isBlocked) {
        OracleManager.addUserToCommunity(communityId, userId, userCodeGroup, isBlocked);
    }
}
