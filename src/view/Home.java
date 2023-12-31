/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import model.DatabaseManager;
import model.Notes;
//import model.NotePanel;
/**
 *
 * @author mfthrr
 */
public class Home extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    List <Notes> listData = new ArrayList();
    public static String notesSelect;
    public static String usr;
    DatabaseManager dab = new DatabaseManager();
    List<Notes> noteList;
    /**
     * Creates new form UI_Home
     */
    public Home() {
        initComponents();
    }
    
    public javax.swing.JList<String> getListNote() {
        return ListNote;
    }
    
    public void showData() {
        noteList = dab.getData();
        DefaultListModel<String> listModel = new DefaultListModel<>();

        if (noteList != null && !noteList.isEmpty()) {
            for (Notes note : noteList) {
                listModel.addElement(note.toString());
                listData.add(note);
            }
            ListNote.setModel(listModel);
        } else {
        // Tampilkan pesan jika noteList null atau kosong
        JOptionPane.showMessageDialog(this, "Kamu Belum Menulis Note, Silahkan Tulis Note Terlebih Dahulu");
        }
    }
    
    private static int findNotesIndex(List<Notes> noteList, String targetNote) {
        for (int i = 0; i < noteList.size(); i++) {
            if (noteList.get(i).getJudul().equals(targetNote)) {
                return i; // Catatan ditemukan, kembalikan indeks
            }
        }
        return -1; // Catatan tidak ditemukan dalam List
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogout = new javax.swing.JButton();
        btn_addNote = new javax.swing.JButton();
        btn_deleteNote = new javax.swing.JButton();
        labelDetilMemo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListNote = new javax.swing.JList<>();
        labelDaftarMemo = new javax.swing.JLabel();
        isiTanggal = new javax.swing.JLabel();
        isiNote = new javax.swing.JLabel();
        isiJudul = new javax.swing.JLabel();
        LabelJudul1 = new javax.swing.JLabel();
        LabelJudul2 = new javax.swing.JLabel();
        LabelJudul = new javax.swing.JLabel();
        btnEditNote = new javax.swing.JButton();
        btnDeleteNote = new javax.swing.JButton();
        btnRefreshMemo = new javax.swing.JButton();
        labelNote = new javax.swing.JLabel();
        begron = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_asset/logout.png"))); // NOI18N
        btnLogout.setBorder(null);
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 50, 50));

        btn_addNote.setBackground(new java.awt.Color(0,0,0,1));
        btn_addNote.setBorderPainted(false);
        btn_addNote.setContentAreaFilled(false);
        btn_addNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addNoteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 720, 53, 53));

        btn_deleteNote.setOpaque(false);
        btn_deleteNote.setContentAreaFilled(false);
        btn_deleteNote.setBorderPainted(false);
        btn_deleteNote.setContentAreaFilled(false);
        getContentPane().add(btn_deleteNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 230, 20, 20));

        labelDetilMemo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelDetilMemo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDetilMemo.setText("Detail Memo");
        getContentPane().add(labelDetilMemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 170, 30));

        ListNote.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ListNote.setToolTipText("as,dfd,fd");
        ListNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListNoteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListNote);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 330, 240));

        labelDaftarMemo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelDaftarMemo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDaftarMemo.setText("Daftar Memo");
        getContentPane().add(labelDaftarMemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 30));

        isiTanggal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(isiTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 180, 20));

        isiNote.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(isiNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 180, 20));

        isiJudul.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        getContentPane().add(isiJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 180, 20));

        LabelJudul1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        LabelJudul1.setText("Isi Note   :");
        getContentPane().add(LabelJudul1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 70, 20));

        LabelJudul2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        LabelJudul2.setText("Tanggal :");
        getContentPane().add(LabelJudul2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 70, 20));

        LabelJudul.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        LabelJudul.setText("Judul      :");
        getContentPane().add(LabelJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 70, 20));

        btnEditNote.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEditNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_asset/edit.png"))); // NOI18N
        btnEditNote.setBorder(null);
        btnEditNote.setContentAreaFilled(false);
        btnEditNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditNoteMouseClicked(evt);
            }
        });
        btnEditNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditNoteActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 610, -1, -1));

        btnDeleteNote.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnDeleteNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_asset/delete.png"))); // NOI18N
        btnDeleteNote.setBorder(null);
        btnDeleteNote.setContentAreaFilled(false);
        btnDeleteNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteNoteMouseClicked(evt);
            }
        });
        btnDeleteNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNoteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, -1, -1));

        btnRefreshMemo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnRefreshMemo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_asset/btnMemo.png"))); // NOI18N
        btnRefreshMemo.setBorder(null);
        btnRefreshMemo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMemoMouseClicked(evt);
            }
        });
        btnRefreshMemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshMemoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefreshMemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 670, -1, -1));

        labelNote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_asset/labelNote.png"))); // NOI18N
        getContentPane().add(labelNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 340, 200));

        begron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_asset/Home.png"))); // NOI18N
        getContentPane().add(begron, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addNoteActionPerformed
        // TODO add your handling code here:
            dispose();
            Note ah = new Note();
            ah.setTitle("Note");
            ah.setVisible(true);
            ah.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_addNoteActionPerformed

    private void btnRefreshMemoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMemoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnRefreshMemoMouseClicked

    private void btnRefreshMemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshMemoActionPerformed
        // TODO add your handling code here:
        showData();    
    }//GEN-LAST:event_btnRefreshMemoActionPerformed

    private void ListNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListNoteMouseClicked
    int selectedIndex = ListNote.locationToIndex(evt.getPoint());

    if (selectedIndex != -1) { // Pastikan item yang diklik adalah item valid
        Object selectedOption = ListNote.getModel().getElementAt(selectedIndex);

        // Tampilkan informasi atau lakukan tindakan sesuai kebutuhan
        String find = selectedOption.toString();
        int i = findNotesIndex(noteList, find);
        isiJudul.setText(noteList.get(i).getJudul());
        isiNote.setText(noteList.get(i).getIsi());
        isiTanggal.setText(noteList.get(i).getTanggal().toString());
        notesSelect = noteList.get(i).getJudul();
        usr = noteList.get(i).getUsername();
    } else {
        // Jika pengguna mengklik list tanpa menekan indeksnya
        JOptionPane.showMessageDialog(this, "Klik Tombol Perbarui Memo");
    }
    }//GEN-LAST:event_ListNoteMouseClicked

    private void btnEditNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditNoteMouseClicked
        // TODO add your handling code here:      
    }//GEN-LAST:event_btnEditNoteMouseClicked

    private void btnEditNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditNoteActionPerformed
        // TODO add your handling code here:
        NoteEdit edit = new NoteEdit();
        edit.setLocationRelativeTo(null);

        // Get the selected option from ListNote
        int selectedIndex = ListNote.getSelectedIndex();
        if (selectedIndex != -1) {
            // Retrieve the selected note from noteList
            Notes selectedNote = noteList.get(selectedIndex);

            // Pass the selected note to the NoteEdit dialog
            edit.listData(selectedNote);

            // Close the current frame and display the NoteEdit dialog
            dispose();
            edit.setVisible(true);
        } else {
            // Show a message or handle the case when no note is selected
            JOptionPane.showMessageDialog(this, "Pilih dulu note yang mau kamu edit!.", "Ga Pilih Note", JOptionPane.WARNING_MESSAGE);
        }
 

    }//GEN-LAST:event_btnEditNoteActionPerformed

    private void btnDeleteNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteNoteMouseClicked
        // TODO add your handling code here:
        try {
            
            String usernameDelete = usr; // Ganti dengan NIM yang ingin dihapus
            String judulDelete = notesSelect;
            int rowsAffected = dab.Delete(usernameDelete, judulDelete);
    
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dihapus");
            } else {
                System.out.println("Yah, gagal menghapus data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }//GEN-LAST:event_btnDeleteNoteMouseClicked

    private void btnDeleteNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteNoteActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        
        dispose();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            Home homeFrame = new Home();

            homeFrame.revalidate();
            homeFrame.repaint();

            homeFrame.setVisible(true);
            homeFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelJudul;
    private javax.swing.JLabel LabelJudul1;
    private javax.swing.JLabel LabelJudul2;
    private javax.swing.JList<String> ListNote;
    private javax.swing.JLabel begron;
    private javax.swing.JButton btnDeleteNote;
    private javax.swing.JButton btnEditNote;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRefreshMemo;
    private javax.swing.JButton btn_addNote;
    private javax.swing.JButton btn_deleteNote;
    private javax.swing.JLabel isiJudul;
    private javax.swing.JLabel isiNote;
    private javax.swing.JLabel isiTanggal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDaftarMemo;
    private javax.swing.JLabel labelDetilMemo;
    private javax.swing.JLabel labelNote;
    // End of variables declaration//GEN-END:variables
}
