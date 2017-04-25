package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AdminManagementMemberSubmit extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");//admin info
        String password = request.getParameter("password");//admin info

        //get form values

        String accountID = request.getParameter("accountid");
        String memberID = request.getParameter("memberid");
        String oldemail = request.getParameter("oldemail");
        String email = request.getParameter("email");
        String passwordcurrent = request.getParameter("passwordcurrent");
        String passwordnew = request.getParameter("passwordnew");
        String passwordnewcheck = request.getParameter("passwordnewcheck");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phoneone = request.getParameter("phone1");
        String phonetwo = request.getParameter("phone2");
        String emerconname = request.getParameter("emerconname");
        String emerconphone = request.getParameter("emerconphone");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String accttypen = request.getParameter("accttype");
        String adminStatusn = request.getParameter("adminStatus");
        String adminTypen = request.getParameter("adminType");

        System.out.println(adminTypen);

        int adminYN;

        Credentials uc = new Credentials();
        Account ua = new Account();
        Member um = new Member();
        Member mnn = new Member();
        Admin newad = new Admin();

        try {

            int ai = Integer.parseInt(accountID);
            int mi = Integer.parseInt(memberID);
            //if password changing
            if (!passwordnew.isEmpty()) {
                String required = "required";
                request.getSession().setAttribute("required", required);
                uc.readFromDatabase(email, passwordcurrent);
                uc.updateCredentials(oldemail, email, passwordnew);
                //if password not changing
            } else {
                uc.updateCredentials(oldemail, email, passwordcurrent);
                uc.readFromDatabase(email, passwordcurrent);
            }
            ua.memberupdateAccount(ai, accttypen, street, city, state, zip);
            um.updateMemberInfo(mi, email, fname, lname, phoneone, phonetwo, emerconname, emerconphone);
                //check if member is an admin
                adminYN = newad.readJustMemNo(mi);
                System.out.println(adminYN);
                System.out.println(adminStatusn);

                if (adminYN == 0) {
                    switch (adminStatusn) {
                        case "asYES": {
                            newad.addToDatabase(mi, adminTypen);
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                } else {
                    switch (adminStatusn) {
                        case "asYES": {
                            newad.updateAdminInfo(mi, adminTypen, true);
                            break;
                        }
                        case "asNO": {
                            newad.updateAdminInfo(mi, adminTypen, false);
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
                newad.readFromDatabase(mi);
                System.out.println(newad);
                mnn.readFromDatabase(email);
                request.getSession().setAttribute("mnn", mnn);
                request.getSession().setAttribute("newad", newad);


                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("password", password);


                request.getRequestDispatcher("/adminmembersubmit.jsp").forward(request, response);


        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        } finally{out.close();

        }
    }
}