package com.qinjingcao.finance.controller;

import com.qinjingcao.finance.common.LockHelper;
import com.qinjingcao.finance.common.Msg;
import com.qinjingcao.finance.entity.Admin;
import com.qinjingcao.finance.entity.User;
import com.qinjingcao.finance.service.AdminService;
import com.qinjingcao.finance.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    //public static final Map<String, HttpSession> USR_SESSION = new HashMap<>();
    public static String last_login = "";

    @GetMapping("/loginVerifyUsername/{username}")
    @ResponseBody
    public Msg loginVerifyUsername(@PathVariable("username") String username) {
        User user = userService.selectUserByTerms(username, null);
        if (user != null) {
            return Msg.success();
        }
        Admin admin = adminService.selectAdminByTerms(username, null);
        if (admin != null) {
            return Msg.success();
        }
        return Msg.fail();
    }

    @GetMapping("/verifyLogin")
    @ResponseBody
    public Msg verifyLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                           HttpSession session) {
//        User user = userService.selectUserByTerms(username, password);
//        if (user != null) {
//            String loginUsername = user.getUsername();
//            if (USR_SESSION.containsKey(loginUsername)) {
//                USR_SESSION.get(loginUsername).removeAttribute("loginUser");
//            }
//            USR_SESSION.put(loginUsername, session);
//            user.setStatus(1);
//            userService.updateUser(user);
//            session.setAttribute("loginUser", user);
//            return Msg.success().add("url","/user/index.html");
//        }
//
//        Admin admin = adminService.selectAdminByTerms(username, password);
//        if (admin != null) {
//            String loginAdminUsername = admin.getUsername();
//            if (USR_SESSION.containsKey(loginAdminUsername)) {
//                USR_SESSION.get(loginAdminUsername).removeAttribute("loginAdmin");
//            }
//            USR_SESSION.put(loginAdminUsername, session);
//            admin.setStatus(1);
//            adminService.updateAdmin(admin);
//            session.setAttribute("loginAdmin", admin);
//            return Msg.success().add("url","/admin/index.html");
//        }
        User loginUser = userService.selectUserByTerms(username, password);
        if (loginUser != null) {
            //获取当前用户
            Subject subject = SecurityUtils.getSubject();
            //封装用户登录数据
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
                //测试
                LockHelper.putSession(session);
                return Msg.success().add("url", "/user/index.html");
            } catch (UnknownAccountException | IncorrectCredentialsException e) {
                //model.addAttribute("msg","密码错误");
                return Msg.fail();
            }
        }

        Admin admin = adminService.selectAdminByTerms(username, password);
        if (admin != null) {
            //获取当前用户
            Subject subject = SecurityUtils.getSubject();
            //封装用户登录数据
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
                return Msg.success().add("url", "/admin/index.html");
            } catch (UnknownAccountException | IncorrectCredentialsException e) {
                //model.addAttribute("msg","密码错误");
                return Msg.fail();
            }
        }
        return Msg.fail();
    }

    @PostMapping("/register")
    @ResponseBody
    public Msg register(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setStatus(0);
        user.setReputation("良好");
        userService.insertUser(user);
        return Msg.success().add("url", "login");
    }


}
