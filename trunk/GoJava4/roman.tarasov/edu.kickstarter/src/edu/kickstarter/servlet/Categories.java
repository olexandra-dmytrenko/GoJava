package edu.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpSession;
import edu.kickstarter.DAO.Dao;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Category;

/**
 * Servlet implementation class Categories
 */

@WebServlet("/Categories")
public class Categories extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PrintWriter out;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		session.setMaxInactiveInterval(5);
		response.setContentType("text/plain");
		out = response.getWriter();
		response.setContentType("text / html;charset=UTF-8");

		out.println("<title>kickstarter.edu</title>");
		StringBuffer html = new StringBuffer();
		try {
			String s =Dao.getQuoteService().getRandomQuote().getQuote();
			out.println(s);
			List<Category> categories = Dao.getCategoryService().getAll();
			html.append("<nav>");
			html.append("<ul class='top-menu'>");
			for (Category currentCategory : categories) {
				html.append("<li><a href='Projects");
				// html.append(currentCategory.getName());
				html.append("'/>");
				html.append(currentCategory.getName());
				html.append("</a></li>");
			}
			html.append("</ul>");
			html.append("</nav>");
			out.println(html.toString());
		} catch (KickstarterException e) {
			// TODO
		}
		out.close();
	}

	@Override
	public void init() throws ServletException {
		Dao.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}