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
        String memberid = request.getParameter("memberid"); //member id passed as session variable
        String resdate = request.getParameter("resdate"); //reservation date
        String restime = request.getParameter("restime"); //reservation time
        String aircrafttype = request.getParameter("act"); //aircraft type
        String instructor = request.getParameter("ins"); //instructor type

        Reservations res = new Reservations();
        Admin ins = new Admin();

        String resType = "F";
        String available;

        ReservationsList reservationsubmit = new ReservationsList();
        Aircraft act = new Aircraft();

        try {

            String[] instr = instructor.split("\\s+");

            String instruc = instr[2];
            System.out.println(instruc);

            System.out.print(aircrafttype);
            System.out.print(resdate);
            int mi = Integer.parseInt(memberid);
            int istruct = Integer.parseInt(instruc);

            //parse date
           // Date rdate = new SimpleDateFormat("yyyy-MM-dd").parse(resdate);

            //System.out.println(rdate);

            //get time
            SimpleDateFormat sdf = new SimpleDateFormat(restime);
            long ms = sdf.parse(restime).getTime();
            Time rtime = new Time(ms);


            //check availbility not working took me error page
            //error page does not have dropdown values
            //check availability
            // available = reservationsubmit.checkAvailability(aircrafttype);
            //thi is always true right now
            // if (available == null){
            //      request.getRequestDispatcher("/flyinglessonreservationnotavailable.jsp").forward(request, response);
            //  }
            // else {}


            String rr = "MS";
            int resID;
            //add reservation
            res.addNewReservation(mi, resType, rr, resdate, rtime, istruct);
            resID = res.getResId();
            res.readFromDatabase(resID);
            request.getSession().setAttribute("mi", mi);
            request.getSession().setAttribute("reservationsubmit", reservationsubmit);
            request.getSession().setAttribute("res", res);
            System.out.println(res);

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