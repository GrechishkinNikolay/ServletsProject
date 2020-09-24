package ru.rsreu.Grechishkin.db.dao;

public abstract class AbstractDAOFactory {
    public static AbstractDAOFactory getInstance(DBType dbType) {
        return dbType.getDAOFactory();
    }

    public abstract AbstractCommentDAO getCommentDAO();

    public abstract AbstractCommunityDAO getCommunityDAO();

    public abstract AbstractCommunityUserDAO getCommunityUserDAO();

    public abstract AbstractProjectDAO getProjectDAO();

    public abstract AbstractTaskDAO getTaskDAO();

    public abstract AbstractUserDAO getUserDAO();

    public abstract AbstractUserGroupDAO getUserGroupDAO();

    public abstract AbstractUserTaskDAO getUserTaskDAO();
}
