package AGPractica1.Ej1;

import Common.Algoritmo;

public class AGCalibracion extends Algoritmo {

	public AGCalibracion(double tolerance,int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation, int tamTorneo, double elitismo) {
		super(tolerance,tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	protected void createPopulation() {
		poblacion= new IndividuoCalibracion[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion; i++) {
			poblacion[i]= new IndividuoCalibracion(this.tolerance,i,2); //TODO change this a bit
		}

	
		
	}

	

}
