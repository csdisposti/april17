package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditMemberInfoSubmit extends HttpServlet {

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
        //StringBuffer memcomms = new StringBuffer(request.getParameter("memcomms"));
        String mc = request.getParameter("memcomms");

        String memberData;

        Member m = new Member();
        Member n = new Member();

        try{

            int mi = Integer.parseInt(memberid);
            m.updateMemberInfo(mi, email, fname, lname, phoneone, phonetwo, en, ep, mc);
            n.readFromDatabase(email);
            request.getSession().setAttribute("n", n);
            System.out.println(email);
            request.getRequestDispatcher("/editmemberinfocomplete.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        } finally{out.close();

        }

    }

}