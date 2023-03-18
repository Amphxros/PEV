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
		// TODO Auto-generated constructor stub
	}
	@Override
	public void createCromosome() {
		// TODO Auto-generated method stub
		this.cromosoma.initCromosome();
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
