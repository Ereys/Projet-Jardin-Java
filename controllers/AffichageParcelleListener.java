package controllers;

import api.*;
import views.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AffichageParcelleListener implements MouseListener{
 

    ParcelleGest fenetre;
    GestParc start;


    public AffichageParcelleListener(ParcelleGest fenetre, GestParc start){
        this.fenetre= fenetre;
        this.start = start;
    }


    public void mouseClicked(MouseEvent e) {

        String str = ((JLabel)e.getSource()).getText();
        
            switch (str){
                case "Sous-parcelle 1":
                    start.visuMoveParcelle("first");
                    break;
                case "CouperV":
                    start.visuCut(Orientation.HORIZONTAL);
                    break;
                case "CouperH":
                    start.visuCut(Orientation.VERTICAL);
                    break;
                case "Sous-parcelle 2":
                    start.visuMoveParcelle("second");
                    break;
                case "Parcelle mere":
                    start.visuParcelleMere();
                    break;
                case "Parcelle racine":
                    start.visuRoot();
                    break;
                case "Réunir":
                    start.visuReunir();
                    break;
                case "Historique":
                    new HistoriqueFrame(start.getActionParcelle());
                    break;
            }
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

