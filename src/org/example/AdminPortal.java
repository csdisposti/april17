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

        String username = request.getParameter("usra");
        String password = request.getParameter("pwda");

        String memInfo;
        int adminLogin;
        String memInfoAll;

        Credentials c = new Credentials();
        Member m = new Member();
        Member m2 = new Member();
        Administrator a = new Administrator();


        try{
            //this gets the email username
            memInfo = c.readFromDatabase(username, password);
            if (memInfo.equals("na")){
                request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
            }
            //read from the member table
            adminLogin = m.readJustMemNo(memInfo);
            request.getSession().setAttribute("m", m);
            m2.readFromDatabase(memInfo);
            request.getSession().setAttribute("m2", m2);
            request.getSession().setAttribute("us", memInfo);
            a.readFromDatabase(adminLogin);
            request.getSession().setAttribute("a", a);


            request.getRequestDispatcher("/adminportal.jsp").forward(request, response);



        }catch (Exception e2)

        {

            e2.printStackTrace();

        }



        finally{out.close();

        }

    }

} 