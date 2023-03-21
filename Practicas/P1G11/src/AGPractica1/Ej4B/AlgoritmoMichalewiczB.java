package AGPractica1.Ej4B;

import AGPractica1.Ej4A.IndividuoMichalewiczA;
import Common.Algoritmo;
import Common.IndividuoFactory;

public class AlgoritmoMichalewiczB extends Algoritmo {
	private final int dimension;
	public AlgoritmoMichalewiczB(double tolerance,int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation,
			int tamTorneo,int dimension, double elitismo) {
		super(tolerance,tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
		this.dimension=dimension;
		this.isMaximize=false;
	}

	@Override
	protected void createPopulation() {
	poblacion= new IndividuoMichalewiczA[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion;i++) {
			poblacion[i]= IndividuoFactory.getIndividuo(5,i,tolerance,2);
			poblacion[i].startCromosome();
		}
		
		
	}
}
