package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cdisp on 3/27/2017.
 * Member Portal
 */

public class MemberPortal extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String memberLogin;
        String fn;
        int memberid;
        String email;

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
                mlogin.readFromDatabase(username);
                request.getSession().setAttribute("mlogin", mlogin);
                request.getSession().setAttribute("us", memberLogin);
                //get member first name
                fn = mlogin.getfName();
                memberid = mlogin.getMemId();
                System.out.println(memberid);

                request.getSession().setAttribute("fn" , fn);
                request.getSession().setAttribute("memberid", memberid);
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("password", password);

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