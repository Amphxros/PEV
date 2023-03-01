package Common;



public abstract class Algoritmo<T> {

	private final int tamPoblacion;
	private Individuo[] poblacion;
	private double[] fitness;
	private final int maxGeneraciones;
	private double probCruce;
	private double probMutacion;
	private int tamTorneo;
	private Individuo elMejor;
	private int pos_mejor;
	
	protected Selection.Type seleccion;
	protected Crossing.Type crossing;
	private Crossing mCrossingInstance;


	
	public Algoritmo(int tamPoblacion, int maxGeneraciones, double probCruce, double probMutation) {
		this.maxGeneraciones = maxGeneraciones;
		this.tamPoblacion = tamPoblacion;
		this.probCruce = probCruce;
		this.probMutacion = probMutation;
		mCrossingInstance= new Crossing();
	
	}

	public void run() {

		createPopulation();
		evaluate();
		for (int i = 0; i < maxGeneraciones; i++) {
			selection();
			crossOver();
			mutate();
			evaluate();
		}
	}

	protected void createPopulation() {
		for(int i=0;i<this.tamPoblacion; i++) {
			
		}
	}

	protected void selection() {
	
		Individuo[] seleccionados = null;
		
		switch(seleccion) {

		case Proporcional:
			seleccionados = Selection.Proporcional(poblacion, fitness);
			break;
		case MuestreoUniversalEstoclastico:
			seleccionados = Selection.MuestreoUniversalEstoclastico(seleccionados, fitness);
			break;
		case Truncamiento:
			seleccionados = Selection.Truncamiento(seleccionados, fitness);
			break;
		case TorneoDeterministico:
			seleccionados = Selection.TorneoDeterministico(seleccionados, fitness, tamTorneo);
			break;
		case TorneoProbabilistico:
			
			double p = 0.5;
			seleccionados = Selection.TorneoProbabilistico(seleccionados, fitness, tamTorneo , p);
			break;
		case Ranking:
			
			seleccionados = Selection.Ranking(seleccionados, fitness);
			break;
		case Restos:
			seleccionados = Selection.Restos(seleccionados, fitness);
			break;
		}
		
		
		
		//Para testear
		
		for(int i = 0; i < seleccionados.length; i++)
		{
			System.out.println(seleccionados[i].fitness);
		}
		
		
	}

	protected void crossOver() {
		switch (crossing) {
		case Mono:
			
			break;
		case Multiple:
			break;
		case Uniform:
			break;
			
		}
	}
	
	protected void mutate() {
		
	}
	protected void evaluate() {
		
	}

}
