package Common;

public class AlgoritmoGenetico {
	
	int tamPopulation;
	int maxGenerations;
	
	Cromosoma[] population;
	Cromosoma[] elite;
	
	Cromosoma best;
	int bestPosition;
	
	

	protected final double[] fitness;
	protected final double[] generations; // eje x
	protected final double[] fitnessAbs; // eje y2
	protected final double[] fitnessMed; // eje y3
	
	
	protected Selection.Type seleccion;
	protected Crossing.Type crossing;
	protected Mutation.Type mutation;
	
	protected boolean maximize=false;
	protected boolean elitism=false;
	
	protected double elitismPercentage;
	protected double crossingProbability;
	protected double mutationProbability;
	
	protected int tamTournament;
	
	
	
	public AlgoritmoGenetico(int tamPopulation, int maxGenerations
	,double crossingProbability,double mutationProbability, double elitismPercentage,
	int tamTournament, boolean maximize)
	{
		this.maxGenerations=maxGenerations;
		this.tamPopulation=tamPopulation;
		this.crossingProbability=crossingProbability;
		this.mutationProbability=mutationProbability;
		this.elitismPercentage=elitismPercentage;
		this.maximize=maximize;
		
		this.elitism= this.elitismPercentage>0;
	
		this.population= new Cromosoma[this.tamPopulation];
	
		generations = new double[this.maxGenerations];
		fitness = new double[this.maxGenerations];
		fitnessAbs = new double[this.maxGenerations];
		fitnessMed = new double[this.maxGenerations];
		
		for (int i = 0; i < this.maxGenerations; i++) {
			generations[i] = i;
			fitness[i] = 0;
			fitnessAbs[i] = 0;
			fitnessMed[i] = 0;
		}
	
	}
	
	public void run() {
		this.createPopulation();
		this.evaluate(0);
		for(int i=0;i<this.maxGenerations;i++) {
			var selected= selection();
			var crossed= crossOver(selected);
			var mutated= mutate(crossed);
			evaluate(i);
		}
		
	}
	
	private void createPopulation() {
		
	}
	
	private void createElite() {
		
	}
	
	
	public void setSelection(int index) {
		seleccion = Selection.Type.values()[index];
	}

	public void setCrossing(int index) {
		crossing = Crossing.Type.values()[index];
	}

	public void setMutacion(int index) {
		mutation = Mutation.Type.values()[index];
	}
	
	private Cromosoma[] selection() {
		Cromosoma[]  seleccionados=null;
		switch (seleccion) {

		case Proporcional:
			seleccionados = Selection.Proporcional(population);
			break;
		case MuestreoUniversalEstoclastico:
			seleccionados = Selection.MuestreoUniversalEstoclastico(population);
			break;
		case Truncamiento:
			seleccionados = Selection.Truncamiento(population);
			break;
		case TorneoDeterministico:

			seleccionados = Selection.TorneoDeterministico(population, this.tamTournament);
			break;
		case TorneoProbabilistico:

			double p = 0.5;
			seleccionados = Selection.TorneoProbabilistico(population, this.tamTournament, p);
			break;
		case Ranking:

			seleccionados = Selection.Ranking(population);
			break;
		case Restos:
			seleccionados = Selection.Restos(population);
			break;
		}
		if(this.elitism) {
			for(int i=0;i<this.elite.length;i++) {
				this.elite[i].copy(this.population[i]);
			}
		}
		return seleccionados;
	}
	
	private Cromosoma[] crossOver(Cromosoma[] selected) {
		switch(crossing) {

		case PMX:
			
			break;
		case OX:
			break;
		case OXVarianteA:
			break;
		case OXVarianteB:
			break;
		case CX:
			break;
		case ERX:
			break;
		case CO:
			break;
		case Own:
			break;
								
		}
		
		return null;
	}
	
	private Cromosoma[] mutate(Cromosoma[] crossed) {
		
		switch(mutation) {
		case Insert:
			Mutation.mutateInserting(crossed, mutationProbability);
			break;
		case Exchange:
			Mutation.mutateExchanging(crossed, mutationProbability);
			break;
		case Invert:
			Mutation.mutateInvert(crossed, mutationProbability);
			break;
		case Heuristic:
			Mutation.mutateHeuristic(crossed, mutationProbability);
			break;
		}
		
		return null;
	}
	
	
	private void evaluate(int currGeneration) {
		
	}

}
