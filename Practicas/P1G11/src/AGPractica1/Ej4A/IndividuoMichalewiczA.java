package AGPractica1.Ej4A;

import java.util.Random;

import Common.Individuo;

public class IndividuoMichalewiczA extends Individuo<Integer> {

	public IndividuoMichalewiczA(double tolerance, int id, int numGenes) {
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
