package controllers;

import api.*;
import views.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginListener implements MouseListener{
 

    private CheckUser user = new CheckUser();

    private JTextField email;
    private JTextField mdp;

    private JFrame frameConnexion;
    public static String[] tabUser = new String[3];


    /**
    *
    *   @param email
    *   @param mdp
    *   @param f
    *
    *   Constructeur de l'observateur permettant (ou non) la connexion 
    *
    */
    public LoginListener(JTextField email, JTextField mdp, JFrame f){

        this.email = email;
        this.mdp = mdp;
        this.frameConnexion = f;
    }




    @Override

    /**
    *
    *   @param arg0
    *
    *   Action effectuée lorsque l'on tente de se connecter. Vérifie la correspondance des adresses mails et des mots de passe
    * 
    */
    public void mouseClicked(MouseEvent arg0) {

        tabUser = user.checkIdentifiers(this.email.getText(),this.mdp.getText());
        
        if(this.email.getText().equals(tabUser[0]) && this.mdp.getText().equals(tabUser[1]))
        {
            frameConnexion.setVisible(false);
            frameConnexion = null;
            ChoixParcelle frameParcelle = new ChoixParcelle();
        }else{
            System.out.println("Non");
        }
    }

    @Override

    public void mouseEntered(MouseEvent arg0) {
         
    }

    @Override

    public void mouseExited(MouseEvent arg0) {
         
    }

    @Override

    public void mousePressed(MouseEvent arg0) {

    }

    @Override

    public void mouseReleased(MouseEvent arg0) {

    }
}