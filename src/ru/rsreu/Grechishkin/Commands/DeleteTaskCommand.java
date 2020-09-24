package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.Resourcer;
import ru.rsreu.Grechishkin.db.dao.AbstractDAOFactory;
import ru.rsreu.Grechishkin.db.dao.AbstractTaskDAO;
import ru.rsreu.Grechishkin.db.dao.AbstractUserDAO;
import ru.rsreu.Grechishkin.db.dao.DBType;
import ru.rsreu.Grechishkin.db.dao.oracle.OracleDAOFactory;
import ru.rsreu.Grechishkin.db.dao.oracle.OracleManager;
import ru.rsreu.Grechishkin.db.dao.oracle.OracleTaskDAO;
import ru.rsreu.Grechishkin.db.dto.User;
import ru.rsreu.Grechishkin.db.db2;

import javax.servlet.http.HttpServletRequest;

public class DeleteTaskCommand extends ActionCommand {

	public DeleteTaskCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		final AbstractDAOFactory abstractDAOFactory = OracleDAOFactory.getInstance(DBType.ORACLE);
		final AbstractTaskDAO taskDAO = abstractDAOFactory.getTaskDAO();
		final AbstractUserDAO userDAO = abstractDAOFactory.getUserDAO();
		User user = userDAO.getUserById((Integer) request.getSession().getAttribute("userID"));
		taskDAO.deleteUsersTask(Integer.parseInt(request.getParameter("taskId")), user.getId());
		return "/controller?command=home";
	}
}