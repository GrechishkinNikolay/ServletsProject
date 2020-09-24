package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.db.dao.AbstractCommunityDAO;
import ru.rsreu.Grechishkin.db.dao.AbstractDAOFactory;
import ru.rsreu.Grechishkin.db.dao.AbstractProjectDAO;
import ru.rsreu.Grechishkin.db.dao.DBType;
import ru.rsreu.Grechishkin.db.dto.Community;

import javax.servlet.http.HttpServletRequest;

public class AddProjectCommand extends ActionCommand {

	public AddProjectCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
		final AbstractProjectDAO projectDAO = daoFactory.getProjectDAO();
		projectDAO.addProject(Integer.parseInt(request.getParameter("communityId")), request.getParameter("projectName"), request.getParameter("projectDescription"));
		String url = "/controller?command=community&communityId=" + request.getParameter("communityId");
		return url;
	}
}