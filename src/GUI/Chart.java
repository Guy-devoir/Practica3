package GUI;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import practica3.*;

public class Chart extends JFrame implements ActionListener{
    
    private JFreeChart _grafico;
    private DefaultPieDataset _dataPie;
    private DefaultCategoryDataset _datos;
    
    private Alumno[] alumnos = new Alumno[6];
    private Curso[] cursos;
    
    public Chart(Alumno[] alumnos, Curso[] cursos) {
        /*
        this.storage = new Almacenamiento(alumnos,cursos);
        this.alumnos =  storage.getArregloAlumno();
        */
        this.alumnos[0] = new Alumno(1, 201800632,"Luciano", true, "02/14/2021", 50);
        this.alumnos[1] = new Alumno(1, 201800612,"Nora", false, "02/14/1920", 50);
        this.alumnos[2] = new Alumno(1, 201800642,"Tora", true, "02/14/1930", 50);
        this.alumnos[3] = new Alumno(1, 201800652,"Dora", false, "02/14/1950", 50);
        this.alumnos[4] = new Alumno(1, 201800642,"Tora", true, "02/14/1950", 50);
        this.alumnos[5] = new Alumno(1, 201800652,"Dora", false, "02/14/1980", 50);
        System.out.println(this.alumnos[0].getAge());
        this.cursos = cursos;
        setSize(300, 450);
        JPanel panel = new JPanel();
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel.setLayout(new GridLayout(10, 1, 5, 5));
        panel.setBackground(Color.red);
        panel.setBounds(30, 20, 20, 210);
        panel.setSize(100,100);
        
        JLabel graphType = new JLabel("Velocidad:");
        JRadioButton j1 = new JRadioButton("Lento");
        JRadioButton j2 = new JRadioButton("Medio");
        JRadioButton j3 = new JRadioButton("Rapido");
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

        JButton pieChart;
        pieChart = new JButton(new AbstractAction("Gráfica generos") {
            @Override
            public void actionPerformed(ActionEvent e) {
                _dataPie = crearDatos();
                _grafico = ChartFactory.createPieChart("Distribución de generos", _dataPie, true, false, false);
                ChartPanel cPanel = new ChartPanel(_grafico);
                JFrame newFrame = new JFrame();
                newFrame.getContentPane().add(cPanel);
                newFrame.pack();
                newFrame.setVisible(true);
            }
        });

        JButton ageChart;
        ageChart = new JButton(new AbstractAction("Grafica edades") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println(b1.isSelected() + "" + b2.isSelected());
                    if (b1.isSelected()) {
                        _datos = setEdades();
                        System.out.println(b1.isSelected());
                    }
                    if (b2.isSelected()) {
                        _datos = setEdades();
                    }
                    _grafico = ChartFactory.createBarChart("DISTRIBUCIÓN DE EDADES", "EDADES", "# DE ALUMNOS", _datos, PlotOrientation.VERTICAL, false, false, false);
                    ChartPanel gPanel = new ChartPanel(_grafico);
                    QuickSort Qs = new QuickSort(_datos, "DISTRIBUCIÓN DE EDADES");
                    (new Thread(Qs)).start();
                    JFrame newFrame = new JFrame();
                    newFrame.add(Qs);
                    newFrame.getContentPane().add(Qs);
                    newFrame.pack();
                    newFrame.setVisible(true);
                    newFrame.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent windowevent) {
                            System.exit(0);
                        }
   
    });   
/*
     
    JFrame frame=new JFrame("Test Chart");   
         RealTimeChart rtcp=new RealTimeChart("Random Data","Random Number", "Value");   
    frame.getContentPane().add(rtcp,new BorderLayout().CENTER);   
    frame.pack();   
    frame.setVisible(true);   
    (new Thread(rtcp)).start();   
    frame.addWindowListener(new WindowAdapter()    
    {   
        public void windowClosing(WindowEvent windowevent)   
        {   
            System.exit(0);   
        }     
                */
                } catch (HeadlessException excep) {

                }
            }               
        });
        
        JButton gradesChart;
        gradesChart = new JButton( new AbstractAction("Grafica notas"){
            @Override
            public void actionPerformed(ActionEvent e) {
                _dataPie = crearDatos();
                _grafico = ChartFactory.createPieChart("Distribución de generos", _dataPie, true, false, false);
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
        panel.add(sortType);
        panel.add(b1);
        panel.add(b2);
        panel.add(ageChart);
        panel.add(pieChart);
        
        
        //Creada a cuantos pixeles debe estar del
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        add(panel, WEST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("...");
    }
   
    public DefaultPieDataset crearDatos() {
        int contadorM = 0;
        int contadorF = 0;
        DefaultPieDataset datos = new DefaultPieDataset();
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].isGenero() == true) {
                contadorM++;
            }
            if (alumnos[i].isGenero() == false) {
                contadorF++;
            }
        }
        int percentM = (contadorM * 100) / alumnos.length;
        int percentF = (contadorF * 100) / alumnos.length;
        System.out.println(contadorM + " " + contadorF + " " + percentM + " " + percentF + " " + alumnos.length);
        datos.setValue("Hombres", new Double(percentM));
        datos.setValue("Mujeres", new Double(percentF));

        //System.out.println(alumnos[2].getNombre()+alumnos[0].getNombre());
        return datos;

   }
    
    public DefaultCategoryDataset setEdades() {
        _datos = new DefaultCategoryDataset();

        int contador10 = 0, contador20 = 0, contador30 = 0, contador40 = 0, contador50 = 0, contador60 = 0, contador70 = 0, contador80 = 0, contador90 = 0, contador100 = 0;
        int[] contador = new int[10];
        System.out.println(alumnos.length);
        
        for (Alumno alumno : alumnos) {
            System.out.println("entra");
            
            if (alumno.getAge() < 10) {
                contador10++;
            }
            if ((alumno.getAge() < 20) && (alumno.getAge() > 10)) {
                contador20++;
            }
            if ((alumno.getAge() < 30) && (alumno.getAge() > 20)) {
                contador30++;
            }
            if ((alumno.getAge() < 40) && (alumno.getAge() > 30)) {
                contador40++;
            }
            if ((alumno.getAge() < 50) && (alumno.getAge() > 40)) {
                contador50++;
            }
            if ((alumno.getAge() < 60) && (alumno.getAge() > 50)) {
                contador60++;
            }
            if ((alumno.getAge() < 70) && (alumno.getAge() > 60)) {
                contador70++;
            }
            if ((alumno.getAge() < 80) && (alumno.getAge() > 70)) {
                contador80++;
            }
            if ((alumno.getAge() < 90) && (alumno.getAge() > 80)) {
                contador90++;
            }
            if ((alumno.getAge() < 100) && (alumno.getAge() > 90)) {
                contador100++;
            }
        }
        
        contador[0] = contador10;
        contador[1] = contador20;
        contador[2] = contador30;
        contador[3] = contador40;
        contador[4] = contador50;
        contador[5] = contador60;
        contador[6] = contador70;
        contador[7] = contador80;
        contador[8] = contador90;
        contador[9] = contador100;
        
        
        
        
        //Adding values to the fucking DataSet
        if (contador10 != 0) {
            _datos.addValue(contador10, "Edades", "10");
        }
        if (contador20 != 0) {
            _datos.addValue(contador20, "Edades", "20");
        }
        if (contador30 != 0) {
            _datos.addValue(contador30, "Edades", "30");
        }
        if (contador40 != 0) {
            _datos.addValue(contador40, "Edades", "40");
        }
        if (contador50 != 0) {
            _datos.addValue(contador50, "Edades", "50");
        }
        if (contador60 != 0) {
            _datos.addValue(contador60, "Edades", "60");
        }
        if (contador70 != 0) {
            _datos.addValue(contador70, "Edades", "70");
        }
        if (contador80 != 0) {
            _datos.addValue(contador80, "Edades", "80");
        }
        if (contador90 != 0) {
            _datos.addValue(contador90, "Edades", "90");
        }
        if (contador100 != 0) {
            _datos.addValue(contador100, "Edades", "100");
        }

        return _datos;
    }
}
