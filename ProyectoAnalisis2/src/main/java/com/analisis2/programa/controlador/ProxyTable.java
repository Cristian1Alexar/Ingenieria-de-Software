package com.analisis2.programa.controlador;

import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * @author Juan Diego Arriola
 */
public class ProxyTable implements TableModel{

    private DefaultTableModel realSubject = new DefaultTableModel();
    
    public ProxyTable()
    {

    }
    
    public void nombresDeColumnas(List nombres)
    {
        for (Object objeto : nombres) {
            realSubject.addColumn(objeto);
        }
    }
    
    public void agregarFila(List nombres)
    {
        Object[] datosFilas = new Object[nombres.size()];
        
        int cont = 0;
        for (Object objeto : nombres) 
        {
            datosFilas[cont] = objeto;
            cont++;
        }
        realSubject.addRow(datosFilas);
    }
    
    @Override
    public int getRowCount() {
        return realSubject.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return realSubject.getColumnCount();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return realSubject.getColumnName(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return realSubject.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return realSubject.isCellEditable(rowIndex, columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return realSubject.getValueAt(rowIndex, columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        realSubject.setValueAt(aValue, rowIndex, columnIndex);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        realSubject.addTableModelListener(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        realSubject.removeTableModelListener(l);
    }
    
}
