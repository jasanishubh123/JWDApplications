/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shubham
 */
@Entity
@Table(name = "AddressTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressTB.findAll", query = "SELECT a FROM AddressTB a"),
    @NamedQuery(name = "AddressTB.findByAddressId", query = "SELECT a FROM AddressTB a WHERE a.addressId = :addressId"),
    @NamedQuery(name = "AddressTB.findByStreet", query = "SELECT a FROM AddressTB a WHERE a.street = :street"),
    @NamedQuery(name = "AddressTB.findByCity", query = "SELECT a FROM AddressTB a WHERE a.city = :city"),
    @NamedQuery(name = "AddressTB.findByState", query = "SELECT a FROM AddressTB a WHERE a.state = :state"),
    @NamedQuery(name = "AddressTB.findByPincode", query = "SELECT a FROM AddressTB a WHERE a.pincode = :pincode")})
public class AddressTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AddressId")
    private Integer addressId;
    @Basic(optional = false)
    @Column(name = "Street")
    private String street;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @Column(name = "Pincode")
    private String pincode;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
    @ManyToOne(optional = false)
    private CustomerTB customerId;

    public AddressTB() {
    }

    public AddressTB(Integer addressId) {
        this.addressId = addressId;
    }

    public AddressTB(Integer addressId, String street, String city, String state, String pincode) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public CustomerTB getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerTB customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressTB)) {
            return false;
        }
        AddressTB other = (AddressTB) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AddressTB[ addressId=" + addressId + " ]";
    }
    
}
