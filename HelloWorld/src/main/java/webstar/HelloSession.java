package webstar;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/helloSession"})
public class HelloSession extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);

        String name = (session != null) ? (String) session.getAttribute("username") : null;

        if (name == null) {
            // nếu chưa login thì quay về login
            resp.sendRedirect(req.getContextPath() + "/indexLoginSession.html");
        } else {
            // hiển thị chào
            out.println("<h2>Xin chào " + name + "</h2>");
        }
    }
}
