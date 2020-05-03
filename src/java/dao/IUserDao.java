/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;

/**
 *
 * @author ticho
 */
public interface IUserDao {
    
    // returns the id of the user
    int findUsersId(String username);
    
   
}
