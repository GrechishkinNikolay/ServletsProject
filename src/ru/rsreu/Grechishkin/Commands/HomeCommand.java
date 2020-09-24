package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.Resourcer;
import ru.rsreu.Grechishkin.db.dao.AbstractCommunityDAO;
import ru.rsreu.Grechishkin.db.dao.AbstractDAOFactory;
import ru.rsreu.Grechishkin.db.dao.AbstractUserDAO;
import ru.rsreu.Grechishkin.db.dao.DBType;
import ru.rsreu.Grechishkin.db.dto.Community;
import ru.rsreu.Grechishkin.db.dto.User;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand extends ActionCommand {

	public HomeCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
		final AbstractUserDAO userDAO = daoFactory.getUserDAO();
		User user = userDAO.getUserById((Integer) request.getSession().getAttribute("userID"));
		request.getSession().setAttribute("user", user);
		return Resourcer.getProperty("path.page.main");
	}
}