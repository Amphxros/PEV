package P2;

import java.util.Random;

import Common.Individuo;

public class TSPIndividuo extends Individuo<Integer,String> {

	public TSPIndividuo(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean mutateSelf(int pos, Random rnd, double probability) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void calculateFenotype() {
		// TODO Auto-generated method stub
		for(int i=0;i<fenotype.length;i++) {
			fenotype[i]=this.cromosoma.getGen(i).toString();
		}
	}

	@Override
	public void evaluateSelf() {
		// TODO Auto-generated method stub
		
	}

}
