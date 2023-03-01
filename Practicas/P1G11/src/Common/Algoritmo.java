package Common;



public abstract class Algoritmo {

	private final int tamPoblacion;
	protected Individuo[] poblacion;
	protected double[] fitness;
	protected double[] generations;
	protected final int maxGeneraciones;
	protected double probCruce;
	protected double probMutacion;
	protected int tamTorneo;
	protected Individuo elMejor;
	protected int pos_mejor;
	
	protected Selection.Type seleccion;
	protected Crossing.Type crossing;
	private Crossing mCrossingInstance;


	
	public Algoritmo(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation) {
		this.maxGeneraciones = maxGeneraciones;
		this.tamPoblacion = tamPoblacion;
		this.probCruce = probCruce;
		this.probMutacion = probMutation;
		mCrossingInstance= new Crossing();
		
		generations= new double[this.maxGeneraciones];
		fitness= new double[this.maxGeneraciones];

		for(int i=0;i<this.maxGeneraciones;i++) {
			generations[i]=i; //axis X
			fitness[i]=0;
		}
	
	}

	public void setSelection(int index) {
		seleccion= Selection.Type.values()[index];
	}
	public void setCrossing(int index) {
		crossing= Crossing.Type.values()[index];
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

	protected abstract void createPopulation();

	protected void selection() {
	
	}

	protected void crossOver() {
		switch (crossing) {
		case Mono:
			mCrossingInstance.MonopointCrossOver(poblacion, probCruce, 1);
			break;
		case Multiple:
			break;
		case Uniform:
			break;
		}
	}
	
	protected void mutate() {
		
	}
	protected abstract void evaluate();

	public double[] getGenerations() {
		return this.generations;
	}
	
	public double[] getFitness() {
		return this.fitness;
	}
}
