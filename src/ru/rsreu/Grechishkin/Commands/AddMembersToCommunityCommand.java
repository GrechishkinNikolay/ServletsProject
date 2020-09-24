package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.db.dao.*;
import ru.rsreu.Grechishkin.db.dto.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddMembersToCommunityCommand extends ActionCommand {

    private static final int ADMIN_GROUP_CODE = 1;
    private static final int MODERATOR_GROUP_CODE = 2;
    private static final int USER_GROUP_CODE = 3;
    private static final int USER_BAN_CODE = 4;
    private static final int PARAMETER_USER_IS_BANNED = 1;
    private static final int PARAMETER_USER_IS_NOT_BANNED = 0;

    public AddMembersToCommunityCommand(boolean sendRedirect) {
        super(sendRedirect);
    }

    @Override
    public String execute(HttpServletRequest request) {
        final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
        final AbstractCommunityDAO communityDAO = daoFactory.getCommunityDAO();
        final AbstractUserDAO userDAO = daoFactory.getUserDAO();
        int communityId = Integer.parseInt(request.getParameter("communityId"));
        List<User> allUsers = userDAO.getAllUsers();
        communityDAO.deleteAllCommunityMembers(communityId);
        for (int i = 0; i < allUsers.size(); i++) {
            switch (Integer.parseInt(request.getParameter(String.valueOf(allUsers.get(i).getId())))) {
                case (ADMIN_GROUP_CODE):
                    userDAO.addUserToCommunity(communityId, allUsers.get(i).getId(), ADMIN_GROUP_CODE, PARAMETER_USER_IS_NOT_BANNED);
                    break;
                case (MODERATOR_GROUP_CODE):
                    userDAO.addUserToCommunity(communityId, allUsers.get(i).getId(), MODERATOR_GROUP_CODE, PARAMETER_USER_IS_NOT_BANNED);
                    break;
                case (USER_GROUP_CODE):
                    userDAO.addUserToCommunity(communityId, allUsers.get(i).getId(), USER_GROUP_CODE, PARAMETER_USER_IS_NOT_BANNED);
                    break;
                case (USER_BAN_CODE):
                    userDAO.addUserToCommunity(communityId, allUsers.get(i).getId(), USER_GROUP_CODE, PARAMETER_USER_IS_BANNED);
                    break;
            }
        }
        String url = "/controller?command=community&communityId=" + communityId;
        return url;
    }
}