package FNC_agora;

import GUI_agora.Agora;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class Product implements Serializable, Cloneable
{
    public Product(int pId, String name, String desc, String cat, double sp, double ip, int qty)
    {
        mProductID = pId;
        mProductName = name;
        mProductDesc = desc;
        mCategory = cat;
        mSellPrice = sp;
        mInvoicePrice = ip;
        mQuantity = qty;
    }
    
    public void changeProduct(String name, String desc, String cat, double sp, double ip, int qty)
    {
        mProductName = name;
        mProductDesc = desc;
        mCategory = cat;
        mSellPrice = sp;
        mInvoicePrice = ip;
        mQuantity = qty;
    }
    
    public String getProductName()
    {
        return mProductName;
    }
    
    public String getProductDec()
    {
        return mProductDesc;
    }
    
    public double getSellPrice()
    {
        return mSellPrice;
    }
    
    public double getCostPrice()
    {
        return mInvoicePrice;
    }
    
    public int getQuantity()
    {
        return mQuantity;
    }
    
    public String getCategory()
    {
        return mCategory;
    }
    
    public void setQuantity(int q)
    {
        mQuantity = q;
    }
    
    public int getProductID()
    {
        return mProductID;
    }
    
    public Product getClone() 
    {
        Product p = this;
        Product z = new Product(p.mProductID, p.mProductName, p.mProductDesc, p.mCategory, p.mSellPrice, p.mInvoicePrice, p.mQuantity);
        return z;

    }
 
    private int mProductID;
    private String mProductName;
    private String mProductDesc;
    private String mCategory;
    private double mSellPrice;
    private double mInvoicePrice;
    private int mQuantity;
}
