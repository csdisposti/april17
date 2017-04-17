package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditMemberInfo extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String memail = request.getParameter("mememail");
        String mfname = request.getParameter("memfname");
        String mlname = request.getParameter("memlname");
        String mempp = request.getParameter("mempphone");
        String memid = request.getParameter("memid");


        Member m = new Member();

        try{
            if (memail != null) {
                m.readFromDatabase(memail);
                request.getRequestDispatcher("/editmemberinfo.jsp").forward(request, response);
            }
            else if (memid != null) {
                int mi = Integer.parseInt(memid);
                m.getMemberByMemID(mi);
                request.getRequestDispatcher("/editmemberinfo.jsp").forward(request, response);
            }
            else if (mfname !=null){
                m.getMemberByNamePhone(mfname, mlname, mempp);
                request.getRequestDispatcher("/editmemberinfo.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("/membernotfound.jsp").forward(request, response);
            }

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}