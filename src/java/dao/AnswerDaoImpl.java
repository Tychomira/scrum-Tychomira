/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import entities.Answer;

/**
 *
 * @author ticho
 */
public class AnswerDaoImpl implements IAnswerDao{
     private EntityManagerFactory emf;
    private EntityManager em;
    
    @Override
    public int findAnsId(String answerText) {
       Answer answer = em.find(Answer.class, answerText);
       int answer_id=answer.getId();
        return answer_id;
    }
    
    
    
    
    }
    

