package com.hg.emp.controller;

import com.hg.emp.entity.Emp;
import com.hg.emp.service.EmpService;
import com.hg.emp.service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateEmpController",value="/manager/safe/updateEmpController")
public class UpdateEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        Double salary=Double.valueOf(request.getParameter("salary"));
        Integer age=Integer.valueOf(request.getParameter("age"));
        Emp emp=new Emp(id,name,salary,age);
        EmpService empService=new EmpServiceImpl();
        empService.modify(emp);
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmpController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
