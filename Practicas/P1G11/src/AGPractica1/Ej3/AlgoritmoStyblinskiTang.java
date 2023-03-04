package AGPractica1.Ej3;


import Common.Algoritmo;

public class AlgoritmoStyblinskiTang extends Algoritmo {

	public AlgoritmoStyblinskiTang(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation,
			int tamTorneo, double elitismo) {
		super(tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createPopulation() {
		poblacion= new IndividuoStyblinskiTang[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion; i++) {
			poblacion[i]= new IndividuoStyblinskiTang(0.1,i,2); //TODO change this a bit
		}
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
		this.fitness[currGeneration]=this.elMejor.getFitness();
		this.fitnessMed[currGeneration]=sum/this.poblacion.length;
		
		if(currGeneration>0) {
			if(this.isMaximize)
				this.fitnessAbs[currGeneration]= Math.max( elMejor.getFitness(), this.fitnessAbs[currGeneration - 1]);
			else
				this.fitnessAbs[currGeneration]= Math.min( elMejor.getFitness(), this.fitnessAbs[currGeneration - 1]);
		}
		else {
			this.fitnessAbs[currGeneration]= this.elMejor.getFitness();
		}
		
		
		
	}

}
