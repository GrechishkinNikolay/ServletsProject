package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;
import ru.rsreu.Grechishkin.db.dao.*;
import ru.rsreu.Grechishkin.db.dao.oracle.OracleDAOFactory;
import ru.rsreu.Grechishkin.db.dto.Community;
import ru.rsreu.Grechishkin.db.dto.User;

import javax.servlet.http.HttpServletRequest;

public class DeleteCommentCommand extends ActionCommand {

	public DeleteCommentCommand(boolean sendRedirect) {
		super(sendRedirect);
	}

	@Override
	public String execute(HttpServletRequest request) {
		final AbstractDAOFactory abstractDAOFactory = OracleDAOFactory.getInstance(DBType.ORACLE);
		final AbstractCommentDAO commentDAO = abstractDAOFactory.getCommentDAO();
		commentDAO.deleteComment(Integer.parseInt(request.getParameter("commentId")));
		Community community = (Community) request.getSession().getAttribute("community");
		String url = "/controller?command=community&communityId=" + community.getId();
		return url;
	}
}