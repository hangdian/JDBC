package com.hg.servletProject.filter;

import com.hg.servletProject.entity.Manager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //权限验证 验证管理员是否登录
        //向下转型 拆箱
//        HttpServletRequest request=(HttpServletRequest)servletRequest;
//        HttpServletResponse response=(HttpServletResponse)servletResponse;
//        HttpSession session=request.getSession();
//        Manager manager=(Manager)session.getAttribute("manager");
//        if (manager!=null){
//            filterChain.doFilter(servletRequest,servletResponse);
//        }else {
//            response.sendRedirect(request.getContextPath()+"/loginMgr.html");
//        }//showall里面就不用写权限验证的代码了


    }

    @Override
    public void destroy() {

    }
}
