
package GestionnairesDevenements;

import Fenetres.CarteSimUI;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author User
 */
public class TableCarteSimGE implements ListSelectionListener{
  private CarteSimUI screen;

    public TableCarteSimGE(CarteSimUI screen) {
        this.screen = screen;
    }
  
    @Override
    public void valueChanged(ListSelectionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         String id,numero,classe;
         
         id=(String) screen.getTableCarteSim().getValueAt(screen.getTableCarteSim().getSelectedRow(), 0);
           numero=(String) screen.getTableCarteSim().getValueAt(screen.getTableCarteSim().getSelectedRow(), 1);
             classe=(String) screen.getTableCarteSim().getValueAt(screen.getTableCarteSim().getSelectedRow(), 2);
             
             screen.getId().setText(id);
             screen.getNumero().setText(numero);
             screen.getClasse().setText(classe);
    }
    
}
