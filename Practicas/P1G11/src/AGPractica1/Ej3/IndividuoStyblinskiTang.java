package AGPractica1.Ej3;

import java.util.Random;

import Common.Individuo;

public class IndividuoStyblinskiTang extends Individuo<Integer>{

	final double minX1=-5;
	final double maxX1=5;
	final int dimension=2;
	
	public IndividuoStyblinskiTang(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean mutateGene(int pos, Random rnd, double mutation_chance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void calculateFenotype() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evaluateSelf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean maximize() {
		// TODO Auto-generated method stub
		return false;
	}

}
