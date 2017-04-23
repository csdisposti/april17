package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Date;


public class FlyingLessonReservationSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String memberid = request.getParameter("memberid"); //member id passed as session variable
        String resdate = request.getParameter("resdate"); //reservation date
        String restime = request.getParameter("restime"); //reservation time
        String lengthoftime = request.getParameter("lengthoftime");
        String aircrafttype = request.getParameter("act"); //aircraft type
        String instructor = request.getParameter("ins"); //instructor type

        Reservations res = new Reservations();
        Admin ins = new Admin();

        //Reservation here is always L for lesson
        String resType = "L";
        String available;
        String seconds = ":00";

        ReservationsList reservationsubmit = new ReservationsList();
        Aircraft act = new Aircraft();
        Admin I = new Admin();

        try {
            //get registrationID only for resources rserved column
            String[] registrationid = aircrafttype.split("\\s+");
            String rr = registrationid[0];
            String make = registrationid[1];
            String model = registrationid[2];

            String makemodel = make + " " + model;

            //get instructor adminID for instructor column
            String[] insructornames = instructor.split("\\s+");
            String fname = insructornames[0];
            String lname = insructornames[1];
            int instruct = I.getInstructorNumber(fname, lname);

            //parse memberid to int
            int mi = Integer.parseInt(memberid);

            //get resdate as yyyy-mmm-dd
            //String[] reservationdate = resdate.split("\\-+");
            //String month = reservationdate[0];
            //String day = reservationdate[1];
            //String year = reservationdate[2];
           // String resdatenew = year + "-" + month + "-" + day;

            //add :00 to restime
            String fullouttime = restime + seconds;

            //add length of time to fullouttime
            String[] starttime = restime.split("\\:+");
            String hour = starttime[0];
            String minute = starttime[1];
            int hr = Integer.parseInt(hour);
            int min = Integer.parseInt(minute);
            int fot = Integer.parseInt(lengthoftime);
            int hournew = hr + fot;

            String intimehr = String.valueOf(hournew);
            String intime = intimehr + ":" + minute + seconds;
            String resintime = intimehr + ":" + minute;

            //check availbility not working took me error page
            //error page does not have dropdown values
            //check availability
            // available = reservationsubmit.checkAvailability(aircrafttype);
            //thi is always true right now
            // if (available == null){
            //      request.getRequestDispatcher("/flyinglessonreservationnotavailable.jsp").forward(request, response);
            //  }
            // else {}

            int resID;
            //add reservation
            res.addNewFlyingLessonReservation(mi, resType, rr, resdate, fullouttime, intime, instruct);
            resID = res.getResId();
            res.readFromDatabase(resID);

            String rrr = res.getResourcesRes();
            Date rdate = res.getResDate();
            String flyinglesson = "Flying Lesson";
            String pending = "pending";

            //used for testing purposes
            String rtype = res.getResType();  //not needed just for clarity
            Time rtime = res.getOutTime();//not needed just for clarity
            int insnum = res.getInstNo();//not needed just for clarity
            Boolean resstat = res.getResStatus(); //not needed just for clarity
            System.out.println(rtype);
            System.out.println(rtime);
            System.out.println(insnum);
            System.out.println(resstat);
            System.out.println(hournew);
            System.out.println(intime);

            request.getSession().setAttribute("memberid", mi);
            request.getSession().setAttribute("reservationsubmit", reservationsubmit);
            request.getSession().setAttribute("res", res);
            request.getSession().setAttribute("flyinglesson", flyinglesson);
            request.getSession().setAttribute("regsitration", rrr);
            request.getSession().setAttribute("makemodel", makemodel);
            request.getSession().setAttribute("rdate", rdate);
            request.getSession().setAttribute("resouttime", restime);
            request.getSession().setAttribute("resintime", resintime);
            request.getSession().setAttribute("instructor", instructor);
            request.getSession().setAttribute("pending", pending);
            request.getSession().setAttribute("lessonlength", lengthoftime);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);
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