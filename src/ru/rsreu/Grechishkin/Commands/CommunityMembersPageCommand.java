package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.Resourcer;
import ru.rsreu.Grechishkin.db.dao.*;
import ru.rsreu.Grechishkin.db.dto.User;
import ru.rsreu.Grechishkin.db.dto.UserGroup;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CommunityMembersPageCommand extends ActionCommand {

	private static final int ID_NEW_USER_GROUP = 0;
	private static final String NAME_NEW_USER_GROUP = "Не состоит";
	private static final int ID_USER_BAN = 4;
	private static final String NAME_USER_BAN = "Бан";

	public CommunityMembersPageCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		int communityId = Integer.parseInt(request.getParameter("communityId"));
		request.setAttribute("communityId", communityId);
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
		final AbstractUserDAO userDAO = daoFactory.getUserDAO();
		final AbstractUserGroupDAO userGroupDAO = daoFactory.getUserGroupDAO();

		List<UserGroup> userGroups = new ArrayList<UserGroup>();
		userGroups.add(new UserGroup(ID_NEW_USER_GROUP, NAME_NEW_USER_GROUP));
		userGroups.addAll(userGroupDAO.getAllUserGroup());
		userGroups.add(new UserGroup(ID_USER_BAN, NAME_USER_BAN));
		List<User> communityUsers = userDAO.getUsersByCommunityId(communityId);
		List<User> allUsers = userDAO.getAllUsers();

		request.setAttribute("userGroups", userGroups);
		request.setAttribute("communityUsers", communityUsers);
		request.setAttribute("allUsers", allUsers);

		return Resourcer.getProperty("path.page.communityMembers");
	}
}