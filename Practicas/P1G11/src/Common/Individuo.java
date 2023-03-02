package Common;

import java.util.ArrayList;

import Common.Genes.Gen;

public abstract class Individuo<T> {

	int[] tamGenes;
	protected Cromosoma<Common.Genes.Gen<T>> cromosoma;
	int tam_Cromosoma;
	private double apt;
	private double punct;
	private double punctAcum;
	
	protected int fenotype; //fenotipo
	protected double fitness; //fitness
	protected int id; //id for different functions
	protected double tolerance;

	public Individuo(double tolerance, int id, int numGenes) {
		this.tam_Cromosoma=numGenes;
		this.cromosoma= new Cromosoma<Common.Genes.Gen<T>>(numGenes);
		this.tolerance=tolerance;
		this.id=id;
		this.tam_Cromosoma=numGenes;
		
		
	}
	
	
	public Cromosoma<Common.Genes.Gen<T>> getCromosomes() {
		return cromosoma;
	}
	
	public Common.Genes.Gen<T> getGen(int pos) {
		return cromosoma.getGen(pos);
	}
	public int getID() {
		return this.id;
	}
	
	public void crossOver(Individuo<T> parent, int position) {
		int index=0;
		int pos = getGenIndex(index ,position);
		this.cromosoma.setGen(null, index); // TODO change null for calculated Individual
		
	}
	
	private int getGenIndex(int ind,int pos) {
		int posAcum= this.cromosoma.getGen(ind).length();
		while(posAcum < pos &&posAcum<this.tam_Cromosoma) {
			ind++;
			posAcum+=this.cromosoma.getGen(ind).length();
		}
		return pos - (posAcum - this.cromosoma.getGen(ind).length());
	}
	
	
	public void mutate(int position) {
		int index=0;
		int pos = getGenIndex(index ,position);
		this.cromosoma.setGen(null, index); // TODO change null for calculated Individual

	}
	public abstract void evaluateSelf();
	
	public abstract boolean maximize();
	
	public int getCromosomeLength(){
		int l = 0;
		for (int i = 0; i < this.cromosoma.getLength(); i++){
			l += this.cromosoma.getGen(i).length();
		}
		return l;
	}

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
	
	public double getAptitud() {
		return apt;
	}
	public void setAptitud(double apt) {
		this.apt=apt;
	}
	
	public int getFenotype() {
		return fenotype;
	}

} 
