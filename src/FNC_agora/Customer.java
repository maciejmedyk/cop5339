package FNC_agora;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class Customer extends User implements Serializable
{
    public Customer(String name, String email, String username, String password, String date)
    {
        super(name, email, username, password, date);
        cart = new Cart();
        orders = new ArrayList<Order>();
    }
    
    public Cart getCart()
    {
        return cart;
    }
    
    public void addItemToCart(Product cp)
    {
        cart.addProductToCart(cp);
    }
    
    public void addOrder(Order o)
    {
        orders.add(o);
    }
    
    public ArrayList<Order> getOrders()
    {
        return orders;
    }
            
    private Cart cart;
    ArrayList<Order> orders;
}
