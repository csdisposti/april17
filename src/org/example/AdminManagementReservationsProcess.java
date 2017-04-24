package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Date;

public class AdminManagementReservationsProcess extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");//admininfo
        String password = request.getParameter("password");//admininfo
        String resid = request.getParameter("resid");

        int resBy;
        String resType;
        String resourcesRes;
        String makemodel;
        Date resDate;
        Time outTime;
        Time inTime;
        String dest;
        int instNo;
        String resStatus;
        int resApprovedBy;
        String resCom;

        Reservations res = new Reservations();
        Member adminmem = new Member();
        Admin appby = new Admin();

        try{
            int ri = Integer.parseInt(resid);
            res.readFromDatabase(ri);

            resBy = res.getResBy();
            resType = res.getResType();
            resourcesRes = res.getResourcesRes();
            makemodel = res.getMakeModel();
            resDate = res.getResDate();
            outTime = res.getOutTime();
            inTime = res.getInTime();
            dest = res.getDest();
            instNo = res.getInstNo();
            resStatus = res.getResStatus();
            resApprovedBy = res.getResApprovedBy();
            resCom = res.getResCom();

            adminmem.readFromDatabase(username);
            int mi = adminmem.getMemId();
            appby.readFromDatabase(mi);
            int adid = appby.getAdminId();

            String showplane = resourcesRes + makemodel;

            String checked = "checked=\"checked\"";
            String selected = "selected";

            //set radio buttons
            resStatus = res.getResType();

            switch (resStatus) {
                case "PENDING":
                    request.getSession().setAttribute("PENDING" , checked);
                    break;
                case "APPROVED":
                    request.getSession().setAttribute("APPROVED" , checked);
                    break;
                case "REJECTED":
                    request.getSession().setAttribute("REJECTED" , checked);
                    break;
                default:
                    break;
            }

            request.getSession().setAttribute("ri" , ri);
            request.getSession().setAttribute("resBy" , resBy);
            request.getSession().setAttribute("resType" , resType);
            request.getSession().setAttribute("showplane" , showplane);
            request.getSession().setAttribute("makemodel" , makemodel);
            request.getSession().setAttribute("resDate" , resDate);
            request.getSession().setAttribute("outTime" , outTime);
            request.getSession().setAttribute("inTime" , inTime);
            request.getSession().setAttribute("dest" , dest);
            request.getSession().setAttribute("instNo" , instNo);
            request.getSession().setAttribute("resStatus" , resStatus);
            request.getSession().setAttribute("resApprovedBy" , resApprovedBy);
            request.getSession().setAttribute("resCom" , resCom);

            request.getSession().setAttribute("adid" , adid);
            request.getSession().setAttribute("username" , username);
            request.getSession().setAttribute("password" , password);
            request.getRequestDispatcher("/adminreservationsmanagementprocess.jsp").forward(request, response);

        }
            catch (Exception e2)
        {
            e2.printStackTrace();
        }
        finally{out.close();

        }

    }

}