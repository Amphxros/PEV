package base;

import base.Factorys.CrossFactory;

public abstract class Algoritmo {

	private final int tamPoblacion;
	private Individuo[] poblacion;
	private double[] fitness;
	private final int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	private int tamTorneo;
	private Individuo elMejor;
	private int pos_mejor;
	
	private Selection.Type seleccion;
	

	private CrossType crossType;
	
	public Algoritmo(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation, CrossType crossType) {
		this.maxGeneraciones = maxGeneraciones;
		this.tamPoblacion = tamPoblacion;
		this.probCruce = probCruce;
		this.probMutacion = probMutation;
		this.crossType= crossType;
	}

	public void run() {

		for (int i = 0; i < maxGeneraciones; i++) {

		}
	}

	protected void createPopulation() {

	}

	protected void selection() {

	}

	protected void CrossOver() {
		switch(this.crossType) {
		case Monopunto:
			CrossFactory.getInstance().MonopointCrossing();
			break;
		case Multipunto:
			CrossFactory.getInstance().MultipointCrossing();
			break;
		case Uniforme:
			CrossFactory.getInstance().UniformCrossing();
			break;
		}
	}

}
