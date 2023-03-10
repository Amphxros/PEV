package Common;

import java.util.ArrayList;

import Common.Genes.Gen;

public class Cromosoma<T>{
	int[] tamGenes;
	private Gen<T>[] genes;
	
	public Cromosoma(int numGenes) {
		genes=(Gen<T>[]) new Gen[numGenes]; 
	}
	public Gen<T> getGen(int index) {
		return this.genes[index];
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
	
	public String getString() {
		String s="";
		for(int i=0;i<this.getLength();i++) {
			s+=this.genes[i].toString();
		}
		return s;
	}
	
}
