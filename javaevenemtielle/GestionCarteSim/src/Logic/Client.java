/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Client {
    private int id;
    private String nom,prenom,identite;
    private CarteSim sim;
    private String information;

    public Client(int id, String nom, String prenom, String identite, CarteSim sim) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.identite = identite;
        this.sim = sim;
    }

    public Client(String nom, String prenom, String identite, CarteSim sim) {
        this.nom = nom;
        this.prenom = prenom;
        this.identite = identite;
        this.sim = sim;
    }

         public void enregistrerClient(){
         int i=db_Mysql.updateBD("insert into client (nom,prenom,identite,sim) values('"+this.nom+"','"+this.prenom+"','"+this.identite+"','"+this.sim.getId()+"')");
         if(i>0){
             this.information="ClientAjoute Avec Succes !!!!!!";
         }else this.information="Echec d'Enregistrement !!!!!";
         
     }
  
    
             
                 public static Client[][] remplirTableauClientDeDeuxDimensions(){
      List<Client> listClient=null;
      
      ResultSet result=db_Mysql.interrogerBD("select * from client ");
    
      if(result!=null)
      {   listClient=new ArrayList();
          try {
              
              while(result.next()){
                
                 listClient.add(new Client(result.getInt("id"),result.getString("nom"),
                         result.getString("prenom"),result.getString("identite"),
                        CarteSim.get_CarteSim_By_ID( result.getString("sim"))));
                
                  
              }
          } catch (SQLException ex) {
              Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
          }
               
          }
      
      Client [][]data=null;
      
      if(listClient!=null && listClient.size()>0){
      
          data=new Client[listClient.size()][5];
          int  j=0;
          for(Client c:listClient){
             
              for(int i=0;i<5;i++)
                  data[j][i]=c;
              j++;
          
          }
          
      }
      
      
      return data;
  }  
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public CarteSim getSim() {
        return sim;
    }

    public void setSim(CarteSim sim) {
        this.sim = sim;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    
    
    
    
    
    
    
}
