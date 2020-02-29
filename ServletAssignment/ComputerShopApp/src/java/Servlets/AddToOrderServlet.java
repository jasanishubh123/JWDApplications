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
import java.sql.PreparedStatement;
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
public class AddToOrderServlet extends HttpServlet {

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
            out.println("<title>Servlet AddToOrderServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           HttpSession s=request.getSession();
           int uid= (int) s.getAttribute("userId");
           String total=  request.getParameter("ptotal");
           String id="";
            String URL="jdbc:mysql://localhost/ComputerShoppingAppDB";
            String user="snehal";
            String pass="snehal";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection(URL,user,pass);
                String csql="";
                String cartid="";
                String sql="";
                String odsql="";
                String cdsql="";
                int pdrow=0;
                csql="select * from CartTB where UserId="+uid;
                Statement pstmt=cn.createStatement();
                ResultSet prs =pstmt.executeQuery(csql);
                prs.absolute(1);
                cartid = prs.getString(1);
                System.out.println(cartid);
                
                if(!cartid.equals(""))
                {
                    System.out.println("get data from cartdetail");
                    
                     sql="insert into OrderTB(UserId,Total)values(?,?)";
                     PreparedStatement stmt=cn.prepareStatement(sql);
                     stmt.setInt(1, uid );
                     stmt.setString(2, total );
                     int row=stmt.executeUpdate();
                     try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                     if (generatedKeys.next()) {

                         id = (String)generatedKeys.getString(1);
                        System.out.println("Inserted ID -" + id);
                     }
           
                    }
                     
                      if(row>0){
                    cdsql="select * from CartDetailTB where CartId="+cartid;
                    Statement cdstmt=cn.createStatement();
                    ResultSet cdrs =cdstmt.executeQuery(cdsql);
                    while(cdrs.next()){
                    String proid="";
                    int pqty=0;
                    String pprice="";
                      proid=cdrs.getString(3);
                      pqty=cdrs.getInt(4);
                      pprice=cdrs.getString(5);
                      
                      odsql="insert into OrderDetailTB(OrderId,ProductId,Qty,Price)values(?,?,?,?) ";
                      PreparedStatement odstmt=cn.prepareStatement(odsql);
                      odstmt.setString(1, id);
                      odstmt.setString(2, proid);
                      odstmt.setInt(3, pqty);
                      odstmt.setString(4, pprice);
                       pdrow=odstmt.executeUpdate();
                      
                  }

                     if(pdrow>0){
                       response.sendRedirect("CustomerHomePage");
                        System.out.println("succefully place your order");
                    }
                    cdstmt.close();
                      }
                       stmt.close();
                    
                }
                
                     pstmt.close();
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
