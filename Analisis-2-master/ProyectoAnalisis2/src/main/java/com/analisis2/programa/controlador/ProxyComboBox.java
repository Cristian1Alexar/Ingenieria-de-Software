package com.analisis2.programa.controlador;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataListener;

/*
 * @author Juan Diego Arriola
 */
public class ProxyComboBox implements ComboBoxModel{

    private DefaultComboBoxModel realSubject = new DefaultComboBoxModel<>();
    
    public ProxyComboBox(List producto)
    {
        for (Object objeto : producto) 
        {
            realSubject.addElement(objeto);
        }
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        realSubject.setSelectedItem(anItem);
    }

    @Override
    public Object getSelectedItem() {
        return realSubject.getSelectedItem();
    }

    @Override
    public int getSize() {
        return realSubject.getSize();
    }

    @Override
    public Object getElementAt(int index) {
        return realSubject.getElementAt(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        realSubject.addListDataListener(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        realSubject.removeListDataListener(l);
    }
    
}

