/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionnairesDevenements;

import Fenetres.ClientUI;
import Logic.Client;
import ModelTable.Model_Client_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ClientGE  implements ActionListener{
    ClientUI screen;

    public ClientGE(ClientUI screen) {
        this.screen = screen;
    }

    public void initialiserLesChampsDeSaisie(){
      screen.getNom().setText("");
        screen.getPrenom().setText("");
        screen.getIdentite().setText("");
        screen.getComboBox().setSelectedIndex(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 
        
        if (e.getActionCommand().equals("ENREGISTRER")){
        
                   Client client = new Client(screen.getNom().getText(), screen.getPrenom().getText(), screen.getIdentite().getText(),screen.getSelectedCarteSimByComboBox());
      client.enregistrerClient();
        JOptionPane.showMessageDialog(null, client.getInformation());
          screen.getTableClient().setModel(new Model_Client_Table(Client.remplirTableauClientDeDeuxDimensions()));
      initialiserLesChampsDeSaisie();
        
        }
        
        
        
       
    }
    
    
}
