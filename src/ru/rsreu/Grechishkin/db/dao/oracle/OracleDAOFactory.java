package ru.rsreu.Grechishkin.db.dao.oracle;

import ru.rsreu.Grechishkin.db.dao.*;

public class OracleDAOFactory extends AbstractDAOFactory {
    public OracleDAOFactory() {
    }

    @Override
    public AbstractCommentDAO getCommentDAO() {
        return new OracleCommentDAO();
    }

    @Override
    public AbstractCommunityDAO getCommunityDAO() {
        return new OracleCommunityDAO();
    }

    @Override
    public AbstractCommunityUserDAO getCommunityUserDAO() {
        return new OracleCommunityUserDAO();
    }

    @Override
    public AbstractProjectDAO getProjectDAO() {
        return new OracleProjectDAO();
    }

    @Override
    public AbstractTaskDAO getTaskDAO() {
        return new OracleTaskDAO();
    }

    @Override
    public AbstractUserDAO getUserDAO() {
        return new OracleUserDAO();
    }

    @Override
    public AbstractUserGroupDAO getUserGroupDAO() {
        return new OracleUserGroupDAO();
    }

    @Override
    public AbstractUserTaskDAO getUserTaskDAO() {
        return new OracleUserTaskDAO();
    }
}
