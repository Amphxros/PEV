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
	
	protected double punt; // puntRelat = aptitud / sumaAptitud
	protected double puntAbs; // para seleccion

	protected int id; //id for different functions
	

	public Individuo(double tolerance, int id, int numGenes) {
		this.numGenes=numGenes;	
		this.tolerance=tolerance;
		this.id=id;
		this.numGenes=numGenes;
		this.fitness=0;
		this.fitnessAbs=0;
		
	}
	/**
	 * Calculates the tam
	 * @param tolerance
	 * @param min
	 * @param max
	 * @return
	 */
	public int tamGen(double tolerance, double min, double max)
	{
		return (int) (Math.log10(((max - min) / tolerance) + 1) / Math.log10(2));
	}
	
	public Cromosoma<T> getCromosomes() {
		return cromosoma;
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
	

	public void copyCromosome(Individuo ind) {
		for (int i = 0; i < this.numGenes; i++)
			this.cromosoma.setGen(ind.cromosoma.getGen(i),i);
		
		this.fitness= ind.getFitness();
		this.numGenes=ind.getCromosomeArraySize();
		this.tolerance= ind.getTolerance();
		this.fitnessAbs=ind.getFitnessAbs();
		this.id=ind.getID();
		
		
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
	
	public void setFitnessAbs(double fitnessAbs){
		this.fitnessAbs=fitnessAbs;
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
	
	public double getPunct() {
		return this.punt;
	}
	
	public void setPunct(double punct) {
		this.punt=punct;
	}

} 
