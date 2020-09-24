package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.Resourcer;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand extends ActionCommand {

	public LogoutCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = Resourcer.getProperty("path.page.index");
		request.getSession().invalidate();
		return page;
	}
}