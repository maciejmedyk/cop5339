/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FNC_agora;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class Order implements Serializable
{
    
    public Order(Cart ct, Customer c)
    {
        mCart = ct;
        mCustomer = c;
        mTimestamp = new Date();   
    }
    
    public Cart getCart()
    {
        return mCart;
    }
    
    public Date getDate()
    {
        return mTimestamp;
    }
    
    public Customer getCustomer()
    {
        return mCustomer;
    }
    
    private Cart mCart;
    private Customer mCustomer;
    private Date mTimestamp;
}
