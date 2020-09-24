package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.db.dao.AbstractDAOFactory;
import ru.rsreu.Grechishkin.db.dao.AbstractTaskDAO;
import ru.rsreu.Grechishkin.db.dao.DBType;
import javax.servlet.http.HttpServletRequest;

public class AddTaskCommand extends ActionCommand {

	public AddTaskCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
		final AbstractTaskDAO taskDAO = daoFactory.getTaskDAO();
		taskDAO.addTask(Integer.parseInt(request.getParameter("projectId")), Integer.parseInt(request.getParameter("performersNumber")), request.getParameter("taskText"));
		String url = "/controller?command=community&communityId=" + request.getParameter("communityId");
		return url;
	}
}