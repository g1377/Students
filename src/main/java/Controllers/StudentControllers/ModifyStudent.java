package Controllers.StudentControllers;

import Database.DBManager;
import Entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyStudent")
public class ModifyStudent extends HttpServlet {
    String idStudent;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        idStudent = req.getParameter("idModifyStudent");

        Student student = DBManager.getStudentById(idStudent);
        req.setAttribute("studentById", student);

        req.setAttribute("current_page", "/WEB-INF/jsp/studentModifying.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastName = req.getParameter("lastName");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");

        DBManager.modifyStudent(idStudent, lastName, name, group, date);

        resp.sendRedirect("/students");
    }
}
