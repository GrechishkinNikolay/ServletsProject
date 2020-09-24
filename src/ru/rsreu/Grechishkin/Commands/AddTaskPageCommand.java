package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.Resourcer;

import javax.servlet.http.HttpServletRequest;

public class AddTaskPageCommand extends ActionCommand {

	public AddTaskPageCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		request.setAttribute("projectId", Integer.parseInt(request.getParameter("projectId")));
		request.setAttribute("communityId", Integer.parseInt(request.getParameter("communityId")));
		return Resourcer.getProperty("path.page.addTask");
	}
}