package Main;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.math.plot.Plot2DPanel;


public class Main extends JFrame{
	
	public Main() { 
		super("Practica 1 Grupo 11");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		
	}
	
	public static void main(String[] args)  {
		Main m= new Main();
		m.setSize(1000,600);
		m.setVisible(true);
	}
	
	
	
}
