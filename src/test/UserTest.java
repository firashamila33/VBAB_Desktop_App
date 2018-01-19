/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import interfaces.IUserService;
import java.util.ArrayList;
import java.util.List;
import models.User;
import services.UserService;

/**
 *
 * @author plazma33
 */
public class UserTest {
    
    
    public static void main(String[] args) {
        List<User> e = new ArrayList<>();
        IUserService I_test = new UserService();
        e=I_test.getAll();
        //System.out.println(e);
        
        
        System.out.println(I_test.getUserById(10));
        
    }
    
    
    
    
    
    
}
