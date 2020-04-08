package Controllers;

import Database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("current_page", "/WEB-INF/jsp/login.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("log");
        String pas = req.getParameter("pass");
        String role = req.getParameter("role");

        boolean access = DBManager.getAccByNameRole(login, pas, role);

        if (access) {
            req.getSession().setAttribute("isLogin", "1");
            req.getSession().setAttribute("role", role);
            req.getSession().setAttribute("username", login);
            System.out.println(role);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("errorMessage", "1");
            req.setAttribute("current_page", "/WEB-INF/jsp/login.jsp");
            req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
        }

    }
}
