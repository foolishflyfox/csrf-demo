package com.fhb.csrfdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class CsrfController {
    @GetMapping("/trans")
    public String trans(HttpServletRequest request, String name, Integer money) {
        HttpSession session = request.getSession();
        Object people = session.getAttribute("people");
        if (people == null) return "没有登录";
        System.out.println("给" + name + "转账" + money + "元");
        return "转账成功";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("people", "people");
        return "登录成功";
    }
}
