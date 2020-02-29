/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupplierServlet;

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
public class DisplaySupplier extends HttpServlet {

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
            out.println("<title>Servlet DisplaySupplier</title>");            
            out.println("</head>");
            out.println("<body>");
           
            String URL="jdbc:mysql://localhost/Jwd_7";
            String user="shubham1";
            String pass="shubham";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection(URL,user,pass);
                String name="";
                String sid=request.getParameter("sid");
                  String sql="select * from SupplierTB";
                
               
                  Statement stmt=cn.createStatement();
                  ResultSet rs =stmt.executeQuery(sql);
                  
                  out.println("<a href='SupplierForm'>Add New Supplier</a><br><hr>");
                  out.println("<center><table border=1><thead><tr><th>Supplier Name</th><th>Gender</th><th>Reports</th></tr></thead><tbody>");
                  
                  while(rs.next()){
                    out.println("<tr>");
                      
                    if(sid!=null){
                        if(sid.equals(rs.getString(1))){
                        name=rs.getString(2);
                        }
                    }
                      //out.println(rs.getInt(1));
                      out.println("<td>"+rs.getString(2)+"</td>");
                      out.println("<td>"+rs.getString(3)+"</td>");
                    
  

                      out.println("<td><a href='DisplaySupplier?sid="+rs.getInt(1)+"'>Purchase of this Supplier</a></td>");
//                       out.println("<td><a href='DeleteServlet?id="+rs.getInt(1)+"' >Delete</a></td>");

                     out.println("</tr>");
                      
                  }
                  out.println("</tbody></table></center>");
               
                  
                  if(sid!=null){
                      
                    String sql1="select p.Date, p.PurchaseId,p.Qty,i.ItemName,s.SupplierName from PurchaseTB p,ItemTB i,SupplierTB s where p.SupplierId=s.SupplierId and p.ItemId=i.ItemId and p.SupplierId="+sid;
                 
                 
                  
               
                  Statement stmt1=cn.createStatement();
                  ResultSet rss =stmt1.executeQuery(sql1);
                 
                 
                 
                 
                  
                  out.println("Supplier "+name+" wise purchase-<hr>");
                  out.println("<center><table border=1><thead><tr><th>Item Name</th><th>Supplier Name</th><th>Qty</th><th>Date</th></tr></thead><tbody>");
                  
                  while(rss.next()){
                    out.println("<tr>");
                      
                   
                      out.println("<td>"+rss.getString(4)+"</td>");
                     out.println("<td>"+rss.getString(5)+"</td>");
                     out.println("<td>"+rss.getString(3)+"</td>");
                      out.println("<td>"+rss.getString(1)+"</td>");

                     out.println("</tr>");
                      
                  }
                  out.println("</tbody></table></center>");
               
                
                stmt.close();
                      
                  }
                
                stmt.close();
                cn.close();
                
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
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
