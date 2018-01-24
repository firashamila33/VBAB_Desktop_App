/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author plazma33
 */
public class Idee {
    private int id;
    private int user_id;
    private String titre;
    private String domaine;
    private String description;
    private Date date_ajout;
    private int prix;
    private String path_doc;
    private String path_img;
    private String etat;

    public Idee(int id, int user_id, String titre, String domaine, String description, Date date_ajout, int prix, String path_doc, String path_img, String etat) {
        this.id = id;
        this.user_id = user_id;
        this.titre = titre;
        this.domaine = domaine;
        this.description = description;
        this.date_ajout = date_ajout;
        this.prix = prix;
        this.path_doc = path_doc;
        this.path_img = path_img;
        this.etat = etat;
    }

    public Idee(int user_id, String titre, String domaine, String description, Date date_ajout, int prix, String path_doc, String path_img, String etat) {
        this.user_id = user_id;
        this.titre = titre;
        this.domaine = domaine;
        this.description = description;
        this.date_ajout = date_ajout;
        this.prix = prix;
        this.path_doc = path_doc;
        this.path_img = path_img;
        this.etat = etat;
    }

    public Idee() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getPath_doc() {
        return path_doc;
    }

    public void setPath_doc(String path_doc) {
        this.path_doc = path_doc;
    }

    public String getPath_img() {
        return path_img;
    }

    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Idee{" + "id=" + id + ", user_id=" + user_id + ", titre=" + titre + ", domaine=" + domaine + ", description=" + description + ", date_ajout=" + date_ajout + ", prix=" + prix + ", path_doc=" + path_doc + ", path_img=" + path_img + ", etat=" + etat + '}';
    }
    
    
}
