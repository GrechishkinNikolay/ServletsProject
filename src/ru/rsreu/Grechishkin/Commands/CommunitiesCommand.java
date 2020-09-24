package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.Resourcer;
import ru.rsreu.Grechishkin.db.dao.AbstractCommunityDAO;
import ru.rsreu.Grechishkin.db.dao.AbstractDAOFactory;
import ru.rsreu.Grechishkin.db.dao.AbstractUserDAO;
import ru.rsreu.Grechishkin.db.dao.DBType;
import ru.rsreu.Grechishkin.db.dto.User;

import javax.servlet.http.HttpServletRequest;

public class CommunitiesCommand extends ActionCommand {

	public CommunitiesCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
		final AbstractCommunityDAO communityDAODAO = daoFactory.getCommunityDAO();
		request.getSession().setAttribute("communities", communityDAODAO.getCommunitiesByUserId((Integer)request.getSession().getAttribute("userID")));
		return Resourcer.getProperty("path.page.communities");
	}
}