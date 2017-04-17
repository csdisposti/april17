package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class SignupThree extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");

        String str = request.getParameter("street");
        String cty = request.getParameter("city");
        String sta = request.getParameter("state");
        String zip = request.getParameter("zip");
        //StringBuffer acccomms = new StringBuffer(request.getParameter("acccomms"));
        String acstr = request.getParameter("acccomms");

        int accID = 0;

        Account ac = new Account();

        try{
            ac.addToDatabase(str, cty, sta, zip, acstr);
            accID = ac.getNewAcctId();
            request.getSession().setAttribute("accID", accID);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("pwd", pwd);
            request.getRequestDispatcher("/signupthree.jsp").forward(request, response);

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}
