package FNC_agora;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class Vendor extends User implements Serializable
{
    public Vendor(String name, String email, String username, String password, String date)
    {
        super(name, email, username, password, date);
        inventory = new Inventory();
    }
    
    public void addToInventory(String name, String desc, String cat, double sp, double ip, int qty)
    {
        inventory.addProductToInventory(name, desc, cat, sp, ip, qty);
    }
    
    public ArrayList<Product> viewInventory()
    {
        return inventory.viewProducts();
    }
    
    private Inventory inventory;
}
