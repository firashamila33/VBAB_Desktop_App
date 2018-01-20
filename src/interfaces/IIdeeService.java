/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import models.Idee;
import models.User;


/**
 *
 * @author plazma33
 */
public interface IIdeeService {
    List<Idee> getAll();
    Idee getIdeeById(Integer i);
    List<Idee> getIdeesByUserId(Integer i);
    List<Idee> getChecked();
    List<Idee> getNonChecked();
    void add(Idee i);
    void delete(Integer id);
    void update(Idee i);
    void check(Integer id);
}
