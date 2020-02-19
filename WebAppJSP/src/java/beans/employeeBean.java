/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author shubham
 */
public class employeeBean  implements  Serializable{
    
 private int empID;
 private String username,password;
 String errname;
 private  Connection conn;

    public int getEmpID() {
        return empID;
        
    }

    public employeeBean(){
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            
            
            
        }
        catch(Exception ex){   
        
            
        }
    }
    

    public void setEmpID(int empID) {
        this.empID = empID;
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
//        if(username.equals(this))
       
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
//    public String validate(){
//        
//        boolean valid=true;
//        if(username.length()<3)
//        {
//            return "Please Enter name length >3";
//        }
//        else{
//            return  ;
//        }
//        
//     
//        
//    }
    
    public int insert(){
        
        try {
            String sql="insert into EmpTB(EmployeeName,Password)values(?,?)";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setString(1,username);
            stm.setString(2,password);
            
        } catch (Exception e) {
        }
     return 0;
    }
    
    
}
