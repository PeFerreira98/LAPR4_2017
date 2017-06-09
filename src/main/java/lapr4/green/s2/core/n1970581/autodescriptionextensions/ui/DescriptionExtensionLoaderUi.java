/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import lapr4.green.s2.core.n1970581.autodescriptionextensions.ExtensionDTO;
import lapr4.green.s2.core.n1970581.autodescriptionextensions.controller.DescriptionExtensionLoaderController;

/**
 *
 * @author Hugo
 */
public class DescriptionExtensionLoaderUi extends javax.swing.JFrame {

    /** The controller for  the UI */
    private final DescriptionExtensionLoaderController ctrl;
    
    /**
     * Creates new form DescriptionExtensionLoaderUi
     * @param ctrl The controller for  the UI
     */
    public DescriptionExtensionLoaderUi(DescriptionExtensionLoaderController ctrl, List<ExtensionDTO> allExtensionsList , List<ExtensionDTO> defaultLoadList ) {
        this.ctrl = ctrl;
        initComponents();
        for(ExtensionDTO exDTO : allExtensionsList){ ((DefaultListModel) this.jListAllExtensions.getModel()).addElement(exDTO);}
        for(ExtensionDTO exDTO : defaultLoadList){ ((DefaultListModel) this.jListListToload.getModel()).addElement(exDTO);}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAccept = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAllExtensions = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListListToload = new javax.swing.JList();
        jButtonAbort = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaInfo = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Versionated Extension Loader");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jButtonAccept.setBackground(new java.awt.Color(204, 255, 204));
        jButtonAccept.setText("Accept");

        jListAllExtensions.setModel(new DefaultListModel<ExtensionDTO>());
        jListAllExtensions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAllExtensionsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListAllExtensions);

        jListListToload.setModel(new DefaultListModel<ExtensionDTO>());
        jScrollPane2.setViewportView(jListListToload);

        jButtonAbort.setBackground(new java.awt.Color(255, 255, 0));
        jButtonAbort.setText("Use old loading system");

        jTextAreaInfo.setColumns(20);
        jTextAreaInfo.setRows(5);
        jScrollPane3.setViewportView(jTextAreaInfo);

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setText("ADD");

        jButton4.setBackground(new java.awt.Color(255, 153, 153));
        jButton4.setText("REMOVE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(77, 77, 77))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAbort)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonAccept)
                                        .addGap(18, 18, 18)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAbort)
                    .addComponent(jButtonAccept))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListAllExtensionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAllExtensionsMouseClicked
        // TODO add your handling code here:
        ExtensionDTO dto = (ExtensionDTO) this.jListAllExtensions.getSelectedValue();
        if (dto != null){
            String name = dto.getName();
            int version = dto.version();
            String desc = dto.description();
            String className = dto.className();
            String text = "Name: " + name + " Version: " + version + "\n" + "Class: " + className + "\nDescription: " + desc;
            this.jTextAreaInfo.setText(text);
        }
    }//GEN-LAST:event_jListAllExtensionsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DescriptionExtensionLoaderUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DescriptionExtensionLoaderUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DescriptionExtensionLoaderUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DescriptionExtensionLoaderUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DescriptionExtensionLoaderUi(null, new ArrayList<ExtensionDTO>(),new ArrayList<ExtensionDTO>() ).setVisible(true);
                System.out.println("ERROR DONT USE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("ERROR DONT USE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("ERROR DONT USE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("ERROR DONT USE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("ERROR DONT USE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("ERROR DONT USE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAbort;
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JList jListAllExtensions;
    private javax.swing.JList jListListToload;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaInfo;
    // End of variables declaration//GEN-END:variables
}
