/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_agora;

import FNC_agora.Cart;
import FNC_agora.Customer;
import FNC_agora.Order;
import FNC_agora.Product;
import FNC_agora.Vendor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class GUI_AccountSummary extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUI_AddProduct
     */
    public GUI_AccountSummary() {
        initComponents();
        
        double revenues = 0;
        double costs = 0;
        double profits = 0;
        Vendor v = Agora.um.vLoggedUser;
        ArrayList<Product> mp = v.viewInventory();
        ArrayList<Customer> cs = Agora.um.getCustomers();
        for (Customer c : cs)
        {
            ArrayList<Order> os = c.getOrders();
            for (Order o : os)
            {
                Cart ct = o.getCart();
                ArrayList<Product> ps = ct.getCartItems();
                for (Product pi : ps)
                {
                    for (Product pj : mp)
                    {
                        if(pi.getProductID() == pj.getProductID())
                        {
                            double revenue = pi.getQuantity() * pi.getSellPrice();
                            revenues += revenue;
                            double cost = pi.getQuantity() * pi.getCostPrice();
                            costs += cost;
                        }
                    }
                }
            }
        }
        profits = revenues - costs;
        DecimalFormat df = new DecimalFormat("####0.00");
        mRevenues.setText(df.format(revenues));
        mCosts.setText(df.format(costs));
        mProfits.setText(df.format(profits));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mRevenues = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mCosts = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mProfits = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Account Summary");
        setAlignmentX(300.0F);
        setAlignmentY(300.0F);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        mRevenues.setEditable(false);
        mRevenues.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        mRevenues.setText("$0.00");
        mRevenues.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        mRevenues.setEnabled(false);
        mRevenues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRevenuesActionPerformed(evt);
            }
        });

        jLabel1.setText("Revenues");

        jLabel4.setText("Costs");

        mCosts.setEditable(false);
        mCosts.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        mCosts.setText("$0.00");
        mCosts.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        mCosts.setEnabled(false);
        mCosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCostsActionPerformed(evt);
            }
        });

        jLabel2.setText("Profits");

        mProfits.setEditable(false);
        mProfits.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        mProfits.setText("$0.00");
        mProfits.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        mProfits.setEnabled(false);
        mProfits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mProfitsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mCosts, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mProfits, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mRevenues, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mRevenues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mCosts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mProfits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mCostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCostsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mCostsActionPerformed

    private void mProfitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProfitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mProfitsActionPerformed

    private void mRevenuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRevenuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mRevenuesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField mCosts;
    private javax.swing.JTextField mProfits;
    private javax.swing.JTextField mRevenues;
    // End of variables declaration//GEN-END:variables
}
