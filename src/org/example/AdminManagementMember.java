package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AdminManagementMember extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");


        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");//admin info
        String password = request.getParameter("password");//admin info

        MemberList memList = new MemberList();
        ArrayList<MemberList> memnamenum;

        try{


            memnamenum = memList.populateResources();

            request.getSession().setAttribute("memnamenum", memnamenum);

                request.getSession().setAttribute("username" , username);
                request.getSession().setAttribute("password" , password);
                request.getRequestDispatcher("/adminmembermanagement.jsp").forward(request, response);

        }catch (Exception e2)

        {
            e2.printStackTrace();
        }
        finally{out.close();
        }
    }
} 