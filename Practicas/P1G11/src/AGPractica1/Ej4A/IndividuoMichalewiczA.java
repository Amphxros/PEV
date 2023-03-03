package AGPractica1.Ej4A;

import java.util.Random;

import Common.Individuo;

public class IndividuoMichalewiczA extends Individuo<Integer> {
	final double min=0;
	final double max=Math.PI;
	final int dimension;
	final int m=10;
	
	public IndividuoMichalewiczA(int dimension,double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		this.dimension=dimension;
		// TODO Auto-generated constructor stub
		for(int i=0;i<numGenes;i++) {
			
		}
	}

	@Override
	protected boolean mutateSelf(int pos, Random rnd, double probability) {
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
