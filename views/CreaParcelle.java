package views;

import api.*;
import models.*;
import controllers.*;
import java.awt.*;
import javax.swing.*;

public class CreaParcelle extends JFrame{

	private JPanel fond = new JPanel(new GridLayout());
	private JPanel decoration = new JPanel(new GridBagLayout());
	private JPanel connexionpanel = new JPanel(new GridBagLayout());

	private JLabel nom = new JLabel("Nom:");
	private JTextField nomtext = new JTextField();
	private JLabel longueur = new JLabel("Longueur:");
	private JTextField longueurtext = new JTextField();
	private JLabel largeur = new JLabel("Largeur:");
	private JTextField largeurtext = new JTextField();
	private JLabel create = new JLabel("Créer");

    private JFrame oldFrame;


    /**
    *
    *   @param oldFrame
    *   Constucteur de la fenêtre permettant la création d'un Jardin
    *
    */
	public CreaParcelle(JFrame oldFrame){
    	super();

        this.oldFrame = oldFrame;

        this.setTitle("Création de parcelle");
        this.setSize(800, 650);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setPanelBackground();
        this.setCreaPanel();
        this.setVisible(true);
	}

    /**
    *
    *   Permet le changement de couleur de fond 
    *
    */
	public void setPanelBackground(){

	    fond.setBackground(new Color(54,66,77));
	    this.add(fond,BorderLayout.CENTER);

	}

    /**
    *
    *   Organise les différents élements de la page de connexion 
    *
    */
	public void setCreaPanel(){

		GridBagConstraints gbc = new GridBagConstraints();

        connexionpanel.setBackground(new Color(174,214,241));

        gbc.fill = GridBagConstraints.BOTH;

        nom.setFont(new Font("Arial",Font.BOLD,15));
        longueur.setFont(new Font("Arial",Font.BOLD,15));
        largeur.setFont(new Font("Arial",Font.BOLD,15));
        create.setOpaque(true);
        create.setFont(new Font("Arial",Font.BOLD,17));


        nom.setBorder(BorderFactory.createEmptyBorder(20,30,20,250));
        nomtext.setBorder(BorderFactory.createEmptyBorder(0,20,30,0));
        longueur.setBorder(BorderFactory.createEmptyBorder(20,30,20,250));
        longueurtext.setBorder(BorderFactory.createEmptyBorder(0,20,30,0));
        largeur.setBorder(BorderFactory.createEmptyBorder(20,30,20,250));
        largeurtext.setBorder(BorderFactory.createEmptyBorder(0,20,30,0));
        create.setBorder(BorderFactory.createEmptyBorder(25,250,25,250));
        
        nom.setForeground(Color.BLACK);
        longueur.setForeground(Color.BLACK);
        largeur.setForeground(Color.BLACK);
        create.setBackground(Color.BLUE);
        create.setForeground(Color.WHITE);
        create.setVerticalTextPosition(SwingConstants.CENTER);

        gbc.gridx = gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        connexionpanel.add(nom, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        connexionpanel.add(nomtext, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc. gridwidth = 1;
        gbc.gridheight = 1;

        connexionpanel.add(longueur, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc. gridwidth = 1;
        gbc.gridheight = 1;

        connexionpanel.add(longueurtext, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc. gridwidth = 1;
        gbc.gridheight = 1;

        connexionpanel.add(largeur, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc. gridwidth = 1;
        gbc.gridheight = 1;

        connexionpanel.add(largeurtext, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc. gridwidth = 1;
        gbc.gridheight = 1;

        connexionpanel.add(create, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc. gridwidth = 1;
        gbc.gridheight = 1;

        decoration.add(connexionpanel,gbc);

        create.addMouseListener(new CreateListener(nomtext,longueurtext,largeurtext,this, oldFrame));
        decoration.setBorder(BorderFactory.createLineBorder(new Color(44, 62, 80), 120));

        fond.add(decoration, gbc);
	}
}