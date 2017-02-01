package interfazGrafica;

import cargaDatos.InterfazCargaDatos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelControlesCarga extends JPanel {
    InterfazCargaDatos interfazCarga;
    private JLabel labelArchivo;
    private JTextField textArchivo;
    private JButton botSelectArchivo;
    private JButton botAceptar;
    private JButton botCancelar;
    
    public PanelControlesCarga(String label, InterfazCargaDatos icd){
        interfazCarga = icd;
        JPanel panelCentral = new JPanel();// panel central para meter la etiqueta, el campo de texto y el boton de seleccionar archivo
        panelCentral.setLayout(new FlowLayout());// plantilla para ir colocando los elementos. Uno detrás de otro
        labelArchivo = new JLabel(label);// etiqueta con ekl texto que nos han pasado
        textArchivo = new JTextField(50);
        botSelectArchivo = new JButton("Seleccionar archivo");
        //hay que agnadir el manejador al boton
        panelCentral.add(labelArchivo);
        panelCentral.add(textArchivo);
        panelCentral.add(botSelectArchivo);
        // listo el panel central. Vamos a por el panel inferior
        
        JPanel panelInferior = new JPanel();// panel inferior para meter los botones "Aceptar" y "Cancelar"
        panelInferior.setLayout(new FlowLayout());
        botAceptar = new JButton("Aceptar");
        botCancelar = new JButton("Cancelar"); // faltan los manejadores de ambos botones
        ManejadorEventosInterfazCUCarga manejadorAceptar = 
                new ManejadorEventosInterfazCUCarga(TipoBoton.ACEPTAR, textArchivo, interfazCarga);
        botAceptar.addActionListener(manejadorAceptar);
        
        ManejadorEventosInterfazCUCarga manejadorCancelar = 
                new ManejadorEventosInterfazCUCarga(TipoBoton.CANCELAR, textArchivo, interfazCarga);
        botCancelar.addActionListener(manejadorCancelar);
        
        ManejadorEventosInterfazCUCarga manejadorSeleccionar = 
                new ManejadorEventosInterfazCUCarga(TipoBoton.SELECCIONAR, textArchivo, interfazCarga);
        botSelectArchivo.addActionListener(manejadorSeleccionar);
        
        panelInferior.add(botAceptar);
        panelInferior.add(botCancelar);
        
        this.setLayout(new BorderLayout());// divide el panel en centro, norte, sur, este y oeste. Vamos a ocupar centro y sur
        this.add(panelCentral, BorderLayout.CENTER);
        this.add(panelInferior, BorderLayout.SOUTH);
    }
}
