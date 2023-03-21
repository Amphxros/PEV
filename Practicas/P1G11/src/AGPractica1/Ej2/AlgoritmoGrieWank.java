package AGPractica1.Ej2;


import Common.Algoritmo;
import Common.IndividuoFactory;

public class AlgoritmoGrieWank extends Algoritmo {

	public AlgoritmoGrieWank(double tolerance,int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation, int tamTorneo, double elitismo) {
		super(tolerance,tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	protected void createPopulation() {
		poblacion= new IndividuoGrieWank[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion; i++) {
			poblacion[i]= IndividuoFactory.getIndividuo(2,i,tolerance,2);
			poblacion[i].startCromosome();
			
		}
		
	}


}
