package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AirportAddSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username"); //admin info
        String password = request.getParameter("password"); //admin info

        String faa  = request.getParameter("faa");
        String airportName = request.getParameter("airportName");
        String airportType = request.getParameter("airportType");
        String streetAddress = request.getParameter("streetAddress");
        String city = request.getParameter("city");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        String contactName = request.getParameter("contactName");
        String contactPhone = request.getParameter("contactPhone");
        String ctaf = request.getParameter("ctaf");
        String runwayType = request.getParameter("runwayType");
        String towerFreq = request.getParameter("towerFreq");
        String fuel = request.getParameter("fuel");
        String storage = request.getParameter("storage");


        Airports ap = new Airports();
        Airports apnew = new Airports();

        try{


           double lat = Double.parseDouble(latitude);
           double lon = Double.parseDouble(longitude);
           int fl = Integer.parseInt(fuel);

            ap.addAirport(faa, airportName, airportType, streetAddress, city, lat, lon, contactName, contactPhone, ctaf, runwayType, towerFreq, fl, storage);
            apnew.readFromDatabase(faa);
            request.getSession().setAttribute("apnew", apnew);

            request.getSession().setAttribute("username" , username);
            request.getSession().setAttribute("password" , password);
            request.getRequestDispatcher("/airportaddsubmit.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        } finally{out.close();

        }

    }

}