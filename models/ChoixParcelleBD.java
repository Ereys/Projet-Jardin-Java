package models;

import api.*;
import views.*;
import controllers.*;
import java.sql.*;

public class ChoixParcelleBD{



/* ----------------------------------------------------------------------------------------------------------------------- */

	private static void Deconnexion(Connection link){

		try{
			link.close();
		}catch(SQLException e){
			System.out.println(e);
		}
	}



/* ----------------------------------------------------------------------------------------------------------------------- */


	public void addJardin(int idUser, String name, int longueur, int largeur){

		try{
			Connection link = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/ribollet","ribollet","iutfbleau77126");
			try{
				PreparedStatement req = link.prepareStatement("Insert into Jardin values(?,0,?,?,?);");
				req.setInt(1, idUser);
				req.setString(2,name);
				req.setInt(3,longueur);
				req.setInt(4,largeur);
				req.executeQuery();

				req = link.prepareStatement("Insert into Parcelle values(1,?,'HORIZONTAL', ? , ? , NULL,NULL)");
				req.setInt(1,this.getIdParcelleMere(idUser));
				req.setInt(2,longueur);
				req.setInt(3,largeur);
				req.executeQuery();
				
				req.close();
				Deconnexion(link);
			}catch(SQLException sqle){
				System.out.println("Erreur lors des requêtes" + sqle);
			}
		 }catch(SQLException e){
			System.out.println("Erreur lors de la connexion "+e);
		}
	}


/* ----------------------------------------------------------------------------------------------------------------------- */

	public void deleteJardin(String name){

		try{
			Connection link = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/ribollet","ribollet","iutfbleau77126");
			try{
				PreparedStatement req = link.prepareStatement("DELETE FROM Parcelle WHERE Parcelle.idParcelleRacine IN (SELECT idParcelleMere FROM Jardin WHERE Jardin.nomJardin = ?)");
				req.setString(1,name);
				req.executeQuery();

				req = link.prepareStatement("DELETE FROM Jardin WHERE Jardin.nomJardin = ?");
				req.setString(1,name);
				req.executeQuery();

				req.close();
				Deconnexion(link);
			}catch(SQLException sqle){
				System.out.println("Erreur lors des requêtes" + sqle);
			}
		 }catch(SQLException e){
			System.out.println("Erreur lors de la connexion"+e);
		}
	}


/* ----------------------------------------------------------------------------------------------------------------------- */

	public int getIdParcelleMere(int idUser){

		int idRoot = 0;

		try{
			Connection link = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/ribollet","ribollet","iutfbleau77126");
			try{			
				PreparedStatement req = link.prepareStatement("Select MAX(idParcelleMere) FROM Jardin WHERE idCreateur = ?");
				req.setInt(1,idUser);
				ResultSet result = req.executeQuery();

				while(result.next()){
					idRoot = result.getInt("MAX(idParcelleMere)");	
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
		return idRoot;
	}


/* ----------------------------------------------------------------------------------------------------------------------- */

	public int getNbJardin(int idUser){

		int nbJardin = 0;

		try{
			Connection link = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/ribollet","ribollet","iutfbleau77126");
			try{			
				PreparedStatement req = link.prepareStatement("SELECT COUNT(DISTINCT nomJardin) FROM Jardin join Utilisateur WHERE idCreateur = ?");
				req.setInt(1,idUser);
				ResultSet result = req.executeQuery();

				while(result.next()){
					nbJardin = result.getInt("COUNT(DISTINCT nomJardin)");	
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
		return nbJardin;
	}


/* ----------------------------------------------------------------------------------------------------------------------- */


	public int getNbParcelle(int idRoot){

		int nbParcelle = 0;

		try{
			Connection link = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/ribollet","ribollet","iutfbleau77126");
			try{			
				PreparedStatement req = link.prepareStatement("SELECT COUNT(DISTINCT idParcelleRacine) From Parcelle WHERE idParcelleRacine = ?");
				req.setInt(1,idRoot);
				ResultSet result = req.executeQuery();

				while(result.next()){
					nbParcelle = result.getInt("COUNT(DISTINCT idParcelleRacine)");	
				}
				result.close();
				req.close();
				Deconnexion(link);
			}catch(SQLException sqle){
				System.out.println("Erreur lors des requêtes getNbParcelle"  + sqle);
			}
		}catch(SQLException e){
			System.out.println("Erreur lors de la connexion "+e);
		}
		return nbParcelle;
	}



/* ----------------------------------------------------------------------------------------------------------------------- */

	public String[][] getInformationJardin(int idUser, int nbJardin){

		String[][] infoJardin = new String[nbJardin][4];
		try{
			Connection link = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/ribollet","ribollet","iutfbleau77126");
			try{			
				PreparedStatement req = link.prepareStatement("SELECT DISTINCT idParcelleMere, nomJardin, Longueur, Largeur FROM Jardin join Utilisateur WHERE idCreateur = ?");
				req.setInt(1,idUser);
				ResultSet result = req.executeQuery();

				for(int step1 = 0; step1 < nbJardin && result.next(); step1++){
					infoJardin[step1][0] = result.getString("idParcelleMere");
					infoJardin[step1][1] = result.getString("nomJardin");
					infoJardin[step1][2] = result.getString("Longueur");
					infoJardin[step1][3] = result.getString("Largeur");
				}

				result.close();
				req.close();
				Deconnexion(link);

			}catch(SQLException sqle){
				System.out.println("Erreur lors des requêtes getInformationJardin" + sqle);
			}
		}catch(SQLException e){
			System.out.println("Erreur lors de la connexion "+e);
		}
		return infoJardin;
	}
	

/* ----------------------------------------------------------------------------------------------------------------------- */

	public String[][] getInformationParcelle(int idRoot, int nbParcelle){

		String[][] infoJardin = new String[nbParcelle][7];
		try{
			Connection link = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/ribollet","ribollet","iutfbleau77126");
			try{			
				PreparedStatement req = link.prepareStatement("SELECT DISTINCT * FROM Parcelle WHERE Parcelle.idParcelleRacine = ?;");
				req.setInt(1,idRoot);
				ResultSet result = req.executeQuery();
				for(int step1 = 0; step1 < nbParcelle && result.next(); step1++){
					infoJardin[step1][0] = result.getString("idParcelleMere");
					infoJardin[step1][1] = result.getString("idParcelleRacine");
					infoJardin[step1][2] = result.getString("position");
					infoJardin[step1][3] = result.getString("longueur");
					infoJardin[step1][4] = result.getString("largeur");
					infoJardin[step1][5] = result.getString("idParcelleFils1");
					infoJardin[step1][6] = result.getString("idParcelleFils2");
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
		return infoJardin;
	}

/* ----------------------------------------------------------------------------------------------------------------------- */

	public int getIdRoot(String nomJardin){

		int idRoot = 0;

		try{
			Connection link = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/ribollet","ribollet","iutfbleau77126");
			try{			
				PreparedStatement req = link.prepareStatement("Select DISTINCT idParcelleRacine FROM Parcelle join Jardin WHERE nomJardin = ?");
				req.setString(1,nomJardin);
				ResultSet result = req.executeQuery();

				while(result.next()){
					idRoot = result.getInt("idParcelleRacine");	
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
		return idRoot;
	}
}