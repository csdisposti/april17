package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditMemberInfo extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("mememail");
        String id = request.getParameter("memid");
        //String mfname = request.getParameter("memfname");
        //String mlname = request.getParameter("memlname");
        //String mempp = request.getParameter("mempphone");


        String emailCheck;
        int memIDCheck;
        int mid;
        String em;
        String fn;
        String ln;
        String ph1;
        String ph2;
        String ecn;
        String ecp;
        String memcomms;

        Member m = new Member();
        CheckEmail ce = new CheckEmail();
        CheckMemberId cmi = new CheckMemberId();

        try {
            if (email != null) {
                emailCheck = ce.readFromDatabase(email);
                request.getSession().setAttribute("email", email);
                if (emailCheck == null) {
                    request.getRequestDispatcher("/membernotfound.jsp").forward(request, response);
                } else {
                    m.readFromDatabase(email);
                    request.getSession().setAttribute("m", m);
                    mid = m.getMemId();
                    em = m.getEmailUsNa();
                    fn = m.getfName();
                    ln = m.getlName();
                    ph1 = m.getPhone1();
                    ph2 = m.getPhone2();
                    ecn = m.getEmerCoNa();
                    ecp = m.getEmerCoNo();
                    memcomms = m.getMemCom();

                    request.getSession().setAttribute("mid", mid);
                    request.getSession().setAttribute("em", em);
                    request.getSession().setAttribute("fn", fn);
                    request.getSession().setAttribute("ln", ln);
                    request.getSession().setAttribute("ph1", ph1);
                    request.getSession().setAttribute("ph2", ph2);
                    request.getSession().setAttribute("ecn", ecn);
                    request.getSession().setAttribute("ecp", ecp);
                    request.getSession().setAttribute("memcomms", memcomms);
                    request.getRequestDispatcher("/editmemberinfo.jsp").forward(request, response);
                }

            } else if (id != null) {
                int mi = Integer.parseInt(id);
                memIDCheck = cmi.readFromDatabase(mi);
                request.getSession().setAttribute("memid", id);
                if (memIDCheck == 0) {
                    request.getRequestDispatcher("/membernotfound.jsp").forward(request, response);
                } else {
                    m.getMemberByMemID(mi);
                    request.getSession().setAttribute("m", m);
                    mid = m.getMemId();
                    em = m.getEmailUsNa();
                    fn = m.getfName();
                    ln = m.getlName();
                    ph1 = m.getPhone1();
                    ph2 = m.getPhone2();
                    ecn = m.getEmerCoNa();
                    ecp = m.getEmerCoNo();
                    memcomms = m.getMemCom();

                    request.getSession().setAttribute("mid", mid);
                    request.getSession().setAttribute("em", em);
                    request.getSession().setAttribute("fn", fn);
                    request.getSession().setAttribute("ln", ln);
                    request.getSession().setAttribute("ph1", ph1);
                    request.getSession().setAttribute("ph2", ph2);
                    request.getSession().setAttribute("ecn", ecn);
                    request.getSession().setAttribute("ecp", ecp);
                    request.getSession().setAttribute("memcomms", memcomms);
                    request.getRequestDispatcher("/editmemberinfo.jsp").forward(request, response);
                }
                }



           // else if (mfname !=null){
           //     m.getMemberByNamePhone(mfname, mlname, mempp);
           //     request.getRequestDispatcher("/editmemberinfo.jsp").forward(request, response);
           // }
          //  else {

         //   }

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}