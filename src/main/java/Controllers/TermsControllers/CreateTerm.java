package Controllers.TermsControllers;

import Database.DBManager;
import Entity.Disciplina;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/termCreate")
public class CreateTerm extends HttpServlet {

    int termd = 1;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Disciplina> disciplinaList = DBManager.getDisciplineList();
        req.setAttribute("disciplines", disciplinaList);



        req.setAttribute("current_page", "/WEB-INF/jsp/termCreating.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String termName = req.getParameter("termName");
        String duration = req.getParameter("duration");



        resp.sendRedirect("/term");
    }
}
