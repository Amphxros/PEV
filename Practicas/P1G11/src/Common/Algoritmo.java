package Common;



public abstract class Algoritmo {

	protected final int tamPoblacion;
	protected Individuo[] poblacion;
	protected final double[] fitness;
	protected final double[] generations;
	protected final int maxGeneraciones;
	protected double probCruce;
	protected double probMutacion;
	protected int tamTorneo;
	protected Individuo elMejor;
	protected int pos_mejor;
	
	protected Selection.Type seleccion;
	protected Crossing.Type crossing;
	protected Mutation.Type mutation;
	

	/**
	 * 
	 * @param tamPoblacion
	 * @param maxGeneraciones
	 * @param probCruce
	 * @param probMutation
	 */
	public Algoritmo(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation) {
		this.maxGeneraciones = maxGeneraciones;
		this.tamPoblacion = tamPoblacion;
		this.probCruce = probCruce;
		this.probMutacion = probMutation;
		
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

	public void setMutacion(int index) {
		mutation= Mutation.Type.values()[index];
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
	
		Individuo[] seleccionados = null;
		
		switch(seleccion) {

		case Proporcional:
			seleccionados = Selection.Proporcional(poblacion, fitness);
			break;
		case MuestreoUniversalEstoclastico:
			seleccionados = Selection.MuestreoUniversalEstoclastico(seleccionados, fitness);
			break;
		case Truncamiento:
			seleccionados = Selection.Truncamiento(seleccionados, fitness);
			break;
		case TorneoDeterministico:
			seleccionados = Selection.TorneoDeterministico(seleccionados, fitness, tamTorneo);
			break;
		case TorneoProbabilistico:
			
			double p = 0.5;
			seleccionados = Selection.TorneoProbabilistico(seleccionados, fitness, tamTorneo , p);
			break;
		case Ranking:
			
			seleccionados = Selection.Ranking(seleccionados, fitness);
			break;
		case Restos:
			seleccionados = Selection.Restos(seleccionados, fitness);
			break;
		}
		
		
		
		
		//Para testear
		for(int i = 0; i < seleccionados.length; i++)
		{
			System.out.println(seleccionados[i].fitness);
		}
		
		
	}

	protected void crossOver() {
		switch (crossing) {
		case Mono:
			Crossing.MonopointCrossOver(poblacion, probCruce, 1);
			break;
		case Multiple:
			break;
		case Uniform:
			break;
			
		}
	}
	
	protected void mutate() {
		switch(mutation) {
		case Uniform:
			break;
			
		}
	}
	protected abstract void evaluate();

	public double[] getGenerations() {
		return this.generations;
	}
	
	public double[] getFitness() {
		return this.fitness;
	}

	protected void createElite() {
		// TODO Auto-generated method stub
		
	}
}
