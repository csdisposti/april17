package org.example;

import javax.naming.spi.ResolveResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AdminManagementReservationsSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String resid = request.getParameter("ri");
        String resType = request.getParameter("resType");
        String resourcesRes = request.getParameter("resourcesRes");
        String resDate = request.getParameter("resDate");
        String outTime =request.getParameter("outTime");
        String inTime = request.getParameter("inTime");
        String dest = request.getParameter("dest");
        String instNo = request.getParameter("instNo");
        String resStatus = request.getParameter("resStatus");

        Reservations resnew = new Reservations();

        ReservationsList reservationsAllSub = new ReservationsList();
        ArrayList<ReservationsList> resListAllSub;

        try{

            int ri = Integer.parseInt(resid);
            int in = Integer.parseInt(instNo);


            resnew.updateReservationStatus(ri, resType, resourcesRes, resDate, outTime, inTime, dest,in, resStatus);

            resListAllSub = reservationsAllSub.populateReservations();
            request.getSession().setAttribute("allreservationsSub", resListAllSub);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);

            request.getRequestDispatcher("/adminreservationsmanagementsubmit.jsp").forward(request, response);

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}