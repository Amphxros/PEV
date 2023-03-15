package Common;

import java.util.ArrayList;

import Common.Genes.Gen;

public class Cromosoma<T>{
	int[] tamGenes;
	private Gen<T>[] genes;
	/**
	 * Constructor
	 * @param numGenes tam of the gene array
	 */
	public Cromosoma(int numGenes) {
		genes=(Gen<T>[]) new Gen[numGenes]; 
	}
	
	/**
	 * @param pos position of the gene 
	 * @return the gene in pos position
	 */
	public Gen<T> getGen(int pos) {
		return this.genes[pos];
	}
	
	/**
	 * Sets the allele of the gene
	 * @param gen
	 * @param pos
	 */
	public void setGen(Gen<T> gen, int pos) {
		this.genes[pos]=(Gen<T>)gen;
	}
	
	/**
	 * 
	 * @return the size of the array
	 */
	public int getLength() {
		return this.genes.length;
	}
	
	/**
	 * @return the array of genes
	 */
	public Gen<T>[] getCromosome(){
		return (Gen<T>[]) genes;
	}
	
	/**
	 * @return the value of the alleles
	 * ex: 0 1 0 0 for fenotype 4
	 */
	public String getString() {
		String s="";
		for(int i=0;i<this.getLength();i++) {
			s+=this.genes[i].toString();
		}
		return s;
	}
	
}
