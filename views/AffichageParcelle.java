package views;

import api.*;
import models.*;
import controllers.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AffichageParcelle extends JPanel{


    private int taillex;
    private int tailley;
    private Orientation o;
    private AffichageParcelle parcelleMere;

    ImageIcon sol;

    public AffichageParcelle(int x, int y, Orientation o, AffichageParcelle parcelleMere){
        this.taillex =x;
        this.tailley = y;
        this.o = o;
        this.parcelleMere = parcelleMere;

        this.removeAll();
        this.setPreferredSize(new Dimension(x,y));
        this.sol = new ImageIcon(new ImageIcon("sol.png").getImage().getScaledInstance(taillex,tailley,Image.SCALE_DEFAULT));
        JLabel parcvisu = new JLabel(sol);
        this.setLayout(new GridLayout(1,1));
        this.add(parcvisu);
    }   

    public Orientation getOrientation(){
        return this.o;
    }

    public void addCont(Conteneur cont){
        this.removeAll();
        this.revalidate();
        this.add(cont);
        this.revalidate();
    }

    public int getxt(){
        return this.taillex;
    }

    public int getyt(){
        return this.tailley;
    }

    public AffichageParcelle getMere(){
        return this.parcelleMere;
    }

    public void removeCont(){
        this.removeAll();
        this.revalidate();
        this.sol = new ImageIcon(new ImageIcon("sol.png").getImage().getScaledInstance(taillex,tailley,Image.SCALE_DEFAULT));
        JLabel parcvisu = new JLabel(sol);
        this.setLayout(new GridLayout(1,1));
        this.add(parcvisu);
        this.revalidate();
    }

 }
   
