package ru.rsreu.Grechishkin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request,
	                            HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;
// определение команды, пришедшей из JSP
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);

		page = command.execute(request);

		if (page != null) {
			if (!command.getSendRedirect()) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + page);
			}
		} else {
			page = Resourcer.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage",
					Resourcer.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}