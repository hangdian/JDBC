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
import java.util.List;

@WebServlet(name = "showAllEmpController",value = "/manager/safe/showAllEmpController")
public class showAllEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("success");
        EmpService empService=new EmpServiceImpl();
        List<Emp> emps=empService.showAllEmp();
        request.setAttribute("emps",emps);
        request.getRequestDispatcher("/manager/safe/showAllEmpJSP").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
