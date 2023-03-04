package AGPractica1.Ej1;

import Common.Algoritmo;

public class AGCalibracion extends Algoritmo {

	public AGCalibracion(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation, int tamTorneo, double elitismo) {
		super(tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	protected void evaluate(int currGeneration) {
		double sum=0.0;
		double best_fitness;

		//resets everything
		this.elMejor=null;
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
			if((best_fitness < poblacion[i].getFitness() && this.isMaximize) ||(best_fitness > poblacion[i].getFitness() && !this.isMaximize) ) {
				best_fitness=poblacion[i].getFitness();
				this.elMejor=poblacion[i];
				this.pos_mejor=i;
			}
		}	
		
		this.fitnessMed[currGeneration]=sum/this.poblacion.length;
		this.fitness[currGeneration]=this.elMejor.getFitness();
		if(currGeneration>0) {
			this.fitnessAbs[currGeneration]+= this.fitnessAbs[currGeneration] + this.elMejor.getFitness();
		}
		else {
			this.fitnessAbs[currGeneration]= this.elMejor.getFitness();
		}
		
		
	}

	@Override
	protected void createPopulation() {
		poblacion= new IndividuoCalibracion[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion; i++) {
			poblacion[i]= new IndividuoCalibracion(0.1,i,2); //TODO change this a bit
		}
		
		
	}

	

}
