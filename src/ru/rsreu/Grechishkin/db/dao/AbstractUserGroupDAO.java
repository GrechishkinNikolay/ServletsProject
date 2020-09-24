package ru.rsreu.Grechishkin.db.dao;

import ru.rsreu.Grechishkin.db.dto.UserGroup;

import java.util.List;

public abstract class AbstractUserGroupDAO {
    public abstract List<UserGroup> getAllUserGroup();
}
