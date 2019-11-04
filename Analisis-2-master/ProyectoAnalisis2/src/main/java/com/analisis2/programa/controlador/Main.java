package com.analisis2.programa.controlador;
import com.analisis2.clases.modelo.EM;
import com.analisis2.clases.vista.MenuPrincipal;
import com.analisis2.insercion.modelo.IncersionInicial;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @author Juan Diego Arriola
 */
public class Main {

    public static void main(String[] args) {
        IncersionInicial i = new IncersionInicial();
        i.insertarDatos();
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);          
       
        Runtime.getRuntime().addShutdownHook(new Thread() 
        {
            EM entity = EM.crearEntityManager();
            public void run() {
                entity.cerrarEntity();
                System.out.println("Se cerro la conexion.");
            }
        });
    }
    
    
}
