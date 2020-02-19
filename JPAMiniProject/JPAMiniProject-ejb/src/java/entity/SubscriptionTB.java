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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shubham
 */
@Entity
@Table(name = "SubscriptionTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubscriptionTB.findAll", query = "SELECT s FROM SubscriptionTB s"),
    @NamedQuery(name = "SubscriptionTB.findBySubScriptionId", query = "SELECT s FROM SubscriptionTB s WHERE s.subScriptionId = :subScriptionId"),
    @NamedQuery(name = "SubscriptionTB.findByTitle", query = "SELECT s FROM SubscriptionTB s WHERE s.title = :title"),
    @NamedQuery(name = "SubscriptionTB.findByType", query = "SELECT s FROM SubscriptionTB s WHERE s.type = :type")})
public class SubscriptionTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SubScriptionId")
    private Integer subScriptionId;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "Type")
    private String type;

    public SubscriptionTB() {
    }

    public SubscriptionTB(Integer subScriptionId) {
        this.subScriptionId = subScriptionId;
    }

    public SubscriptionTB(Integer subScriptionId, String title, String type) {
        this.subScriptionId = subScriptionId;
        this.title = title;
        this.type = type;
    }

    public Integer getSubScriptionId() {
        return subScriptionId;
    }

    public void setSubScriptionId(Integer subScriptionId) {
        this.subScriptionId = subScriptionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subScriptionId != null ? subScriptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubscriptionTB)) {
            return false;
        }
        SubscriptionTB other = (SubscriptionTB) object;
        if ((this.subScriptionId == null && other.subScriptionId != null) || (this.subScriptionId != null && !this.subScriptionId.equals(other.subScriptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SubscriptionTB[ subScriptionId=" + subScriptionId + " ]";
    }
    
}
