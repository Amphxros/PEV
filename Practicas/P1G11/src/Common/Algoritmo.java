package Common;

public abstract class Algoritmo {

	protected final int tamPoblacion;
	protected Individuo[] poblacion;
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
			fitness[i] = 1;
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
		evaluate(0);

		for (int i = 0; i < maxGeneraciones; i++) {
			
			DesplazarFitnessNegativo();
			if(!this.isMaximize) {
				CorregirMinimizar();
			}
			
			
			var elite = generarElite();
			
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

	protected Individuo[] selection() {

		Individuo[] seleccionados = null;

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

		return seleccionados;

	}

	protected Individuo[] crossOver(Individuo[] poblacion) {

		Individuo[] crossed = null;
		switch (crossing) {
		case Mono:
			crossed = Crossing.MonopointCrossOver(poblacion, probCruce, 1);
			break;
		case Multiple:
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

	public Individuo[] generarElite() {

		if (!elitism)
			return null;

		final double elitePercentage = this.elitismPercentage;
		int size = poblacion.length;

		int eliteSize = (int) Math.floor(size * elitePercentage / 100.0f);

		Individuo[] elite = new Individuo[eliteSize];

		Individuo[] poblacionOrdenada = poblacion.clone();
		Selection.quickSort(poblacionOrdenada, 0, poblacion.length - 1);

		for (int i = 0; i < eliteSize; i++) {

			elite[i] = poblacionOrdenada[i];
		}

		return elite;

	}

	public void introducirElite(Individuo[] elite) {

		int eliteSize = elite.length;

		for (int i = 0; i < eliteSize; i++) {

			poblacion[i]= elite[i];
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

		double sum=0.0;
		double best_fitness;
		if(this.isMaximize) {
			best_fitness=Double.MIN_VALUE;
		}
		else {
			best_fitness=Double.MAX_VALUE;
		}
		for(int i=0;i<poblacion.length;i++) {
			poblacion[i].evaluateSelf();
			sum+=poblacion[i].getFitness();
			//calculate the best fitness
			if((best_fitness < poblacion[i].getFitness() && this.isMaximize) ||
				(best_fitness > poblacion[i].getFitness() && !this.isMaximize) ) {
				best_fitness=poblacion[i].getFitness();
				this.elMejor= poblacion[i];
				this.pos_mejor=i;
			}
		}	
		this.fitness[currGeneration]=this.elMejor.getFitness();
		this.fitnessMed[currGeneration]=sum/this.poblacion.length;
		
		if(currGeneration>0) {
			if(this.isMaximize)
				this.fitnessAbs[currGeneration]= Math.max( elMejor.getFitness(), this.fitnessAbs[currGeneration - 1]);
			else
				this.fitnessAbs[currGeneration]= Math.min( elMejor.getFitness(), this.fitnessAbs[currGeneration - 1]);
		}
		else {
			this.fitnessAbs[currGeneration]= this.elMejor.getFitness();
		}
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

	protected void createElite() {
		// TODO Auto-generated method stub

	}
}
