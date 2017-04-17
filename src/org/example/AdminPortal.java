package org.example;

import org.example.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminPortal extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");


        PrintWriter out = response.getWriter();

        String username = request.getParameter("usr");
        String password = request.getParameter("pwd");

        String adminLogin;

        Credentials c = new Credentials();
        Member m = new Member();
        Administrator a = new Administrator();


        try{
            //this gets the email username
            adminLogin = c.readFromDatabase(username, password);
            if (adminLogin.equals("na")){
                request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
            }
            //read from the member table
            a.readFromDatabase(adminLogin);
            request.getSession().setAttribute("a", a);
            //request.getSession().setAttribute("us", adminLogin);

            request.getRequestDispatcher("/adminportal.jsp").forward(request, response);



        }catch (Exception e2)

        {

            e2.printStackTrace();

        }



        finally{out.close();

        }

    }

} 