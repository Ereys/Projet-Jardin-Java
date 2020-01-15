package views;

import api.*;
import models.*;
import controllers.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;

public class Connexion extends JFrame{

	private JPanel fond = new JPanel(new GridBagLayout());
	private JPanel decoration = new JPanel(new GridBagLayout());
	private JPanel connexionpanel = new JPanel(new GridLayout(5,1));

	private JLabel mail = new JLabel("Adresse mail:");
	private JTextField mailtext = new JTextField();
	private JLabel mdp = new JLabel("Mot de passe:");
	private JTextField mdptext = new JTextField();
	private JLabel espace = new JLabel("-");
	private JLabel log = new JLabel("Connexion");


    /**
    *
    *   Constructeur de la fenêtre Connexion 
    *
    */
    
	public Connexion(){
	super();
    this.setTitle("Connexion");
    this.setSize(800, 650);
    this.setResizable(false);
    this.setLocation(100, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    this.setConnexionPanel();
    this.setPanelBackground();

    this.setLocationRelativeTo(null);     
    this.setVisible(true);
	}

	public void setPanelBackground(){

	    fond.setBackground(new Color(54,66,77));
	    this.add(fond,BorderLayout.CENTER);
	}



    /**
    *
    *   Méthode gérant l'affichage de la page de connexion 
    *
    */
	public void setConnexionPanel(){

		GridBagConstraints gbc = new GridBagConstraints();

        connexionpanel.setBackground(new Color(174,214,241));
       	decoration.setBackground(new Color(174,214,241));

        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = gbc.gridy = 1;

        mail.setFont(new Font("Arial",Font.BOLD,15));
        mdp.setFont(new Font("Arial",Font.BOLD,15));
        log.setFont(new Font("Arial",Font.BOLD,17));


        mail.setBorder(BorderFactory.createEmptyBorder(0,0,0,250));
        mail.setForeground(Color.BLACK);
        mdp.setBorder(BorderFactory.createEmptyBorder(20,0,10,250));
        mdp.setForeground(Color.BLACK);
        mdptext.setBorder(BorderFactory.createEmptyBorder(0,0,20,250));
        log.setBorder(BorderFactory.createEmptyBorder(0,250,0,250));
        log.setOpaque(true);
        log.setBackground(Color.BLUE);
        log.setForeground(Color.WHITE);

        gbc.insets = new Insets(25,100,0,100);
        connexionpanel.add(log,gbc);

        connexionpanel.add(mail);
        connexionpanel.add(mailtext);
        connexionpanel.add(mdp);
        connexionpanel.add(mdptext);
        connexionpanel.add(log);

        gbc.insets = new Insets(50,50,50,50);
        decoration.add(connexionpanel,gbc);
        decoration.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));

       	gbc.insets = new Insets(90,100,90,100);   /* insets(top, left, bottom, right) */
        fond.add(decoration, gbc);

        log.addMouseListener(new LoginListener(this.mailtext,this.mdptext,this));
	}

}