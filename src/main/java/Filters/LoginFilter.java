package Filters;

import Utils.DecodeFilterUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.LogRecord;

public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");

        if (!req.getRequestURI().endsWith(".css") || req.getRequestURI().endsWith(".js")) {
            if (req.getRequestURI().endsWith("/login")) {
                if (req.getSession().getAttribute("isLogin") != null && !req.getSession().getAttribute("isLogin").equals("0")) {
                    res.sendRedirect("/");
                    return;
                }
            }
            if (req.getSession().getAttribute("isLogin") == null) {
                req.getSession().setAttribute("isLogin", "0");
                res.sendRedirect("/login");
                return;
            } else if (req.getSession().getAttribute("isLogin").equals("0")) {
                if (req.getRequestURI().endsWith("login")) {
                    filterChain.doFilter(req, res);
                    return;
                } else {
                    res.sendRedirect("/login");
                    return;
                }
            }
        }

        filterChain.doFilter(req, res);
    }


    @Override
    public void destroy() {

    }
}
