package ru.rsreu.Grechishkin.db.dao.oracle;

import ru.rsreu.Grechishkin.db.dao.AbstractCommunityDAO;
import ru.rsreu.Grechishkin.db.dto.Community;

import java.util.List;

public class OracleCommunityDAO extends AbstractCommunityDAO {
    public OracleCommunityDAO() {
    }

    @Override
    public List<Community> getCommunitiesByUserId(int userId) {
        return OracleManager.getCommunitiesByUserId(userId);
    }

    @Override
    public Community getCommunityById(int communityId) {
        return OracleManager.getCommunityById(communityId);
    }

    @Override
    public void AddCommunity(int userId, String communityName) {
        OracleManager.AddCommunity(userId, communityName);
    }

    @Override
    public void deleteAllCommunityMembers(int communityId) {
        OracleManager.deleteAllCommunityMembers(communityId);
    }
}
