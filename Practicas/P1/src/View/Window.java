package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.math.plot.*;

public class Window extends JFrame{
	private JTextField crossProbabilityTextField;
	
	public Window(String tittle, int width, int height) {
		super(tittle);
		setSize(width, height);
		setVisible(true);
		this.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel right= new JPanel(new BorderLayout());
		JPanel bottom= new JPanel(new BorderLayout());
		  

		add(right, BorderLayout.WEST);
		add(bottom, BorderLayout.SOUTH);
		
		JLabel selectionTypeLabel = new JLabel("Tipo de selección");
		selectionTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		right.setLayout(new GridLayout(20,20,0,0));
		right.add(selectionTypeLabel);
		
		JComboBox selectionTypeComboBox = new JComboBox();
		selectionTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Proporcional(ruleta)", 
				"MuestreoUniversalEstoclastico",
				"Truncamiento",
				"TorneoDeterministico",
				"TorneoProbabilistico",
				"Ranking",
				"Restos"
				}
		));
		right.add(selectionTypeComboBox);
		
		JLabel crossTypeLabel = new JLabel("Tipo de cruce");
		selectionTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		right.add(crossTypeLabel);
		
		JComboBox crossTypeComboBox = new JComboBox();
		crossTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"MonoPunto", "Multipunto","Uniforme"}));
		right.add(crossTypeComboBox);
		
		JLabel crossProbabilityLabel = new JLabel("% Cruce");
		right.add(crossProbabilityLabel);
		crossProbabilityTextField = new JTextField();
		crossProbabilityTextField.setText("60.0");
		right.add(crossProbabilityTextField);
		crossProbabilityTextField.setColumns(10);
		
		JPanel problemPanel = new JPanel();
		problemPanel.setBorder(new TitledBorder("Problema"));
		problemPanel.setLayout(new GridLayout(0, 2, 2, 0));
		
		JLabel lblSeleccionaProblema = new JLabel("Selecciona problema");
		lblSeleccionaProblema.setHorizontalAlignment(SwingConstants.LEFT);
		problemPanel.add(lblSeleccionaProblema);
		
		JComboBox problemBox = new JComboBox();
		problemBox.setModel(new DefaultComboBoxModel(new String[] {
				"P1 - Funcion 1",
				"P1 - Funcion 2",
				"P1 - Funcion 3",
				"P1 - Funcion 4",
				"P1 - Funcion 5"
				//add more here
				}
		));
		problemPanel.add(problemBox);
		right.add(problemPanel);

		

	    JButton boton = new JButton("Calcula grafica");
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		bottom.add(boton, BorderLayout.EAST);

		
		double[] x = { 1, 2, 3, 4, 5, 6 };
		double[] y = { 45, 89, 6, 32, 63, 12 };

		// create your PlotPanel (you can use it as a JPanel)
	
		Plot2DPanel plot = new Plot2DPanel();
		plot.setSize(new Dimension(1000,1000));
		plot.setAxisLabels("generaciones", "fitness");
	
		add(plot);
	    
	    
	}
	
	
	
}
