package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Welcome extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        //get form values
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phoneone = request.getParameter("phone1");
        String phonetwo = request.getParameter("phone2");
        String emerconname = request.getParameter("emerconname");
        String emerconphone = request.getParameter("emerconphone");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String accttype = request.getParameter("accttype");

        Credentials c = new Credentials();
        Account ac = new Account();
        Member nm = new Member();

        try{
            c.addToDatabase(username, password);
            ac.memberCreateNewAccount(street, city, state, zip, accttype);
            int accID = ac.getAcctId();
            nm.memberCreateNewMember(accID, username, fname, lname, phoneone, phonetwo, emerconname, emerconphone);

            ac.readFromDatabase(accID);
            nm.readFromDatabase(username);

            request.getSession().setAttribute("fn", fname);
            request.getSession().setAttribute("nm", nm);
            request.getSession().setAttribute("ac", ac);
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        } finally{out.close();

        }

    }

}