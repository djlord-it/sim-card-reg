/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionnairesDevenements;

import Fenetres.CarteSimUI;
import Logic.CarteSim;
import ModelTable.Model_CarteSim_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CarteSimGE  implements ActionListener{
    CarteSimUI screen;

    public CarteSimGE(CarteSimUI screen) {
        this.screen = screen;
    }

    public void initialiserLesChampsDeSaisie(){
      screen.getId().setText("");
        screen.getNumero().setText("");
        screen.getClasse().setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 
        
        if (e.getActionCommand().equals("ENREGISTRER")){
        
                   CarteSim sim = new CarteSim(screen.getId().getText(), screen.getNumero().getText(), screen.getClasse().getText());
        sim.enregistrerCarteSim();
        JOptionPane.showMessageDialog(null, sim.getInfo());
            screen.getTableCarteSim().setModel(new Model_CarteSim_Table(CarteSim.remplirTableauDeuxDimensions()));
      initialiserLesChampsDeSaisie();
        
        }
         else if(e.getActionCommand().equals("MODIFIER")){
    
               CarteSim sim = new CarteSim(screen.getId().getText(), screen.getNumero().getText(), screen.getClasse().getText());
        sim.modifierCarteSim();
        JOptionPane.showMessageDialog(null, sim.getInfo());
            screen.getTableCarteSim().setModel(new Model_CarteSim_Table(CarteSim.remplirTableauDeuxDimensions()));
     initialiserLesChampsDeSaisie();
    
    }
    else if(e.getActionCommand().equals("SUPPRIMER")){
    
               CarteSim sim = new CarteSim(screen.getId().getText(), screen.getNumero().getText(), screen.getClasse().getText());
        sim.supprimerCarteSim();
        JOptionPane.showMessageDialog(null, sim.getInfo());
            screen.getTableCarteSim().setModel(new Model_CarteSim_Table(CarteSim.remplirTableauDeuxDimensions()));
     
    initialiserLesChampsDeSaisie();
    }
    }
    
    
}
