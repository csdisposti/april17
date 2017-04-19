package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReservationSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String memidres = request.getParameter("memidres"); //member id passed as session variable
        String resmain = request.getParameter("resmain");
        String resflight = request.getParameter("resflight");
        String reslesson = request.getParameter("reslesson");
        String resdate = request.getParameter("resdate");
        String restime = request.getParameter("restime");
        String aircrafttype = request.getParameter("rer");
        String instructor = request.getParameter("instructor");


        //String[] words = aircrafttype.split("\\s+");

        Reservations ressub = new Reservations();

        try{
            System.out.print(aircrafttype);
            System.out.print(resdate);
            int mi = Integer.parseInt(memidres);

           //ressub.checkAvailability(words[0]);

            request.getSession().setAttribute("ressub", ressub);
            System.out.println(ressub);

                request.getRequestDispatcher("/reservationsubmit.jsp").forward(request, response);

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}