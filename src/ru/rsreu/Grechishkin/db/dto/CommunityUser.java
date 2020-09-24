package ru.rsreu.Grechishkin.db.dto;

public class CommunityUser {

    private int CommunityId;
    private int UserId;
    private UserGroup userGroup;
    private boolean isBlocked;

    public CommunityUser(int communityId, int userId, UserGroup userGroup, boolean isBlocked) {
        CommunityId = communityId;
        UserId = userId;
        this.userGroup = userGroup;
        this.isBlocked = isBlocked;
    }

    public int getCommunityId() {
        return CommunityId;
    }

    public void setCommunityId(int communityId) {
        CommunityId = communityId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
