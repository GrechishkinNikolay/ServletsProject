package ru.rsreu.Grechishkin;

import ru.rsreu.Grechishkin.db.dao.AbstractDAOFactory;
import ru.rsreu.Grechishkin.db.dao.AbstractUserDAO;
import ru.rsreu.Grechishkin.db.dao.DBType;
import ru.rsreu.Grechishkin.db.dto.User;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoginLogic {
	public static int checkLogin(String enterLogin, String enterPass, HttpServletRequest request) {
		final AbstractDAOFactory daoFactory = AbstractDAOFactory.getInstance(DBType.ORACLE);
		final AbstractUserDAO userDAO = daoFactory.getUserDAO();
		List<User> users = userDAO.getAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(enterLogin) && users.get(i).getPassword().equals(enterPass)) {
				return users.get(i).getId();
			}
		}
		return 0;
	}
}
