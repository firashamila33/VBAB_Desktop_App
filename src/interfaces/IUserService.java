/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.User;

/**
 *
 * @author YACINE
 */
public interface IUserService{
    List<User> getAll();
    User getUserById(Integer i);
    User Login_User(String Username,String Password); 
    

}
