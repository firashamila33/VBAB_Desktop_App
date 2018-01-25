/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;


/**
 *
 * @author Sami
 */
public class User {

    private int id;
    private String nom;
    private String prenom;
    private String cin;
    private Date datenaissance;
    private String username;
    private String password;
    private String email;
    private int numtelephone;
    private String adresse;
    private Date dateajout;
    private String role;
    public static User static_user;

    public User() {
        
    }

    public User(int id, String nom, String prenom, String cin, Date dateNaissance, String username, String password, String email, int numtelephone, String adresse, Date dateajout, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.datenaissance = dateNaissance;
        this.username = username;
        this.password = password;
        this.email = email;
        this.numtelephone = numtelephone;
        this.adresse = adresse;
        this.dateajout = dateajout;
        this.role = role;
    }

    public User(String nom, String prenom, String cin, Date dateNaissance, String username, String password, String email, int numtelephone, String adresse, Date dateajout, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.datenaissance = dateNaissance;
        this.username = username;
        this.password = password;
        this.email = email;
        this.numtelephone = numtelephone;
        this.adresse = adresse;
        this.dateajout = dateajout;
        this.role = role;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date dateNaissance) {
        this.datenaissance = dateNaissance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumtelephone() {
        return numtelephone;
    }

    public void setNumtelephone(int numtelephone) {
        this.numtelephone = numtelephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateajout() {
        return dateajout;
    }

    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", dateNaissance=" + datenaissance + ", username=" + username + ", password=" + password + ", email=" + email + ", numtelephone=" + numtelephone + ", adresse=" + adresse + ", dateajout=" + dateajout + ", role=" + role + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    

    
}
