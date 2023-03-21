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
		// TODO Auto-generated method stub
		
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
