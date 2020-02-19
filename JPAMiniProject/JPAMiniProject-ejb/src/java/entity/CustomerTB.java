/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shubham
 */
@Entity
@Table(name = "CustomerTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerTB.findAll", query = "SELECT c FROM CustomerTB c"),
    @NamedQuery(name = "CustomerTB.findByCustomerId", query = "SELECT c FROM CustomerTB c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "CustomerTB.findByFname", query = "SELECT c FROM CustomerTB c WHERE c.fname = :fname"),
    @NamedQuery(name = "CustomerTB.findByLname", query = "SELECT c FROM CustomerTB c WHERE c.lname = :lname")})
public class CustomerTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CustomerId")
    private Integer customerId;
    @Basic(optional = false)
    @Column(name = "Fname")
    private String fname;
    @Basic(optional = false)
    @Column(name = "Lname")
    private String lname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<AddressTB> addressTBCollection;

    public CustomerTB() {
    }

    public CustomerTB(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerTB(Integer customerId, String fname, String lname) {
        this.customerId = customerId;
        this.fname = fname;
        this.lname = lname;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @XmlTransient
    public Collection<AddressTB> getAddressTBCollection() {
        return addressTBCollection;
    }

    public void setAddressTBCollection(Collection<AddressTB> addressTBCollection) {
        this.addressTBCollection = addressTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerTB)) {
            return false;
        }
        CustomerTB other = (CustomerTB) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CustomerTB[ customerId=" + customerId + " ]";
    }
    
}
