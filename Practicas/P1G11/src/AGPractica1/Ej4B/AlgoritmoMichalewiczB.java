package AGPractica1.Ej4B;

import AGPractica1.Ej4A.IndividuoMichalewiczA;
import Common.Algoritmo;

public class AlgoritmoMichalewiczB extends Algoritmo {
	private final int dimension;
	public AlgoritmoMichalewiczB(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation,
			int tamTorneo,int dimension, double elitismo) {
		super(tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
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
}
