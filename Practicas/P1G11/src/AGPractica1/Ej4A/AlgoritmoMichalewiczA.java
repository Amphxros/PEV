package AGPractica1.Ej4A;

import AGPractica1.Ej1.IndividuoCalibracion;
import Common.Algoritmo;
import Common.IndividuoFactory;

public class AlgoritmoMichalewiczA extends Algoritmo{

	private final int dimension;
	public AlgoritmoMichalewiczA(double tolerance,int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation,
			int tamTorneo,int dimension, double elitismo) {
		super(tolerance,tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
		this.dimension=dimension;
		this.isMaximize=false;
		
		indiceAlgoritmo = 4;
		numeroGenes = 2;
	}
	

	@Override
	protected void createPopulation() {
		poblacion= new IndividuoMichalewiczA[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion;i++) {
			poblacion[i]= IndividuoFactory.getIndividuo(4,i,tolerance,2);
			poblacion[i].startCromosome();
		}
		this.elMejor= IndividuoFactory.getIndividuo(4,-1,tolerance,2);
		this.elMejor.startCromosome();
	}


	@Override
	protected void createElite() {
		// TODO Auto-generated method stub
		this.elite= new IndividuoCalibracion[(int)(this.tamPoblacion* this.elitismPercentage)];
		
		for(int i=0;i<this.elite.length;i++) {
			this.elite[i]=IndividuoFactory.getIndividuo(4,i,tolerance,2);
			this.elite[i].startCromosome();
		}

	}

}
