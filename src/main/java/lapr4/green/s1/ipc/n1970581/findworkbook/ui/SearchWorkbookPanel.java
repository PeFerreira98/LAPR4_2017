/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1970581.findworkbook.ui;

import csheets.CleanSheets;
import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import lapr4.blue.s2.ipc.n1140948.advancedworkbooksearch.DescodificadorWorkbook;
import lapr4.blue.s2.ipc.n1140948.advancedworkbooksearch.controller.PreviewWorkbookController;
import lapr4.green.s1.ipc.n1970581.findworkbook.FileDTO;
import lapr4.green.s1.ipc.n1970581.findworkbook.SearchWorkbookExtension;
import lapr4.green.s1.ipc.n1970581.findworkbook.controller.SearchWorkbookController;

/**
 * Sidebar Pannel for use case: IPC01.1 Search Workbook
 * @author Hugo
 */
public class SearchWorkbookPanel extends javax.swing.JPanel implements Observer {

    /** The ui Controller of the main window */
    private UIController uiController;
    
    /** The Controller of the use case */
    private SearchWorkbookController controller;
    
    /** This pannel */
    SearchWorkbookPanel myselfPanel;
    
    /** file chooser object */
    private JFileChooser chooser;
    
    private final static String CHOOSER_TITLE = "Choose the search root directory";
    
    /** chosen root Directory*/
    private File rootDir;
    
    /** root directory path */
    private String rootDirPath;
    
    /** The defaultListModel */
    private DefaultListModel<FileDTO> defaultListModel;
    
    private DescodificadorWorkbook descWorkbook;
    private PreviewWorkbookController previewController;
    
    /**
     * Creates new form SearchWorkbookPanel
     * @param uiController the uiController
     */
    public SearchWorkbookPanel(UIController uiController) {
        this.uiController = uiController;
        this.controller = new SearchWorkbookController(uiController);
        initComponents();
        this.myselfPanel = this;
        this.defaultListModel = new DefaultListModel<FileDTO>();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRoot = new javax.swing.JButton();
        jTextFieldRoot = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jButtonOpen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListWorkbooks = new javax.swing.JList();
        PreviewWorkbookButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, SearchWorkbookExtension.NAME, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        setName(SearchWorkbookExtension.NAME);

        jButtonRoot.setText("Root");
        jButtonRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRootActionPerformed(evt);
            }
        });

        jTextFieldRoot.setEditable(false);
        jTextFieldRoot.setText("Press [Root] to select search directory...");

        jButtonSearch.setText("Search");
        jButtonSearch.setEnabled(false);
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonOpen.setText("Open");
        jButtonOpen.setEnabled(false);
        jButtonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenActionPerformed(evt);
            }
        });

        jListWorkbooks.setModel(new DefaultListModel<FileDTO>());
        jListWorkbooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListWorkbooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListWorkbooks);

        PreviewWorkbookButton.setText("Preview");
        PreviewWorkbookButton.setEnabled(false);
        PreviewWorkbookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviewWorkbookButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PreviewWorkbookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRoot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRoot)
                    .addComponent(jTextFieldRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PreviewWorkbookButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOpen))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRootActionPerformed
        // TODO add your handling code here:
        chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new java.io.File("."));
        //chooser.setCurrentDirectory(new java.io.File("d:/testc/"));
        chooser.setDialogTitle(CHOOSER_TITLE);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(this);
        File dir = chooser.getSelectedFile();
        //System.out.println(file.toPath());
        if(!dir.isDirectory()){
            Logger.getGlobal().log(Level.SEVERE, "Directory chooser chose a non directory.");
            return;
        }
        this.rootDir = dir;
        this.rootDirPath = dir.getAbsolutePath();
        this.jTextFieldRoot.setText(rootDirPath);
        this.jButtonSearch.setEnabled(true);
    }//GEN-LAST:event_jButtonRootActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        ((DefaultListModel) this.jListWorkbooks.getModel()).clear();
        this.jButtonOpen.setEnabled(false);
        this.controller.search(rootDir, (Observer) this.myselfPanel);
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jListWorkbooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListWorkbooksMouseClicked
        // TODO add your handling code here:
        //System.out.println("mouse clicked!!!");
        boolean doubleClick = (evt.getClickCount() ==2);
        if (doubleClick) {
            //System.out.println("double");
            openWorkbook();
            
        }
        
    }//GEN-LAST:event_jListWorkbooksMouseClicked

    private void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenActionPerformed
        // TODO add your handling code here:
        if (this.jListWorkbooks.getSelectedValue() != null) openWorkbook();
    }//GEN-LAST:event_jButtonOpenActionPerformed

    private void PreviewWorkbookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviewWorkbookButtonActionPerformed
        // TODO add your handling code here:        
        FileDTO file = (FileDTO) jListWorkbooks.getSelectedValue();
        this.previewController = new PreviewWorkbookController(this, uiController);
        previewController.getPreviousWorkbook();
        try {
            this.descWorkbook = new DescodificadorWorkbook(uiController.getActiveWorkbook(), file, myselfPanel);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SearchWorkbookPanel.class.getName()).log(Level.SEVERE, null, ex);
        }        
        if (this.jListWorkbooks.getSelectedValue() != null) {
            openWorkbook();
            try {
                previewController.previewFile(previewController.openFile(file), file);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SearchWorkbookPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }//GEN-LAST:event_PreviewWorkbookButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PreviewWorkbookButton;
    private javax.swing.JButton jButtonOpen;
    private javax.swing.JButton jButtonRoot;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JList jListWorkbooks;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldRoot;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public synchronized void  update(Observable o, Object arg) {
        if( !(arg instanceof FileDTO) ) return;
        FileDTO fileDTO = (FileDTO) arg;
        //System.out.println(fileDTO.toString());
        //Logger.getGlobal().log(Level.SEVERE, fileDTO.toString());
        //DefaultListModel lista = (DefaultListModel) this.jListWorkbooks.getModel();
        this.defaultListModel.addElement(fileDTO);
        ((DefaultListModel) this.jListWorkbooks.getModel()).addElement(arg);
        this.jButtonOpen.setEnabled(true);
        this.PreviewWorkbookButton.setEnabled(true);
    }
    
    /**
     * CUSTOM: Calls the controller to open the workbook.
     */
    public void openWorkbook(){
        int index = this.jListWorkbooks.getSelectedIndex();
        Object obj =  this.jListWorkbooks.getSelectedValue();
        if(obj == null) {
            //throw new NullPointerException("null returned from this.jListWorkbooks.getSelectedValue() while opening woorkbook");
            JOptionPane.showMessageDialog(this.myselfPanel, "Null workbook selected from list", "Error" , JOptionPane.ERROR_MESSAGE);
            return;
        }
        FileDTO fileDTO = (FileDTO) this.jListWorkbooks.getSelectedValue();
        
        /* Not needed, when it opens, it doesn't discard the other open workbooks.
        boolean modified = true;
        modified = this.controller.isActiveWorkbookModified();
        int answer = 0;  // NO = 1 , YES = 0
        if(modified) answer = JOptionPane.showConfirmDialog(this.myselfPanel, "Unsaved Modifications Detected. Still wish to open?", "Title" , JOptionPane.YES_NO_OPTION);
        System.out.println("Anser:" + answer);
        */
        
        
        this.controller.openWorkbook(fileDTO);
    }
    
}
