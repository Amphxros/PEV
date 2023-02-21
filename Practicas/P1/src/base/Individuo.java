package base;

import java.util.ArrayList;

import base.Genes.Gen;

public class Individuo<T> {

	int[] tamGenes;
	private ArrayList<Gen<T>> cromosoma; //genotipo
	int tam_Cromosoma;
	private double apt;
	private double punct;
	private double punctAcum;
	
	protected double fenotype; //fenotipo
	protected double fitness; //fitness
	protected int id; //id for different functions
	protected double tolerance;

	public Individuo(double tolerance, int id, int numGenes) {
		this.cromosoma= new ArrayList<>(numGenes);
		this.tolerance=tolerance;
		this.id=id;
		this.tam_Cromosoma=numGenes;
		
		
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
		int index=0;
		int pos = getGenIndex(index ,position);
		this.cromosoma.add(index, null); // TODO change null for calculated Individual
		
	}
	
	private int getGenIndex(int ind,int pos) {
		int posAcum= this.cromosoma.get(ind).length();
		while(posAcum < pos &&posAcum<this.tam_Cromosoma) {
			ind++;
			posAcum+=this.cromosoma.get(ind).length();
		}
		return pos - (posAcum - this.cromosoma.get(ind).length());
	}
	
	
	public void mutate(int position) {
		int index=0;
		int pos = getGenIndex(index ,position);
		this.cromosoma.add(index, null); // TODO change null for calculated Individual

	}
	public void evaluateSelf() {
		
	}


} 
