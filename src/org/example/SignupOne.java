package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignupOne extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String emailCheck;

        CheckEmail ce = new CheckEmail();

        try{
            emailCheck = ce.readFromDatabase(email);
            request.getSession().setAttribute("em", email);
            if (emailCheck == null) {
                request.getRequestDispatcher("/signupone.jsp").forward(request, response);
            }
            request.getRequestDispatcher("/emailexists.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}