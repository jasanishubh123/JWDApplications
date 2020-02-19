/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.EmpTB;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author shubham
 */
@Local
public interface empBeanLocal {
    
    void  addBook(String ename,String pass,int did);
    void updateBook(int id,String ename,String pass,int did);
    void remove(int id);
    Collection<EmpTB> getdata();
    
}
