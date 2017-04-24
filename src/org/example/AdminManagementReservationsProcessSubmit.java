package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminManagementReservationsProcessSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");//admininfo
        String password = request.getParameter("password");//admininfo

        try{
            request.getSession().setAttribute("username" , username);
            request.getSession().setAttribute("password" , password);
            request.getRequestDispatcher("/reservationmanagement.jsp").forward(request, response);

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}