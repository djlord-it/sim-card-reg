/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionnairesDevenements;

import Fenetres.ClientUI;
import Logic.CarteSim;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ComboBoxGE implements ItemListener{
    private ClientUI screen;

    public ComboBoxGE(ClientUI screen) {
        this.screen = screen;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    screen.setSelectedCarteSimByComboBox((CarteSim) e.getItem());
    }
    
    
}
