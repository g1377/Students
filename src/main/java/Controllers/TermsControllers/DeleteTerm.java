package Controllers.TermsControllers;

import Database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTerm")
public class DeleteTerm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTerm = (String) req.getSession().getAttribute("termVal");
        if (idTerm != null) DBManager.deleteTermbyId(idTerm);
        else DBManager.deleteTermbyId(DBManager.getAllActiveTerms().get(0).getId());

        resp.sendRedirect("/term");
    }
}
