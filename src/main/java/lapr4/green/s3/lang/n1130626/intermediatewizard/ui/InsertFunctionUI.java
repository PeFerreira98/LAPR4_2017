/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1130626.intermediatewizard.ui;

import csheets.core.IllegalValueTypeException;
import csheets.core.formula.Formula;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import lapr4.green.s3.lang.n1130626.intermediatewizard.controller.InsertFunctionController;

/**
 *
 * @author Pedro Pereira
 */
public class InsertFunctionUI extends javax.swing.JFrame {

    //private final UIController uiController;
    
    private InsertFunctionController controller;
    
    DefaultListModel<Function> functionList;
    
    DefaultListModel<String> functionListString;
    
    Formula form = null;
    
    /**
     * Creates new form InsertFunctionUI
     * @param controller
     */
    public InsertFunctionUI(InsertFunctionController controller) {
        initComponents();
        this.controller = controller;
        //controller = new InsertFunctionController(uiController);
        this.functionList = new DefaultListModel<>();
        this.functionListString = new DefaultListModel<>();
        addFunctionsToList();
        this.jListFunctions.setModel(functionListString);
    }

    private void addFunctionsToList(){
        for(Function function : this.controller.getListSupportedFunctions()){
            this.functionList.addElement(function);
            this.functionListString.addElement(function.getIdentifier());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListFunctions = new javax.swing.JList<>();
        cancelButton = new javax.swing.JButton();
        previewLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        editFunctionText = new javax.swing.JTextField();
        previewButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();
        insertButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Insert function Wizard");

        jListFunctions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListFunctionsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListFunctions);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        previewLabel.setText("<SYNTAX OF FUNCTION SELECTED>");

        jLabel2.setText("Edit:");

        previewButton.setText("Preview");
        previewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Syntax:");

        jLabel4.setText("Result:");

        resultLabel.setText("<RESULT OF FUNCTION>");

        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editFunctionText, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(previewLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jLabel1)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previewLabel)
                    .addComponent(jLabel3)
                    .addComponent(helpButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editFunctionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(resultLabel)
                    .addComponent(previewButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(insertButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void jListFunctionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListFunctionsMouseClicked
        // TODO add your handling code here:
        int functionSelected = this.jListFunctions.getSelectedIndex();
        Function f = this.functionList.getElementAt(functionSelected);
        this.previewLabel.setText(buildSyntax(f, f.getPARAMETERS()));
        this.editFunctionText.setText(buildSyntax(f, f.getPARAMETERS()));
    }//GEN-LAST:event_jListFunctionsMouseClicked

    private void previewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewButtonActionPerformed
        // TODO add your handling code here:
        String data = this.editFunctionText.getText();
        
        try {
            form = controller.compileFormula(data);
            String text = form.evaluate().toString();
            this.resultLabel.setText(text);
        } catch (FormulaCompilationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            //Logger.getLogger(InsertFunctionUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalValueTypeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            //Logger.getLogger(InsertFunctionUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_previewButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        String data = this.editFunctionText.getText();
        try {
            form = controller.compileFormula(data);
            controller.copyContentToCell(data);
            dispose();
        } catch (FormulaCompilationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            //Logger.getLogger(InsertFunctionUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_insertButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        // TODO add your handling code here:
        String info = "";
        int functionSelected = this.jListFunctions.getSelectedIndex();
        Function f = this.functionList.getElementAt(functionSelected);
        for(FunctionParameter funcParam : f.getPARAMETERS()){
            info += "\n" + funcParam.getName() + " (" + funcParam.getValueType().name() + ") " + " : " + funcParam.getDescription();
        }
        JOptionPane.showMessageDialog(this, info);
    }//GEN-LAST:event_helpButtonActionPerformed

    /**
     * Method thats build a description a function with parameters.
     *
     * @param func
     * @param param
     * @return syntax String
     */
    public String buildSyntax(Function func, FunctionParameter param[]) {
        StringBuilder builder = new StringBuilder();
        int numParam = param.length;
        if (numParam > 0) {
            if (!this.jListFunctions.getValueIsAdjusting()) {
                builder.append("=");
                builder.append(func.getIdentifier());
                builder.append("(");
                for (int i = 0; i < numParam; i++) {
                    if (i > 0) {
                        builder.append(";");
                    }
                    builder.append(param[i].getValueType().toString());
                }
                builder.append(")");
                return builder.toString();
            }
        } else{
            builder.append("=");
            //this.jFunctionlbl.setText(func.getIdentifier());
            builder.append("(NUMBER)");
            return builder.toString();
        }
        return null;
    }
    
    
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField editFunctionText;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jListFunctions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton previewButton;
    private javax.swing.JLabel previewLabel;
    private javax.swing.JLabel resultLabel;
    // End of variables declaration//GEN-END:variables
}
