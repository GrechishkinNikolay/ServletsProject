package ru.rsreu.Grechishkin;

import javax.servlet.http.HttpServletRequest;

public abstract class ActionCommand {

	private boolean sendRedirect;

	public ActionCommand(boolean sendRedirect) {
		this.sendRedirect = sendRedirect;
	}

	public abstract String execute(HttpServletRequest request);

	public boolean getSendRedirect() {
		return sendRedirect;
	}
}