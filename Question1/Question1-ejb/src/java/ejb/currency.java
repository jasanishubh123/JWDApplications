/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

/**
 *
 * @author shubham
 */
public class currency {
     
    int Cid;

    public int getCid() {
        return Cid;
    }

    public void setCid(int Cid) {
        this.Cid = Cid;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String CurrencyName) {
        this.CurrencyName = CurrencyName;
    }

    public Double getCurrencyStandard() {
        return CurrencyStandard;
    }

    public void setCurrencyStandard(Double CurrencyStandard) {
        this.CurrencyStandard = CurrencyStandard;
    }
    String CurrencyName;
    Double CurrencyStandard;
   
    
}
