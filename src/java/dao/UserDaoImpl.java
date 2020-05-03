/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ticho
 */
public class UserDaoImpl implements IUserDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDaoImpl() {
        emf = Persistence.createEntityManagerFactory("PersistentUserPU");
        em = emf.createEntityManager();
    }

    @Override
    public int findUsersId(String username) {
        User user = em.find(User.class, username);
        int user_id=user.getId();
        return user_id;
    }

  

   
}
