/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.EmpTB;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shubham
 */
@Stateless
public class empBean implements empBeanLocal {

    @PersistenceContext(unitName = "MyPU")
    EntityManager em;
    @Override
    public void addBook(String ename, String pass, int did) {
       EmpTB e=new EmpTB(ename,pass,did);
       em.persist(e);
    }

    @Override
    public void updateBook(int id, String ename, String pass, int did) {
       EmpTB e=(EmpTB)em.find(EmpTB.class,id);
       e.setEmployeeName(ename);
       e.setPassword(pass);
       e.setDepartmentID(did);
       em.merge(e);
       
        
    }

    @Override
    public void remove(int id) {
        EmpTB e=(EmpTB)em.find(EmpTB.class, id);
        em.remove(e);
    }

    @Override
    public Collection<EmpTB> getdata() {
       return em.createNamedQuery("EmpTB.findAll").getResultList();
    }
    
   
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
