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
public class AnswerImpl implements IAnswer{
     private dao.AnswerDaoImpl answerDao;
    
    @Override
    public int findAnsId(String answerText) {
        if (answerText==null) {
            return 0;

        } else {
            //DAO = DATA ACCESS OBJECT
            answerDao = new dao.AnswerDaoImpl();
            return answerDao.findAnsId(answerText);

        }
    }
    }
    

