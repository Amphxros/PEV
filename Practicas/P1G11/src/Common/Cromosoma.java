package Common;

import java.util.ArrayList;

import Common.Genes.Gen;

public class Cromosoma<T>{
	int[] tamGenes;
	private Gen<T>[] genes;
	
	public Cromosoma(int numGenes) {
		genes=(Gen<T>[]) new Gen[numGenes]; 
	}
	public T getGen(int index) {
		return (T) this.genes[index];
	}
	public void setGen(Gen<T> gen, int index) {
		this.genes[index]=(Gen<T>)gen;
	}
	
	public int getLength() {
		return this.genes.length;
	}
	public Gen<T>[] getCromosome(){
		return (Gen<T>[]) genes;
	}
	
}
