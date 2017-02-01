package interfazGrafica;

import javax.swing.JFrame;


public class VentanaAplicacion extends JFrame {
    public VentanaAplicacion(){
        super("Cuadro de Mando");//llamar al constructor de JFrame
        PanelCentral panel = new PanelCentral();
        this.setContentPane(panel);
    }
    
    public static void main(String args[]){
        VentanaAplicacion aplicacion = new VentanaAplicacion();
        aplicacion.setSize(800, 400);
        aplicacion.setVisible(true);
    }
}
