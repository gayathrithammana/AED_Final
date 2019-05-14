/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GovtEmployeeRole;

import Business.EcoSystem;
import Business.Enterprise.GovtEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.THCSDataAnalyserOrganization;
import Business.Organization.THCSDataCollectorOrganization;
import Business.Organization.THCSManagerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.RequestReportsWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mahitha
 */
public class RequestReportsJPanel extends javax.swing.JPanel {
    
    
    private JPanel userProcessContainer;
    private EcoSystem business;
    private Network network;
    private GovtEnterprise govtEnterprise;
    private UserAccount userAccount;
    

    /**
     * Creates new form RequestHospitalInfoJPanel
     */
    public RequestReportsJPanel(JPanel userProcessContainer, UserAccount account,GovtEnterprise govtEnterprise, EcoSystem business, Network network) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.network = network;
        this.govtEnterprise = govtEnterprise;
        this.userAccount = account;
//        enterpriseValue.setText(enterprise.getName());
//        usernameJLabel.setText(this.userAccount.getUsername());
//        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        requestReportsJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        requestReportsJTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 204));
        setPreferredSize(new java.awt.Dimension(794, 452));

        jLabel1.setText("Request Description");

        requestReportsJButton.setBackground(new java.awt.Color(255, 255, 255));
        requestReportsJButton.setText("Submit");
        requestReportsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestReportsJButtonActionPerformed(evt);
            }
        });

        backJButton.setBackground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< My Work Area");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Request Reports Form");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(backJButton)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(requestReportsJButton)
                            .addComponent(requestReportsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(jLabel2))
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(requestReportsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(requestReportsJButton)
                .addContainerGap(193, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestReportsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestReportsJButtonActionPerformed

        String message = requestReportsJTextField.getText();

        RequestReportsWorkRequest request = new RequestReportsWorkRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("In THCS Manager Queue");

        Organization THCSmanagerOrg = null;
        for (Organization organization : network.getTHCSEnterprise().getOrganizationDirectory().getOrganizationList()){
            
            if (organization instanceof THCSManagerOrganization){
                THCSmanagerOrg = organization;
            }
        }
        if (THCSmanagerOrg!=null){
            THCSmanagerOrg.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        JOptionPane.showMessageDialog(null, "Request successfully placed!!!");

    }//GEN-LAST:event_requestReportsJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        GovtEmployeeWorkAreaJPanel dcwajp = (GovtEmployeeWorkAreaJPanel) component;
        dcwajp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer); 

    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton requestReportsJButton;
    private javax.swing.JTextField requestReportsJTextField;
    // End of variables declaration//GEN-END:variables
}
