/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpiapp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shubham
 */
@Entity
@Table(name = "EmpTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpTB.findAll", query = "SELECT e FROM EmpTB e"),
    @NamedQuery(name = "EmpTB.findByEmpID", query = "SELECT e FROM EmpTB e WHERE e.empID = :empID"),
    @NamedQuery(name = "EmpTB.findByEmployeeName", query = "SELECT e FROM EmpTB e WHERE e.employeeName = :employeeName"),
    @NamedQuery(name = "EmpTB.findByPassword", query = "SELECT e FROM EmpTB e WHERE e.password = :password")})
public class EmpTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EmpID")
    private Integer empID;
    @Basic(optional = false)
    @Column(name = "EmployeeName")
    private String employeeName;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;

    public EmpTB() {
    }

    public EmpTB(Integer empID) {
        this.empID = empID;
    }

    public EmpTB(Integer empID, String employeeName, String password) {
        this.empID = empID;
        this.employeeName = employeeName;
        this.password = password;
    }

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empID != null ? empID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpTB)) {
            return false;
        }
        EmpTB other = (EmpTB) object;
        if ((this.empID == null && other.empID != null) || (this.empID != null && !this.empID.equals(other.empID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpiapp.EmpTB[ empID=" + empID + " ]";
    }
    
    
}
