/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author ticho
 */
public class UserImpl implements IUser{
     private dao.UserDaoImpl userDao;
     
     
     
    @Override
    public int findUsersId(String username) {
      if (username==null) {
            return 0;

        } else {
            //DAO = DATA ACCESS OBJECT
            userDao = new dao.UserDaoImpl();
            return userDao.findUsersId(username);

        }
    }
    
}
