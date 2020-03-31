package Utils;

import javax.servlet.Filter;
import javax.servlet.http.Cookie;

public class DecodeFilterUtils {



    public static boolean isCookieContain(Cookie[] cookies, String name) {
        if (cookies == null) return false;
        for (Cookie iter : cookies) {
            if (iter.getName().equals(name)) return true;
        }
        return false;
    }


    public static Cookie getCookieByName(Cookie[] cookies, String name) {
        for (Cookie iter : cookies) {
            if (iter.getName().equals(name)) return iter;
        }
        return null;
    }




}
