package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import practica3.*;

public class Directorio implements ActionListener {

    private Alumno[] alumnos;
    private Curso[] cursos;
    String directorio;
    JTextField text;
    JFrame frame;

    public Directorio() {
        frame = new JFrame();
        frame.setTitle("Directorio");
        frame.setLayout(new BorderLayout());
        JLabel ruta = new JLabel("Seleccione el directorio de los archivos .csv");
        text = new JTextField();
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        aceptar.setPreferredSize(new Dimension(100, 10));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1, 5, 5));
        panel1.setBounds(50, 50, 290, 210);
        panel1.add(ruta);
        //Creada a cuantos pixeles debe estar del
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel1.add(text);
        panel1.add(aceptar);

        frame.add(panel1, BorderLayout.CENTER);

        frame.setSize(600, 170);

        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        directorio = text.getText();
        System.out.println("El Directorio está: " + directorio);
        frame.setVisible(false);
        makeChart();
    }

    public void makeChart() {
        Chart graficos = new Chart(alumnos, cursos);
        graficos.setVisible(true);
    }

}
