package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AircraftAddSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String registrationID = request.getParameter("registrationID");
        String ownerID = request.getParameter("ownerID");
        String makeModel = request.getParameter("makeModel");
        String aircraftType = request.getParameter("aircraftType");
        String airportHome = request.getParameter("airportHome");
        String airportCurrent = request.getParameter("airportCurrent");
        String rentalFee = request.getParameter("rentalFee");
        String aircraftAge = request.getParameter("aircraftAge");
        String flightHours = request.getParameter("flightHours");
        String flightDistance = request.getParameter("flightDistance");
        String lastMaintType = request.getParameter("lastMaintType");
        String lastMaintDate = request.getParameter("lastMaintDate");
        String aircraftComms = request.getParameter("aircraftComms");

        Aircraft ac = new Aircraft();
        Aircraft acnew = new Aircraft();

        try{


            int oi = Integer.parseInt(ownerID);
            int rf = Integer.parseInt(rentalFee);
            int aa = Integer.parseInt(aircraftAge);
            double fh = Double.parseDouble(flightHours);
            double fd = Double.parseDouble(flightDistance);

            ac.addAircraft(registrationID, oi, makeModel, aircraftType, airportHome, airportCurrent, rf, aa, fh, fd, lastMaintType, lastMaintDate, aircraftComms);
            acnew.readFromDatabase(registrationID);
            request.getSession().setAttribute("acnew", acnew);
            request.getRequestDispatcher("/aircraftaddsubmit.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        } finally{out.close();

        }

    }



}