package AGPractica1.Ej4A;

import java.util.Random;

import Common.Conversions;
import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.BooleanGen;

public class IndividuoMichalewiczA extends Individuo<Boolean, Double> {
	
	final double min=0;
	final double max=Math.PI;
	final int dimension;
	final int m=10;
	
	public IndividuoMichalewiczA(double tolerance, int id, int numGenes,int dimension) {
		super(tolerance, id, numGenes);
		this.dimension=dimension;
		createCromosome();
		calculateFenotype();
		super.lcrom= this.getLength();
		this.setType(4);
	}
	
	@Override
	public void createCromosome() {
		// TODO Auto-generated method stub
		for(int i=0;i<this.numGenes;i++) {
			this.cromosoma.genes[i]= new BooleanGen(min,max,this.tolerance);
		}
	}
	@Override
	public void evaluateSelf() {
		// TODO Auto-generated method stub
		
	}
	
	private double f(double x) {
		return x;
		
	}
	@Override
	public boolean mutateSelf(int pos, Random rnd, double probability) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected void calculateFenotype() {
		// TODO Auto-generated method stub
		
	}
	
	



}
