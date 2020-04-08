package Controllers.TermsControllers;

import Controllers.TermsControll;
import Database.DBManager;
import Entity.Disciplina;
import Entity.Term;
import Utils.Utils;
import jdk.nashorn.internal.ir.IfNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/modifyTerm")
public class ModifyTerm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String duration = req.getParameter("duration");
        String[] terms = req.getParameterValues("selectTermDisc");
        String idTerm = (String) req.getSession().getAttribute("termVal");

        if (idTerm != null) {
            DBManager.deleteTerm(idTerm);
            DBManager.updateDuration(idTerm, duration);
            DBManager.modifyTermByDisc(idTerm, terms, duration);
        } else {
            DBManager.deleteTerm(DBManager.getAllActiveTerms().get(0).getId());
            DBManager.updateDuration(DBManager.getAllActiveTerms().get(0).getId(), duration);
            DBManager.modifyTermByDisc(DBManager.getAllActiveTerms().get(0).getId(), terms, duration);
        }
        resp.sendRedirect("/term");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTerm = (String) req.getSession().getAttribute("termVal");

        if (idTerm != null)
            req.setAttribute("termName", Utils.SearchTermById(DBManager.getAllTerm(), idTerm).getName());
        else req.setAttribute("termName", DBManager.getAllActiveTerms().get(0).getName());

        List<Disciplina> disciplinaList = DBManager.getDisciplineList();
        req.setAttribute("disciplines", disciplinaList);

        req.setAttribute("current_page", "/WEB-INF/jsp/termModifying.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}
