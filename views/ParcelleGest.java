package views;

import api.*;
import models.*;
import controllers.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.*;


public class ParcelleGest extends JFrame{



	private JPanel fond = new JPanel(new GridBagLayout());
    private JPanel haut = new JPanel(new GridBagLayout());
	private JPanel gauche = new JPanel(new GridBagLayout());
	private JPanel milieu = new JPanel(new FlowLayout());
    private JPanel droite = new JPanel(new GridBagLayout());
    private JPanel bas = new JPanel(new GridBagLayout());

	private JLabel titre = new JLabel("Pota'Gestion");
	
	private JLabel outils = new JLabel("Outils");
	private JLabel couperHorizontale = new JLabel("CouperH");
    private JLabel couperVerticale = new JLabel("CouperV");
	private JLabel reunir = new JLabel("Réunir");

    private JLabel sol = new JLabel("Sol");
    private JLabel doublebechage = new JLabel("double-bêchage");
    private JLabel bechage =  new JLabel("bêchage");
    private JLabel sarclage = new JLabel("sarclage");
    private JLabel desherbage =  new JLabel("desherbage");
    private JLabel amendement = new JLabel("amendement terre");
    private JLabel traitementpurin = new JLabel("traitement purin");

    private JLabel legumes = new JLabel("Légumes");
    private JLabel semer = new JLabel("Semer");
    private JLabel transplanter = new JLabel("Transplanter");
    private JLabel recolter = new JLabel("Récolter");
    private JLabel arracher = new JLabel("Arracher");

    private JLabel observer = new JLabel("Observer");
    private JLabel maladie = new JLabel("Maladie");
    private JLabel ravageurs = new JLabel("Ravageurs");
    private JLabel historique = new JLabel("Historique");

    private JLabel parcellefirst = new JLabel("Sous-parcelle 1");
    private JLabel parcellesecond = new JLabel("Sous-parcelle 2");
    private JLabel parcellemere = new JLabel("Parcelle mere");
    private JLabel parcelleracine = new JLabel("Parcelle racine");

    private AffichageParcelleListener mlisten;
    private HistoriqueListener hlisten;
    private LegumeHistorique hllisten;
	private ArrayList<AffichageParcelle> testList = new ArrayList<AffichageParcelle>();
    private ArrayList<Conteneur> contList = new ArrayList<Conteneur>();
    private GestParc start;

	public ParcelleGest(){

	    this.setTitle("Exercice 2");
		this.setExtendedState(this.MAXIMIZED_BOTH);
	    this.setLocation(0, 0);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.setParcelleGest();
        this.setPanelBackground();
        this.revalidate();
	    this.setVisible(true);
	}


	public void setPanelBackground(){

	    fond.setBackground(new Color(54,66,77));
	    this.add(fond,BorderLayout.CENTER);
        start = new GestParc(this);
        start.visuRoot();

        /*Action sur parcelle */

        mlisten = new AffichageParcelleListener(this,start);

        parcellesecond.addMouseListener(mlisten);
        parcelleracine.addMouseListener(mlisten);
        parcellemere.addMouseListener(mlisten);
        parcellefirst.addMouseListener(mlisten);
        couperHorizontale.addMouseListener(mlisten);
        couperVerticale.addMouseListener(mlisten);
        reunir.addMouseListener(mlisten);
        historique.addMouseListener(mlisten);


        hlisten = new HistoriqueListener(this,start);

        doublebechage.addMouseListener(hlisten);
        bechage.addMouseListener(hlisten);
        sarclage.addMouseListener(hlisten);
        desherbage.addMouseListener(hlisten);
        amendement.addMouseListener(hlisten);
        traitementpurin.addMouseListener(hlisten);

        hllisten = new LegumeHistorique(this,start);

        semer.addMouseListener(hllisten);
        transplanter.addMouseListener(hllisten);
        recolter.addMouseListener(hllisten);
        arracher.addMouseListener(hllisten);

        maladie.addMouseListener(hlisten);
        ravageurs.addMouseListener(hlisten);
	}

	public void setParcelleGest(){

		GridBagConstraints gbc = new GridBagConstraints();


        haut.setBackground(new Color( 46, 134, 193 ));
        gauche.setBackground(new Color( 58, 60, 62 ));
        milieu.setBackground(Color.WHITE);
        droite.setBackground(new Color( 58, 60, 62 ));
        bas.setBackground(new Color( 46, 134, 193 ));

        Border bordure = BorderFactory.createLineBorder(new Color( 58, 60, 62 ), 1);
        haut.setBorder(bordure);
        gauche.setBorder(bordure);
        milieu.setBorder(bordure);
        droite.setBorder(bordure);
        bas.setBorder(bordure);

        outils.setOpaque(true);
        outils.setBackground(new Color( 118, 189, 254 ));
        couperHorizontale.setOpaque(true);
        couperHorizontale.setBackground(new Color( 58, 60, 62 ));
        couperHorizontale.setForeground(Color.WHITE);
        couperVerticale.setOpaque(true);
        couperVerticale.setBackground(new Color( 58, 60, 62 ));
        couperVerticale.setForeground(Color.WHITE);
        reunir.setOpaque(true);
        reunir.setBackground(new Color( 58, 60, 62 ));
        reunir.setForeground(Color.WHITE);
        sol.setOpaque(true);
        sol.setBackground(new Color( 118, 189, 254 ));
        doublebechage.setOpaque(true);
        doublebechage.setBackground(new Color( 58, 60, 62 ));
        doublebechage.setForeground(Color.WHITE);
        bechage.setOpaque(true);
        bechage.setBackground(new Color( 58, 60, 62 ));
        bechage.setForeground(Color.WHITE);
        sarclage.setOpaque(true);
        sarclage.setBackground(new Color( 58, 60, 62 ));
        sarclage.setForeground(Color.WHITE);
        desherbage.setOpaque(true);
        desherbage.setBackground(new Color( 58, 60, 62 ));
        desherbage.setForeground(Color.WHITE);
        amendement.setOpaque(true);
        amendement.setBackground(new Color( 58, 60, 62 ));
        amendement.setForeground(Color.WHITE);
        traitementpurin.setOpaque(true);
        traitementpurin.setBackground(new Color( 58, 60, 62 ));
        traitementpurin.setForeground(Color.WHITE);
        legumes.setOpaque(true);
        legumes.setBackground(new Color( 118, 189, 254 ));
        semer.setOpaque(true);
        semer.setBackground(new Color( 58, 60, 62 ));
        semer.setForeground(Color.WHITE);
        transplanter.setOpaque(true);
        transplanter.setBackground(new Color( 58, 60, 62 ));
        transplanter.setForeground(Color.WHITE);
        recolter.setOpaque(true);
        recolter.setBackground(new Color( 58, 60, 62 ));
        recolter.setForeground(Color.WHITE);
        arracher.setOpaque(true);
        arracher.setBackground(new Color( 58, 60, 62 ));
        arracher.setForeground(Color.WHITE);
        observer.setOpaque(true);
        observer.setBackground(new Color( 118, 189, 254 ));
        maladie.setOpaque(true);
        maladie.setBackground(new Color( 58, 60, 62 ));
        maladie.setForeground(Color.WHITE);
        ravageurs.setOpaque(true);
        ravageurs.setBackground(new Color( 58, 60, 62 ));
        ravageurs.setForeground(Color.WHITE);
        historique.setOpaque(true);
        historique.setBackground(new Color( 118, 189, 254 ));


        titre.setFont(new Font("Arial",Font.BOLD,20));

        gbc.fill = GridBagConstraints.BOTH;        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1.5;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        haut.add(titre);
        fond.add(haut, gbc);

        gbc.fill = GridBagConstraints.BOTH;        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 2;
        gbc.weighty = 9;

        gbc.gridwidth = gbc.gridheight = 1;
        GridLayout glg = new GridLayout(11,1);
        gauche.setLayout(glg);
        outils.setHorizontalAlignment(JLabel.CENTER);
        couperHorizontale.setHorizontalAlignment(JLabel.CENTER);
        couperVerticale.setHorizontalAlignment(JLabel.CENTER);
        reunir.setHorizontalAlignment(JLabel.CENTER);
        sol.setHorizontalAlignment(JLabel.CENTER);
        doublebechage.setHorizontalAlignment(JLabel.CENTER);
      
        bechage.setHorizontalAlignment(JLabel.CENTER);

        sarclage.setHorizontalAlignment(JLabel.CENTER);
 
        desherbage.setHorizontalAlignment(JLabel.CENTER);
   
        amendement.setHorizontalAlignment(JLabel.CENTER);
   
        traitementpurin.setHorizontalAlignment(JLabel.CENTER);
        
        gauche.add(outils);
        gauche.add(couperHorizontale);
        gauche.add(couperVerticale);
        gauche.add(reunir);
        gauche.add(sol);
        gauche.add(doublebechage);
        gauche.add(bechage);
        gauche.add(sarclage);
        gauche.add(desherbage);
        gauche.add(amendement);
        gauche.add(traitementpurin);
        fond.add(gauche, gbc);

        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 5;
        gbc.weighty = 9;
        fond.add(milieu, gbc);

        gbc.fill = GridBagConstraints.BOTH;        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 2;
        gbc.weighty = 9;
        gbc.gridwidth = gbc.gridheight = 1;
        GridLayout gld = new GridLayout(11,1);
        droite.setLayout(gld);
        legumes.setHorizontalAlignment(JLabel.CENTER);
        semer.setHorizontalAlignment(JLabel.CENTER);
        transplanter.setHorizontalAlignment(JLabel.CENTER);
     
        recolter.setHorizontalAlignment(JLabel.CENTER);
 
        arracher.setHorizontalAlignment(JLabel.CENTER);
 
        observer.setHorizontalAlignment(JLabel.CENTER);
        maladie.setHorizontalAlignment(JLabel.CENTER);

        ravageurs.setHorizontalAlignment(JLabel.CENTER);

        historique.setHorizontalAlignment(JLabel.CENTER);
  
        droite.add(legumes);
        droite.add(semer);
        droite.add(transplanter);
        droite.add(recolter);
        droite.add(arracher);
        droite.add(observer);
        droite.add(maladie);
        droite.add(ravageurs);
        droite.add(historique);
        fond.add(droite, gbc);

        gbc.fill = GridBagConstraints.BOTH; 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        GridLayout glb = new GridLayout(1,4);
        bas.setLayout(glb);
        parcellefirst.setHorizontalAlignment(JLabel.CENTER);
        parcellesecond.setHorizontalAlignment(JLabel.CENTER);
        parcellemere.setHorizontalAlignment(JLabel.CENTER);
        parcelleracine.setHorizontalAlignment(JLabel.CENTER);
        parcellefirst.setForeground(Color.WHITE);
      
        parcellesecond.setForeground(Color.WHITE);
        
        parcellemere.setForeground(Color.WHITE);
     
        parcelleracine.setForeground(Color.WHITE);
       
        bas.add(parcellefirst);
        bas.add(parcellesecond);
        bas.add(parcellemere);
        bas.add(parcelleracine);
        fond.add(bas, gbc);
    }

    public void setPanel(AffichageParcelle test){
        milieu.add(test,BorderLayout.CENTER);
        milieu.revalidate();
    }

    public void addConteneur(Conteneur cont){

        this.testList.add(cont.getFirstComponent());
        this.testList.add(cont.getSecondComponent());
        milieu.add(cont,BorderLayout.CENTER);
        milieu.revalidate();
    }

    public void removeLastPanel(AffichageParcelle test){
        milieu.remove(test);
        milieu.revalidate();
    }

    public void removeConteneur(Conteneur cont){
        milieu.remove(cont);
        milieu.revalidate();
    }


    public void removeAllPan(){
        milieu.removeAll();
        milieu.revalidate();
    }
}


