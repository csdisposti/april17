package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ReservationsManagement extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("mememail");
        String id = request.getParameter("memid");


        String emailCheck;

        int memIDCheck;
        int mid;
        String em;
        String fn;
        String ln;
        String ph1;
        String ph2;
        String ecn;
        String ecp;
        String memcomms;

        int accid;
        String accttype;
        String street;
        String city;
        String state;
        String zip;
        String payplan;
        int totcharges;
        int totpayments;
        int creditreduc;
        Date lastinvoicedate;
        Date lastpaymentdate;
        String accountstatus;
        String acccomms;

        Member m = new Member();
        Account a = new Account();
        CheckEmail ce = new CheckEmail();
        CheckMemberId cmi = new CheckMemberId();

        try {
            if (email != null) {
                emailCheck = ce.readFromDatabase(email);
                request.getSession().setAttribute("email", email);
                if (emailCheck == null) {
                    request.getRequestDispatcher("/reservationinfo.jsp").forward(request, response);
                } else {
                    m.readFromDatabase(email);
                    request.getSession().setAttribute("m", m);
                    mid = m.getMemId();
                    em = m.getEmailUsNa();
                    fn = m.getfName();
                    ln = m.getlName();
                    ph1 = m.getPhone1();
                    ph2 = m.getPhone2();
                    ecn = m.getEmerCoNa();
                    ecp = m.getEmerCoNo();
                    memcomms = m.getMemCom();

                    accid = m.getAcctNo();
                    a.readFromDatabase(accid);
                    request.getSession().setAttribute("a", a);
                    accttype = a.getAcctType();
                    street = a.getStreet();
                    city = a.getCity();
                    state = a.getState();
                    zip = a.getZip();
                    payplan = a.getPaymentPlan();
                    totcharges = a.getTotalChgs();
                    totpayments = a.getTotalPays();
                    creditreduc = a.getCreditReds();
                    lastinvoicedate = a.getLastInvDate();
                    lastpaymentdate = a.getLastPayDate();
                    accountstatus = a.getAcctStat();
                    acccomms = a.getAcctCom();

                    request.getSession().setAttribute("mid", mid);
                    request.getSession().setAttribute("em", em);
                    request.getSession().setAttribute("fn", fn);
                    request.getSession().setAttribute("ln", ln);
                    request.getSession().setAttribute("ph1", ph1);
                    request.getSession().setAttribute("ph2", ph2);
                    request.getSession().setAttribute("ecn", ecn);
                    request.getSession().setAttribute("ecp", ecp);
                    request.getSession().setAttribute("memcomms", memcomms);
                    request.getSession().setAttribute("accid", accid);
                    request.getSession().setAttribute("accttype", accttype);
                    request.getSession().setAttribute("street", street);
                    request.getSession().setAttribute("city", city);
                    request.getSession().setAttribute("state", state);
                    request.getSession().setAttribute("zip", zip);
                    request.getSession().setAttribute("payplan", payplan);
                    request.getSession().setAttribute("totcharges", totcharges);
                    request.getSession().setAttribute("totpayments", totpayments);
                    request.getSession().setAttribute("creditreduc", creditreduc);
                    request.getSession().setAttribute("lastinvoicedate", lastinvoicedate);
                    request.getSession().setAttribute("lastpaymentdate", lastpaymentdate);
                    request.getSession().setAttribute("accountstatus", accountstatus);
                    request.getSession().setAttribute("acccomms", acccomms);
                    request.getRequestDispatcher("/memberinfo.jsp").forward(request, response);
                }

            } else if (id != null) {
                int mi = Integer.parseInt(id);
                memIDCheck = cmi.readFromDatabase(mi);
                request.getSession().setAttribute("memid", id);
                if (memIDCheck == 0) {
                    request.getRequestDispatcher("/reservationinfo.jsp").forward(request, response);
                } else {
                    m.getMemberByMemID(mi);
                    request.getSession().setAttribute("m", m);
                    mid = m.getMemId();
                    em = m.getEmailUsNa();
                    fn = m.getfName();
                    ln = m.getlName();
                    ph1 = m.getPhone1();
                    ph2 = m.getPhone2();
                    ecn = m.getEmerCoNa();
                    ecp = m.getEmerCoNo();
                    memcomms = m.getMemCom();

                    accid = m.getAcctNo();
                    a.readFromDatabase(accid);
                    request.getSession().setAttribute("a", a);
                    accttype = a.getAcctType();
                    street = a.getStreet();
                    city = a.getCity();
                    state = a.getState();
                    zip = a.getZip();
                    payplan = a.getPaymentPlan();
                    totcharges = a.getTotalChgs();
                    totpayments = a.getTotalPays();
                    creditreduc = a.getCreditReds();
                    lastinvoicedate = a.getLastInvDate();
                    lastpaymentdate = a.getLastPayDate();
                    accountstatus = a.getAcctStat();
                    acccomms = a.getAcctCom();

                    request.getSession().setAttribute("mid", mid);
                    request.getSession().setAttribute("em", em);
                    request.getSession().setAttribute("fn", fn);
                    request.getSession().setAttribute("ln", ln);
                    request.getSession().setAttribute("ph1", ph1);
                    request.getSession().setAttribute("ph2", ph2);
                    request.getSession().setAttribute("ecn", ecn);
                    request.getSession().setAttribute("ecp", ecp);
                    request.getSession().setAttribute("memcomms", memcomms);
                    request.getSession().setAttribute("accid", accid);
                    request.getSession().setAttribute("accttype", accttype);
                    request.getSession().setAttribute("street", street);
                    request.getSession().setAttribute("city", city);
                    request.getSession().setAttribute("state", state);
                    request.getSession().setAttribute("zip", zip);
                    request.getSession().setAttribute("payplan", payplan);
                    request.getSession().setAttribute("totcharges", totcharges);
                    request.getSession().setAttribute("totpayments", totpayments);
                    request.getSession().setAttribute("creditreduc", creditreduc);
                    request.getSession().setAttribute("lastinvoicedate", lastinvoicedate);
                    request.getSession().setAttribute("lastpaymentdate", lastpaymentdate);
                    request.getSession().setAttribute("payplan", payplan);
                    request.getSession().setAttribute("accountstatus", accountstatus);
                    request.getSession().setAttribute("acccomms", acccomms);
                    request.getRequestDispatcher("/reservationinfo.jsp").forward(request, response);
                }
                }



           // else if (mfname !=null){
           //     m.getMemberByNamePhone(mfname, mlname, mempp);
           //     request.getRequestDispatcher("/editmemberinfo.jsp").forward(request, response);
           // }
          //  else {

         //   }

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}