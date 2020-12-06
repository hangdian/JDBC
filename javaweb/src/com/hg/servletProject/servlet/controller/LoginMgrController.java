package com.hg.servletProject.servlet.controller;

import com.hg.servletProject.entity.Manager;
import com.hg.servletProject.service.ManagerService;
import com.hg.servletProject.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(value="/loginMgr")
public class LoginMgrController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //1,处理乱码
             req.setCharacterEncoding("utf-8");
             resp.setContentType("text/html;charset=utf-8");
            //2，收参
            String username=req.getParameter("username");
            String password=req.getParameter("password");
            String inputVcode=req.getParameter("inputVcode");
            String codes=(String) req.getSession().getAttribute("codes");
            if (inputVcode.isEmpty()&&inputVcode.equalsIgnoreCase(codes)){
                //3，调用业务方法
                ManagerService managerService=new ManagerServiceImpl();
                Manager manager=managerService.login(username,password);
                //4，处理结果，流程跳转
                if (manager!=null){
                    //success

                    //将管理员信息存储到session中
                    HttpSession session=req.getSession();
                    session.setAttribute("manager",manager);//登陆成功的manager
                    //跳转，目标，方式
                    resp.sendRedirect("/javaweb_war_exploded/showallcontroller");

                }else {
                    resp.sendRedirect("/javaweb_war_exploded/loginMgr.html");
                }
            }else {
                resp.sendRedirect("/javaweb_war_exploded/loginMgr.html");
            }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
