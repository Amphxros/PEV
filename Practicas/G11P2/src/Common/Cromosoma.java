package Common;

import java.util.Random;

public class Cromosoma {
	protected Gen[] genes;
	protected int numGenes;
	
	protected String fenotype;
	
	protected double fitness;
	protected double fitnessAbs;
	
	protected double punct;
	protected double punctAbs;
	
	public Cromosoma(int numGenes) {
		this.numGenes=numGenes;
		Random rnd= new Random();
		int city;
		boolean [] included= new boolean[this.numGenes];
		for(int i=0;i<this.numGenes;i++) {
			included[i]=false;
		}
		
		for(int i=0;i<this.numGenes;i++) {
			do{
				city= rnd.nextInt(0,this.numGenes);
			}
			while(city==25 || included[city]);
			this.genes[i]= new Gen(city);
			included[city]=true;
		}
	}
	
	public int getNumGenes() {
		return this.numGenes;
	}
	
	public double getFitness() {
		return this.fitness;
	}

	
	public void setFitness(double fitness) {
		this.fitness=fitness;
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
	
	public double getPunctAbs() {
		return this.punctAbs;
	}
	
	public void setPunctAbs(double punct) {
		this.punctAbs=punct;
	}
		
	
	public void copy(Cromosoma cromosoma) {
		for (int i=0;i<this.numGenes;i++) {
			this.genes[i].setAllele(cromosoma.genes[i].getAllele()); 
		}
		
		this.fitness=cromosoma.getFitness();
		this.fitnessAbs=cromosoma.getFitnessAbs();
		this.punct=cromosoma.getPunct();
		this.punctAbs=cromosoma.getPunctAbs();
		
	}

	public void evaluateSelf() {
		int fitness =0;
		int city= this.numGenes;
		
		for(int i=0;i<this.numGenes;i++) {
			fitness+=CityData.getDistance(this.genes[i].getAllele(), city);
			city=genes[i].getAllele();
		}
		
		this.setFitness(fitness);
		this.setFitnessAbs(this.getFitnessAbs() + fitness);
	}
	
	
}
