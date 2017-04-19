package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminManagementAircraft extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");


        PrintWriter out = response.getWriter();


        String username = request.getParameter("usr");


        try{
            //Member m = new Member();
           // m.readFromDatabase(username);

            //request.getSession().setAttribute("m", m);
           // request.getSession().setAttribute("usr", username);


               request.getRequestDispatcher("/aircraftmanagement.jsp").forward(request, response);


        }catch (Exception e2)

        {
            e2.printStackTrace();
        }
        finally{out.close();
        }
    }
} 