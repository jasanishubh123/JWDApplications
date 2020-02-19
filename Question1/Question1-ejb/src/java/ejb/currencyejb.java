/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;

/**
 *
 * @author shubham
 */
@Stateless
public class currencyejb implements currencyejbLocal {

    @Override
    public Collection<currency> getdata() {
             Connection con;
         
        Collection<currency> c=new ArrayList<currency>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/CurrencyConvertor", "shubham1","shubham");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from CurrencyTB");
            currency cr;
            while(rs.next()){
                cr=new currency();
                cr.setCid(rs.getInt(1));
                cr.setCurrencyName(rs.getString(2));
                cr.setCurrencyStandard(rs.getDouble(3));
                c.add(cr);
                
            }
            
            
        }catch(Exception e){
            System.out.println("Not  FOUND");
        }
        return c;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Double Calculate(Double from, Double to,Double money) {
       Double ans1=money/from;
       Double ans=ans1*to;
       return ans;
    }

    
}
