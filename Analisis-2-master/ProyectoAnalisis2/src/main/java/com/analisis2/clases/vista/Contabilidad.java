/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analisis2.clases.vista;

import com.analisis2.clases.modelo.Cuenta;
import com.analisis2.clases.modelo.Producto;
import static com.analisis2.clases.tipos.TiposCuenta.ACTIVO;
import static com.analisis2.clases.tipos.TiposCuenta.COSTO;
import static com.analisis2.clases.tipos.TiposCuenta.GASTO;
import static com.analisis2.clases.tipos.TiposCuenta.INGRESO;
import static com.analisis2.clases.tipos.TiposCuenta.PASIVO;
import com.analisis2.consultas.modelo.ConsultaCuenta;
import com.analisis2.insercion.modelo.IncersionCuenta;
import com.analisis2.modificaciones.modelo.ModificarCuenta;
import com.analisis2.programa.controlador.Activo;
import com.analisis2.programa.controlador.ClasificadorCuenta;
import com.analisis2.programa.controlador.Costo;
import com.analisis2.programa.controlador.Gasto;
import com.analisis2.programa.controlador.Ingreso;
import com.analisis2.programa.controlador.LectorDeBarras;
import com.analisis2.programa.controlador.Pasivo;
import com.analisis2.programa.controlador.ProxyTable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class Contabilidad extends javax.swing.JFrame {

    /**
     * Creates new form Contabilidad
     */
    Cuenta cuenta;
    ConsultaCuenta consulta; 
    ProxyTable tabla;
    ClasificadorCuenta clasificador;
    ClasificadorCuenta nuevascuentas; 
    List<Cuenta> listaCuentas;
    
    public Contabilidad() {
        initComponents();
        clasificador = new ClasificadorCuenta();
        nuevascuentas = new ClasificadorCuenta();
        consulta = new ConsultaCuenta();
        tabla = new ProxyTable();
        this.llenarColumnas(); 
    }
    private void llenarColumnas()
    {
        List listaNombres = new ArrayList();
        listaNombres.add("Nombre");
        listaNombres.add("Activo");
        listaNombres.add("Pasivo");
        listaNombres.add("Ingreso");
        listaNombres.add("Costo");
        listaNombres.add("Gasto");
        tabla.nombresDeColumnas(listaNombres);
        jTable1.setModel(tabla);
        List<Cuenta> listaCuentas = consulta.consultar();
       
        if (listaCuentas != null)
        {
            for (int i = 0; i < listaCuentas.size(); i++) {
            if (listaCuentas.get(i).getTipo() == ACTIVO)
            {
                List listac = new ArrayList(); 
                listac.add(listaCuentas.get(i).getNombre());
                listac.add(listaCuentas.get(i).getMonto()); 
                listac.add("0");
                listac.add("0");
                listac.add("0");
                listac.add("0"); 
                Activo nuevaActivo = new Activo();
                nuevaActivo.setNombre(listaCuentas.get(i).getNombre());
                nuevaActivo.setMonto(listaCuentas.get(i).getMonto());
                tabla.agregarFila(listac);
            }    
            if (listaCuentas.get(i).getTipo() == PASIVO)
            {
                List listac = new ArrayList(); 
                listac.add(listaCuentas.get(i).getNombre());
                listac.add("0");
                listac.add(listaCuentas.get(i).getMonto()); 
                listac.add("0");
                listac.add("0");
                listac.add("0"); 
                Pasivo nuevaPasivo = new Pasivo();
                nuevaPasivo.setNombre(listaCuentas.get(i).getNombre());
                nuevaPasivo.setMonto(listaCuentas.get(i).getMonto());
                tabla.agregarFila(listac);
            }   
            if (listaCuentas.get(i).getTipo() == INGRESO)
            {
                List listac = new ArrayList(); 
                listac.add(listaCuentas.get(i).getNombre());
                listac.add("0");
                
                listac.add("0");
                listac.add(listaCuentas.get(i).getMonto()); 
                listac.add("0");
                listac.add("0"); 
                Ingreso nuevaIngreso = new Ingreso();
                nuevaIngreso.setNombre(listaCuentas.get(i).getNombre());
                nuevaIngreso.setMonto(listaCuentas.get(i).getMonto());
                tabla.agregarFila(listac);
            }   
            if (listaCuentas.get(i).getTipo() == COSTO)
            {
                List listac = new ArrayList(); 
                listac.add(listaCuentas.get(i).getNombre());
                listac.add("0");
                
                listac.add("0");
                listac.add("0");
                listac.add(listaCuentas.get(i).getMonto()); 
                listac.add("0"); 
                Costo nuevaCosto = new Costo();
                nuevaCosto.setNombre(listaCuentas.get(i).getNombre());
                nuevaCosto.setMonto(listaCuentas.get(i).getMonto());
                tabla.agregarFila(listac);
            }   
            if (listaCuentas.get(i).getTipo() == GASTO)
            {
                List listac = new ArrayList(); 
                listac.add(listaCuentas.get(i).getNombre());
                listac.add("0");
                
                listac.add("0");
                listac.add("0");
                listac.add("0"); 
                listac.add(listaCuentas.get(i).getMonto()); 
                Gasto nuevaGasto = new Gasto();
                nuevaGasto.setNombre(listaCuentas.get(i).getNombre());
                nuevaGasto.setMonto(listaCuentas.get(i).getMonto());
                tabla.agregarFila(listac);
            }   
        }
        
        }
        
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 240, 240));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Ingresar Nombre  de Cuenta");

        jLabel2.setText("Ingresar Monto de Cuenta");

        jToggleButton1.setText("Agregar Cuenta");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Activo");
        jRadioButton1.setContentAreaFilled(false);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Pasivo");
        jRadioButton2.setContentAreaFilled(false);

        jLabel4.setText("Cuentas: ");

        jToggleButton2.setText("Ver Reporte");
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseClicked(evt);
            }
        });

        jButton1.setText("Menu");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Eliminar Cuenta");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Ingreso");
        jRadioButton3.setContentAreaFilled(false);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Costo");
        jRadioButton4.setContentAreaFilled(false);

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Gasto");
        jRadioButton5.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jToggleButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jToggleButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2))))
                        .addGap(98, 98, 98))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton1)
                            .addComponent(jButton2))
                        .addGap(152, 152, 152)
                        .addComponent(jButton1)
                        .addGap(147, 147, 147))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(48, 48, 48)
                        .addComponent(jToggleButton2)
                        .addGap(163, 163, 163))))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modulo de Contabilidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() == -1)
        {
            System.out.println("Hola");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked

            IncersionCuenta ic = new IncersionCuenta();
            String nombre = jTextField1.getText();
            float monto = Float.parseFloat(jTextField2.getText());
            if (nombre.equals(""))
            {
                System.out.println("No hay ningun nombre ingresado");
            }
            else if (monto == 0)
            {
                System.out.println("No hay ningun monto ingresado ");
            }
            else 
            {
            
                List lista = new ArrayList();

                lista.add(jTextField1.getText());
                if (jRadioButton1.isSelected())
                {
                  lista.add(jTextField2.getText());
                  lista.add("0");
                  lista.add("0");
                  lista.add("0");
                  lista.add("0");
                  Activo cuentaActivo = new Activo(); 
                  cuentaActivo.setNombre(nombre);
                  cuentaActivo.setMonto(monto);
                  ic.insertar(cuentaActivo);          
                }
                if(jRadioButton2.isSelected())
                {

                  lista.add("0");
                  lista.add(jTextField2.getText());
                  lista.add("0");
                  lista.add("0");
                  lista.add("0");
                  Pasivo cuentaPasivo = new Pasivo(); 
                  cuentaPasivo.setNombre(nombre);
                  cuentaPasivo.setMonto(monto);
                  ic.insertar(cuentaPasivo);

                }
                if(jRadioButton3.isSelected())
                {

                  lista.add("0");
                  lista.add("0");
                  lista.add(jTextField2.getText());
                  lista.add("0");
                  lista.add("0");
                  Ingreso cuentaIngreso = new Ingreso(); 
                  cuentaIngreso.setNombre(nombre);
                  cuentaIngreso.setMonto(monto);
                  ic.insertar(cuentaIngreso);

                }
                if(jRadioButton4.isSelected())
                {

                  lista.add("0");
                  lista.add("0");
                  lista.add("0");
                  lista.add(jTextField2.getText());
                  lista.add("0");
                  Costo cuentaCosto = new Costo(); 
                  cuentaCosto.setNombre(nombre);
                  cuentaCosto.setMonto(monto);
                  ic.insertar(cuentaCosto);

                }
                if(jRadioButton5.isSelected())
                {

                  lista.add("0");
                  lista.add("0");
                  lista.add("0");
                  lista.add("0");
                  lista.add(jTextField2.getText());
                  Gasto cuentaGasto = new Gasto(); 
                  cuentaGasto.setNombre(nombre);
                  cuentaGasto.setMonto(monto);
                  ic.insertar(cuentaGasto);

                }

                tabla.agregarFila(lista);
                jTable1.setModel(tabla);



                this.resetearValores();
            }
        
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jToggleButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseClicked
        this.cargarClasificador();
        Balance balance = new Balance (clasificador);
        balance.setVisible(true);
    
    }//GEN-LAST:event_jToggleButton2MouseClicked

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged
        System.out.println("Se cambio algo");
    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        String nombree = (String) tabla.getValueAt(jTable1.getSelectedRow(), 0);
        int id = jTable1.getSelectedRow() + 1;
        int montoActivo = Integer.valueOf(tabla.getValueAt(jTable1.getSelectedRow(), 1).toString());
        int montoPasivo = Integer.valueOf(tabla.getValueAt(jTable1.getSelectedRow(), 2).toString());
        int montoIngreso = Integer.valueOf(tabla.getValueAt(jTable1.getSelectedRow(), 1).toString());
        int montoCosto = Integer.valueOf(tabla.getValueAt(jTable1.getSelectedRow(), 1).toString());
        int montoGasto = Integer.valueOf(tabla.getValueAt(jTable1.getSelectedRow(), 1).toString());
        
        if (montoActivo != 0)
        {
//            if (nuevascuentas.getCuentasActivo() != null)
//            {
//               for (int i = 0; i < nuevascuentas.getCuentasActivo().size(); i++) {
//                if (nombree.equals(nuevascuentas.getCuentasActivo().get(i)))
//                {
//                    System.out.println("Viejo Monto: " + nuevascuentas.getCuentasActivo().get(i).getValor());
//                    nuevascuentas.getCuentasActivo().get(i).setMonto(montoActivo);
//                    System.out.println("Nuevo Monto: " + nuevascuentas.getCuentasActivo().get(i).getValor());
//                }
//                } 
//            }
//            for (int i = 0; i < clasificador.getCuentasActivo().size(); i++) {
//                if (nombree.equals(clasificador.getCuentasActivo().get(i)))
//                {
//                    System.out.println("Viejo Monto: " + clasificador.getCuentasActivo().get(i).getValor());
//                    clasificador.getCuentasActivo().get(i).setMonto(montoActivo);
//                    System.out.println("Nuevo Monto: " + clasificador.getCuentasActivo().get(i).getValor());
//                }
//            }
            ModificarCuenta modificador = new ModificarCuenta(); 
            modificador.modificar(id, montoActivo);
            
        }
        
        
        if (montoPasivo != 0)
        {
//            for (int i = 0; i < nuevascuentas.getCuentasActivo().size(); i++) {
//                if (nombree.equals(nuevascuentas.getCuentasActivo().get(i)))
//                {
//                    nuevascuentas.getCuentasActivo().get(i).setMonto(montoActivo);
//                }
//            }
            ModificarCuenta modificador = new ModificarCuenta(); 
            modificador.modificar(id, montoPasivo);
        }
        if (montoIngreso != 0)
        {

            ModificarCuenta modificador = new ModificarCuenta(); 
            modificador.modificar(id, montoIngreso);
        }
        if (montoCosto!= 0)
        {

            ModificarCuenta modificador = new ModificarCuenta(); 
            modificador.modificar(id, montoCosto);
        }
        if (montoGasto != 0)
        {

            ModificarCuenta modificador = new ModificarCuenta(); 
            modificador.modificar(id, montoGasto);
        }
      
    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       MenuPrincipal menu = new MenuPrincipal();
       menu.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed
    private void resetearValores()
    {
        jTextField1.setText("");
        jTextField2.setText("");
        
        
        cuenta = null;
    }
    private void cargarClasificador()
    {
        ClasificadorCuenta cc = new ClasificadorCuenta();
        int x = 0;
        int y = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
             String nombree = (String) tabla.getValueAt(i, 0);
             int montoActivo = Integer.valueOf(tabla.getValueAt(i, 1).toString());
             int montoPasivo = Integer.valueOf(tabla.getValueAt(i, 2).toString());
             
             if (montoActivo != 0)
             {
                 
                 Activo cuentaActivo = new Activo();
                 cuentaActivo.setNombre(nombree);
                 cuentaActivo.setMonto(montoActivo);
                 cc.clasificarCuenta(cuentaActivo);
                 System.out.println(".................");
                 System.out.println("Monto Activo: " + montoActivo);
                 System.out.println(cc.getCuentasActivo().get(x).getNombre());
                 System.out.println(cc.getCuentasActivo().get(x).getValor());
                 System.out.println(".................");
                 x = x+1;
                 
             }
             if (montoPasivo != 0)
             {
                 
                 Pasivo cuentaPasivo = new Pasivo(); 
                 cuentaPasivo.setNombre(nombree);
                 cuentaPasivo.setMonto(montoPasivo);
                 cc.clasificarCuenta(cuentaPasivo);
                 System.out.println(".................");
                 System.out.println("Monto Pasivo: " + montoPasivo);
                 System.out.println(cc.getCuentasPasivo().get(y).getNombre());
                 System.out.println(cc.getCuentasPasivo().get(y).getValor());
                 System.out.println(".................");
                 y = y+1;
             }    
             
        }
        clasificador = cc;
        
    }
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
