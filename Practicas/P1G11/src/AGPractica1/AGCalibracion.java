package AGPractica1;

import Common.Algoritmo;

public class AGCalibracion extends Algoritmo {

	public AGCalibracion(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation) {
		super(tamPoblacion, maxGeneraciones, probCruce, probMutation);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	protected void evaluate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createPopulation() {
		poblacion= new IndividuoCalibracion[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion; i++) {
			poblacion[i]= new IndividuoCalibracion(0,0,3); //TODO change this a bit
		}
		
		
	}

	

}