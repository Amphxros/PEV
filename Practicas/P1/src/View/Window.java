package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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
		JPanel central = new JPanel(new BorderLayout());
		JPanel right= new JPanel(new BorderLayout());
		add(central,  BorderLayout.CENTER);
		add(right, BorderLayout.WEST);
		

		JLabel selectionTypeLabel = new JLabel("Tipo de selección");
		selectionTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		right.setLayout(new GridLayout(3, 3, 3, 3));
		right.add(selectionTypeLabel);
		
		JComboBox selectionTypeComboBox = new JComboBox();
		selectionTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Ruleta", "Estocástico", "T-Determinístico", "T-Probabilístico"}));
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
		
		JComboBox selectionTypeComboBox_1 = new JComboBox();
		selectionTypeComboBox_1.setModel(new DefaultComboBoxModel(new String[] {"P1 - Funcion 1", "P1 - Funcion 2", "P1 - Funcion 3", "P1 - Funcion 4", "P1 - Funcion 5"}));
		problemPanel.add(selectionTypeComboBox_1);
		right.add(problemPanel);
		
	
	}
	
	public Plot2DPanel createPanel() {
		Plot2DPanel plot = new Plot2DPanel();
		plot.setAxisLabels("Generacion","Fitness");
		
		return plot;
	}
}
