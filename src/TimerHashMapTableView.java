
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class TimerHashMapTableView extends javax.swing.JFrame implements Display {

    /**
     * Creates new form TimerHashMapTableView
     */
    
    private TimerCtrl timerCtrl;
    private HashMap<Subscription, Timer> timerHashMap;
    
    public TimerHashMapTableView(TimerCtrl timerCtrl, HashMap timerHashMap) {
        this.timerCtrl = timerCtrl;
        this.timerHashMap = timerHashMap;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        timerTable = new javax.swing.JTable();
        newTimer = new javax.swing.JButton();
        viewTimer = new javax.swing.JButton();
        deleteTimer = new javax.swing.JButton();
        searchTimer = new javax.swing.JButton();
        exitFrame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        timerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        timerTable.setModel(new TimerHashMapTableModel(timerCtrl.currentTimerHashMap));
        timerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(timerTable);

        newTimer.setText("New");
        newTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTimerActionPerformed(evt);
            }
        });

        viewTimer.setText("Detail");
        viewTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTimerActionPerformed(evt);
            }
        });

        deleteTimer.setText("Delete");
        deleteTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTimerActionPerformed(evt);
            }
        });

        searchTimer.setText("Search");
        searchTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTimerActionPerformed(evt);
            }
        });

        exitFrame.setText("Done");
        exitFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(newTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(searchTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(exitFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTimer)
                    .addComponent(viewTimer)
                    .addComponent(deleteTimer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitFrame))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFrameActionPerformed
        TimerHashMapTableView.this.dispose();
    }//GEN-LAST:event_exitFrameActionPerformed

    private void newTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTimerActionPerformed
        TimerHashMapTableView.this.timerCtrl.getTimerNew(this.timerCtrl, this.timerHashMap);
        timerCtrl.saveCurrentTimer();
    }//GEN-LAST:event_newTimerActionPerformed

    private void viewTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTimerActionPerformed
        // View object
        if(timerTable.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please select a row to proceed", "Error", HEIGHT);
        } else {
            int selectedTableRow = timerTable.getSelectedRow();
            String tempTime = (String) timerTable.getValueAt(selectedTableRow, 0);
            for(Subscription temp : this.timerHashMap.keySet()) {
                if(this.timerHashMap.get(temp).getTime().equals(tempTime)) {
                    JOptionPane.showMessageDialog(rootPane, "Subscription Name: " +  temp.getSubscriptionName() + 
                            "\n" + "Alert Time: " + timerHashMap.get(temp).getTime() +
                            "\n" + "Alert Frequency: " + timerHashMap.get(temp).getAlertFrequency(), "Detail", HEIGHT);
                }
            }
        }
    }//GEN-LAST:event_viewTimerActionPerformed

    private void deleteTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTimerActionPerformed
        // Delete object
        if(timerTable.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please select a row to proceed", "Error", HEIGHT);
        } else {
            int selectedTableRow = timerTable.getSelectedRow();
            String tempTime = (String) timerTable.getValueAt(selectedTableRow, 0);
            // Delete object
            for(Subscription temp : this.timerHashMap.keySet()) {
                if(timerHashMap.get(temp).getTime().equals(tempTime)) {
                    this.timerCtrl.currentTimerHashMap.removeItem(temp);
                    this.timerCtrl.refreshTable(timerCtrl, timerCtrl.currentTimerHashMap.getMap());
                    System.out.println("Deleted Timer: " + temp.getSubscriptionName() + " Time: " + tempTime);
                    break;
                }
            }
        }
    }//GEN-LAST:event_deleteTimerActionPerformed

    private void searchTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTimerActionPerformed
        // Search object
        String name = JOptionPane.showInputDialog("Enter the name of the subscription you want to search");
        boolean found = false;
        if(name != null && !name.isEmpty()) {
            // Check if the sub exists
            if(this.timerHashMap.keySet().contains(new Subscription(name, 0, "1/1/1"))) {
                Timer temp = this.timerHashMap.get(new Subscription(name, 0, "1/1/1"));
                int row = 0;
                for(int i = 0; i < timerTable.getRowCount(); i++) {
                    if(timerTable.getValueAt(i, 0).equals(temp.getTime())) {
                        row = i;
                        timerTable.setRowSelectionInterval(0, row);
                        break;
                    }
                }        
                
                JOptionPane.showMessageDialog(rootPane, "Alert Time: " + temp.getTime() + 
                        "\n" + "Subscription Name: " + name + 
                        "\n" + "Alert Frequency: " +  temp.getAlertFrequency() + 
                        "\n" + "Row: " + row, "Found", HEIGHT);   
            } else {
                JOptionPane.showMessageDialog(rootPane, "Timer for subscription: " + name + " not found.", "Not Found", HEIGHT);
            }
        }
    }//GEN-LAST:event_searchTimerActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteTimer;
    private javax.swing.JButton exitFrame;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newTimer;
    private javax.swing.JButton searchTimer;
    private static javax.swing.JTable timerTable;
    private javax.swing.JButton viewTimer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showInformation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkNull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
