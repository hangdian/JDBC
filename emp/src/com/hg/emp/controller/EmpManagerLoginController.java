package com.hg.emp.controller;

import com.hg.emp.entity.EmpManager;
import com.hg.emp.service.EmpManagerService;
import com.hg.emp.service.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(value="/manger/EmpManagerLoginController")
public class EmpManagerLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String inputVcode=req.getParameter("inputVcode");
        //检验验证码
        String codes=(String)req.getSession().getAttribute("codes");
        if(!inputVcode.isEmpty()&&inputVcode.equalsIgnoreCase(codes)) {
            //调用业务逻辑实现登陆
            EmpManagerService empManagerService = new EmpManagerServiceImpl();
            EmpManager empManager = empManagerService.login(username, password);
            if (empManager != null) {
                //登陆成功
                //存储在session作用域中
                HttpSession session = req.getSession();
                session.setAttribute("empManager", empManager);
                //跳转到查询所有的controller
                resp.sendRedirect(req.getContextPath() + "/manager/showAllEmpController");
            } else {
                resp.sendRedirect(req.getContextPath() + "/login.html");
             }

        }else {
            //验证码失败，跳转登陆页面
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
