/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts.ui;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;

/**
 *
 * @author AlexandraFerreira 1140388
 */
public class PopUp extends javax.swing.JDialog {

    private String infoMostrar;

    private ContactController controller;

    private Timer timer = null;
    private long time;

    /**
     * Creates new form Dialog to the PopUp
     * 
     * @param parent the parent frame
     * @param modal a boolean modal
     * @param controller the contact controller
     * @param infoApresentar the message to show
     */
    public PopUp(Object parent, boolean modal, ContactController controller, String infoApresentar) {

        this.controller = controller;
        this.infoMostrar = infoApresentar;

        initComponents();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        txtInfo.setText(infoMostrar);

        timeTo();
    }

    /**
     * Set a timer to the window automatically disappear.
     */
    private void timeTo() {
        long eventMask = AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK;

        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            public void eventDispatched(AWTEvent e) {
                time = System.currentTimeMillis();
            }
        }, eventMask);

        time = System.currentTimeMillis();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (System.currentTimeMillis() - time > 5000) {
                        PopUp.this.dispose();
                        break;
                    }
                }
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtInfo.setColumns(20);
        txtInfo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtInfo.setRows(5);
        jScrollPane2.setViewportView(txtInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtInfo;
    // End of variables declaration//GEN-END:variables
}
