package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.Resourcer;
import ru.rsreu.Grechishkin.db.dao.*;
import ru.rsreu.Grechishkin.db.dto.Community;
import ru.rsreu.Grechishkin.db.dto.Task;
import ru.rsreu.Grechishkin.db.dto.User;

import javax.servlet.http.HttpServletRequest;

public class GetToWorkCommand extends ActionCommand {

	public GetToWorkCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
		final AbstractTaskDAO taskDAO = daoFactory.getTaskDAO();
		User user = (User) request.getSession().getAttribute("user");
		Task task = taskDAO.getTasksById(Integer.parseInt(request.getParameter("taskId")));
		if (!taskDAO.getTasksByUserId((Integer) request.getSession().getAttribute("userID")).contains(task)) {
			taskDAO.addTaskToUser(Integer.parseInt(request.getParameter("taskId")),(Integer) request.getSession().getAttribute("userID"));
			Community community = (Community) request.getSession().getAttribute("community");
			String url = "/controller?command=community&communityId=" + community.getId();
			return url;
		} else {
			return Resourcer.getProperty("path.page.community");
		}
	}
}