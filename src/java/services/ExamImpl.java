/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DummyData.DummyData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Answer;
import models.Question;
import models.QuestionPossibleAnswers;
import models.QuestionRightAnswer;
import models.QuestionSelectedAnswer;
import models.Result;
import models.User;
import models.UserAnswers;

/**
 *
 * @author Walter
 */
public class ExamImpl implements IExam {

    @Override
    public List<QuestionPossibleAnswers> getQuestionsWithPossibleAnswers() {
//        List<QuestionAnswers> questionAnswers = examDao.getQuestionAnswers();
//        if (questionAnswers.size() == 0){
//            // Oops, there are no questions
//            return null;
//        }
//        return questionAnswers;

        // *********** TESTING ************
        return DummyData.getQuestionsWithPossibleAnswers();
    }

    @Override
    public boolean saveUserSelectedAnswers(UserAnswers userAnswers, User user,String url, String usernameDB, String password) {
        
       String username= user.getUsername();
       services.UserImpl userService = new services.UserImpl(); 
       services.AnswerImpl ansService=new services.AnswerImpl();
       int user_id=userService.findUsersId(username);
     
       int answer_id=0;
       QuestionSelectedAnswer answer=null;
        String answerText=null;
       
       for(int i =0; i<userAnswers.getSelectedAnswers().size(); i++)
       { 
           try {
               answer=userAnswers.getSelectedAnswers().get(i);
               answerText=answer.getSelectedAnswer().getText();
               answer_id=ansService.findAnsId(answerText);
               
               String query="INSERT INTO `users_answers` (`user_id`,`answer_id`) "
                       + "VALUES("
                       + "'"+ user_id  +"',"
                       +"'"+  answer_id   +"'"
                       + "); ";
               
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection connection=DriverManager.getConnection(url, usernameDB, password);
               Statement st=connection.createStatement();
               int records= st.executeUpdate(query);
               st.close();
               connection.close();
               //return records;
           } catch (SQLException  | ClassNotFoundException  ex) {
               Logger.getLogger(ExamImpl.class.getName()).log(Level.SEVERE, null, ex);
               return false;
           }
       
        }
       return true;
                //boolean saved = examDao.saveUserSelectedAnswers(userAnswers);
//        if (!saved){
//            //  oops something went wrong
//            return false;
//        }
//        return true;
        
        // To be deleted


        
        }
        
     
           
           
           
       
      
        
        
        
        
        
        
        
        
        
        
        

    @Override
    public Result getResult(User user) {
//        Result result = examDao.getResult(User user);
//        if (result == null){
//            // oops
//            return null;
//        }
//        return result;


        // *********** TESTING ************
        return DummyData.getResult(user);
    }

    @Override
    public boolean saveUser(User user){
        // call saveUser from dao
        
        // To be deleted
        return false;
    }
}
