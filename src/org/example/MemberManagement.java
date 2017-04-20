package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class MemberManagement extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        //get input from form
        String email = null;
        String id = null;
        email = request.getParameter("mememail");
        id = request.getParameter("memid");

        //check for email
        String emailCheck;

        //member variables
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

        //account variables
        int accid = 0;
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

        //Admin level
        String memberstatus;
        String admincomms;

        //new objects
        Member m = new Member();
        Account a = new Account();
        Administrator admin = new Administrator();
        CheckEmail ce = new CheckEmail();
        CheckMemberId cmi = new CheckMemberId();



        try {


            //if email entered
            if (email != null && !email.isEmpty()) {
                emailCheck = ce.readFromDatabase(email);
                request.getSession().setAttribute("email", email);
                if (emailCheck != null && !emailCheck.isEmpty()) {
                    m.readFromDatabase(email);
                    //set session member variable
                    request.getSession().setAttribute("m", m);

                    //get member info
                    mid = m.getMemId();
                    em = m.getEmailUsNa();
                    fn = m.getfName();
                    ln = m.getlName();
                    ph1 = m.getPhone1();
                    ph2 = m.getPhone2();
                    ecn = m.getEmerCoNa();
                    ecp = m.getEmerCoNo();
                    memcomms = m.getMemCom();

                    //get account info
                    accid = m.getAcctNo();
                    a.readFromDatabase(accid);

                    //set account session variable
                    request.getSession().setAttribute("a", a);

                    //get the rest of the account info
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

                    //get admin info
                    admin.readFromDatabase(mid);
                    //get member level
                    memberstatus = admin.getAdminLev();
                    admincomms = admin.getAdminCom();

                    //set session variables
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
                    request.getSession().setAttribute("memberstatus", memberstatus);
                    request.getSession().setAttribute("admincomms", admincomms);
                }
                //if id entered
            } else if (id != null && !id.isEmpty()) {
                //parse int
                int mi = Integer.parseInt(id.trim());
                memIDCheck = cmi.readFromDatabase(mi);
                request.getSession().setAttribute("memid", mi);
                if (memIDCheck != 0) {
                    m.getMemberByMemID(mi);
                    //set session member variable
                    request.getSession().setAttribute("m", m);

                    //get member info
                    mid = m.getMemId();
                    em = m.getEmailUsNa();
                    fn = m.getfName();
                    ln = m.getlName();
                    ph1 = m.getPhone1();
                    ph2 = m.getPhone2();
                    ecn = m.getEmerCoNa();
                    ecp = m.getEmerCoNo();
                    memcomms = m.getMemCom();

                    //get account info
                    accid = m.getAcctNo();
                    a.readFromDatabase(accid);

                    //set account session variable
                    request.getSession().setAttribute("a", a);

                    //get the rest of the account info
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

                    //get admin info
                    admin.readFromDatabase(mid);
                    //get member level
                    memberstatus = admin.getAdminLev();
                    admincomms = admin.getAdminCom();

                    //set session variables
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
                    request.getSession().setAttribute("memberstatus", memberstatus);
                    request.getSession().setAttribute("admincomms", admincomms);
                }
            } else {
                request.getRequestDispatcher("/membernotfound.jsp").forward(request, response);
            }
            request.getRequestDispatcher("/memberinfo.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}