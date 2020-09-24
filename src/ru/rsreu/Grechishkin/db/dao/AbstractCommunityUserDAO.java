package ru.rsreu.Grechishkin.db.dao;

public abstract class AbstractCommunityUserDAO {
    public abstract int findUserGroupByCommunityAndUserId(int communityId, int userId);
}
