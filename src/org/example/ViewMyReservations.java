package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ViewMyReservations extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String memberid = request.getParameter("memberid");

        ReservationsList reservationsMy = new ReservationsList();
        ArrayList<ReservationsList> myResList;


        try{

            int mid = Integer.parseInt(memberid);

            myResList = reservationsMy.populateReservations(mid);
            request.getSession().setAttribute("myreservations", myResList);
            request.getSession().setAttribute("memberid", mid);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);


                request.getRequestDispatcher("/viewmyreservations.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}