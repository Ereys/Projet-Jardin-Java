package views;

import api.*;
import models.*;
import controllers.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HistoriqueFrame extends JFrame implements ActionListener{

	public HistoriqueFrame(JPanel panelHisto){
		 super();
        this.setTitle("Historique");
        this.setSize(800, 500);
        this.setResizable(false);
 		 this.setLocationRelativeTo(null);    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titre = new JLabel("Actions effectuées sur la parcelle");
        Font font = new Font("Arial",Font.BOLD,15);
        titre.setFont(font);
        titre.setHorizontalAlignment(SwingConstants.CENTER);

        JButton returne = new JButton("Retour");

        this.setLayout(new GridLayout(3,1));
        this.add(titre);
        this.add(panelHisto);
        this.add(returne);

        returne.addActionListener(this);


    	this.revalidate();
        this.setVisible(true);
	}


    public void actionPerformed(ActionEvent e) {
                
       	this.dispose();
   }


}