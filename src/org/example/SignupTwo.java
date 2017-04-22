package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignupTwo extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String emailCheck;

        CheckEmail ce = new CheckEmail();

        try{
            //check if email is already registered
            emailCheck = ce.readFromDatabase(email);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);
            //if email is not already registered send to next step in signup process
            if (emailCheck == null) {
                request.getRequestDispatcher("/signuptwo.jsp").forward(request, response);
            }
            //if email is already registered send back to index to have user sign in
            else {
                request.getRequestDispatcher("/emailexists.jsp").forward(request, response);
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