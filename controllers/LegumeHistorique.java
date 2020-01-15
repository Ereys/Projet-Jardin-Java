package controllers;

import api.*;
import views.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LegumeHistorique implements MouseListener{
 

    ParcelleGest fenetre;
    GestParc start;

    ActionLegumeType action;
    LegumeJ leg;

    public LegumeHistorique(ParcelleGest fenetre, GestParc start){
        this.fenetre= fenetre;
        this.start = start;
    }


    public void mouseClicked(MouseEvent e) {

        String str = ((JLabel)e.getSource()).getText();

        switch (str){
            case "Semer":
                new LegumeFrame(this);
                this.action = ActionLegumeType.SEMER;
                break;
            case "Transplanter":
                new LegumeFrame(this);
                this.action = ActionLegumeType.TRANSPLANTER;
                break;
            case "Récolter":
                new LegumeFrame(this);
                this.action = ActionLegumeType.RECOLTER;              
                break;
            case "Arracher":
                new LegumeFrame(this);
                this.action = ActionLegumeType.ARRACHER;
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

    public void setActionLegume(LegumeJ t){
        System.out.println(this.action);
        start.actionBuilderLegume(t,this.action);
    }
}

