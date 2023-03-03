package Common;

import AGPractica1.Ej1.IndividuoCalibracion;

public abstract class Algoritmo {

	protected final int tamPoblacion;
	protected Individuo[] poblacion; 
	protected final double[] fitness;
	protected final double[] generations; //eje x
	protected final double[] fitnessAbs; //eje y2
	protected final double[] fitnessMed; //eje y3
	
	
	
	protected final int maxGeneraciones;
	protected double probCruce;
	protected double probMutacion;
	protected int tamTorneo;
	protected Individuo elMejor;
	protected int pos_mejor;
	
	protected Selection.Type seleccion;
	protected Crossing.Type crossing;
	protected Mutation.Type mutation;
	protected boolean isMaximize=false;
	

	/**
	 * 
	 * @param tamPoblacion
	 * @param maxGeneraciones
	 * @param probCruce
	 * @param probMutation
	 */
	public Algoritmo(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation, int tamTorneo) {
		this.maxGeneraciones = maxGeneraciones;
		this.tamPoblacion = tamPoblacion;
		this.probCruce = probCruce;
		this.probMutacion = probMutation;
		this.tamTorneo = tamTorneo;
		
		generations= new double[this.maxGeneraciones];
		fitness= new double[this.maxGeneraciones];
		
		fitnessAbs= new double[this.maxGeneraciones];
		fitnessMed= new double[this.maxGeneraciones];

		for(int i=0;i<this.maxGeneraciones;i++) {
			generations[i]=i; 
			fitness[i]=1;
			fitnessAbs[i]=0;
			fitnessMed[i]=0;
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

		IndividuoCalibracion.static_fitness_ = 1;
		createPopulation();
		evaluate(0);
		
		
		/*Esto es de testeo de las selecciones
		 * 
		 * var seleccionados = selection();
		
		double count = 0;
		for(int i = 0; i < seleccionados.length; i++) {
			System.out.println(seleccionados[i].fitness);
			count+= seleccionados[i].fitness;
		}
		
		System.out.println("Valor medio " + count / seleccionados.length);
		
		*/
		
		for (int i = 0; i < maxGeneraciones; i++) {
			
			var selected = selection();
			var crossed = crossOver(selected);
			var mutated = mutate(crossed);
			
			poblacion = mutated;
			evaluate(i);
		}
	}

	protected abstract void createPopulation();

	protected Individuo[] selection() {
	
		Individuo[] seleccionados = null;
		
		switch(seleccion) {

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
			seleccionados = Selection.TorneoProbabilistico(poblacion, tamTorneo , p);
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
		
		switch(mutation) {
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
	protected abstract void evaluate(int currGeneration);

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
