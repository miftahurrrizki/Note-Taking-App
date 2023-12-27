/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;

/**
 *
 * @author mfthr
 */
public interface UserOperations {
    boolean userSignup(String newUserName, String newPassword);
    boolean userLogin(String userName, String password);
}
