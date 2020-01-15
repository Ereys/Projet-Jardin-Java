package controllers;

import api.*;
import views.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PanelListener  implements MouseListener{
 
        JPanel[] tabPanel;
        ParcelleCT edit;


        @Override

        /**
        *
        *   @param arg0
        *   
        *   Lors du clic, permet la selection d'un jardin
        *   
        */
        public void mouseClicked(MouseEvent arg0) {
            String str = ((JLabel)arg0.getSource()).getText();
            edit = new ParcelleCT(str);
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