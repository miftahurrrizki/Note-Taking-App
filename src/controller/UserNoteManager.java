/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author mfthr
 */
public class UserNoteManager extends AbstractUserNoteManager {
    private DatabaseManager databaseManager;

    public UserNoteManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public void saveNote(String title, String noteText) {
        // Implementation for saving a note
        databaseManager.saveNote(title, noteText);
    }

    @Override
    public boolean userSignup(String newUserName, String newPassword) {
        return databaseManager.userSignup(newUserName, newPassword);
    }

    @Override
    public int Edit(Notes n, String username) {
        try {
            return databaseManager.Edit(n, username);
        } catch (SQLException ex) {
            Logger.getLogger(UserNoteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    @Override
    public List<Notes> getData() {
        return databaseManager.getData();
    }

    @Override
    public int Delete(String username, String judul) {
        try {
            return databaseManager.Delete(username, judul);
        } catch (SQLException ex) {
            Logger.getLogger(UserNoteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    @Override
    public boolean userLogin(String userName, String password) {
        return databaseManager.userLogin(userName, password);
    }
}



