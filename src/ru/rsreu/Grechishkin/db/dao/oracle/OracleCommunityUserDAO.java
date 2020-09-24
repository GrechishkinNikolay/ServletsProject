package ru.rsreu.Grechishkin.db.dao.oracle;

import ru.rsreu.Grechishkin.db.dao.AbstractCommunityUserDAO;

public class OracleCommunityUserDAO extends AbstractCommunityUserDAO {
    public OracleCommunityUserDAO() {
    }

    @Override
    public int findUserGroupByCommunityAndUserId(int communityId, int userId) {
        return OracleManager.findUserGroupByCommunityAndUserId(communityId, userId);
    }
}
