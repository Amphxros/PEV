package AGPractica1.Ej4A;

import Common.Algoritmo;

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
			poblacion[i]= new IndividuoMichalewiczA(this.tolerance,i,2,dimension);
		}
		
	}

}
