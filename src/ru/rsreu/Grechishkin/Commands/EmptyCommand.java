package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.Resourcer;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand extends ActionCommand {

	public EmptyCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = Resourcer.getProperty("path.page.login");
		return page;
	}
}