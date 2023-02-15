package base;



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
	
	protected Selection.Type seleccion;
	protected Crossing.Type crossing;
	


	
	public Algoritmo(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation) {
		this.maxGeneraciones = maxGeneraciones;
		this.tamPoblacion = tamPoblacion;
		this.probCruce = probCruce;
		this.probMutacion = probMutation;
	
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
		switch (crossing) {
		case Mono:
			break;
		case Multiple:
			break;
		case Uniform:
			break;
		}
	}

}
