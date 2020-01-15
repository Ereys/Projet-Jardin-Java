package views;


import api.*;
import models.*;
import controllers.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LegumeFrame extends JFrame implements ActionListener{

	private JTextField nomLegume;
	private JComboBox liste1;
	LegumeHistorique lh;

	public LegumeFrame(LegumeHistorique lh){

    	super();
        this.setTitle("Choix Legume");
        this.setSize(500, 300);
        this.setResizable(false);
 		 this.setLocationRelativeTo(null);      
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	 this.lh = lh;

		Object[] elements = new Object[]{FamilleLegume.AUTRE, FamilleLegume.ALLIACEES, FamilleLegume.CHENOPODES, FamilleLegume.CUCURBITACEES, FamilleLegume.CRUCIFERES, FamilleLegume.LEGUMINEUSES, FamilleLegume.OMBELLIFERES, FamilleLegume.SOLANACEES};

    	 JPanel page = new JPanel(new GridLayout(5,1));

    	 JLabel nom = new JLabel("Nom Legume : ");
    	 nomLegume = new JTextField();
      	 JLabel famille = new JLabel("Famille Legume : ");
		 liste1 = new JComboBox(elements);
		 JButton button = new JButton("Validé");

		 button.addActionListener(this);

      	 page.add(nom);
    	 page.add(nomLegume);
    	 page.add(famille);
    	 page.add(liste1);
    	 page.add(button);

    	 this.add(page);
    	 this.revalidate();
    	 this.setVisible(true);
	}

    public void actionPerformed(ActionEvent e) {
                
       	if(!this.nomLegume.getText().equals("")){
       		createLegume(nomLegume.getText(), (FamilleLegume)liste1.getSelectedItem());
      		this.dispose(); 
        }else{
        	nomLegume.setBackground(Color.RED);
        }
   }

   public void createLegume(String nom, FamilleLegume leg){

        lh.setActionLegume(new LegumeJ(nom,leg));
   }


}