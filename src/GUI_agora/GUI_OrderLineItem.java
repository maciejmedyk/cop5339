/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_agora;

import FNC_agora.Customer;
import FNC_agora.Product;
import java.text.DecimalFormat;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class GUI_OrderLineItem extends javax.swing.JPanel {

    /**
     * Creates new form GUI_LineItem
     * @param p
     */
    public GUI_OrderLineItem(Product p, Customer c) {
        initComponents();
        mP = p;
        mC = c;
        mName.setText(p.getProductName());
        mCategory.setText(p.getCategory());
        mQuantity.setText(Integer.toString(p.getQuantity()));
        double total = p.getQuantity() * p.getSellPrice();
        DecimalFormat df = new DecimalFormat("####0.00");
        mTotal.setText(df.format(total));
        mCustomer.setText(c.getFullName());
    }

    public GUI_OrderLineItem() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        mName = new javax.swing.JLabel();
        mCustomer = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        mQuantity = new javax.swing.JLabel();
        mTotal = new javax.swing.JLabel();
        mCategory = new javax.swing.JLabel();

        setBackground(new java.awt.Color(224, 227, 233));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mName.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        mName.setForeground(new java.awt.Color(51, 51, 255));
        mName.setText("ProductName");
        add(mName, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        mCustomer.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        mCustomer.setText("Customer");
        add(mCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, -1, -1));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 3));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 700, 3));

        mQuantity.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        mQuantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mQuantity.setText("Quantity");
        add(mQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        mTotal.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        mTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mTotal.setText("Total");
        add(mTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        mCategory.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        mCategory.setText("Category");
        add(mCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel mCategory;
    private javax.swing.JLabel mCustomer;
    private javax.swing.JLabel mName;
    private javax.swing.JLabel mQuantity;
    private javax.swing.JLabel mTotal;
    // End of variables declaration//GEN-END:variables
    private Product mP;
    private Customer mC;
}
