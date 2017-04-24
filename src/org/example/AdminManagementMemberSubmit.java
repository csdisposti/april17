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
        String accttype = request.getParameter("accttype");
        String memcomms = request.getParameter("memcomms");
        String adminStatus = request.getParameter("adminStatus");
        String adminType = request.getParameter("adminType");
        String admincomms = null;



        Credentials uc = new Credentials();
        Credentials newuc = new Credentials();
        Account ua = new Account();
        Member um = new Member();
        Member newmem = new Member();
        Admin ad = new Admin();
        Admin newad = new Admin();


        try {


            // System.out.println(password);
            if (!passwordnew.isEmpty()) {
                String required = "required";
                request.getSession().setAttribute("required", required);
                uc.readFromDatabase(email, passwordcurrent);
                uc.updatePassword(email, passwordnew);

                int ai = Integer.parseInt(accountID);
                ua.memberupdateAccount(ai, accttype, street, city, state, zip);
                int mi = Integer.parseInt(memberID);
                um.updateMemberInfo(mi, email, fname, lname, phoneone, phonetwo, emerconname, emerconphone, memcomms);

                //check if member is an admin
                int adminYN = ad.readJustMemNo(mi);
                Boolean adminActive = true;
                Boolean adminInactive = false;
                if (adminYN == 0) {
                    switch (adminStatus) {
                        case "asYES": {
                            newad.addToDatabase(mi, adminType, admincomms, adminActive);
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                } else{
                        switch (adminStatus) {
                            case "asYES": {
                                newad.updateAdminInfo(mi, adminType, admincomms, adminActive);
                                break;
                            }
                            case "asNO": {
                                newad.updateAdminInfo(mi, adminType, admincomms, adminInactive);
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }


                System.out.println(newad);
                newmem.readFromDatabase(email);
                request.getSession().setAttribute("newmem", newmem);
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("password", password);
                request.getRequestDispatcher("/adminmembersubmitpasswordchanged.jsp").forward(request, response);

            } else {
                int ai = Integer.parseInt(accountID);
                ua.memberupdateAccount(ai, accttype, street, city, state, zip);
                int mi = Integer.parseInt(memberID);
                um.updateMemberInfo(mi, email, fname, lname, phoneone, phonetwo, emerconname, emerconphone, memcomms);

                //check if member is an admin
                int adminYN = ad.readJustMemNo(mi);
                Boolean adminActive = true;
                Boolean adminInactive = false;
                if (adminYN == 0) {
                    switch (adminStatus) {
                        case "asYES": {
                            newad.addToDatabase(mi, adminType, admincomms, adminActive);
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                } else{
                    switch (adminStatus) {
                        case "asYES": {
                            newad.updateAdminInfo(mi, adminType, admincomms, adminActive);
                            break;
                        }
                        case "asNO": {
                            newad.updateAdminInfo(mi, adminType, admincomms, adminInactive);
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }


                newmem.readFromDatabase(email);
                request.getSession().setAttribute("newmem", newmem);
                request.getSession().setAttribute("username", username);
                request.getSession().setAttribute("password", password);
                request.getRequestDispatcher("/adminmembersubmit.jsp").forward(request, response);
            }
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        } finally{out.close();

        }
    }
}