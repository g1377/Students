package Controllers;

import Database.DBManager;
import Entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentsControll", urlPatterns = "/students")
public class StudentsControll extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valueForDelet = request.getParameter("idsDeleteStudent");
        String[] masForDelet = valueForDelet.split(",");
        DBManager.deleteStudent(masForDelet);

        response.sendRedirect("/students");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        List<Student> students = DBManager.getStudedentList();
        req.setAttribute("students", students);

        req.setAttribute("current_page", "/WEB-INF/jsp/studentsList.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}
