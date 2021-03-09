package com.qinjingcao.finance.common;

import com.qinjingcao.finance.entity.User;
import org.apache.shiro.session.Session;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class LockHelper {

    static Map<Integer, HttpSession> map=new HashMap<Integer, HttpSession>();
    public static void putSession(HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        map.put(user.getId(), session);
    }
    public static void moveSession(HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        map.remove(user.getId());
    }
    public static void destroyedSession(User user){
        HttpSession session = map.get(user.getId());
       session.invalidate();
    }
}

