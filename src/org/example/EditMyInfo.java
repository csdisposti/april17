package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditMyInfo extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        //get form values
        String memberpassword = request.getParameter("memberpwd");
        String memberemail = request.getParameter("memberemail");

        //variables
        int accountID;
        int memberID;
        String fname;
        String lname;
        String phoneone;
        String phonetwo;
        String emerconname;
        String emerconphone;
        String street;
        String city;
        String state;
        String zip;

        String accttype;
        String checked = "checked=\"checked\"";
        String selected = "selected";


        Member medit = new Member();
        Account aedit = new Account();

        try{

            medit.readFromDatabase(memberemail);
            accountID = medit.getAcctNo();
            aedit.readFromDatabase(accountID);

            memberID = medit.getMemId();
            fname = medit.getfName();
            lname = medit.getlName();
            phoneone = medit.getPhone1();
            phonetwo = medit.getPhone2();
            emerconname = medit.getEmerCoNa();
            emerconphone = medit.getEmerCoNo();
            street = aedit.getStreet();
            city = aedit.getCity();
            zip = aedit.getZip();

            request.getSession().setAttribute("em" , memberemail);
            request.getSession().setAttribute("pw" , memberpassword);
            request.getSession().setAttribute("mi" , memberID);
            request.getSession().setAttribute("ai" , accountID);
            request.getSession().setAttribute("fn" , fname);
            request.getSession().setAttribute("ln" , lname);
            request.getSession().setAttribute("p1" , phoneone);
            request.getSession().setAttribute("p2" , phonetwo);
            request.getSession().setAttribute("ec" , emerconname);
            request.getSession().setAttribute("ep" , emerconphone);
            request.getSession().setAttribute("st" , street);
            request.getSession().setAttribute("ct" , city);

            request.getSession().setAttribute("zi" , zip);

            //set state
            state = aedit.getState();
            switch(state) {
                case "NC":
                    request.getSession().setAttribute("NC" , selected);
                    break;
                case "SC":
                    request.getSession().setAttribute("SC" , selected);
                    break;
                case "AL":
                    request.getSession().setAttribute("AL" , selected);
                    break;
                case "AK":
                    request.getSession().setAttribute("AK" , selected);
                    break;
                case "AZ":
                    request.getSession().setAttribute("AZ" , selected);
                    break;
                case "AR":
                    request.getSession().setAttribute("AR" , selected);
                    break;
                case "CA":
                    request.getSession().setAttribute("CA" , selected);
                    break;
                case "CO":
                    request.getSession().setAttribute("CO" , selected);
                    break;
                case "CT":
                    request.getSession().setAttribute("CT" , selected);
                    break;
                case "DE":
                    request.getSession().setAttribute("DE" , selected);
                    break;
                case "DC":
                    request.getSession().setAttribute("DC" , selected);
                    break;
                case "FL":
                    request.getSession().setAttribute("FL" , selected);
                    break;
                case "GA":
                    request.getSession().setAttribute("GA" , selected);
                    break;
                case "HI":
                    request.getSession().setAttribute("HI" , selected);
                    break;
                case "ID":
                    request.getSession().setAttribute("ID" , selected);
                    break;
                case "IL":
                    request.getSession().setAttribute("IL" , selected);
                    break;
                case "IN":
                    request.getSession().setAttribute("IN" , selected);
                    break;
                case "IA":
                    request.getSession().setAttribute("IA" , selected);
                    break;
                case "KS":
                    request.getSession().setAttribute("KS" , selected);
                    break;
                case "KY":
                    request.getSession().setAttribute("KY" , selected);
                    break;
                case "LA":
                    request.getSession().setAttribute("LA" , selected);
                    break;
                case "ME":
                    request.getSession().setAttribute("ME" , selected);
                    break;
                case "MD":
                    request.getSession().setAttribute("MA" , selected);
                    break;
                case "MI":
                    request.getSession().setAttribute("MN" , selected);
                    break;
                case "MS":
                    request.getSession().setAttribute("MO" , selected);
                    break;
                case "MT":
                    request.getSession().setAttribute("MT" , selected);
                    break;
                case "NE":
                    request.getSession().setAttribute("NE" , selected);
                    break;
                case "NV":
                    request.getSession().setAttribute("NV" , selected);
                    break;
                case "NH":
                    request.getSession().setAttribute("NH" , selected);
                    break;
                case "NJ":
                    request.getSession().setAttribute("NM" , selected);
                    break;
                case "NY":
                    request.getSession().setAttribute("NY" , selected);
                    break;
                case "ND":
                    request.getSession().setAttribute("ND" , selected);
                    break;
                case "OH":
                    request.getSession().setAttribute("OH" , selected);
                    break;
                case "OK":
                    request.getSession().setAttribute("OK" , selected);
                    break;
                case "OR":
                    request.getSession().setAttribute("PA" , selected);
                    break;
                case "RI":
                    request.getSession().setAttribute("RI" , selected);
                    break;
                case "SD":
                    request.getSession().setAttribute("SD" , selected);
                    break;
                case "TN":
                    request.getSession().setAttribute("TN" , selected);
                    break;
                case "TX":
                    request.getSession().setAttribute("TX" , selected);
                    break;
                case "UT":
                    request.getSession().setAttribute("UT" , selected);
                    break;
                case "VT":
                    request.getSession().setAttribute("VT" , selected);
                    break;
                case "VA":
                    request.getSession().setAttribute("VA" , selected);
                    break;
                case "WA":
                    request.getSession().setAttribute("WA" , selected);
                    break;
                case "WV":
                    request.getSession().setAttribute("WV" , selected);
                    break;
                case "WI":
                    request.getSession().setAttribute("WI" , selected);
                    break;
                case "WY":
                    request.getSession().setAttribute("WY" , selected);
                    break;
                    default:
                        break;
            }

            //set radio buttons
            accttype = aedit.getAcctType();

                switch (accttype) {
                    case "I":
                        request.getSession().setAttribute("atic" , checked);
                        break;
                    case "F":
                        request.getSession().setAttribute("atfc" , checked);
                        break;
                    case "D":
                        request.getSession().setAttribute("atdc" , checked);
                        break;
                    default:
                        request.getSession().setAttribute("attc" , checked);
                        break;
                }

            request.getRequestDispatcher("/editmyinfo.jsp").forward(request, response);
        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}