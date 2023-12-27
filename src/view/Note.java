/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.*;
import java.awt.BorderLayout;
import javax.swing.*;
import model.*;

/**
 *
 * @author mfthrr
 */
public class Note extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    DatabaseManager db = new DatabaseManager();
    UserNoteManager userNoteManager = new UserNoteManager(db); // buat objek UserNoteManager
    User currentUser = db.getUserLogin();

    /**
     * Creates new form Home
     */
    public Note() {
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

        btn_backHome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        isi_Note = new javax.swing.JTextArea();
        input_title_note = new javax.swing.JTextField();
        btnSaveNote = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_backHome.setBackground(new java.awt.Color(0,0,0,1));
        btn_backHome.setBorderPainted(false);
        btn_backHome.setContentAreaFilled(false);
        btn_backHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_backHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 30, 40));

        isi_Note.setBackground(new java.awt.Color(217, 217, 217));
        isi_Note.setColumns(20);
        isi_Note.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        isi_Note.setRows(5);
        isi_Note.setBorder(null);
        jScrollPane1.setViewportView(isi_Note);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 170, 320, 290));

        input_title_note.setBackground(null);
        input_title_note.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        input_title_note.setForeground(new java.awt.Color(51, 51, 51));
        input_title_note.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        input_title_note.setText("Judul");
        input_title_note.setBorder(null);
        input_title_note.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_title_noteActionPerformed(evt);
            }
        });
        getContentPane().add(input_title_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 220, 40));

        btnSaveNote.setBorderPainted(false);
        btnSaveNote.setContentAreaFilled(false);
        btnSaveNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNoteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaveNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_asset/Note.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backHomeActionPerformed
        // TODO add your handling code here:
        
            dispose(); //Nutup frame ini
            
            Home ah = new Home(); // Bikin objek dari frame Home
            ah.setTitle("Selamat Datang");
            ah.setLocationRelativeTo(null);
            ah.setVisible(true); // Nampilin frame Home
    }//GEN-LAST:event_btn_backHomeActionPerformed

    private void btnSaveNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNoteActionPerformed
        // TODO add your handling code here:
        String title = input_title_note.getText();
        String noteText = isi_Note.getText();

        if (currentUser == null) {
            JOptionPane.showMessageDialog(null, "Belum ada user yang login.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("Username: " + currentUser.getUsername());
        Notes note = new Notes(title, noteText);
        
        userNoteManager.saveNote(note.getJudul(), note.getIsi());
    }//GEN-LAST:event_btnSaveNoteActionPerformed

    private void input_title_noteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_title_noteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_title_noteActionPerformed

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
            java.util.logging.Logger.getLogger(Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Note.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            Note noteFrame = new Note();
            noteFrame.setVisible(true);
            noteFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveNote;
    private javax.swing.JButton btn_backHome;
    private javax.swing.JTextField input_title_note;
    private javax.swing.JTextArea isi_Note;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}