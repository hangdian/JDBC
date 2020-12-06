package com.hg.servletProject.servlet.controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(value="/createCode")
public class CreateCodeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1,创建验证码图片
        ValidateCode validateCode=new ValidateCode(200,30,2,20);
        String codes=validateCode.getCode();
        HttpSession session=req.getSession();
        session.setAttribute("codes",codes);
        //2，验证码图片相应给客户端
        validateCode.write(resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
