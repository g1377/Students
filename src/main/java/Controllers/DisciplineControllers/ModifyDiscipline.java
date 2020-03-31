package Controllers.DisciplineControllers;

import Database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyDiscipline", urlPatterns = "/modifyDiscipline")
public class ModifyDiscipline extends HttpServlet {
    String idDisc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        idDisc = req.getParameter("idModifyDisc");
        req.setAttribute("discAtr", DBManager.getDiscById(idDisc));

        req.setAttribute("current_page", "/WEB-INF/jsp/disciplineModifying.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String discModify = req.getParameter("discModify");
        DBManager.modifyDiscipline(idDisc, discModify);
        resp.sendRedirect("/disciplines");

    }
}
