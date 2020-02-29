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
import javax.servlet.http.HttpSession;

/**
 *
 * @author snehal
 */
public class DisplayCartServlet extends HttpServlet {

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
            out.println("<title>Servlet DisplayCartServlet</title>");            
            out.println("</head>");
            out.println("<body>");
             HttpSession s=request.getSession();
           int uid= (int) s.getAttribute("userId");
           int cid=0;
           String sql="";
           String cdsql="";
           int ptotal=0;
           int qty=0;
           String price="";
           int prtotal=0;
            String URL = "jdbc:mysql://localhost/ComputerShoppingAppDB";
            String user = "snehal";
            String pass = "snehal";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection(URL,user,pass);
                   sql="select * from CartTB where UserId="+uid;
                  Statement stmt=cn.createStatement();
                  ResultSet rs =stmt.executeQuery(sql);
                  rs.absolute(1);
                  cid=rs.getInt(1);
                stmt.close();
                if(cid>0)
                {
                     cdsql="select cd.CartDetailId, p.ProductName,p.Price,cd.Qty from CartDetailTB cd,ProductTB p where p.ProductId=cd.ProductId and CartId="+cid;
                  Statement cdstmt=cn.createStatement();
                  ResultSet cdrs =cdstmt.executeQuery(cdsql);
                 out.println("<table border=1><thead><tr><th>ProductName</th>"
                         + "<th>Qty</th><th>Price</th><th>Total</th>"
                         + "<th> Edit Qty</th><th>Delete</th></tr></thead><tbody>");
                  
                  while(cdrs.next()){
                    out.println("<tr>");
                      
                      //out.println(rs.getInt(1));
                      out.println("<td>"+cdrs.getString(2)+"</td>");
                      out.println("<td>"+cdrs.getInt(4)+"</td>");
                      out.println("<td>"+cdrs.getString(3)+"</td>");
                      qty=cdrs.getInt(4);
                      price=cdrs.getString(3);
                      prtotal=qty*Integer.parseInt(price);
                      ptotal=ptotal+prtotal;
                      out.println("<td>"+prtotal+"</td>"); 

                     out.println("<td><a href='EditQtyFormServlet?cdid="+cdrs.getInt(1)+"'>Edit</a></td>");
                     out.println("<td><a href='DeleteProductFromCartServlet?cdid="+cdrs.getInt(1)+"'>Delete</a></td>");
                       

                     out.println("</tr>");
                    
                      
                  }
                  
                  out.println("</tbody></table>");
                   out.println("TOTAL:"+ptotal);
                stmt.close();
                }
                else{
                    out.println("No item in cart.");
                }
                out.println("<a href='AddToOrderServlet?ptotal="+ptotal+"'> Place Order </a>");
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
