package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AdminManagementReservations extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        ReservationsList reservationsAll = new ReservationsList();
        ArrayList<ReservationsList> resListAll;

        try{

            resListAll = reservationsAll.populateReservations();
            request.getSession().setAttribute("allreservations", resListAll);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);


            request.getRequestDispatcher("/adminreservationsmanagement.jsp").forward(request, response);
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}