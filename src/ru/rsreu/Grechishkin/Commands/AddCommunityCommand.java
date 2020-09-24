package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.LoginLogic;
import ru.rsreu.Grechishkin.Resourcer;
import ru.rsreu.Grechishkin.db.dao.AbstractCommunityDAO;
import ru.rsreu.Grechishkin.db.dao.AbstractDAOFactory;
import ru.rsreu.Grechishkin.db.dao.AbstractUserDAO;
import ru.rsreu.Grechishkin.db.dao.DBType;
import ru.rsreu.Grechishkin.db.dto.Community;

import javax.servlet.http.HttpServletRequest;

public class AddCommunityCommand extends ActionCommand {

	public AddCommunityCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
		final AbstractCommunityDAO communityDAO = daoFactory.getCommunityDAO();
		communityDAO.AddCommunity((Integer)request.getSession().getAttribute("userID"), request.getParameter("CommunityName"));
		return "/controller?command=communities";
	}
}