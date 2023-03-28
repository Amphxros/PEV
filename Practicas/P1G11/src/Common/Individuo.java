package Common;

import java.util.Random;

import Common.Genes.BooleanGen;

public abstract class Individuo<T,U> {
	protected Cromosoma<T> cromosoma;
	
	
	protected double fitness=0;
	protected double fitnessAbs=0;
	
	protected double punct=0;
	protected double punctAbs=0;
	
	protected int lcrom;
	protected int numGenes;
	protected double tolerance;
	protected double adaptation;

	protected int id;
	protected int typeFunct;
	
	protected double[] min;
	protected double[] max;
	
	protected U[] fenotype;
	
	private int posGen=0;
	private int indGen=0;
	
	
	public Individuo(double tolerance,int id, int numGenes) {
		this.tolerance=tolerance;
		this.id=id;
		this.numGenes=numGenes;
		this.min=new double[this.numGenes];
		this.max= new double[this.numGenes];
		this.cromosoma= new Cromosoma(numGenes,tolerance, min, max);
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
		
		obtenIndGen(position);
		//this.cromosoma.genes[indGen]).getAllele(posGen)-1), posGen))
		var aux=(BooleanGen)parent.cromosoma.genes[indGen];
		int i=0;
		if(aux.getAlelle(posGen -1)) i=1;
		this.cromosoma.genes[indGen].insert(i, posGen);
	}
	

	private void obtenIndGen(int pos){
		indGen = 0;
		int posAcum = this.cromosoma.genes[indGen].getLength();
		while (posAcum <= pos && posAcum < lcrom) {
			indGen++;
			posAcum +=this.cromosoma.genes[indGen].getLength();
		}
		posGen = pos-(posAcum-this.cromosoma.genes[indGen].getLength());
	}
	
	public abstract void evaluateSelf();
	
	public abstract boolean mutateSelf(int pos, Random rnd, double probability);	
	
	protected abstract void calculateFenotype();
	
	public void copySelf(Individuo ind) {
		this.tolerance=ind.tolerance;
		this.fitness=ind.fitness;
		this.fitnessAbs=ind.fitnessAbs;
		this.punct=ind.punct;
		this.punctAbs=ind.punctAbs;
		this.min=ind.min;
		this.max=ind.max;
		
		this.cromosoma.copy(ind.cromosoma);
		
		
	}
	
	public int getNumGenes() {
		return this.numGenes;
	}
	
	
	
	public double getFitness() {
		return this.fitness;
	}
	
	public void setFitness(double fitness) {
		if(fitness>this.fitnessAbs) {
			this.setFitnessAbs(fitness);
		}
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
		
	public void setFitnessAbs(double fitness) {
		this.fitnessAbs=fitness;
	}
	
	public double getPunct() {
		return this.punct;
	}
	
	public void setPunct(double punct) {
		this.punct=punct;
	}
	
	public double getTolerance() {
		return this.tolerance;
	}
	public void setTolerance(double tolerance) {
		this.tolerance=tolerance;
	}
	
	public int getLcrom() {
		return this.lcrom;
	}

	public int getLength(){
		int l = 0;
		for (int i = 0; i < this.getNumGenes(); i++){
			l += this.cromosoma.genes[i].getLength();
		}
		return l;
	}
	
	public void setType(int type) {
		this.typeFunct=type;
	}
	public int getType() {
		return this.typeFunct;
	}
	
	
	
}
