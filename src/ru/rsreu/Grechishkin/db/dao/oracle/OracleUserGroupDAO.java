package ru.rsreu.Grechishkin.db.dao.oracle;

import ru.rsreu.Grechishkin.db.dao.AbstractUserGroupDAO;
import ru.rsreu.Grechishkin.db.dto.UserGroup;

import java.util.List;

public class OracleUserGroupDAO extends AbstractUserGroupDAO {
    public OracleUserGroupDAO() {
    }

    @Override
    public List<UserGroup> getAllUserGroup() {
        return OracleManager.getAllUserGroup();
    }
}
