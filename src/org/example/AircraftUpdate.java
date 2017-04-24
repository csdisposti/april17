package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AircraftUpdate extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String aircraft = request.getParameter("aircrafttype");

        int ownerID;
        String makeModel;
        String aircraftType;
        String airportHome;
        String airportCurr;
        int rentalFee;
        int aircraftAge;
        double flightHours;
        double flightDistance;
        String lastMaintType;
        Date lastMaintDate;
        String aircraftComms;

        Aircraft act = new Aircraft();

        try {

            String[] aircraftsplit = aircraft.split("\\s+");

            String registrationID = aircraftsplit[0];
            System.out.println(registrationID);
            act.readFromDatabase(registrationID);

            ownerID = act.getOwnId();
            makeModel = act.getMakeModel();
            aircraftType = act.getAirType();
            airportHome = act.getAirHome();
            airportCurr = act.getAirCurr();
            rentalFee = act.getRentFee();
            aircraftAge = act.getAirAge();
            flightHours = act.getFlightHrs();
            flightDistance = act.getFlightDist();
            lastMaintType = act.getLastMaintType();
            lastMaintDate = act.getLastMaintDate();
            aircraftComms = act.getAirCom();

            request.getSession().setAttribute("registrationID", registrationID);
            request.getSession().setAttribute("ownerID", ownerID);
            request.getSession().setAttribute("makeModel", makeModel);
            request.getSession().setAttribute("aircraftType", aircraftType);
            request.getSession().setAttribute("airportHome", airportHome);
            request.getSession().setAttribute("airportCurr", airportCurr);
            request.getSession().setAttribute("rentalFee", rentalFee);
            request.getSession().setAttribute("aircraftAge", aircraftAge);
            request.getSession().setAttribute("flightHours", flightHours);
            request.getSession().setAttribute("flightDistance", flightDistance);
            request.getSession().setAttribute("lastMaintType", lastMaintType);
            request.getSession().setAttribute("lastMaintDate", lastMaintDate);
            request.getSession().setAttribute("aircraftComms", aircraftComms);

            request.getRequestDispatcher("/aircraftinfo.jsp").forward(request, response);

        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            out.close();

        }

    }

}