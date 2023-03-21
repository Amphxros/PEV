package AGPractica1.Ej4B;

import java.util.Random;

import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.BooleanGen;
import Common.Genes.RealGen;

public class IndividuoMichalewiczB extends Individuo<Double, Double>{


	private final int dimension;
	private double min=0;
	private double max=Math.PI;
	private double m=10;
	public IndividuoMichalewiczB(double tolerance, int id, int numGenes, int dimension) {
		super(tolerance, id, numGenes);
		this.dimension=dimension;
		createCromosome();
		calculateFenotype();
		super.lcrom= this.getLength();
		this.setType(5);
	}
	@Override
	public void createCromosome() {
		// TODO Auto-generated method stub
		for(int i=0;i<this.numGenes;i++) {
			this.cromosoma.genes[i]= new RealGen(min,max,this.tolerance);
		
		}
		
		this.startCromosome();
		
	}
	@Override
	public void evaluateSelf() {
		// TODO Auto-generated method stub
		
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
