package controllers;

import api.*;
import views.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ChoixListener implements ActionListener{
 
        /**
         * Redéfinition de la méthode actionPerformed
         */

        private JButton addParcelle;
        private JButton deleteParcelle;
        private JFrame currentFrame;

        public ChoixListener(JButton addParcelle, JButton deleteParcelle, JFrame frame){
            this.addParcelle = addParcelle;
            this.deleteParcelle = deleteParcelle;
            this.currentFrame = frame;
        }

        public void actionPerformed(ActionEvent evt){

            if(evt.getSource() == addParcelle){
                CreaParcelle frameCreate = new CreaParcelle(currentFrame);
            }
            if(evt.getSource() == deleteParcelle){
                DeleteFrame frame = new DeleteFrame(currentFrame);
            }
        }
    }