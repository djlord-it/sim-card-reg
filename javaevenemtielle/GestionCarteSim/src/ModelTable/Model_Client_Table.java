
package ModelTable;

import Logic.Client;
import javax.swing.table.AbstractTableModel;


public class Model_Client_Table extends AbstractTableModel {

    private String[] titles = new String[]{"ID", "NOM","PRENOM", "CNI", "CARTESIM"};
    
    private Client[][] data;

    public String getColumnName(int col) {
        return titles[col];
    }

    public Model_Client_Table(Client[][] carts) {
        data = carts;

    }

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (data != null) {
            return data.length;
       } else {
            return -1;
        }
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (titles == null) {
            return -1;
        }
        return titles.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (data != null) {
            if (columnIndex == 0 && rowIndex >= 0) {
                return data[rowIndex][columnIndex].getId();
            } else if (columnIndex == 1 && rowIndex >= 0) {
                return data[rowIndex][columnIndex].getNom();
                  } else if (columnIndex == 2 && rowIndex >= 0) {
                return data[rowIndex][columnIndex].getPrenom();
                  } else if (columnIndex == 3 && rowIndex >= 0) {
                return data[rowIndex][columnIndex].getIdentite();
            } else if (columnIndex == 4 && rowIndex >= 0) {
                try {
                     return  data[rowIndex][columnIndex].getSim().getNumero();
                } catch (Exception e) {
                }
               
            }
          
        }
        
        return null;
    
    }
}
