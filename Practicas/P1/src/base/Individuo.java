package base;

import java.util.ArrayList;

public class Individuo<T> {

	int[] tamGenes;
	private ArrayList<Gen<T>> cromosoma; //genotipo
	int tam_Cromosoma;
	private double apt;
	private double punct;
	private double punctAcum;
	private double fenotype; //fenotipo
	private double fitness; //fitness
	

	public Individuo() {
		this.cromosoma= new ArrayList<>();
		
	}
	
	public Individuo(Algoritmo<T> problema) {
		this.cromosoma= new ArrayList<>();
		
	}
	
	public ArrayList<Gen<T>> getCromosomes() {
		return cromosoma;
	}
	
	public Gen<T> getGen(int pos) {
		return cromosoma.get(pos);
	}
	
	public void crossOver(Individuo<T> parent, int position) {
		
	}
	public void mutate(int position) {
		
	}
	public void evaluateSelf() {
		
	}


} 
