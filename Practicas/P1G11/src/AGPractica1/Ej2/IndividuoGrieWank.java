package AGPractica1.Ej2;

import java.util.Random;

import Common.Individuo;

public class IndividuoGrieWank extends Individuo<Integer>{

	public IndividuoGrieWank(double tolerance, int id, int numGenes) {
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
