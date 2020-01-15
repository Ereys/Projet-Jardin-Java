package controllers;

import api.*;
import views.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DeleteListener implements ActionListener{
 
        private JTextField name;
        private ChoixParcelleBD jardin = new ChoixParcelleBD();
        private JFrame deleteFrame;
        private JFrame chooseFrame;

        /**
        *
        *   @param name 
        *   @param deleteFrame
        *   @param frame 
        *   
        *   Constructeur permettant la suppression de jardin
        *
        */
        public DeleteListener(JTextField name, JFrame deleteFrame, JFrame frame){
            this.name = name;
            this.deleteFrame = deleteFrame;
            this.chooseFrame = frame;
        }


        /**
        *
        *   @param evt
        *   
        *   Action permettant de supprimer un jardin
        *
        */
        public void actionPerformed(ActionEvent evt){
        
            jardin.deleteJardin(name.getText()); 
            deleteFrame.setVisible(false);
            deleteFrame = null;
            this.chooseFrame.setVisible(false);
            this.chooseFrame = null;
            new ChoixParcelle();

        }  
    }
