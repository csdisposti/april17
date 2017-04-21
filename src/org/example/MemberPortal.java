package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cdisp on 3/27/2017.
 */

public class MemberPortal extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("email");
        String password = request.getParameter("password");

        String memberLogin;
        String fn;
        int memidlogin;

        Credentials c = new Credentials();
        Member mlogin = new Member();

        try{

            memberLogin = c.readFromDatabase(username, password);
            //check is member username and password match
            if (memberLogin == null){
                request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
            }
            else {
                //read member data from member table
                mlogin.readFromDatabase(memberLogin);
                request.getSession().setAttribute("mlogin", mlogin);
                request.getSession().setAttribute("us", memberLogin);
                //get member first name
                fn = mlogin.getfName();
                memidlogin = mlogin.getMemId();
                request.getSession().setAttribute("fn" , fn);
                request.getSession().setAttribute("memidlogin", memidlogin);
                request.getRequestDispatcher("/memberportal.jsp").forward(request, response);
            }
        }catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();
        }
    }
} 