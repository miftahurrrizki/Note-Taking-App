/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author mfthr
 */
public interface NoteOperations {
    void saveNote(String title, String noteText);
    int Edit(Notes n, String username);
    List<Notes> getData();
    int Delete(String username, String judul);
}
