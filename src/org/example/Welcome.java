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


        String accountID = request.getParameter("accID");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phoneone = request.getParameter("phone1");
        String phonetwo = request.getParameter("phone2");
        String en = request.getParameter("en");
        String ep = request.getParameter("ep");
        //StringBuffer memcomms = new StringBuffer(request.getParameter("memcomms"));
        String mcstr = request.getParameter("memcomms");

        String memberData;

        Credentials c = new Credentials();
        Member nm = new Member();

        try{

            request.getSession().setAttribute("fn", fname);

            int ai = Integer.parseInt(accountID);
            nm.addToDatabase(ai, email, fname, lname, phoneone, phonetwo, en, ep, mcstr);
            memberData = c.readFromDatabase(email, pwd);
            nm.readFromDatabase(memberData);
            request.getSession().setAttribute("nm", nm);
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        } finally{out.close();

        }

    }

}