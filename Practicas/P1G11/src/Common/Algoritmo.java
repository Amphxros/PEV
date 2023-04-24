package Common;

public abstract class Algoritmo {

	protected final int tamPoblacion;
	protected Individuo[] poblacion;
	protected Individuo[] elite;
	
	protected final double[] fitness;
	protected final double[] generations; // eje x
	protected final double[] fitnessAbs; // eje y2
	protected final double[] fitnessMed; // eje y3

	protected final double tolerance;
	protected final int maxGeneraciones;
	protected double probCruce;
	protected double probMutacion;
	protected int tamTorneo;
	protected Individuo elMejor;
	protected int pos_mejor;

	protected Selection.Type seleccion;
	protected Crossing.Type crossing;
	protected Mutation.Type mutation;
	protected boolean isMaximize = true;
	protected double elitismPercentage;
	protected boolean elitism;

	protected int indiceAlgoritmo = 1;
	protected int numeroGenes = 2;
	
	/**
	 * 
	 * @param tamPoblacion
	 * @param maxGeneraciones
	 * @param probCruce
	 * @param probMutation
	 */
	public Algoritmo(double tolerance, int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation, int tamTorneo,
			double elitismo) {
		this.tolerance=tolerance;
		this.maxGeneraciones = maxGeneraciones;
		this.tamPoblacion = tamPoblacion;
		this.probCruce = probCruce;
		this.probMutacion = probMutation;
		this.tamTorneo = tamTorneo;
		this.elitismPercentage = elitismo;
		this.elitism = elitismPercentage > 0;

		generations = new double[this.maxGeneraciones];
		fitness = new double[this.maxGeneraciones];
		fitnessAbs = new double[this.maxGeneraciones];
		fitnessMed = new double[this.maxGeneraciones];

		for (int i = 0; i < this.maxGeneraciones; i++) {
			generations[i] = i;
			fitness[i] = 0;
			fitnessAbs[i] = 0;
			fitnessMed[i] = 0;
		}
		
	}

	public void setSelection(int index) {
		seleccion = Selection.Type.values()[index];
	}

	public void setCrossing(int index) {
		crossing = Crossing.Type.values()[index];
	}

	public void setMutacion(int index) {
		mutation = Mutation.Type.values()[index];
	}

	public void run() {
		createPopulation();
		if(this.elitism) {
			this.createElite();
		}
		evaluate(0);

		for (int i = 0; i < maxGeneraciones; i++) {
			
			//DesplazarFitnessNegativo();
			//if(!this.isMaximize) {
			//	CorregirMinimizar();
			//}
			
			var selected = selection();
			var crossed = crossOver(selected);
			var mutated = mutate(crossed);
			
			if(elitism) {
				introducirElite(elite);
			}
			
			poblacion = mutated;
			evaluate(i);
		}
		
		
		
		
	}
	
	public int getBestPosition() {
		return this.pos_mejor;
	}
	
	public String getBestIndividuo() {
		return this.elMejor.cromosoma.toString();
	}
	

	public void setMaximized(boolean max) {
		this.isMaximize = max;
	}

	protected abstract void createPopulation();

	
	
	protected Individuo[] clonarPoblacion() {
		
		
		Individuo[] clone = new Individuo[poblacion.length];
		
		
		
		for(int i = 0; i < poblacion.length; i++) {
			
			
			clone[i]=IndividuoFactory.getIndividuo(indiceAlgoritmo,i,tolerance, numeroGenes);
			clone[i].copySelf(poblacion[i]);
		}
		
		
		
		return clone;
	}
	
	
	protected Individuo[] selection() {

		Individuo[] seleccionados = null;

		Individuo[] poblacion = clonarPoblacion();
		
		switch (seleccion) {

		case Proporcional:
			seleccionados = Selection.Proporcional(poblacion);
			break;
		case MuestreoUniversalEstoclastico:
			seleccionados = Selection.MuestreoUniversalEstoclastico(poblacion);
			break;
		case Truncamiento:
			seleccionados = Selection.Truncamiento(poblacion);
			break;
		case TorneoDeterministico:

			seleccionados = Selection.TorneoDeterministico(poblacion, tamTorneo);
			break;
		case TorneoProbabilistico:

			double p = 0.5;
			seleccionados = Selection.TorneoProbabilistico(poblacion, tamTorneo, p);
			break;
		case Ranking:

			seleccionados = Selection.Ranking(poblacion);
			break;
		case Restos:
			seleccionados = Selection.Restos(poblacion);
			break;
		}
		if(this.elitism) {
			for(int i=0;i<this.elite.length;i++) {
				this.elite[i].copySelf(this.poblacion[i]);
			}
		}
		return seleccionados;

	}

	protected Individuo[] crossOver(Individuo[] poblacion) {

		Individuo[] crossed = null;
		switch (crossing) {
		case Mono:
			crossed = Crossing.MonopointCrossOver(poblacion, probCruce, 1);
			break;
		case Aritmetic:
			crossed= Crossing.AritmeticCrossOver(poblacion, probCruce);
			break;
		case Uniform:
			crossed = Crossing.UniformCrossOver(poblacion, probCruce);
			break;

		}

		return crossed;
	}

	protected Individuo[] mutate(Individuo[] poblacion) {

		Individuo[] mutated = null;

		switch (mutation) {
		case Uniform:
			mutated = Mutation.mutateUniform(poblacion, probMutacion);
			break;
		case NonUniform:
			mutated = Mutation.mutateNonUniform(poblacion, probMutacion);
			break;
		default:
			mutated = Mutation.mutateUniform(poblacion, probMutacion);
			break;

		}
		return mutated;
	}


	public void introducirElite(Individuo[] elite) {

		int eliteSize = elite.length;

		for (int i = 0; i < eliteSize; i++) {

			poblacion[i].copySelf(elite[i]);
		}
	}

	public void CorregirMinimizar() {

		double max = poblacion[0].getFitness();
		for (int i = 1; i < poblacion.length; i++) {

			if (poblacion[i].getFitness() > max)
				max = poblacion[i].getFitness();
		}

		max = max * 1.05;

		for (int i = 0; i < poblacion.length; i++) {
			poblacion[i].setFitness(max - poblacion[i].getFitness());
		}
	}

	public void DesplazarFitnessNegativo() {

		double min = poblacion[0].getFitness();

		for (int i = 1; i < poblacion.length; i++) {

			if (poblacion[i].getFitness() < min)
				min = poblacion[i].getFitness();
		}

		if(min < 0) {
			for(int i = 0; i < poblacion.length; i++) {
				poblacion[i].setFitness( poblacion[i].getFitness() + Math.abs(min));
			}
		}
		
	}

	protected void evaluate(int currGeneration) {

		poblacion[0].evaluateSelf();
		
		double best_fitness=poblacion[0].getFitness();
		double best_fitness_abs=poblacion[0].getFitnessAbs();
		this.pos_mejor=0;
		double sum_fitness=poblacion[0].getFitness();
		double sum_score=0.0;
	
		for(int i = 1; i < this.tamPoblacion; i++) {
			poblacion[i].evaluateSelf();
			double fit=poblacion[i].getFitness();
			sum_fitness+=fit;
			if((this.isMaximize && fit>best_fitness) || 
				(!this.isMaximize && fit<best_fitness)) {
				best_fitness=fit;
				pos_mejor=i;
			}
		}
		this.elMejor=poblacion[this.pos_mejor];
	
		for(int i = 0; i < this.tamPoblacion; i++) {
			double div=this.poblacion[i].getFitness()/sum_fitness;
			this.poblacion[i].setPunct(div);
			sum_score+=this.poblacion[i].getPunct();
			
		}
		
		for(int i = 0; i < this.tamPoblacion; i++) {
			double fit= this.poblacion[i].getFitnessAbs();
			if((this.isMaximize && fit>best_fitness_abs) || 
					(!this.isMaximize && fit<best_fitness_abs)) {
				best_fitness_abs=fit;
			}
		}
		
		this.fitnessMed[currGeneration]=sum_fitness/this.poblacion.length;
		this.fitness[currGeneration]=best_fitness;
		
		if(currGeneration > 0 && this.fitnessAbs[currGeneration -1] > best_fitness_abs) {
			best_fitness_abs = this.fitnessAbs[currGeneration -1];
		}
		
		this.fitnessAbs[currGeneration]=best_fitness_abs;
	}

	public double[] getGenerations() {
		return this.generations;
	}

	public double[] getFitness() {
		return this.fitness;
	}

	public double[] getAbsFitness() {
		return this.fitnessAbs;
	}

	public double[] getMediumFitness() {
		return this.fitnessMed;
	}

	protected abstract void createElite();
	
}
