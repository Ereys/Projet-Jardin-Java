package controllers;

import api.*;
import views.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HistoriqueListener implements MouseListener{
 

    ParcelleGest fenetre;
    GestParc start;

    public HistoriqueListener(ParcelleGest fenetre, GestParc start){
        this.fenetre= fenetre;
        this.start = start;
    }


    public void mouseClicked(MouseEvent e) {

        String str = ((JLabel)e.getSource()).getText();

        JOptionPane jop1 = new JOptionPane();
        ImageIcon img = new ImageIcon("frog.png"); 

        switch (str){
            case "double-bêchage":
                start.actionBuilderSol(ActionSolType.BECHER);
                break;
            case "bêchage":
                start.actionBuilderSol(ActionSolType.BECHER);
                break;
            case "sarclage":
                start.actionBuilderSol(ActionSolType.AMENDER);                   
                break;
            case "desherbage":
                start.actionBuilderSol(ActionSolType.FUMER);
                break;
            case "amendement terre":
                start.actionBuilderSol(ActionSolType.AMENDER);
                break;
            case "traitement purin":
                start.actionBuilderSol(ActionSolType.PAILLER);
                break;
        }  
        jop1.showMessageDialog(null, "Action effectuée", "Information", JOptionPane.INFORMATION_MESSAGE, img);   
    }

    @Override

    public void mouseEntered(MouseEvent e) {
    }

    @Override

    public void mouseExited(MouseEvent e) {

    }

    @Override

    public void mousePressed(MouseEvent e) {

    }

    @Override

    public void mouseReleased(MouseEvent e) {

    }
}

