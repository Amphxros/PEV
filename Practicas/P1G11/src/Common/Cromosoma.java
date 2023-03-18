package Common;

import java.util.ArrayList;

import Common.Genes.BooleanGen;
import Common.Genes.Gen;
import Common.Genes.RealGen;
/**
 * 
 * @author Amph
 *
 */
public class Cromosoma<T>{
	public Gen[] genes;
	protected int chromosome_length;
	protected double tolerance;
	protected double[] min;
	protected double[] max;
	
	
	public Cromosoma(int tamCromosoma, double tolerance, double[]mins,double[]maxs ) {
		this.chromosome_length=tamCromosoma;
		this.tolerance=tolerance;
		
		this.genes= new Gen[this.chromosome_length];
		this.min= new double[this.chromosome_length];
		this.max=new double [this.chromosome_length];
		
		for(int i=0;i<this.chromosome_length;i++) {
			this.min[i]=mins[i];
			this.max[i]=maxs[i];
		}
	}
	public Cromosoma( double tolerance, double min,double max ) {
		this.tolerance=tolerance;
		this.chromosome_length=1;
		this.genes= new Gen[this.chromosome_length];
		this.min= new double[this.chromosome_length];
		this.max=new double [this.chromosome_length];
		
		for(int i=0;i<this.chromosome_length;i++) {
			this.min[i]=min;
			this.max[i]=max;
		}
	}
	
	/**
	 * Fills the genes in the chromosome
	 */
	public void initCromosome() {
		for (int i = 0; i < this.chromosome_length; i++) {
			genes[i].startGen();
		}
	}
	
	public void createGenes(int indGen){ 
		genes[indGen] = new BooleanGen(min[indGen],max[indGen],tolerance);
	}
	
	public void createGenes(int min,int max){ 
		genes[0]= new RealGen(min,max,this.tolerance);
	}
	
	
	public void copy(Cromosoma cromosoma) {
		this.chromosome_length=cromosoma.chromosome_length;
		this.genes= new Gen[this.chromosome_length];
		for(int i=0;i<this.chromosome_length;i++) {
			genes[i].copyGen(cromosoma.genes[i]);
		}
		
		this.tolerance=cromosoma.tolerance;
		
	}
	
	public int getLength() {
		return this.chromosome_length;
	}
	
		
	
	
}
