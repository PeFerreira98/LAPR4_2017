/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import lapr4.green.s1.ipc.n1151211.comm.CommExtension2;
import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.EchoReply;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author Fernando
 */
public class CommPing extends JFrame implements CommHandler2 {

    private static final int WINDOW_WIDTH = 200;

    private static final int WINDOW_HEIGHT = 350;

    private DefaultListModel<String> listModel = new DefaultListModel<>();

    private JList<String> peerList;

    private JButton btPing;
    private JScrollPane scrollPane;
    private JLabel answer;
    
    private ClientTestAction2 controller;

    public CommPing(ClientTestAction2 cntrl) {

        super("Ping Peers");

        controller = cntrl;

        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        buildComponents();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setMaximumSize(dim);
        setResizable(false);
        setVisible(true);
    }

    private void buildComponents() {
        makeButton();
        JPanel pNorth = new JPanel();
        pNorth.setBackground(Color.YELLOW);
        pNorth.add(btPing);
        add(pNorth, BorderLayout.NORTH);
        
        JPanel pSouth = new JPanel();

        answer = new JLabel("answer", JLabel.CENTER );
        pSouth.add(answer);
        add(pSouth, BorderLayout.SOUTH);

        //create the list
        peerList = new JList<>(listModel);
        peerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(peerList);

        add(scrollPane);

    }

    private void makeButton() {

        btPing = new JButton("Ping");
        btPing.setForeground(Color.BLUE);
        final int BUTTON_WIDTH = 80, BUTTON_ALTURA = 50;
        btPing.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_ALTURA));

        /* 
         * Regista uma classe interna anónima destinada a executar o método de 
         * evento depois do botão bt1 ser acionado.  
         */
        btPing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oneSelected = peerList.getSelectedValue();

                if (oneSelected != null) {
                    controller.doPing( oneSelected );
                }
            }
        });

    }

    void updatePeers(ArrayList<String> peers) {
        if (listModel.isEmpty() && peers.isEmpty()) {
            return;
        } else if (peers.isEmpty()) {
            listModel.clear();
        } else {

            if (theSamePeers(peers)) {
                return;
            }

            String selected = null;
            selected = peerList.getSelectedValue();

            listModel.clear();
            for (int i = 0; i < peers.size(); ++i) {
                listModel.add(i, peers.get(i));
            }
            if (selected != null && listModel.contains(selected)) {
                peerList.setSelectedValue(selected, false);
            }
        }

    }

    private boolean theSamePeers(ArrayList<String> peers) {
        if (peers.size() != listModel.size()) {
            return false;
        }

        boolean same = true;
        for (int i = 0; i < peers.size(); ++i) {
            same = peers.get(i).equals(listModel.get(i));
            if (!same) {
                break;
            }
        }

        return same;
    }

    @Override
    public void handleDTO(Object dto, SendDto commWorker) {
        EchoReply echoReply = (EchoReply)dto;
        answer.setText(echoReply.whoAsk() + " <-> " + echoReply.whoAnswered() + " : " + echoReply.theRequest() );
    }

    @Override
    public Object getLastReceivedDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void communicationFailure() {
        answer.setText( "communication failure");
    }

}
