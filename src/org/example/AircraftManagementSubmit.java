package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AircraftManagementSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String memberid = request.getParameter("memid");
        String email = request.getParameter("email");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phoneone = request.getParameter("phone1");
        String phonetwo = request.getParameter("phone2");
        String en = request.getParameter("en");
        String ep = request.getParameter("ep");
        String mc = request.getParameter("memcomms");
        String accountid = request.getParameter("accid");
        String accttype = request.getParameter("accttype");
        String street = request.getParameter("street");
         String city  = request.getParameter("city");

        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String payplan = request.getParameter("payplan");
          String totcharges = request.getParameter("totcharges");
        String totpayments = request.getParameter("totpayments");
        String creditreduc = request.getParameter("creditreduc");
        String lastinvoicedate = request.getParameter("lastinvoicedate");
        String lastpaymentdate = request.getParameter("lastpaymentdate");
        String accountstatus = request.getParameter("accountstatus");
        String acccomms = request.getParameter("acccomms");



        Member m = new Member();
        Member n = new Member();
        Account a = new Account();
        Account an = new Account();

        try{

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            int mi = Integer.parseInt(memberid);
            int ai = Integer.parseInt(accountid);
            int tc = Integer.parseInt(totcharges);
            int tp = Integer.parseInt(totpayments);
            int cr = Integer.parseInt(creditreduc);
            //Date lid = df.parse(lastinvoicedate);
           // Date lpd= df.parse(lastpaymentdate);
            /*lid, lpd,*/

            m.updateMemberInfo(mi, email, fname, lname, phoneone, phonetwo, en, ep, mc);
            a.updateAccount(ai, accttype, street, city, state, zip, payplan, tc, tp, cr, accountstatus, acccomms);

            n.readFromDatabase(email);
            an.readFromDatabase(ai);
            request.getSession().setAttribute("n", n);
            request.getSession().setAttribute("an", an);
            System.out.println(email);
            System.out.println(accttype);
            request.getRequestDispatcher("/aircraftmanagementsubmit.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        } finally{out.close();

        }

    }

}