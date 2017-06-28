
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class SubscriptionListUI extends javax.swing.JFrame {
    
    /**
     * Creates new form NewJFrame
     */
    
    private SubscriptionCtrl subCtrl;
    private ArrayList<Subscription> subUIList;
    
    public SubscriptionListUI(SubscriptionCtrl subCtrl) {
        this.subCtrl = subCtrl;
        this.subUIList = subCtrl.subList.getSubscriptionList();
        this.setTitle("Simple MVC Application");
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

        jScrollPane3 = new javax.swing.JScrollPane();
        subTable = new javax.swing.JTable();
        newButton = new javax.swing.JButton();
        viewDetail = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        subTable.setModel(new SubscriptionTableModel(subCtrl.subList.getSubscriptionList()));
        subTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(subTable);
        subTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        newButton.setText("New");
        newButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newButtonMouseClicked(evt);
            }
        });

        viewDetail.setText("Detail");
        viewDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewDetailMouseClicked(evt);
            }
        });

        exitButton.setText("Done");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(viewDetail)
                    .addComponent(exitButton)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewDetailMouseClicked
       
        if(subTable.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please select a row to proceed", "Error", HEIGHT);
        } else {
            int selectedTableRow = subTable.getSelectedRow();
            int selectedModelRow = subTable.convertRowIndexToModel(selectedTableRow);
            SubscriptionListUI.this.subCtrl.getSubscriptionListDetail(selectedModelRow); 
        }
        
    }//GEN-LAST:event_viewDetailMouseClicked

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        
        SubscriptionListUI.this.dispose();
        
    }//GEN-LAST:event_exitButtonMouseClicked

    private void newButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newButtonMouseClicked
        SubscriptionListUI.this.subCtrl.getSubscriptionNew();
    }//GEN-LAST:event_newButtonMouseClicked
    
    private void printCurrentSubscriptions() {
        
        // Print current arraylist
        System.out.println("List of Subscriptions in the ArrayList");
        for(Subscription i : subUIList) {
            System.out.println(i.getSubscriptionName() + " " + i.getSubscriptionPrice() + " " + i.getSubscriptionDate());
        }
        System.out.println("--------------------------------------------");
    }
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton newButton;
    private javax.swing.JTable subTable;
    private javax.swing.JButton viewDetail;
    // End of variables declaration//GEN-END:variables
}
