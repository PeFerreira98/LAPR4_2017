/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.ui;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
import lapr4.red.s3.ipc.n1140388.chatrooms.Notification;
import lapr4.red.s3.ipc.n1140388.chatrooms.controller.ChatRoomApplicationController;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class JoinRoomUI extends javax.swing.JFrame implements Observer {

    /**
     * The Login Participant Controller
     */
    private ChatRoomApplicationController controller;

    private ChatUser activeParticipant;

    /**
     * Creates new form JoinRoomUI
     *
     * @param controller the controller
     */
    public JoinRoomUI(ChatRoomApplicationController controller) {

        this.controller = controller;

        activeParticipant = controller.owner();

        if (activeParticipant != null) {
            initComponents();

            Object[] publicRooms = new Object[controller.getRoomsList().publicRoomsWithoutParticipant(activeParticipant).size()];

            for (int i = 0; i < publicRooms.length; i++) {
                publicRooms[i] = controller.getRoomsList().publicRoomsWithoutParticipant(activeParticipant).get(i).name();
            }

            publicList.setListData(publicRooms);
            publicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            Object[] privateRooms = new Object[controller.getRoomsList().privateRoomsWithInvationWithoutParticipant(activeParticipant).size()];

            for (int i = 0; i < privateRooms.length; i++) {
                privateRooms[i] = controller.getRoomsList().privateRoomsWithInvationWithoutParticipant(activeParticipant).get(i).name();
            }

            privateList.setListData(privateRooms);
            privateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            this.controller.getListener().addObserver(this);

            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "You need to be logged in order to join a chat room!", "Not logged", JOptionPane.WARNING_MESSAGE);
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPublicRooms = new javax.swing.JLabel();
        lblPrivateRooms = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        publicList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        privateList = new javax.swing.JList();
        btnAccept = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblPublicRooms.setText("Public Rooms");

        lblPrivateRooms.setText("PrivateRooms");

        publicList.setModel(new javax.swing.DefaultListModel<>());
        if(publicList.getSelectedValue()!=null){
            btnReject.setVisible(false);
        }
        jScrollPane1.setViewportView(publicList);

        privateList.setModel(new javax.swing.DefaultListModel<>());
        if(privateList.getSelectedValue()!=null){
            btnReject.setVisible(true);
        }
        jScrollPane2.setViewportView(privateList);

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        jLabel1.setText("INVITATIONS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lblPublicRooms)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPrivateRooms)
                .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnAccept)
                        .addGap(59, 59, 59)
                        .addComponent(btnReject)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPublicRooms)
                            .addComponent(lblPrivateRooms))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 115, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAccept)
                            .addComponent(btnReject))
                        .addGap(35, 35, 35))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        if (privateList.getSelectedValue() != null
                && publicList.getSelectedValue() != null) {
            JOptionPane.showMessageDialog(this, "You can't select two chat rooms!",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else if (privateList.getSelectedValue() == null
                && publicList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "You need to select one chat room!",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else if (privateList.getSelectedValue() != null) {
            boolean verify = controller.joinChatRoom(controller.getRoomsList().findChatRoomByName((String) privateList.getSelectedValue()));
            if (verify) {
                JOptionPane.showMessageDialog(this, "You join this Chat Room!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "You are already in this Chat Room!",
                        "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (publicList.getSelectedValue() != null) {
            boolean verify = controller.joinChatRoom(controller.getRoomsList().findChatRoomByName((String) publicList.getSelectedValue()));
            if (verify) {
                JOptionPane.showMessageDialog(this, "You join this Chat Room!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "You are already in this Chat Room!",
                        "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        Notification.chatInformer().notifyChange(controller);
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        if (privateList.getSelectedValue() != null
                && publicList.getSelectedValue() != null) {
            JOptionPane.showMessageDialog(this, "You can't select two chat rooms!",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else if (privateList.getSelectedValue() == null
                && publicList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "You need to select one chat room!",
                    "Error", JOptionPane.WARNING_MESSAGE);
        } else if (privateList.getSelectedValue() != null) {
            boolean verify = controller.rejectChatRoom(controller.getRoomsList().findChatRoomByName((String) privateList.getSelectedValue()));
            if (verify) {
                JOptionPane.showMessageDialog(this, "You rejected this Chat Room!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (publicList.getSelectedValue() != null) {
            boolean verify = controller.rejectChatRoom(controller.getRoomsList().findChatRoomByName((String) publicList.getSelectedValue()));
            if (verify) {
                JOptionPane.showMessageDialog(this, "You rejected this Chat Room!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        Notification.chatInformer().notifyChange(controller);
    }//GEN-LAST:event_btnRejectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnReject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPrivateRooms;
    private javax.swing.JLabel lblPublicRooms;
    private javax.swing.JList privateList;
    private javax.swing.JList publicList;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        Object[] publicRooms = new Object[controller.getRoomsList().publicRoomsWithoutParticipant(activeParticipant).size()];

        for (int i = 0; i < publicRooms.length; i++) {
            publicRooms[i] = controller.getRoomsList().publicRoomsWithoutParticipant(activeParticipant).get(i).name();
        }

        publicList.setListData(publicRooms);
        publicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        Object[] privateRooms = new Object[controller.getRoomsList().privateRoomsWithInvationWithoutParticipant(activeParticipant).size()];

        for (int i = 0; i < privateRooms.length; i++) {
            privateRooms[i] = controller.getRoomsList().privateRoomsWithInvationWithoutParticipant(activeParticipant).get(i).name();
        }

        privateList.setListData(privateRooms);
        privateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
