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
 * @author snehal
 */
public class CityFormServlet extends HttpServlet {

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
            out.println("<title>Servlet CityFormServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String id = request.getParameter("cityid");
            String editCityname="";
            String editState="";
           
            if (id != null) {
                String URL = "jdbc:mysql://localhost/ComputerShoppingAppDB";
                String user = "snehal";
                String pass = "snehal";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection(URL, user, pass);

                    String sql = "select * from CityTB where CityId=" + id;

                    Statement stmt = cn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.absolute(1);
                    editCityname = rs.getString(2);
                    editState = rs.getString(3);
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
                  String URL = "jdbc:mysql://localhost/ComputerShoppingAppDB";
                String user = "snehal";
                String pass = "snehal";
                
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection cn = DriverManager.getConnection(URL, user, pass);

                    String ssql = "select * from StateTB";
                    Statement stmt = cn.createStatement();
                   
                    ResultSet rsb =stmt.executeQuery(ssql);                   
                    out.println("<form method='post' action='CityAddServlet'>");
                    out.println("<input type='hidden' name='txtCityid' value='"+id+"'>");
                    
                    out.println("City:<input type='text' name='txtCityname' value='"+editCityname+"'><br>");
                    out.println("State:<select name='txtstate'>");
                    if(id != null){
                         while(rsb.next()){
                             if(rsb.getString(1) == null ? editState == null : rsb.getString(1).equals(editState)){
                                 out.println("<option value='"+rsb.getString(1)+"'selected >"+rsb.getString(2)+"</option>");
                             }
                             else{
                                 out.println("<option value='"+rsb.getString(1)+"' >"+rsb.getString(2)+"</option>");
                             }
                        
                         }
                         }
                    else{
                         while(rsb.next()){
                        out.println("<option value='"+rsb.getString(1)+"'>"+rsb.getString(2)+"</option>");
                         }
                          
                    }
                    out.println("</select><br>");
                    out.println("<br><input type='submit' name='btnsubmit' value='Add City'>");
                    out.println("</form>");
                   

                    stmt.close();
                    cn.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }

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
