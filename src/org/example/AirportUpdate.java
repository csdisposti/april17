package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AirportUpdate extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        AircraftList aircrafts = new AircraftList();
        ArrayList<AircraftList> ResourcesReserved = new ArrayList<>();
        InstructorsList instructors = new InstructorsList();
        ArrayList<InstructorsList> InstructorReserved = new ArrayList<>();

        try{

            ResourcesReserved = aircrafts.populateResourcesReserved();
            request.getSession().setAttribute("rr", ResourcesReserved);

            InstructorReserved = instructors.populateResourcesReserved();
            request.getSession().setAttribute("ir", InstructorReserved);

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