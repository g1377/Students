package Controllers;

import Database.DBManager;
import Entity.Term;
import Utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/term")
public class TermsControll extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String termSelect = req.getParameter("termSelect");

        req.getSession().setAttribute("termVal", termSelect);
        req.setAttribute("termList", DBManager.getAllActiveTerms());

        if (termSelect == null) {
            req.setAttribute("selectedTerm", DBManager.getAllActiveTerms().get(0));
        } else {
            req.setAttribute("selectedTerm", Utils.SearchTermById(DBManager.getAllActiveTerms(), termSelect));
        }

        req.setAttribute("current_page", "/WEB-INF/jsp/termsList.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}
