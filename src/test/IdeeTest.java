/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import interfaces.IIdeeService;
import interfaces.IUserService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import models.Idee;
import models.User;
import services.IdeeService;
import services.UserService;

/**
 *
 * @author plazma33
 */
public class IdeeTest {
 
    public static void main(String[] args) {
        
        List<Idee> ideas = new ArrayList<>();
        IIdeeService Idea_test = new IdeeService();
//        Idee I = new Idee(10, "firas", "coding", "testing",Date.valueOf("2018-01-21"), 52, "a document", "an image", "NON");
//        ideas=Idea_test.getAll();
//        System.out.println(ideas);
//        System.out.println(Idea_test.getIdeeById(11));
        Idea_test.getIdeesByUserId(2).forEach((i) -> {
            System.out.println(i);
            System.out.println("\n");
        });
//        Idea_test.add(I);
//        Idea_test.delete(20);
//        Idee I1 = new Idee(21,40, "firas1oa", "codingoa", "testingoa",Date.valueOf("2018-01-21"), 52, "a documentoa", "an imageoa", "NON");
//        Idea_test.update(I1);
//        Idea_test.check(21);

//        Idea_test.getChecked() .forEach((i) -> {
//            System.out.println(i);
//        });
//        Idea_test.getNonChecked().forEach((i) -> {
//            System.out.println(i);
//        });



    }

}
