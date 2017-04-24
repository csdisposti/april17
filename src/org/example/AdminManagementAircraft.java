package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AdminManagementAircraft extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        AircraftList aircrafts = new AircraftList();
        ArrayList<AircraftList> aircraftindb = new ArrayList<>();

        try{
            aircraftindb = aircrafts.populateResources();
            request.getSession().setAttribute("acftup", aircraftindb);
            request.getRequestDispatcher("/aircraftmanagement.jsp").forward(request, response);

        }catch (Exception e2)

        {
            e2.printStackTrace();
        }
        finally{out.close();
        }
    }
} 