package AGPractica1.Ej2;


import Common.Algoritmo;

public class AlgoritmoGrieWank extends Algoritmo {

	public AlgoritmoGrieWank(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation, int tamTorneo, double elitismo) {
		super(tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createPopulation() {
		poblacion= new IndividuoGrieWank[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion; i++) {
			poblacion[i]= new IndividuoGrieWank(0.1,i,2); //TODO change this a bit
			
			
		}
		
	}


}
