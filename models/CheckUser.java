package models;

import api.*;
import views.*;
import controllers.*;

import java.sql.*;

public class CheckUser{

	private String[] user = new String[3];

	private static void Deconnexion(Connection link){

		try{
			link.close();
		}catch(SQLException e){
			System.out.println(e);
		}
	}

	public String[] checkIdentifiers(String email, String password){

		int id = 0;

		try{
			Connection link = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/ribollet","ribollet","iutfbleau77126");
			try{
				PreparedStatement req = link.prepareStatement("Select idUser,email,motDePasse from Utilisateur WHERE email =? && motDePasse =?");
				req.setString(1,email);
				req.setString(2,password);
				ResultSet result = req.executeQuery();

				while(result.next()){
					this.user[0] = result.getString("email");
					this.user[1] = result.getString("motDePasse");
					this.user[2] = Integer.toString(result.getInt("idUser"));
				}
				result.close();
				req.close();
				Deconnexion(link);
			}catch(SQLException sqle){
				System.out.println("Erreur lors des requêtes" + sqle);
			}
		}catch(SQLException e){
			System.out.println("Erreur lors de la connexion "+e);
		}
		return user;
	}
}