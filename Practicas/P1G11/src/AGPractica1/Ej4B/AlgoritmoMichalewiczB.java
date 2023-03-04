package AGPractica1.Ej4B;

import AGPractica1.Ej4A.IndividuoMichalewiczA;
import Common.Algoritmo;

public class AlgoritmoMichalewiczB extends Algoritmo {
	private final int dimension;
	public AlgoritmoMichalewiczB(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation,
			int tamTorneo,int dimension) {
		super(tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo);
		this.dimension=dimension;
		this.isMaximize=false;
	}

	@Override
	protected void createPopulation() {
	poblacion= new IndividuoMichalewiczA[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion;i++) {
			poblacion[i]= new IndividuoMichalewiczA(0.1,i,2,dimension);
		}
		
		
	}

	@Override
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
			if(i==0||(best_fitness < poblacion[i].getFitness() && this.isMaximize) ||(best_fitness > poblacion[i].getFitness() && !this.isMaximize) ) {
				best_fitness=poblacion[i].getFitness();
				this.elMejor=poblacion[i];
				this.pos_mejor=i;
			}
		}	
		this.fitness[currGeneration]=this.elMejor.getFitness();
		this.fitnessMed[currGeneration]=sum/this.poblacion.length;
		
		if(currGeneration>0) {
			this.fitnessAbs[currGeneration]+= this.fitnessAbs[currGeneration] + this.elMejor.getFitness();
		}
		else {
			this.fitnessAbs[currGeneration]= this.elMejor.getFitness();
		}
		//resets everything
		
	}

}
