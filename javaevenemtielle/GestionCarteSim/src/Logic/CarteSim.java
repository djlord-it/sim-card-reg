
package Logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarteSim {
    private String id ,numero , classe;
    private String info;

    public CarteSim(String id, String numero, String classe) {
        this.id = id;
        this.numero = numero;
        this.classe = classe;
    }

    public CarteSim() {
      numero="Selectionnez la carte sim ";
    }

    
    
    @Override
    public String toString() {
        if(! numero.equals("Selectionnez la carte sim "))
        return  "n° " + numero + ", classe=" + classe ;
        else return "Selectionnez la carte sim ";
    }

  

          public void enregistrerCarteSim(){
         int i=db_Mysql.updateBD("insert into cartesim (id,numero,classe) values('"+this.id+"','"+this.numero+"','"+this.classe+"')");
         if(i>0){
             this.info="Carte Sim Ajoute !!!!!!";
         }else this.info="Echec d'Enregistrement !!!!!";
         
     }
  public void modifierCarteSim(){
         int i=db_Mysql.updateBD("update cartesim set  id='"+this.id+"',numero='"+this.numero+"',classe='"+this.classe+"'  where id='"+this.id+"'");
	
          if(i>0){
             this.info="Carte Sim  Modifiee avec succes !!!!!!";
         }else this.info="Echec de Mofification   !!!!!";
         
     }
             public void supprimerCarteSim(){
         int i=db_Mysql.updateBD("delete from cartesim  where id='"+this.id+"'");
           if(i>0){
             this.info="Carte Sim  est supprimee avec succes !!!!!!";
         }else this.info="Echec de Suppression !!!!!";
         
     }
    
             
                 public static CarteSim[][] remplirTableauDeuxDimensions(){
      List<CarteSim> carte=null;
      
      ResultSet result=db_Mysql.interrogerBD("select * from cartesim ");
    
      if(result!=null)
      {   carte=new ArrayList();
          try {
              
              while(result.next()){
                
                 carte.add(new CarteSim(result.getString("id"),result.getString("numero"),
                         result.getString("classe")));
                
                  
              }
          } catch (SQLException ex) {
              Logger.getLogger(CarteSim.class.getName()).log(Level.SEVERE, null, ex);
          }
               
          }
      
      CarteSim [][]data=null;
      
      if(carte!=null && carte.size()>0){
      
          data=new CarteSim[carte.size()][3];
          int  j=0;
          for(CarteSim d:carte){
             
              for(int i=0;i<3;i++)
                  data[j][i]=d;
              j++;
          
          }
          
      }
      
      
      return data;
  }  
    
                 public static void remplirComboBox(javax.swing.JComboBox comboBox){
        
        ResultSet result=db_Mysql.interrogerBD("select * from cartesim");
        
        comboBox.removeAllItems();
        comboBox.addItem(new CarteSim());
        if(result!=null)
        {
            try {
                while(result.next())
                {
                 comboBox.addItem(new CarteSim(result.getString("id"),result.getString("numero"),result.getString("classe")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CarteSim.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
         public static CarteSim get_CarteSim_By_ID(String idCarteSim){
      
       ResultSet result=db_Mysql.interrogerBD("select * from cartesim where id='"+idCarteSim+"'");
       
       if(result!=null)
           try {
               if(result.next())
                   return new CarteSim(result.getString("id"),result.getString("numero"),result.getString("classe"));
              
               result.close();
       } catch (SQLException ex) {
           Logger.getLogger(CarteSim.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("Problem");
       }
          return null;
         }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getInfo() {
        return info;
    }

}
