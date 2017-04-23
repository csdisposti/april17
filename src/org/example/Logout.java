package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Logout extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        try{
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/logout.jsp");

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();
        }
    }

}