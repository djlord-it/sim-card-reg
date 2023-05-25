/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author utilisateur
 */
public class db_Mysql {
  

    static Connection con;
	public static String rapporteur;
	private static void getInstance(){
		rapporteur="";
		try {
			
		    Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cartesim", "root", "");
		    rapporteur="succes";
			//System.out.println("La connexion a �t� �tablie avec succes");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rapporteur="La connexion echouee";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rapporteur="Connexion echouee";
		}
			
		
		
	
	}
	
	public static ResultSet interrogerBD(String requete){
		ResultSet result=null;
		Statement st=null;
		if(con==null)
			getInstance();
		if(rapporteur.equalsIgnoreCase("succes"))
		{ 
			try {
				st=con.createStatement();
				result=st.executeQuery(requete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	public static int updateBD(String requete){
		int result=-1;
		Statement st=null;
		if(con==null)
			getInstance();
		if(rapporteur.equalsIgnoreCase("succes"))
		{
			try {
				st=con.createStatement();
				result=st.executeUpdate(requete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
    
}
