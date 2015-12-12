package FNC_agora;

import GUI_agora.Agora;
import GUI_agora.GUI_BrowseItems;
import GUI_agora.GUI_CreateAccount;
import GUI_agora.GUI_Login;
import GUI_agora.GUI_VendorInventory;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class UserManager implements Serializable
{
    public UserManager()
    {
        customers = new ArrayList();
        vendors = new ArrayList();
    }
    
    public void addVendor(String name, String email, String username, String password, String date)
    {
        Vendor v = new Vendor(name, email, username, password, date);
        vendors.add(v);
    }
    
    public void addCustomer(String name, String email, String username, String password, String date)
    {
        Customer v = new Customer(name, email, username, password, date);
        customers.add(v);
    }
    
    public ArrayList<Vendor> getVendors()
    {
        return vendors;
    }
    
    public Vendor getVendor(int i)
    {
        return vendors.get(i);
    }
    
    public Customer getCustomer(int i)
    {
        return customers.get(i);
    }
    
    public ArrayList<Customer> getCustomers()
    {
        return customers;
    }
    
    public int login(String username, String password)
    {
        for (Vendor user : vendors)
        {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                //System.out.println("Vendor logged in");
                vLoggedUser = user;
                loggedName = user.getFullName();
                Agora.desktop.removeAll();
                GUI_VendorInventory vi = new GUI_VendorInventory();
                Agora.desktop.add(vi);
                vi.setVisible(true);
                return 0;
            }
        }
        for (Customer user : customers)
        {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                //System.out.println("Customer logged in");
                loggedName = user.getFullName();
                cLoggedUser = user;
                Agora.desktop.removeAll();
                GUI_BrowseItems bi = new GUI_BrowseItems();
                Agora.desktop.add(bi);
                bi.setVisible(true);
                return 0;
            }
        }
        System.out.println("User not found");
        return 1;
    }
    
    public Customer cLoggedUser;
    public Vendor vLoggedUser;
    public String loggedName;
    private ArrayList<Vendor> vendors;
    private ArrayList<Customer> customers;
}
