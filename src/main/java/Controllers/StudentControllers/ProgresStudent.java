package Controllers.StudentControllers;

import Database.DBManager;
import Utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/progresStudent")
public class ProgresStudent extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("idStudentForProgres") != null) {
            String idStudent = req.getParameter("idStudentForProgres");
            req.getSession().setAttribute("idStudent", idStudent);
            req.getSession().setAttribute("studentForProgres", DBManager.getStudentById(idStudent));
            HashMap<String, String> hm = DBManager.progresStudentByTerm(idStudent, DBManager.getAllActiveTerms().get(0).getId());
            req.getSession().setAttribute("discMark", hm);
            req.getSession().setAttribute("valueMark", Utils.averageMark(hm));
        }


        req.getSession().setAttribute("allTerms", DBManager.getAllActiveTerms());

        req.setAttribute("current_page", "/WEB-INF/jsp/studentProgress.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idstudent = (String) req.getSession().getAttribute("idStudent");
        req.getSession().setAttribute("discMark", DBManager.progresStudentByTerm(idstudent, req.getParameter("selectTerm")));

        req.getSession().setAttribute("selectTermId", req.getParameter("selectTerm"));
        HashMap<String, String> hm = (HashMap<String, String>) req.getSession().getAttribute("discMark");

        req.getSession().setAttribute("valueMark", Utils.averageMark(hm));

        resp.sendRedirect("/progresStudent");
    }
}
