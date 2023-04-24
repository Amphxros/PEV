package AGPractica1.Ej3;

import java.util.Random;

import Common.Conversions;
import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.BooleanGen;

public class IndividuoStyblinskiTang extends Individuo<Boolean, Double>{

	final double min=-5;
	final double max=5;
	final int dimension=2;
	
	public IndividuoStyblinskiTang(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		createCromosome();
		calculateFenotype();
		super.lcrom= this.getLength();
		this.setType(3);
	}
	
	@Override
	public void createCromosome() {
		for(int i=0;i<this.numGenes;i++) {
			this.cromosoma.genes[i]= new BooleanGen(min,max,this.tolerance);
		
		}
		this.startCromosome();
	
	}
	@Override
	public void evaluateSelf() {
		calculateFenotype();
		this.setFitness(0.5*(fenotype[0] + fenotype[1]));
		
	}
	@Override
	public boolean mutateSelf(int pos, Random rnd, double probability) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected void calculateFenotype() {
		fenotype= new Double[this.numGenes];
		double sum=0;
		for(int i=0;i<this.dimension;i++) {
			double d=this.cromosoma.genes[i].fenotype();
			sum=Math.pow(d, 4) - 16*Math.pow(d, 2) + 5*d; 
			this.fenotype[i]=sum;
		}
		
		
	}
	

}
