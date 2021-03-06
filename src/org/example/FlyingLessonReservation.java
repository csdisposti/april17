package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FlyingLessonReservation extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String memberid = request.getParameter("memberid");

        AircraftList aircrafts = new AircraftList();
        ArrayList<AircraftList> aircrafttype;
        InstructorsList instructors = new InstructorsList();
        ArrayList<InstructorsList> instructortype;

        try{

            int mid = Integer.parseInt(memberid);
            aircrafttype = aircrafts.populateResources();
            instructortype = instructors.populateResources();
            request.getSession().setAttribute("aircrafttype", aircrafttype);
            request.getSession().setAttribute("instructortype", instructortype);
            request.getSession().setAttribute("memberid", mid);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);
            request.getRequestDispatcher("/flyinglessonreservation.jsp").forward(request, response);
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}