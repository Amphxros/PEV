package Common;

import java.util.ArrayList;

import Common.Genes.BooleanGen;
import Common.Genes.Gen;
import Common.Genes.RealGen;

public class Cromosoma<T>{
	public Gen[] genes;
	protected int tamCromosoma;
	protected double tolerance;
	protected double[] min;
	protected double[] max;
	
	
	public Cromosoma(int tamCromosoma, double tolerance, double[]mins,double[]maxs ) {
		this.tamCromosoma=tamCromosoma;
		this.tolerance=tolerance;
		
		this.genes= new Gen[this.tamCromosoma];
		this.min= new double[this.tamCromosoma];
		this.max=new double [this.tamCromosoma];
		
		for(int i=0;i<this.tamCromosoma;i++) {
			this.min[i]=mins[i];
			this.max[i]=maxs[i];
		}
	}
	public Cromosoma( double tolerance, double min,double max ) {
		this.tolerance=tolerance;
		this.tamCromosoma=1;
		this.genes= new Gen[this.tamCromosoma];
		this.min= new double[this.tamCromosoma];
		this.max=new double [this.tamCromosoma];
		
		for(int i=0;i<this.tamCromosoma;i++) {
			this.min[i]=min;
			this.max[i]=max;
		}
	}
	
	public void initCromosome() {
		for (int i = 0; i < this.tamCromosoma; i++) {
		genes[i].startGen();
		}
	}
	
	public void createGenes(int indGen){ //solamente crea los genes vacios
		genes[indGen] = new BooleanGen(min[indGen],max[indGen],tolerance);
	}
	
	public void createGenes(int min,int max){ //solamente crea los genes vacios
		genes[0]= new RealGen(min,max,this.tolerance);
	}
	
	
	public void copy(Cromosoma cromosoma) {
		this.tamCromosoma=cromosoma.tamCromosoma;
		this.genes= new Gen[this.tamCromosoma];
		for(int i=0;i<this.tamCromosoma;i++) {
			genes[i].copyGen(cromosoma.genes[i]);
		}
		
		this.tolerance=cromosoma.tolerance;
		
	}
	
	public int getLength() {
		return 1;
	}
	
		
	
	
}
