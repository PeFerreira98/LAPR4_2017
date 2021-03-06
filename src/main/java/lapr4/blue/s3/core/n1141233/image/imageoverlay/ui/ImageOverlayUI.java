package lapr4.blue.s3.core.n1141233.image.imageoverlay.ui;

import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lapr4.blue.s3.core.n1141233.image.imageoverlay.controller.ImageOverlayController;
import lapr4.blue.s3.core.n1141233.image.insertimage.ImagenableCell;

/**
 *
 * @author Rafael Vieira
 */
public class ImageOverlayUI extends javax.swing.JFrame
{

    private final ImageOverlayController controller;
    private int index;

    /**
     * Creates new form ImageOverlayUI
     *
     * @param cell currently being hovered cell
     * @param point location to open the window
     */
    public ImageOverlayUI(ImagenableCell cell, Point point)
    {
        initComponents();
        this.setLocation(point);

        // dont exit on close
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // dont exit on close

        this.index = 0;
        this.controller = new ImageOverlayController(cell);
        this.updateLabel();
        this.updateButtons();
        try
        {
            drawImage(controller.getImage());
        }
        catch (IOException ex)
        {
            warning("Couldn't load image");
        }

        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        imagePanel = new javax.swing.JPanel();
        imageIndex = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        previousButton.setText("<");
        previousButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setText(">");
        nextButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        imageIndex.setText("0/0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(previousButton)
                .addGap(18, 18, 18)
                .addComponent(imageIndex)
                .addGap(18, 18, 18)
                .addComponent(nextButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(nextButton)
                    .addComponent(imageIndex))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_previousButtonActionPerformed
    {//GEN-HEADEREND:event_previousButtonActionPerformed
        try
        {
            index--;
            updateLabel();
            updateButtons();
            drawImage(controller.getPreviousImage());
        }
        catch (IOException ex)
        {
            warning("Couldn't load image");
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_nextButtonActionPerformed
    {//GEN-HEADEREND:event_nextButtonActionPerformed
        try
        {
            index++;
            updateLabel();
            updateButtons();
            drawImage(controller.getNextImage());
        }
        catch (IOException ex)
        {
            warning("Couldn't load image");
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageIndex;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    // End of variables declaration//GEN-END:variables

    private void drawImage(Image image)
    {
        this.imagePanel.getGraphics().drawImage(image, 0, 0, this.imagePanel.getWidth(), this.imagePanel.getHeight(), null);
    }

    /**
     * updates the label content according to the actual image and the number of
     * images available
     */
    private void updateLabel()
    {
        this.imageIndex.setText(index + 1 + " / " + controller.getImagesNum());
    }

    /**
     * enables and disables the next and previous buttons according to the
     * actual image and the number of images available
     */
    private void updateButtons()
    {
        if (index <= 0)
        {
            previousButton.setEnabled(false);
        }
        else
        {
            previousButton.setEnabled(true);
        }

        if (index >= controller.getImagesNum() - 1)
        {
            nextButton.setEnabled(false);
        }
        else
        {
            nextButton.setEnabled(true);
        }
    }

    private void warning(String message)
    {
        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
