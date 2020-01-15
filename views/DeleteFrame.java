package views;

import api.*;
import models.*;
import controllers.*;
import java.awt.*;
import javax.swing.*;

public class DeleteFrame extends JFrame{


    private JPanel container = new JPanel(new GridBagLayout());
    private JFrame oldFrame;

	public DeleteFrame(JFrame oldFrame){

	super();
	this.oldFrame = oldFrame;

    this.setSize(400, 200);
    this.setResizable(false);
    this.setLocation(500, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    this.setComponent();
    this.setVisible(true);
	}

	public void setComponent(){

		JLabel titre = new JLabel("Quel Jardin voulez-vous détruire ?");
		JTextField choix = new JTextField();
		JButton buttonChoix = new JButton("Confirmer");

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 1;
        gc.insets = new Insets(0,0,10,0);

		container.add(titre,gc);

		gc.gridy = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;

		container.add(choix,gc);

		gc.gridy = 3;
		container.add(buttonChoix,gc);

		buttonChoix.addActionListener(new DeleteListener(choix,this,oldFrame));
		this.add(container);
	}
}




