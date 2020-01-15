package controllers;

import api.*;
import views.*;
import models.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChoixParcelleCT{

	JFrame choixParcelle;
    public static String[][] tabJardin;
    private ChoixParcelleBD jardin = new ChoixParcelleBD();

    /**
    *	
    *	@param choixParcelle
    *	Constructeur qui permet de récupérer la parcelle chosie ainsi que ses informations perso
    *
    */
	public ChoixParcelleCT(JFrame f){
		this.choixParcelle = f;
		getTabInfoJardin();
	}



	/**
	*
	*	@return Renvoie le numéro de jardin de la parcelle
	*
	*/
	public int setNbJardin(){
		return jardin.getNbJardin(Integer.parseInt(LoginListener.tabUser[2]));
	}



	/**
	*	
	*	Méthode appelé par le constructeur de ChoixParcelleCT
	*
	*/
	public void getTabInfoJardin(){
		this.tabJardin = jardin.getInformationJardin(Integer.parseInt(LoginListener.tabUser[2]),setNbJardin());
	}

}