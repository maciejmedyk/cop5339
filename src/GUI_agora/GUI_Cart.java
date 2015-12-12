/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_agora;

import FNC_agora.Cart;
import FNC_agora.Customer;
import FNC_agora.Product;
import FNC_agora.Vendor;
import java.awt.BorderLayout;
import static java.awt.Component.LEFT_ALIGNMENT;
import static java.awt.Component.TOP_ALIGNMENT;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Maciej Medyk and Caio Farias
 */
public class GUI_Cart extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUI_AddProduct
     */
    public GUI_Cart(GUI_BrowseItems bi) {

        initComponents(); 
        mBi = bi;
        Customer c = Agora.um.cLoggedUser;
        ArrayList<Product> ct = c.getCart().getCartItems();
        mpanel = new JPanel();
        npanel = new JPanel();
        mpanel.setLayout(new BoxLayout(mpanel, BoxLayout.Y_AXIS));
        npanel.setLayout(new BorderLayout());
        mpanel.setAlignmentX(LEFT_ALIGNMENT);
        mpanel.setAlignmentY(TOP_ALIGNMENT);
        for(Product p : ct)
        {
            if (p.getQuantity() > 0)
            {
                item = new GUI_CartLineItem(p, this, mBi);
                mpanel.add(item);
                mpanel.setAlignmentX(LEFT_ALIGNMENT);
                mpanel.setAlignmentY(TOP_ALIGNMENT);
            }
        }
        npanel.add(mpanel, BorderLayout.NORTH);
        mainPanel.getViewport().add(npanel);
        DecimalFormat df = new DecimalFormat("####0.00");
        mCartTotal.setText('$' + df.format(c.getCart().getCartAmount()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JScrollPane();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mCartTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cart");
        setAlignmentX(300.0F);
        setAlignmentY(300.0F);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        mLabel.setForeground(new java.awt.Color(255, 0, 0));
        mLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mainPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jButton2.setText("Checkout");
        jButton2.setToolTipText("Go To Checkout Button");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Product Name                                                                                                   Unit Price        Qty       Total Price        Qty");

        mCartTotal.setEditable(false);
        mCartTotal.setBackground(new java.awt.Color(232, 232, 232));
        mCartTotal.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        mCartTotal.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        mCartTotal.setText("$0.00");

        jLabel2.setText("Total Cart Price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 249, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainPanel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mCartTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mCartTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(2, 2, 2)
                .addComponent(mLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Cart c = Agora.um.cLoggedUser.getCart();
        GUI_Checkout ct = new GUI_Checkout(c, this, mBi);
        ct.setLocation((Agora.desktop.getWidth() - ct.getWidth())/2,(Agora.desktop.getHeight() - ct.getHeight())/2);
        Agora.desktop.add(ct, new Integer(10));
        ct.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void serialization() throws IOException, ClassNotFoundException
    {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("agora.dat"));
        output.writeObject(Agora.um);
        output.close();
    }
    
    public void repaintMainPanel()
    {
        Vendor v = Agora.um.vLoggedUser;
        mpanel.removeAll();
        npanel.removeAll();
        Customer c = Agora.um.cLoggedUser;
        ArrayList<Product> ct = c.getCart().getCartItems();
        for(Product p : ct)
        {
            if (p.getQuantity() > 0)
            {
                item = new GUI_CartLineItem(p, this, mBi);
                mpanel.add(item);
                mpanel.setAlignmentX(LEFT_ALIGNMENT);
                mpanel.setAlignmentY(TOP_ALIGNMENT);
            }
        }
        npanel.add(mpanel, BorderLayout.NORTH);
        mainPanel.getViewport().add(npanel);
        mainPanel.getViewport().revalidate();
        mainPanel.getViewport().repaint();
        mBi.repaintMainPanel();
    }
    
    public void setCartTotal()
    {
        Customer c = Agora.um.cLoggedUser;
        DecimalFormat df = new DecimalFormat("####0.00");
        mCartTotal.setText('$' + df.format(c.getCart().getCartAmount()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField mCartTotal;
    private javax.swing.JLabel mLabel;
    private javax.swing.JScrollPane mainPanel;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel mpanel;
    private javax.swing.JPanel npanel;
    private GUI_CartLineItem item;
    private GUI_BrowseItems mBi;
}
