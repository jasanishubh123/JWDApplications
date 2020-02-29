/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shubham
 */
public class FormServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormServlet</title>");
            out.println("</head>");
            out.println("<body>");
            String id = request.getParameter("id");
            String editusername="";
            String editpass="";
            String editdept="";

            if (id != null) {
                String URL = "jdbc:mysql://localhost/EmpDB";
                String user = "shubham1";
                String pass = "shubham";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection(URL, user, pass);

                    String sql = "select * from EmpTB where EmpID=" + id;

                    Statement stmt = cn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.absolute(1);
                    editusername = rs.getString(2);
                    editpass = rs.getString(3);
                    editdept=rs.getString(4);
                    stmt.close();
                    cn.close();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
            else{
                 id="0";
              }
            
            try{
                  String URL = "jdbc:mysql://localhost/EmpDB";
                String user = "shubham1";
                String pass = "shubham";
                String errName=(String)request.getAttribute("errName");
                if (errName==null){
                    errName="";
                }
                String errPass=(String)request.getAttribute("errPass");
                if (errPass==null){
                    errPass="";
                }
                
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection(URL, user, pass);

                    String sql = "select * from DeptTB";

                    Statement stmt = cn.createStatement();
                   
                    ResultSet rsd =stmt.executeQuery(sql);
                    out.println("<form method='post' action='addServlet'>");
                    out.println("<input type='hidden' name='txtEid' value='"+id+"'>");
                    out.println("Name:<input type='text' name='txtname' value='"+editusername+"'><label style=color:red;>"+errName+"</label><br>");
                    out.println("Password:<input type='password' name='txtpass' value='"+editpass+"'><label style=color:red;>"+errPass+"</label><br>");
                    out.println("Department:<select name='txtdept'>");
                    if(id != null){
                         while(rsd.next()){
                             if(rsd.getString(1) == null ? editdept == null : rsd.getString(1).equals(editdept)){
                                 out.println("<option value='"+rsd.getString(1)+"'selected >"+rsd.getString(2)+"</option>");
                             }
                             else{
                                 out.println("<option value='"+rsd.getString(1)+"' >"+rsd.getString(2)+"</option>");
                             }
                        
                    }
                    }else{
                         while(rsd.next()){
                        out.println("<option value='"+rsd.getString(1)+"'>"+rsd.getString(2)+"</option>");
                    }
                    }
                   
                    out.println("</select><br><input type='submit' name='btnsubmit' value='submit'>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");

                    stmt.close();
                    cn.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
           
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
