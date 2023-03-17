package AGPractica1.Ej3;


import Common.Algoritmo;

public class AlgoritmoStyblinskiTang extends Algoritmo {

	public AlgoritmoStyblinskiTang(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation,
			int tamTorneo, double elitismo) {
		super(tamPoblacion, maxGeneraciones, probCruce, probMutation, tamTorneo, elitismo);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createPopulation() {
		poblacion= new IndividuoStyblinskiTang[this.tamPoblacion];
		
		for(int i=0;i<this.tamPoblacion; i++) {
			poblacion[i]= new IndividuoStyblinskiTang(0.1,i,2); //TODO change this a bit
		}
	}

}
