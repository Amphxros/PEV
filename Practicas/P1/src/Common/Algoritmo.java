package Common;



public abstract class Algoritmo<T> {

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
	private Crossing mCrossingInstance;


	
	public Algoritmo(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation) {
		this.maxGeneraciones = maxGeneraciones;
		this.tamPoblacion = tamPoblacion;
		this.probCruce = probCruce;
		this.probMutacion = probMutation;
		mCrossingInstance= new Crossing();
	
	}

	public void run() {

		createPopulation();
		evaluate();
		for (int i = 0; i < maxGeneraciones; i++) {
			selection();
			crossOver();
			mutate();
			evaluate();
		}
	}

	protected void createPopulation() {

	}

	protected void selection() {
	
	}

	protected void crossOver() {
		switch (crossing) {
		case Mono:
			
			break;
		case Multiple:
			break;
		case Uniform:
			break;
		}
	}
	
	protected void mutate() {
		
	}
	protected void evaluate() {
		
	}

}
