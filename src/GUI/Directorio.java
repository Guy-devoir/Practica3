package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Directorio implements ActionListener {

    public Directorio() {
        JFrame frame = new JFrame();
        frame.setTitle("Directorio");
        frame.setLayout(new BorderLayout());
        JLabel ruta = new JLabel("    Seleccione el directorio de los archivos .csv");
        JTextField text = new JTextField();
        JButton aceptar = new JButton("Aceptar");
        aceptar.setPreferredSize(new Dimension(100,10));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,1));
        panel1.setBounds(50, 50, 290,210);
        panel1.add(ruta);
        panel1.add(text);
        panel1.add(aceptar);
        frame.add(panel1, BorderLayout.CENTER);

        frame.setSize(300, 120);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
