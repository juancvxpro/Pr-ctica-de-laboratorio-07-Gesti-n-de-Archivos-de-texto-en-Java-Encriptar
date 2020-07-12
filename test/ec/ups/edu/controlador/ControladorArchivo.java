package ec.ups.edu.controlador;

import ec.ups.edu.vista.VentanaPrincipal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ControladorArchivo {

    VentanaPrincipal ventanaPrincipal;

    public ControladorArchivo(VentanaPrincipal principal) {
        ventanaPrincipal = principal;
    }

    public String abrirArchivo() {
        String aux = "";
        String texto = "";
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(ventanaPrincipal);
            /**
             * abrimos el archivo seleccionado
             */
            File abre = file.getSelectedFile();

            /**
             * recorremos el archivo, lo leemos para plasmarlo en el area de
             * texto
             */
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                try (BufferedReader lee = new BufferedReader(archivos)) {
                    while ((aux = lee.readLine()) != null) {
                        texto += aux + "\n";
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Error al leer el archivo");
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }

    public void guardarArchivo(String texto) {
        try {
            String nombre = "";
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(ventanaPrincipal);
            File guarda = file.getSelectedFile();

            if (guarda != null) {
                try ( /*guardamos el archivo y le damos el formato directamente,
       * si queremos que se guarde en formato doc lo definimos como .doc*/
                        FileWriter save = new FileWriter(guarda + ".txt")) {
                    save.write(texto);
                }
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

}
