/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;
import lapr4.green.s1.ipc.n1151211.comm.CommExtension2;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.Notification;
import lapr4.red.s3.ipc.n1140388.chatrooms.PrivateChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.PublicChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.controller.ChatRoomApplicationController;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class CommunicationChatRoomUI extends javax.swing.JFrame implements Observer {

    private ChatRoom chatRoom;

    private ChatUser activeParticipant;

    private ChatRoomApplicationController controller;

    /**
     * Creates new form ChatRoomUI
     *
     * @param cntrl the controller
     * @param room the room chosen to communicate
     */
    public CommunicationChatRoomUI(ChatRoomApplicationController cntrl, ChatRoom room) {
        this.chatRoom = room;
        this.controller = cntrl;
        this.activeParticipant = controller.owner();

        if (activeParticipant != null) {

            initComponents();

            serverLabel.setText(chatRoom.name());

            this.controller.getListener().addObserver(this);
            Notification.chatInformer().addObserver(this);

            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "You need to be logged in order to communicate in a chat room!", "Not logged", JOptionPane.WARNING_MESSAGE);
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
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMessageArea = new javax.swing.JTextArea();
        sendBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        serverLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagesTextArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Type your message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.blue)); // NOI18N
        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtMessageArea.setColumns(20);
        txtMessageArea.setLineWrap(true);
        txtMessageArea.setRows(5);
        txtMessageArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(txtMessageArea);

        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Users List");

        serverLabel.setText("Server Name");

        messagesTextArea.setEditable(false);
        messagesTextArea.setColumns(20);
        messagesTextArea.setLineWrap(true);
        messagesTextArea.setRows(5);
        jScrollPane1.setViewportView(messagesTextArea);

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jScrollPane4.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(serverLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverLabel)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        if (!txtMessageArea.getText().isEmpty()) {
            String message = txtMessageArea.getText();
            //txtMessageArea.setText("");
            this.controller.sendMessage(chatRoom, message);
        }
    }//GEN-LAST:event_sendBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea messagesTextArea;
    private javax.swing.JButton sendBtn;
    private javax.swing.JLabel serverLabel;
    private javax.swing.JTextArea txtMessageArea;
    // End of variables declaration//GEN-END:variables
@Override
    public void update(Observable o, Object arg) {
        if (arg instanceof ChatRoom || arg instanceof PrivateChatRoom || arg instanceof PublicChatRoom) {
            ChatRoom chat = (ChatRoom) arg;
            String str = "";
            for (Message mess : chat.getLst_Conversations().getLst_Conversations()) {
                str += mess.toString();
            }

            messagesTextArea.setText(str);
        } else {
            ArrayList<String> peers = controller.getListener().getServicePeers(CommExtension2.NAME);

            for (String user : peers) {
                String tmp[] = user.split("@");

                String machineName = tmp[0] + "@";
                String id = tmp[1];

                ChatUser chatUser = new ChatUser(machineName, id);
                // controller.
                if (!this.controller.getUsers().containsKey(id)) {
                    chatUser.setStatus(true);
                    this.controller.addChatUser(chatUser);
                } else {
                    this.controller.getChatUsersList().getUserByIP(id).setStatus(true);
                }
            }

            for (ChatUser user : this.controller.getUsers().values()) {

                String aux = user.getMachineName() + user.getIp();
                if (!peers.contains(aux)) {
                    user.setStatus(false);
                }
            }

            updateList(this.controller.getChatUsersList().getUserList());
        }
    }

    public void updateList(HashMap<String, ChatUser> list) {

        DefaultListModel model = new DefaultListModel();

        for (ChatUser participant : list.values()) {
            if (chatRoom.hasParticipant(participant)) {
                if (participant.isOnline()) {
                    if (!participant.getNickname().equalsIgnoreCase("")) {
                        model.addElement(participant.getNickname() + "(Online)");
                    } else {
                        model.addElement(participant.getMachineName() + participant.getIp() + "(Online)");
                    }
                } else if (!participant.getNickname().equalsIgnoreCase("")) {
                    model.addElement(participant.getNickname() + "(Offline)");
                } else {
                    model.addElement(participant.getMachineName() + participant.getIp() + "(Offline)");
                }
            }
        }

        jList1.setModel(model);
    }

}
