package ru.rsreu.Grechishkin;

import ru.rsreu.Grechishkin.Commands.CommandEnum;
import ru.rsreu.Grechishkin.Commands.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand(false);
// извлечение имени команды из запроса
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
// если команда не задана в текущем запросе
			return current;
		}
// получение объекта, соответствующего команде
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action
					+ Resourcer.getProperty("message.wrongaction"));
		}
		return current;
	}
}