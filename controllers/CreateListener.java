package controllers;

import api.*;
import views.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CreateListener implements MouseListener{
 
        private JTextField name;
        private JTextField longueur;
        private JTextField largeur;
        private JFrame createFrame;
        private JFrame oldFrame;

        private ChoixParcelleBD jardin = new ChoixParcelleBD();
         

        /**
        *
        *   @param name
        *   @param longueur
        *   @param largeur
        *   @param createFrame
        *   @param oldFrame
        *
        *   Constructeur de CreateListener
        *
        */

        public CreateListener(JTextField name,JTextField longueur, JTextField largeur, JFrame createFrame, JFrame oldFrame){
            this.name = name;
            this.longueur = longueur;
            this.largeur = largeur;
            this.createFrame = createFrame;
            this.oldFrame = oldFrame;
        }


        @Override

        /**
        *
        *   @param arg0
        *
        *   Création de jardin
        *
        */

        public void mouseClicked(MouseEvent arg0) {


            if(name.getText().equals("") && longueur.getText().equals("")  && largeur.getText().equals("")){
                name.setBackground(Color.RED);
                longueur.setBackground(Color.RED);
                largeur.setBackground(Color.RED);
            }else{
                name.setBackground(Color.WHITE);
                longueur.setBackground(Color.WHITE);
                largeur.setBackground(Color.WHITE);
                if(longueur.getText().matches("[0-9]*")&&(longueur.getText().matches("[0-9]*"))){
                   jardin.addJardin(Integer.parseInt(LoginListener.tabUser[2]),name.getText(),Integer.parseInt(longueur.getText()),Integer.parseInt(largeur.getText()));
                   createFrame.setVisible(false);
                   createFrame = null;
                   oldFrame.setVisible(false);
                   oldFrame = null;
                   new ChoixParcelle();
                }else{
                    longueur.setBackground(Color.RED);
                    largeur.setBackground(Color.RED);
                }
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