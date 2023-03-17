package Common;

import java.util.ArrayList;
import java.util.Random;

import Common.Genes.Gen;

public abstract class Individuo<T, U> {

	
	protected Cromosoma<T> cromosoma;
	protected int numGenes;

	protected double tolerance;
	
	protected U[] fenotype; //fenotipo

	private double fitness; //fitness
	private double fitnessAbs; //absolute fitness

	protected int id; //id for different functions
	

	public Individuo(double tolerance, int id, int numGenes) {
		this.numGenes=numGenes;
		
		this.tolerance=tolerance;
		this.id=id;
		this.numGenes=numGenes;
		this.fitness=0;
		this.fitnessAbs=0;
		
	}
	
	public int tamGen(double tolerance, double min, double max)
	{
		return (int) (Math.log10(((max - min) / tolerance) + 1) / Math.log10(2));
	}
	
	public Cromosoma<T> getCromosomes() {
		return cromosoma;
	}
	
	/**
	 * Copys the cromosome ind
	 * @param ind
	 */
	public void get(Individuo ind) {
		ind.setTolerance(tolerance);
		ind.setFitness(fitness);
		ind.setID(id);
		
		for(int i=0;i<numGenes;i++) {
			ind.cromosoma.setGen(cromosoma.getGen(i), i);
		}
	}
	
	public T getGen(int pos) {
		return (T) cromosoma.getGen(pos);
	}
	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id=id;
	}
	public void print() {
		
		System.out.print("Individuo " +this.id+ " Fitness:" + getFitness() + " ");
		
		for(int i=0;i<this.getCromosomeArraySize();i++) {
			System.out.print(this.cromosoma.getGen(i).toString());
		}
		System.out.print(" ");
	}
	
	public void mutate(Random rnd, double probability) {
		boolean mutated = false;
		
		for (int i=0; i < numGenes ; i++) {
			if(!mutated) {
				mutated = mutateSelf(i, rnd, probability);
			}
		}
		if (mutated)
			calculateFenotype(); // Update fenotype
	}
	
	

	protected abstract boolean mutateSelf(int pos, Random rnd, double probability);
	protected abstract void calculateFenotype();
	public abstract void evaluateSelf();
	

	public int getCromosomeArraySize() {
		return cromosoma.getLength();
	}
	
	
	public double getFitness(){
		return this.fitness;
	}
	
	public void setFitness(double fitness){
		this.fitness = fitness;
		this.fitnessAbs+=fitness;
	}
	
	
	public double getTolerance() {
		return tolerance;
	}

	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
	
	public U[] getFenotype() {
		return fenotype;
	}
	
	public double getFitnessAbs() {
		return this.fitnessAbs;
	}

} 
