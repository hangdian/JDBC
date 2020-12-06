package com.hg.servletProject.servlet.controller;

import com.hg.servletProject.entity.Admin;
import com.hg.servletProject.entity.Manager;
import com.hg.servletProject.service.AdminService;
import com.hg.servletProject.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 将业务的逻辑和显示分开
 * 逻辑用XXXController 命名
 * 显示用XXXJSP命名
 */
@WebServlet(value="/showallcontroller")
public class ShowAllAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //权限的验证，通过httpsession
        HttpSession session=req.getSession();
        Manager Mgr=(Manager)session.getAttribute("manager");
        if (Mgr!=null) {


            //只负责调用业务逻辑功能
            AdminService adminService = new AdminServiceImpl();
            List<Admin> adminList = adminService.showAllAdmin();
            //request作用域存储数据
            req.setAttribute("admins", adminList);
            //通过转发，跳转到显示结果servlet
            req.getRequestDispatcher("/showalljsp").forward(req, resp);
        }else{
            resp.sendRedirect("/javaweb_war_exploded/loginMgr.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
