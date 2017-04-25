package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AirportUpdate extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username"); //admin info
        String password = request.getParameter("password"); //admin info

        String airport = request.getParameter("airporttype");

        String faa;
        String airportName;
        String airportType;
        String streetAddress;
        String city;
        double latitude;
        double longitude;
        String contactName;
        String contactPhone;
        String ctaf;
        String runwayType;
        String towerFreq;
        double fuel;
        String storage;
        String airportComms;


        Airports apt = new Airports();

        try {
            String[] airportsplit = airport.split("\\s+");

            faa = airportsplit[0];
            System.out.println(faa);
            apt.readFromDatabase(faa);

            faa = apt.getFaaCode();
            airportName = apt.getAirportName();
            airportType = apt.getAirportType();
            streetAddress = apt.getAirportSt();
            city = apt.getAirportCity();
            latitude = apt.getLatitude();
            longitude = apt.getLongitude();
            contactName = apt.getContactName();
            contactPhone = apt.getContactPhone();
            ctaf = apt.getCtaf();
            runwayType = apt.getRunwayType();
            towerFreq = apt.getTowerFreq();
            fuel = apt.getFuel();
            storage = apt.getStorage();


            request.getSession().setAttribute("faa", faa);
            request.getSession().setAttribute("airportName", airportName);
            request.getSession().setAttribute("airportType", airportType);
            request.getSession().setAttribute("streetAddress", streetAddress);
            request.getSession().setAttribute("city", city);
            request.getSession().setAttribute("latitude", latitude);
            request.getSession().setAttribute("longitude", longitude);
            request.getSession().setAttribute("contactName", contactName);
            request.getSession().setAttribute("contactPhone", contactPhone);
            request.getSession().setAttribute("ctaf", ctaf);
            request.getSession().setAttribute("runwayType", runwayType);
            request.getSession().setAttribute("towerFreq", towerFreq);
            request.getSession().setAttribute("fuel", fuel);
            request.getSession().setAttribute("storage", storage);


            request.getSession().setAttribute("username" , username);
            request.getSession().setAttribute("password" , password);
            request.getRequestDispatcher("/airportinfo.jsp").forward(request, response);

        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}