package Controllers;

import Database.DBManager;
import Entity.Disciplina;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DisciplinesListController", urlPatterns = "/disciplines")
public class DisciplinesListControllers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Disciplina> disciplinaList = DBManager.getDisciplineList();
        req.setAttribute("disciplines", disciplinaList);

        req.setAttribute("current_page", "/WEB-INF/jsp/disciplinesList.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("idsDelete");
        String[] idsMas = ids.split(",");

        DBManager.deleteDiscipline(idsMas);

        resp.sendRedirect("/disciplines");

    }
}
