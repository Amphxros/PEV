package AGPractica1.Ej1;

import Common.Algoritmo;
import Common.IndividuoFactory;

public class AGCalibracion extends Algoritmo {

	public AGCalibracion(double tolerance,int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation, int tamTorneo, double elitismo) {
		super(tolerance,tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	protected void createPopulation() {
		poblacion= new IndividuoCalibracion[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion; i++) {
			poblacion[i]= IndividuoFactory.getIndividuo(1,i,tolerance,2);
			poblacion[i].startCromosome();
		}
		
		this.elMejor= IndividuoFactory.getIndividuo(1,0,tolerance,2);
		this.elMejor.startCromosome();
	
		
	}

	@Override
	protected void createElite() {
		this.elite= new IndividuoCalibracion[(int)(this.tamPoblacion* this.elitismPercentage)];
		
		for(int i=0;i<this.elite.length;i++) {
			this.elite[i]=IndividuoFactory.getIndividuo(1,i,tolerance,2);
			this.elite[i].startCromosome();
		}
	}

	

}
