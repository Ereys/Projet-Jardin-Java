package controllers;

import api.*;
import views.*;
import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.time.Month;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class GestParc{

	private ParcelleJ parcelle;

	private ParcelleGest fenetre;
	private AffichageParcelle root;
	private Conteneur contRoot;

	private ParcelleJ currentParcelle;
	private Conteneur currentCont;
	private AffichageParcelle currentPrintParcelle;

    LocalDate now = LocalDate.now(); // Variable qui prend la date du système 
    private Integer compteur = 0;

	public GestParc(ParcelleGest fenetres){

		this.fenetre = fenetres;
		parcelle =  new ParcelleJ("Jardin Mallicieux", 800,400);
		this.currentParcelle = parcelle;

		this.root = new AffichageParcelle(parcelle.getx1(),parcelle.gety1(),parcelle.getSplit(), null);
		this.currentCont = new Conteneur(parcelle.getx1(),parcelle.gety1(),root.getOrientation(),null);
		currentCont.setComponent(root,root);
		this.currentPrintParcelle = root;
	}

	public void visuCut(Orientation o){

		ParcelleJ ssparcelle1;
		ParcelleJ ssparcelle2;
		Conteneur cont;

		this.currentParcelle.SplitParcelle(o);

		ssparcelle1 = currentParcelle.getFirst();
		ssparcelle2 = currentParcelle.getSecond();

		if(o == Orientation.HORIZONTAL){
			cont = new Conteneur(currentParcelle.getx1(),currentParcelle.gety1(),o,currentPrintParcelle);
			cont.setComponent(new AffichageParcelle(ssparcelle1.getx1(),ssparcelle1.gety1(), ssparcelle1.getSplit(),currentPrintParcelle),new AffichageParcelle(ssparcelle1.getx1(),ssparcelle1.gety1(), ssparcelle1.getSplit(),currentPrintParcelle));
		}else{
			cont = new Conteneur(currentParcelle.getx1(),currentParcelle.gety1(),o,currentPrintParcelle);
			cont.setComponent(new AffichageParcelle(ssparcelle1.getx1(),ssparcelle1.gety1(), ssparcelle1.getSplit(),currentPrintParcelle),new AffichageParcelle(ssparcelle1.getx1(),ssparcelle1.gety1(), ssparcelle1.getSplit(),currentPrintParcelle));
		}
		this.currentCont = cont;

		if(currentParcelle.getMother() == null){
			root.addCont(currentCont);
			visuRoot();
		}else{
			currentPrintParcelle.addCont(currentCont);
		}
	}


	public void visuMoveParcelle(String str){
		currentPrintParcelle.setBorder(BorderFactory.createEmptyBorder());
		if(str == "first" && currentParcelle.getSplit() != null){
			this.currentParcelle = currentParcelle.getFirst();
			this.currentPrintParcelle = currentCont.getFirstComponent();
		}
		if(str == "second" && currentParcelle.getSplit() != null){
			this.currentParcelle = currentParcelle.getSecond();
			this.currentPrintParcelle = currentCont.getSecondComponent();
		}
		currentPrintParcelle.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	}

	public void visuParcelle(AffichageParcelle t){
		fenetre.setPanel(t);
	}

	public void visuParcelleMere(){

		currentPrintParcelle.setBorder(BorderFactory.createEmptyBorder());	
		if(this.currentPrintParcelle != this.root){
			this.currentParcelle = currentParcelle.getMother();
			this.currentPrintParcelle = currentPrintParcelle.getMere();
			currentPrintParcelle.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		}else{
			this.currentParcelle = currentParcelle.getRoot();
			this.currentPrintParcelle = root;
			currentPrintParcelle.setBorder(BorderFactory.createLineBorder(Color.RED, 2));			
		}
	}

	public void visuRoot(){
        currentPrintParcelle.setBorder(BorderFactory.createEmptyBorder()); 
		this.currentParcelle = currentParcelle.getRoot();
		this.currentPrintParcelle = root;
		fenetre.removeAllPan();
        currentPrintParcelle.setBorder(BorderFactory.createLineBorder(Color.RED, 2));    
		fenetre.setPanel(root);
	}

	public void visuReunir(){

		if(currentParcelle.getSplit() != null){
			this.currentParcelle.reset();
			if(currentParcelle.getMother() == null){
				currentPrintParcelle.removeCont();
				visuParcelle(currentPrintParcelle);
			}else{
				currentPrintParcelle.removeCont();
			}
		}
	}

    public void actionBuilderSol(ActionSolType action){

        ActionSol s = new ActionSol(now, currentParcelle, action); 
        currentParcelle.addActionParcelle(s); 
    }

    public void actionBuilderLegume(Legume leg, ActionLegumeType alt){

        ActionLegume l = new ActionLegume(now, currentParcelle, leg, alt);
        currentParcelle.addActionParcelle(l);

    }

    public int countAction(){

        Iterator<ActionParcelle> array = currentParcelle.getActions();
        while(array.hasNext()){
            compteur++;
           ActionParcelle tmp = (ActionParcelle)array.next();
        }
        return compteur;
    }

    public JPanel getActionParcelle(){

        Iterator<ActionParcelle> arraylabel = currentParcelle.getActions();
        JPanel historiquepanel = new JPanel(new GridLayout(countAction(),1));

        while(arraylabel.hasNext()){
            ActionParcelle tmp = (ActionParcelle)arraylabel.next();
            JLabel label = new JLabel(tmp.toString());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            historiquepanel.add(label);
        }
        return historiquepanel;
    }
}
