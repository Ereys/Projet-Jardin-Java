package views;

import api.*;
import models.*;
import controllers.*;
import javax.swing.*;
import java.awt.*;



/**
 * La classe <code>Conteneur</code> est utilisée pour gérer 2 parcelles coupées
 *  
 * 
 * 
 */

public class Conteneur extends JPanel{


    private int taillex;
    private int tailley;
    private Orientation o;

    private AffichageParcelle component1;
    private AffichageParcelle component2;

    private Conteneur componentbis;

    private AffichageParcelle mere;


 /**
   * Constructeur uniquement destiné à la création des constantes publiques.
   *
   * @param x longueur du conteneur
   * @param y hauteur du conteneur
   * @param o Orientation de la parcelle (Orientation.HORIZONTAL ou Orientatin.VERTICAL)
   *
   *
   */
    public Conteneur(int x, int y, Orientation o, AffichageParcelle mere){

        super();
        this.taillex =x;
        this.tailley = y;
        this.o = o;
        this.mere =mere;

        this.setPreferredSize(new Dimension(x,y));

        if(this.o == Orientation.HORIZONTAL){
            this.setLayout(new GridLayout(1,2));
        }
        if(this.o == Orientation.VERTICAL){
            this.setLayout(new GridLayout(2,1));
        }
        if(this.o == null){
            this.setLayout(new GridLayout(1,1));
        }
    }   


 /**
   * Constructeur uniquement destiné à la création des constantes publiques.
   *
   * @param test1 
   * @param test2
   * 
   *
   *
   */

    public void setComponent(AffichageParcelle test1, AffichageParcelle test2){
        this.removeAll();
        this.component1 = test1;
        this.component2 = test2;

        this.add(component1);
        this.add(component2);
        this.revalidate();
    }

    public void setComponentCont(Conteneur test, AffichageParcelle test2, boolean isFirst){
        this.removeAll();
        this.componentbis = test;
        this.component2 = test2;
        if(isFirst){        
            this.add(componentbis);
            this.add(component2);
        }else{
            this.add(componentbis);
            this.add(component2);      
        }
        this.revalidate();
    }

    public AffichageParcelle getFirstComponent(){
        return component1;
    }

    public AffichageParcelle getSecondComponent(){
        return component2;
    }

    public void setNull(){
        this.component1 = null;
        this.component2 = null;
    }

    public AffichageParcelle getMaman(){
        return this.mere;
    }
 }

