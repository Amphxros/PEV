package View;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.math.plot.Plot2DPanel;
import org.math.plot.plots.LinePlot;

import AGPractica1.Ej1.AGCalibracion;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JToolBar;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.Label;
import java.awt.Button;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.SystemColor;
import Common.Algoritmo;
public class Mainframe extends JFrame  {
	
		

		private JPanel window;
		
		private JTextField numGenTF;
		private JTextField crossProbabilityTF;
		private JTextField mutationProbabilityTF;
		private JTextField tamTorneoTF;
		private JTextField solutionTF;
		private JTextField dimTF;	
		
		private Plot2DPanel plot;
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		
		private final Color blue = new Color(104,64,255);
		private final Color green = new Color(104,255,104);
		private final Color red = new Color(255,104,104);
		
		
		private void replot()
		{
			plot.resetMapData();
			double[][] xy = {{1, 2, 3, 4, 5}, {3, 4, 5, 4, 3}};
		    
		    plot.addLinePlot("Test Plot", blue, xy);
		}
		
		private void plot(double[][] xy, Color c, String name)
		{
			plot.resetMapData();
		    plot.addLinePlot(name, c, xy);
		}
		
		private void plot(double[] x,double [] y, Color c, String name)
		{
			
			plot.resetMapData();
		    plot.addLinePlot(name, c,x,y);
		}
		
		/**
		 * Create the frame.
		 */
		public Mainframe() {
			super("P1G11 -- PEV");
			this.setResizable(false);
			this.setMinimumSize(new Dimension(1280,720));
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
					
			JPanel westSidePanel = new JPanel();
			getContentPane().add(westSidePanel, BorderLayout.WEST);
			westSidePanel.setBorder(BorderFactory.createTitledBorder("Params"));
			
			JLabel genSizeLabel = new JLabel("Tam. de la población");
			genSizeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));;
			JTextField genSizeTextField = new JFormattedTextField(numberFormat);
			genSizeTextField.setText("100");
			
			JLabel numGenLabel = new JLabel("Nº de generaciones");
			numGenLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			numGenTF = new JTextField();
			numGenTF.setText("100");
			numGenTF.setColumns(10);
			
			//SELECTION PANEL
			
			JPanel selectionPanel = new JPanel();
			selectionPanel.setBorder(new TitledBorder(null, "Seleccion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			selectionPanel.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel selectionTL = new JLabel("Tipo de selección");
			selectionTL.setHorizontalAlignment(SwingConstants.LEFT);
			selectionPanel.add(selectionTL);
			
			JComboBox selectionTypeComboBox = new JComboBox();
			selectionTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {
					"Proporcional/Ruleta"
					, "MuestreoUniversalEstoclastico"
					, "Truncamiento"
					, "TorneoDeterministico"
					, "TorneoProbabilistico"
					, "Ranking",
					"Restos"
			}));
			
			selectionPanel.add(selectionTypeComboBox);
			
			
			JLabel tamTorneo = new JLabel("TamTorneo");
			selectionPanel.add(tamTorneo);
			
			
			tamTorneoTF = new JTextField();
			tamTorneoTF.setText("1");
			selectionPanel.add(tamTorneoTF);
			tamTorneoTF.setColumns(10);
			

			//CROSS PANEL

			JPanel crossPanel = new JPanel();
			crossPanel.setBorder(new TitledBorder("Cruce"));
			crossPanel.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel crossTL = new JLabel("Tipo de cruce");
			crossTL.setHorizontalAlignment(SwingConstants.LEFT);
			crossPanel.add(crossTL);
			
			JComboBox crossTypeComboBox = new JComboBox();
			crossTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Cruce Monopunto",
				
				}
			));
			
			JLabel lblDimension = new JLabel("Dimension: ");
			crossPanel.add(lblDimension);
			
			dimTF = new JTextField();
			dimTF.setText("1");
			crossPanel.add(tamTorneoTF);
			tamTorneoTF.setColumns(10);
			
			crossPanel.add(crossTypeComboBox);
			
			JLabel crossProbabilityLabel = new JLabel("% Cruce");
			crossPanel.add(crossProbabilityLabel);
			
			crossProbabilityTF = new JTextField();
			crossProbabilityTF.setText("60.0");
			crossPanel.add(crossProbabilityTF);
			crossProbabilityTF.setColumns(10);
			
			//MUTATION PANEL

			JPanel mutationPanel = new JPanel();
			mutationPanel.setBorder(new TitledBorder("Mutacion"));
			mutationPanel.setLayout(new GridLayout(0, 2, 3, 0));
			
			JLabel mutationTypeLabel = new JLabel("Tipo de mutación");
			mutationTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
			mutationPanel.add(mutationTypeLabel);
			
			JComboBox mutationTypeComboBox = new JComboBox();
			mutationTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Mutación básica"
				}
			));
			mutationPanel.add(mutationTypeComboBox);
			
			JLabel mutationProbLabel = new JLabel("% Mutación");
			mutationPanel.add(mutationProbLabel);
			
			mutationProbabilityTF = new JTextField();
			mutationProbabilityTF.setText("60.0");
			mutationProbabilityTF.setColumns(10);
			mutationPanel.add(mutationProbabilityTF);

			JLabel dimensionLabel = new JLabel("Dimension");
			dimensionLabel.setHorizontalAlignment(SwingConstants.LEFT);
			
			dimTF= new JTextField();
			dimTF.setText("2");
			mutationPanel.add(dimensionLabel);
			mutationPanel.add(dimTF);
			
			//PROBLEM PANEL
			
			JPanel problemPanel = new JPanel();
			problemPanel.setBorder(new TitledBorder("Problema"));
			problemPanel.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblSelectProblema = new JLabel("Selecciona problema");
			lblSelectProblema.setHorizontalAlignment(SwingConstants.LEFT);
			problemPanel.add(lblSelectProblema);
			
			JComboBox problemTypeComboBox = new JComboBox();
			problemTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {
					"P1 - Funcion 1", 
					"P1 - Funcion 2", 
					"P1 - Funcion 3", 
					"P1 - Funcion 4", 
					"P1 - Funcion 5"
					
				}
			));
			problemPanel.add(problemTypeComboBox);
			
			//BUTTONS 
			JButton executeButton = new JButton("Ejecutar");
			executeButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
		
					int tamPoblacion = Integer.parseInt(numGenTF.getText());
					int nGeneraciones = Integer.parseInt(numGenTF.getText());
					int dim = Integer.parseInt(dimTF.getText());
					
					double probCruce= Double.parseDouble(crossProbabilityTF.getText());
					double probMutacion= Double.parseDouble(mutationProbabilityTF.getText());
				
					int crossingType= crossTypeComboBox.getSelectedIndex();
					int selectionType= selectionTypeComboBox.getSelectedIndex();
					int mutationType= mutationTypeComboBox.getSelectedIndex();
					
					switch(problemTypeComboBox.getSelectedIndex()) {
					case 0:
						System.out.println("Calibracion");
						AGCalibracion ag= new AGCalibracion(tamPoblacion,nGeneraciones,probCruce,probMutacion);
						//sets the selection, crossing and mutation parameters
						ag.setCrossing(crossingType);
						ag.setSelection(selectionType);
						ag.setMutacion(mutationType);
						
						//runs the algoritm
						ag.run();
						//puts them in the graphic plot
						plot(ag.getGenerations(), ag.getFitness(),red,"Calibre");
						break;
					case 1:
						System.out.println("GrieWank");
						break;
					case 2:
						System.out.println("Styblinski-tang");
						break;
					case 3:
						System.out.println("Michalewicz --A");
						break;
					case 4:
						System.out.println("Michalewicz --B");
						break;
					default:
						break;
					}
					
					
					
				
				}
				
			});
			
			JButton restartButton = new JButton("Reiniciar");
			restartButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("re");
				}
				
			});
			
			
			
			
			GroupLayout gl_westPanel = new GroupLayout(westSidePanel);
			gl_westPanel.setHorizontalGroup(
				gl_westPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_westPanel.createSequentialGroup()
						.addGap(10)
						.addGroup(gl_westPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(restartButton, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addComponent(mutationPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addComponent(crossPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(selectionPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addComponent(numGenTF, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addComponent(numGenLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addComponent(genSizeTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addComponent(genSizeLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addComponent(executeButton, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
							.addComponent(problemPanel, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
						.addGap(10))
			);
			gl_westPanel.setVerticalGroup(
				gl_westPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_westPanel.createSequentialGroup()
						.addGap(1)
						.addComponent(genSizeLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(genSizeTextField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(numGenLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(numGenTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(selectionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(crossPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(mutationPanel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(problemPanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(executeButton)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(restartButton)
						.addGap(244))
			);
			gl_westPanel.setAutoCreateGaps(true);
			gl_westPanel.setAutoCreateContainerGaps(true);
			westSidePanel.setLayout(gl_westPanel);
			
			JPanel eastPanel = new JPanel();
			eastPanel.setBorder(new TitledBorder(null, "Plot", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			getContentPane().add(eastPanel, BorderLayout.CENTER);
			eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
			
			plot = new Plot2DPanel();
			plot.plotCanvas.setAutoBounds(1);
			plot.plotCanvas.setAxisLabels(new String[] {"X", "Y"});
			plot.plotCanvas.setBackground(UIManager.getColor("Button.light"));
			eastPanel.add(plot);
			replot();
			
			JPanel solutionPanel = new JPanel();
			eastPanel.add(solutionPanel);
			
			JLabel solutionLabel = new JLabel("Solution:");
			solutionLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			solutionLabel.setHorizontalAlignment(SwingConstants.LEFT);
			
			solutionTF = new JTextField();
			solutionTF.setText("Here will be solution");
			solutionTF.setEditable(false);
			solutionTF.setColumns(10);
			GroupLayout gl_solutionPanel = new GroupLayout(solutionPanel);
			gl_solutionPanel.setHorizontalGroup(
				gl_solutionPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_solutionPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(solutionLabel)
						.addGap(18)
						.addComponent(solutionTF, GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
						.addContainerGap())
			);
			gl_solutionPanel.setVerticalGroup(
				gl_solutionPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_solutionPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_solutionPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(solutionTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(solutionLabel, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE))
						.addGap(11))
			);
			solutionPanel.setLayout(gl_solutionPanel);
			
			window = new JPanel();
			window.setLayout(new BorderLayout());
			
			this.setVisible(true);
		}
	}

