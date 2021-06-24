package GUI;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import practica3.*;

public class Chart extends JFrame implements ActionListener{
    
    private JFreeChart _grafico;
    private DefaultPieDataset _data;
    
    private Alumno[] alumnos = new Alumno[6];
    private Curso[] cursos;
    private double[] gotdamn = {0.0,1.0,10,50,23,24};
    private int[] touchme;
    
    Almacenamiento storage;
    private String addDirectory;

    public Chart(Alumno[] alumnos, Curso[] cursos) {
        /*this.storage = new Almacenamiento(alumnos,cursos);
        this.alumnos =  storage.getArregloAlumno();
        */
        this.alumnos[0] = new Alumno(1, 201800632,"Luciano", true, "02/14/1998", 50);
        this.alumnos[1] = new Alumno(1, 201800612,"Nora", false, "02/14/1998", 50);
        this.alumnos[2] = new Alumno(1, 201800642,"Tora", true, "02/14/1998", 50);
        this.alumnos[3] = new Alumno(1, 201800652,"Dora", false, "02/14/1998", 50);
        this.alumnos[4] = new Alumno(1, 201800642,"Tora", true, "02/14/1998", 50);
        this.alumnos[5] = new Alumno(1, 201800652,"Dora", false, "02/14/1998", 50);
        this.cursos = cursos;
        setSize(300, 450);
        JPanel panel = new JPanel();
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel.setLayout(new GridLayout(8, 1, 5, 5));
        panel.setBackground(Color.red);
        panel.setBounds(30, 20, 20, 210);
        panel.setSize(100,100);
        
        JLabel graphType = new JLabel("Tipico de gráfica:");
        JRadioButton j1 = new JRadioButton("Grafica de generos (Sorting no disponible)");
        JRadioButton j2 = new JRadioButton("Grafica de Edad");
        JRadioButton j3 = new JRadioButton("Grafica de Notas");
        ButtonGroup J = new ButtonGroup();
        J.add(j1);
        J.add(j2);
        J.add(j3);
        
        JLabel sortType = new JLabel("Tipo de Sorting");
        JRadioButton b1 = new JRadioButton("Quick Sort");
        JRadioButton b2 = new JRadioButton("Bubble Sort");
        ButtonGroup G = new ButtonGroup();
        G.add(b1);
        G.add(b2);

        JButton graficar;
        graficar = new JButton( new AbstractAction("Cargar Archivo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                _data = crearDatos();
                _grafico = ChartFactory.createPieChart("Distribución de generos", _data, true, false, false);
                ChartPanel cPanel = new ChartPanel(_grafico);
                JFrame newFrame = new JFrame();
                newFrame.getContentPane().add(cPanel);
                newFrame.pack();
                newFrame.setVisible(true);
            }            
        });

        panel.add(graphType);
        panel.add(j1);
        panel.add(j2);
        panel.add(j3);
        graficar.setText("Graficar");
        panel.add(sortType);
        panel.add(b1);
        panel.add(b2);
        panel.add(graficar);
        //Creada a cuantos pixeles debe estar del
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        add(panel, WEST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("...");
    }
   
   public DefaultPieDataset crearDatos(){
       int contadorM = 0;
       int contadorF = 0;
      DefaultPieDataset datos = new DefaultPieDataset();
       for (int i = 0; i < alumnos.length; i++) {
           if(alumnos[i].isGenero() == true){
           contadorM++;
           }
           if(alumnos[i].isGenero() == false){
               contadorF++;
           }
       }
       int percentM = (1 * 100) / 3;
       int percentF = (2 * 100) / 3;
       System.out.println(contadorM + " " + contadorF + " " + percentM + " " + percentF + " " + alumnos.length);
       datos.setValue("Hombres", new Double(percentM));
       datos.setValue("Mujeres", new Double(percentF));

       //System.out.println(alumnos[2].getNombre()+alumnos[0].getNombre());
       return datos;

   }
}
