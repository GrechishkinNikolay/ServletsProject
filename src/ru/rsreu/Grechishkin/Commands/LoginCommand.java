package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.OnlineUsersManager;
import ru.rsreu.Grechishkin.Resourcer;
import ru.rsreu.Grechishkin.LoginLogic;
import ru.rsreu.Grechishkin.db.dao.AbstractDAOFactory;
import ru.rsreu.Grechishkin.db.dao.AbstractUserDAO;
import ru.rsreu.Grechishkin.db.dao.DBType;
import ru.rsreu.Grechishkin.db.dto.User;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand extends ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	public LoginCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
		final AbstractUserDAO userDAO = daoFactory.getUserDAO();
		int UserID = LoginLogic.checkLogin(login, pass, request);
		if (UserID != 0) {
			request.getSession().setAttribute("userID", UserID);
			User user =  userDAO.getUserById(UserID);
			request.getSession().setAttribute("user", user);
			page = Resourcer.getProperty("path.page.main");
			OnlineUsersManager.markUserAsLoggedIn(user);
		} else {
			request.setAttribute("errorLoginPassMessage",
					Resourcer.getProperty("message.loginerror"));
			page = Resourcer.getProperty("path.page.login");
		}
		return page;
	}
}