package Controllers.StudentControllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/progresStudent")
public class ProgresStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("current_page","/WEB-INF/jsp/studentProgress.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req,resp);
    }
}
