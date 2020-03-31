package Filters;

import Utils.DecodeFilterUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DecodeFilter implements Filter {
    String cookie1 ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");



        Cookie[] cookies = req.getCookies();

//        Cookie cookie = new Cookie("getCount", "1");

        if (DecodeFilterUtils.isCookieContain(cookies, "getCount")) {
            int count = Integer.parseInt(DecodeFilterUtils.getCookieByName(cookies, "getCount").getValue());
            count++;
            Cookie cookie = new Cookie("getCount", "" + count);
            res.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("getCount", "1");
            res.addCookie(cookie);
        }


        filterChain.doFilter(req, res);

    }

    @Override
    public void destroy() {

    }
}
