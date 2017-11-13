package com.example.demo.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hutingcong on 2017/10/31.
 */
public class CookieUtil {
    /**
     * 设置cookie
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(7200);
        response.addCookie(cookie);
    }

    public static Cookie get(HttpServletRequest request, String name) {
        Map<String, Cookie> map = readCookies(request);
        if(map.containsKey(name)){
            return map.get(name);
        }else {
            return null;
        }
    }

    private static Map<String, Cookie> readCookies(HttpServletRequest request) {
        Map<String, Cookie> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                map.put(cookie.getName(), cookie);
            }
        }
        return map;
    }

}
