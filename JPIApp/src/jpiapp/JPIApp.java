/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpiapp;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author shubham
 */
public class JPIApp {

    /**;
     * @param args the command line arguments
     */
    EntityManagerFactory emf;
    EntityManager em;
    Collection<EmpTB> emps;

    public JPIApp() {
        emf=Persistence.createEntityManagerFactory("JPIAppPU");
        em=emf.createEntityManager();
        
    }
    Collection<EmpTB> showall(){
        
        emps= em.createNamedQuery("EmpTB.findAll").getResultList();
        for (EmpTB e : emps) {
            System.out.println(e.getEmployeeName()+ " "+e.getPassword());
            
            
        }
        return emps;
        
    }
    
    void AddEmp(String ename,String pass){
        EmpTB e=new EmpTB();
        e.setEmployeeName(ename);
        e.setPassword(pass);
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }
    
    void UpdateEmp(int id,String ename,String pass){
        EmpTB e=(EmpTB)em.find(EmpTB.class,id);
        
        e.setEmployeeName(ename);
        e.setPassword(pass);
        em.getTransaction().begin();
        //em.persist(e);
        em.merge(e);
        em.getTransaction().commit();
    }
    void removeemp(int id){
        EmpTB e=(EmpTB)em.find(EmpTB.class,id);

        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        JPIApp japp =new JPIApp();
       // japp.AddEmp("Snehal", "vvcvx");
        japp.UpdateEmp(2, "Bhavik", "ittyuti");
        
        japp.showall();
       japp.removeemp(1);
       japp.showall();
    }
    
}
