package Common;

import java.util.Random;

public abstract class Individuo<T,U> {
	protected Cromosoma<T> cromosoma;
	
	protected double fitness;
	protected double fitnessAbs;
	
	protected double punct;
	protected double punctAbs;
	
	protected int lcrom;
	protected int numGenes;
	protected double tolerance;
	protected double adaptation;
	protected int id;
	
	protected double[] min;
	protected double[] max;
	
	protected U[] fenotype;
	
	public Individuo(double tolerance,int id, int numGenes) {
		this.tolerance=tolerance;
		this.id=id;
		this.numGenes=numGenes;
		this.min=new double[this.numGenes];
		this.max= new double[this.numGenes];
	}
	
	public Individuo(double tolerance,int id, int numGenes, double[] min, double[]max) {
		this.tolerance=tolerance;
		this.id=id;
		this.numGenes=numGenes;
		this.min=min;
		this.max= max;
	}

	public abstract void createCromosome();
	
	public void startCromosome() {
		this.cromosoma.initCromosome();
	}
	
	
	public void crossOver(Individuo parent, int position) {
		
	}
	
	public abstract void evaluateSelf();
	public abstract boolean mutateSelf(int pos, Random rnd, double probability);	
	protected abstract void calculateFenotype();
	
	
	public void copySelf(Individuo ind) {
		this.cromosoma.copy(ind.cromosoma);
		this.tolerance=ind.tolerance;
		this.fitness=ind.fitness;
		this.fitnessAbs=ind.fitnessAbs;
		this.punct=ind.punct;
		this.punctAbs=ind.punctAbs;
		this.min=ind.min;
		this.max=ind.max;
		
	}
	
	
	public double getFitness() {
		return this.fitness;
	}
	
	public void setFitness(double fitness) {
		this.fitness=fitness;
	}
	

	public double getAdaptation() {
		return this.adaptation;
	}
	
	public void setAdaptation(double adpt) {
		this.adaptation=adpt;
	}
	
	public double getFitnessAbs() {
		return this.fitnessAbs;
	}
		
	public void setFitnessAbs(double fitnessAbs) {
		this.fitnessAbs=fitnessAbs;
	}
	
	public double getPunct() {
		return this.punct;
	}
	
	public void setPunct(double punct) {
		this.punct=punct;
	}

	
	
}
