package model;

import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
public class ExcelExporter  {
    public ExcelExporter() { }
    public void exportTable(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
	    
        FileWriter out = new FileWriter(file);
        
        for(int i=0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");
        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                out.write(model.getValueAt(i,j).toString()+"\t");
            
            }
            out.write("\n");
        }
        out.close();
       
    }
    

}

