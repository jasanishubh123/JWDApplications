/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author shubham
 */
@Local
public interface currencyejbLocal {
     Collection<currency> getdata();
     Double Calculate(Double c1,Double c2,Double money);
}
