package Common;

import java.util.ArrayList;
import java.util.Random;

import Common.Genes.Gen;

public abstract class Individuo<T> {

	
	protected double[] tamGenes;
	protected Cromosoma<T> cromosoma;
	int tam_Cromosoma;
	private double punct;
	private double punctAcum;
	
	protected double[] fenotype; //fenotipo
	protected double fitness; //fitness
	protected int id; //id for different functions
	protected double tolerance;

	public Individuo(double tolerance, int id, int numGenes) {
		this.tam_Cromosoma=numGenes;
		
		this.tolerance=tolerance;
		this.id=id;
		this.tam_Cromosoma=numGenes;
		
	}
	
	public int calculateGenSize(double tolerance, double min, double max)
	{
		return (int) (Math.log10(((max - min) / tolerance) + 1) / Math.log10(2));
	}
	
	public Cromosoma<T> getCromosomes() {
		return cromosoma;
	}
	
	public T getGen(int pos) {
		return cromosoma.getGen(pos);
	}
	public int getID() {
		return this.id;
	}
	public void print() {
		for(int i=0;i<this.getCromosomeArraySize();i++) {
			System.out.print(this.cromosoma.getGen(i).toString());
		}
	}
	
	public void mutate(Random rnd, double probability) {
		int index=0;
		
	}
	
	
	protected abstract boolean mutateSelf(int pos, Random rnd, double probability);
	protected abstract void calculateFenotype();
	public abstract void evaluateSelf();
	public abstract boolean maximize();
	

	public int getCromosomeArraySize() {
		return cromosoma.getLength();
	}
	
	
	public double getFitness(){
		return this.fitness;
	}
	
	public void setFitness(double fitness){
		this.fitness = fitness;
	}
	
	public double getTolerance() {
		return tolerance;
	}

	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
	
	public double[] getFenotype() {
		return fenotype;
	}

} 
