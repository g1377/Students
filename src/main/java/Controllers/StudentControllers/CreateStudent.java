package Controllers.StudentControllers;

import Database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createStudent")
public class CreateStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("current_page", "/WEB-INF/jsp/studentCreating.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String lastName = req.getParameter("lastName");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");
        DBManager.addStudent(lastName, name, group, date);

        resp.sendRedirect("/students");
    }
}
