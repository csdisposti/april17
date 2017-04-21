package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class FlyingLessonReservationSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String memberid = request.getParameter("mid"); //member id passed as session variable
        String resdate = request.getParameter("resdate"); //reservation date
        String restime = request.getParameter("restime"); //reservation time
        String aircrafttype = request.getParameter("at"); //aircraft type
        String instructor = request.getParameter("it"); //instructor type

        Reservations res = new Reservations();

        String resType = "F";

        ReservationsList reservationsubmit = new ReservationsList();

        try{
            System.out.print(aircrafttype);
            System.out.print(resdate);
            int mi = Integer.parseInt(memberid);
            int ist = Integer.parseInt(instructor);
            //get util date
            DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
            Date rdate = formatter.parse(resdate);

            //get sql time
            java.sql.Time rtime = java.sql.Time.valueOf(restime);

            //check availibility
            //reservationsubmit.checkAvailability(words[0]);

            //add reservation
            res.addNewReservation(mi, resType, aircrafttype, rdate, rtime, ist);

            request.getSession().setAttribute("mi", mi);
            request.getSession().setAttribute("reservationsubmit", reservationsubmit);
            System.out.println(reservationsubmit);

                request.getRequestDispatcher("/flyinglessonreservationsubmit.jsp").forward(request, response);

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}