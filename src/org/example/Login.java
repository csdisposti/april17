package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("usr");
        String password = request.getParameter("pwd");

        String memberLogin;

        Credentials c = new Credentials();
        Member m = new Member();
        try{

            memberLogin = c.readFromDatabase(username, password);
            //send to login error page if username and password do not match or username does not exist
            if (memberLogin.equals("na")){
                request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
            }
             m.readFromDatabase(memberLogin);
            request.getSession().setAttribute("m", m);
            request.getSession().setAttribute("us", memberLogin);
            //send to member info page
            request.getRequestDispatcher("/member.jsp").forward(request, response);

        }catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();
        }
    }
} 