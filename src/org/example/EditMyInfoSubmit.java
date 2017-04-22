package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditMyInfoSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        //get form values
        String accountID = request.getParameter("accountid");
        String memberID = request.getParameter("memberid");
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

        Credentials uc = new Credentials();
        Account ua = new Account();
        Member um = new Member();

        try{
            uc.updateCredentials(username, password);
            int ai = Integer.parseInt(accountID);
            ua.memberupdateAccount(ai, accttype, street, city, state, zip);
            int mi = Integer.parseInt(memberID);
            um.updateMyInfo(mi, fname, lname, phoneone, phonetwo, emerconname, emerconphone);

            request.getSession().setAttribute("fn", fname);
            request.getSession().setAttribute("nm", ua);
            request.getSession().setAttribute("ac", um);
            request.getRequestDispatcher("/editmyinfosubmit.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        } finally{out.close();

        }

    }

}