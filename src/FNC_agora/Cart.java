package FNC_agora;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class Cart implements Serializable
{
    public Cart()
    {
        products = new ArrayList();
    }
    
    public void addProductToCart(Product cp)
    {
        products.add(cp);
    }
   
    public ArrayList<Product> getCartItems()
    {
        return products;
    }  
    
    public Cart clone()
    {
        Cart n = new Cart();
        for(Product p : this.products)
        {
            n.products.add(p.getClone());
        }
        return n;
    }
    
    public void clear()
    {
        products.clear();
    }
    
    public double getCartAmount()
    {
        double amount = 0;
        
        for (Product p : products)
        {
            double price = p.getSellPrice();
            int qty = p.getQuantity();
            amount += price * qty;
        }
        return amount;
    }
    
    ArrayList<Product> products;
}
