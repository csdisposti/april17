package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Reservation extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String reg = "N3621";
        String blah;
        AircraftList aircrafts = new AircraftList();
        ArrayList<AircraftList> ResourcesReserved = new ArrayList<>();

        try{

            ResourcesReserved = aircrafts.populateResourcesReserved();

            System.out.println(ResourcesReserved);
            request.getSession().setAttribute("rr", ResourcesReserved);

            request.getRequestDispatcher("/reservation.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}