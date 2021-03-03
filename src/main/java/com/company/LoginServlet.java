package com.company;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "LoginPage", urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
    private static final long serialVersion = 1L;

    private LoginPage login;

    public void init(){
        login = new LoginPage();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Server at: ").append(request.getContextPath());
        RequestDispatcher dispatcher = request.getRequestDispatcher("webapp/login.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userName = request.getParameter("UserName");
        String userPassword = request.getParameter("UserPassword");

        UserInfo user = new UserInfo();
        user.setUserName(userName);
        user.setUserPassword(userPassword);

        try{
            login.userLogin(user);
        } catch(Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("webapp/index.jsp");
        dispatcher.forward(request,response);
    }
}
