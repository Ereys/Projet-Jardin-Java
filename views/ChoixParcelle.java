package views;


import api.*;
import models.*;
import controllers.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class ChoixParcelle extends JFrame{

    private JPanel container = new JPanel(new GridBagLayout());
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel(new GridBagLayout());
    private JPanel panel3 = new JPanel(new GridLayout(2,2));
    private JPanel panel4 = new JPanel();

    private JPanel[] tabPanel;
    private String[] nameGarden;

    private ChoixListener buttonController;


    /**
    *
    *   Constructeur de la fenetre
    *
    */
	public ChoixParcelle(){

    super();
    this.setTitle("PotaGestion");
    this.setSize(1500, 800);
    this.setLocation(0, 0);
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    this.setLocationRelativeTo(null);         
    setPanel();
	}



    /**
    *
    *   Méthode gérant l'affichage de la page d'accueil
    *
    */
    public void setPanel(){

        ChoixParcelleCT controlleur = new ChoixParcelleCT(this);

        panel1.setBackground(new Color( 46, 134, 193 ));
        panel2.setBackground(new Color( 58, 60, 62 ));
        panel3.setBackground(new Color( 58, 60, 62 ));

        JLabel titre = new JLabel("Mes Jardins");
        JLabel potaGestion = new JLabel("Pota'Gestion");
        JButton addParcelle = new JButton("Ajouter jardin");
        JButton deleteParcelle = new JButton("Supprimer jardin");

        addParcelle.setBackground(Color.GREEN); 
        deleteParcelle.setBackground(Color.RED); 
        potaGestion.setFont(new Font("Arial",Font.BOLD,50));
        titre.setFont(new Font("Arial",Font.BOLD,25));

        GridBagConstraints gc = new GridBagConstraints();

        createPattern(controlleur.setNbJardin());

        Border border = BorderFactory.createEmptyBorder(30, 0, 30, 0);
        potaGestion.setBorder(border);
        potaGestion.setForeground(Color.WHITE);
        panel1.add(potaGestion);

        gc.gridx = 1;
        gc.insets = new Insets(10,0,25,100);  /* top left bottom right */
        panel2.add(addParcelle,gc);

        gc.gridx = 2;
        gc.insets = new Insets(10,100,25,0);
        panel2.add(deleteParcelle,gc);


        buttonController = new ChoixListener(addParcelle, deleteParcelle, this);
        addParcelle.addActionListener(buttonController);
        deleteParcelle.addActionListener(buttonController);

        titre.setForeground(Color.WHITE);
        Border emptyBorder = BorderFactory.createEmptyBorder(40, 20, 20, 0);
        titre.setBorder(emptyBorder);
        panel4.add(titre);
        panel4.setBackground(new Color( 58, 60, 62 ));

        gc.gridy=0;
        gc.weightx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.fill = GridBagConstraints.HORIZONTAL;

        container.add(panel1,gc);


        gc.fill = GridBagConstraints.BOTH;
        gc.gridy=2;

        container.add(panel2,gc);

        gc.gridy = 1;
        gc.weightx= 1;

        container.add(panel4,gc);

        gc.gridy=3;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.BOTH;

        this.add(panel3,BorderLayout.CENTER);

        this.add(container,BorderLayout.NORTH);

        this.setVisible(true);
    }



    /**
    *
    *   @param nbJardin
    *   Permet de générer une nouvelle vue de jardin dans l'écran de sélection de ces derniers 
    *
    */
    public void createPattern(int nbJardin){


        ImageIcon icon = new ImageIcon(new ImageIcon("Jardin.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

        for(int i = 0; i < nbJardin; i++){

             JPanel panelJardin = new JPanel(new GridBagLayout());
             panelJardin.setBackground(new Color( 58, 60, 62 ));
             GridBagConstraints gc = new GridBagConstraints();

             gc.gridy = 1;
             gc.weightx = 1;

             JLabel nomJardin = new JLabel(ChoixParcelleCT.tabJardin[i][1]);

             nomJardin.setFont(new Font("Arial",Font.BOLD,15));
             nomJardin.setForeground(Color.WHITE);
             panelJardin.add(nomJardin, gc);
             
             gc.gridy = 2;

             JLabel image = new JLabel(ChoixParcelleCT.tabJardin[i][1], icon, 0);
             image.setFont(new Font("Arial",Font.BOLD,0));
             panelJardin.add(image,gc);

             image.addMouseListener(new PanelListener());
             panel3.add(panelJardin);
         }

    }


    /**
    *
    *   @param panel
    *   Rafraichissement de la page de sélection de jardin (nécessaire après appel à la méthode createPattern()) 
    *
    */
    public void refreshPanel(JPanel panel){
        panel.revalidate();
    }

}



