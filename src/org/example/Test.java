package org.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;

public class Test extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();



        Credentials c = new Credentials();
        Test2 t2 = new Test2();
        try{

          t2.test();
            request.getSession().setAttribute("t2", t2);
            request.getRequestDispatcher("/test2.jsp").forward(request, response);

        }catch (Exception e2)

        {

            e2.printStackTrace();

        }

        finally{out.close();

        }

    }

}