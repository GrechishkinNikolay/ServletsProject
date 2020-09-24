package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.Resourcer;
import ru.rsreu.Grechishkin.db.*;
import ru.rsreu.Grechishkin.db.dao.*;
import ru.rsreu.Grechishkin.db.dto.Community;
import ru.rsreu.Grechishkin.db.dto.Project;
import ru.rsreu.Grechishkin.db.dto.Task;
import ru.rsreu.Grechishkin.db.dto.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommunityCommand extends ActionCommand {

	private static final int ADMIN_CODE_GROUP = 1;
	private static final int MODERATOR_CODE_GROUP = 2;
	private static final int USER_CODE_GROUP = 3;
	private static final String ADMIN_GROUP_NAME = "admin";
	private static final String MODERATOR_GROUP_NAME = "moderator";
	private static final String USER_GROUP_NAME = "user";

	public CommunityCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
		final AbstractCommunityDAO communityDAO = daoFactory.getCommunityDAO();
		final AbstractUserDAO userDAO = daoFactory.getUserDAO();
		final AbstractCommunityUserDAO communityUserDAO = daoFactory.getCommunityUserDAO();
		Community community = communityDAO.getCommunityById(Integer.parseInt(request.getParameter("communityId")));
		request.getSession().setAttribute("community", community);
		Map<Integer, List<User>> performersByTasksId = new HashMap<Integer, List<User>>();

		for (Project project : community.getProjects()) {
			for (Task task : project.getTasks()) {
				performersByTasksId.put(task.getId(), userDAO.getUsersByTaskId(task.getId()));
			}
		}
		request.getSession().setAttribute("performersByTasksId", performersByTasksId);

		int codeGroup = communityUserDAO.findUserGroupByCommunityAndUserId(Integer.parseInt(request.getParameter("communityId")),
				(Integer) request.getSession().getAttribute("userID"));
		String userGroupName = null;
		switch (codeGroup){
			case (ADMIN_CODE_GROUP):
				userGroupName = ADMIN_GROUP_NAME;
				break;
			case (MODERATOR_CODE_GROUP):
				userGroupName = MODERATOR_GROUP_NAME;
				break;
			case (USER_CODE_GROUP):
				userGroupName = USER_GROUP_NAME;
				break;
		}
		request.getSession().setAttribute("userGroupName", userGroupName);
		return Resourcer.getProperty("path.page.community");
	}
}