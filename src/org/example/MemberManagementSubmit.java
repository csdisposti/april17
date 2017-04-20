package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class MemberManagementSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        //member info
        String memberid = request.getParameter("memid");
        String email = request.getParameter("email");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phoneone = request.getParameter("phone1");
        String phonetwo = request.getParameter("phone2");
        String en = request.getParameter("en");
        String ep = request.getParameter("ep");
        String mc = request.getParameter("memcomms");

        //account info
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

        //admin info
        String memberstatus = request.getParameter("memberstatus");
        String admincomms = request.getParameter("admincomms");

        Member m = new Member();
        Member n = new Member();
        Account a = new Account();
        Account an = new Account();
        Administrator admin = new Administrator();
        Administrator adminnew = new Administrator();


        try{
            int mi = Integer.parseInt(memberid);
            int ai = Integer.parseInt(accountid);
            int tc = Integer.parseInt(totcharges);
            int tp = Integer.parseInt(totpayments);
            int cr = Integer.parseInt(creditreduc);
            String nodate = "0000-00-00";
            Date lpd = new SimpleDateFormat("yyyy-MM-dd").parse(nodate);
            Date lid = new SimpleDateFormat("yyyy-MM-dd").parse(nodate);
            if (lastinvoicedate != null && !lastinvoicedate.isEmpty())  {
                lid = new SimpleDateFormat("yyyy-MM-dd").parse(lastinvoicedate);
            }
            if (lastpaymentdate != null && !lastpaymentdate.isEmpty())  {
                lpd = new SimpleDateFormat("yyyy-MM-dd").parse(lastpaymentdate);
            }

            m.updateMemberInfo(mi, email, fname, lname, phoneone, phonetwo, en, ep, mc);
            a.updateAccount(ai, accttype, street, city, state, zip, payplan, tc, tp, cr, lid, lpd, accountstatus, acccomms);

            admin.readFromDatabase(mi);
            if (admin.getMemId() == 0) {
                admin.addToDatabase(mi, memberstatus, admincomms);
            } else {
                admin.updateAdminInfo(mi, memberstatus, admincomms);
            }
            n.readFromDatabase(email);
            an.readFromDatabase(ai);
            adminnew.readFromDatabase(mi);

            request.getSession().setAttribute("n", n);
            request.getSession().setAttribute("an", an);
            request.getSession().setAttribute("adminnew", adminnew);

            request.getRequestDispatcher("/memberinfosubmit.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        } finally{out.close();

        }

    }

}