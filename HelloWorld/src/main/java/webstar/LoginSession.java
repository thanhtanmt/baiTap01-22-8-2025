package webstar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/loginSession" })
public class LoginSession extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		String user = req.getParameter("username");
		String pass = req.getParameter("password");

		if ("tan".equals(user) && "123".equals(pass)) {
			HttpSession session = req.getSession();
			session.setAttribute("username", user);

			resp.sendRedirect(req.getContextPath() + "/helloSession");
		} else {
			resp.sendRedirect(req.getContextPath() + "/indexLoginSession.html");
		}
	}
}
