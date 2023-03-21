package AGPractica1.Ej4A;

import Common.Algoritmo;
import Common.IndividuoFactory;

public class AlgoritmoMichalewiczA extends Algoritmo{

	private final int dimension;
	public AlgoritmoMichalewiczA(double tolerance,int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation,
			int tamTorneo,int dimension, double elitismo) {
		super(tolerance,tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
		this.dimension=dimension;
		this.isMaximize=false;
	}
	

	@Override
	protected void createPopulation() {
		poblacion= new IndividuoMichalewiczA[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion;i++) {
			poblacion[i]= IndividuoFactory.getIndividuo(4,i,tolerance,2);
			poblacion[i].startCromosome();
		}
		
	}

}
