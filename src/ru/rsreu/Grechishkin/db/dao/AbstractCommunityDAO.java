package ru.rsreu.Grechishkin.db.dao;

import ru.rsreu.Grechishkin.db.dto.Community;
import java.util.List;

public abstract class AbstractCommunityDAO {
    public abstract List<Community> getCommunitiesByUserId(int userId);
    public abstract Community getCommunityById(int communityId);
    public abstract void AddCommunity(int userId, String communityName);
    public abstract void deleteAllCommunityMembers(int communityId);
}
