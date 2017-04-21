package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReservationFlyingLessonSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String resdate = request.getParameter("resdate");
        String restime = request.getParameter("restime");
        String aircrafttype = request.getParameter("at");
        String instructor = request.getParameter("it");
        String memberid = request.getParameter("mid"); //member id passed as session variable

//begin here
        Reservations ressub = new Reservations();

        try{
            System.out.print(aircrafttype);
            System.out.print(resdate);
            int mi = Integer.parseInt(memberid);

           //ressub.checkAvailability(words[0]);

            request.getSession().setAttribute("mi", mi);
            request.getSession().setAttribute("ressub", ressub);
            System.out.println(ressub);

                request.getRequestDispatcher("/reservationflyinglessonsubmit.jsp").forward(request, response);

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}