/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shubham
 */
public class Servlet1 extends HttpServlet {

    ArrayList<String> insertAll = new ArrayList<String>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");
            out.println("</head>");
            out.println("<body>");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/EmpDB");
                con.setAutoCommit(false);
                Statement stmt = con.createStatement();
                String uname = request.getParameter("uname");
                String pass = request.getParameter("pass");
                out.println(uname);
                String flag = request.getParameter("flag");
                out.println(flag);
                if (uname != null && pass != null) {
                    out.println("hell");

                    String s = "insert into EmpTB(EmployeeName,Password,DepartmentID)values('" + uname + "','" + pass + "',1)";
                    insertAll.add(s);
                    for (String q : insertAll) {
                        stmt.addBatch(q);

                        out.println(s);
                    }

                }

                if (flag.equals("1")) {
                    stmt.executeBatch();
                    out.print("Execute");
                    con.commit();
                    con.close();
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);

            }

            out.println("<form method=\"post\" action='Servlet1'>\n"
                    + "            Username :<input type=\"text\" name=\"uname\"><br>\n"
                    + "            Password :<input type=\"password\" name=\"pass\"><br>\n"
                    + "           <input type='submit' value='Add to Batch'/>"
                    + "            <br>\n"
                    + "           <a href='Servlet1?flag=1'>Execute Batch</a>"
                    + "        </form>");
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
