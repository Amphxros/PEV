package Common;

import java.util.ArrayList;

public class Cromosoma<T>{
	int[] tamGenes;
	private ArrayList<T> genes;
	public Cromosoma() {
		
	}
	public Cromosoma(int numGenes) {
		genes= new ArrayList<T>(numGenes);
	}
	public T getGen(int index) {
		return this.genes.get(index);
	}
	public void setGen(T gen, int index) {
		this.genes.add(index, gen);
	}
	
	public int getLength() {
		return this.genes.size();
	}
	public T[] getCromosome(){
		return (T[]) genes.toArray(); 
	}
	
}
