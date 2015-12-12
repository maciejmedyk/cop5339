package FNC_agora;

import GUI_agora.Agora;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class Inventory implements Serializable
{
    public Inventory()
    {
        products = new ArrayList();
    }
    
    public void addProductToInventory(String name, String desc, String cat, double sp, double ip, int qty)
    {
        int rand = generateRandom();
        Product p = new Product(rand,name, desc, cat, sp, ip, qty);
        products.add(p);
    }
    
    public ArrayList<Product> viewProducts()
    {
        return products;
    }
    
    private int generateRandom()
    {
        int min = 1000000;
        int max = 9999999;
        Random rand = new Random();
        int randomNum = 0;
        int count = 0;
        while(count == 0)
        {
            randomNum = rand.nextInt((max - min) + 1) + min;
            ArrayList<Vendor> vl = Agora.um.getVendors();
            for(Vendor v : vl)
            {
                for(Product p : v.viewInventory())
                {
                    if(p.getProductID()== randomNum)
                    {
                        count++;
                    }
                }
            }
            if (count == 0) return randomNum;
        }
        return randomNum;
    }
    
    private ArrayList<Product> products;
}
