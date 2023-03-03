package AGPractica1.Ej2;

import java.util.Random;

import Common.Individuo;

public class IndividuoGrieWank extends Individuo<Integer>{

	final double min = -600.0;
	final double max = 600.0;
	final int dimension=2;
	
	public IndividuoGrieWank(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		Random rnd= new Random();
		// TODO Auto-generated constructor stub
		for(int i=0;i<numGenes;i++) {
			
		}
		
	}

	@Override
	protected boolean mutateSelf(int pos, Random rnd, double mutation_chance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void calculateFenotype() {
		fenotype= new double[this.getCromosomeArraySize()];
		for(int i=0;i<fenotype.length;i++) {
			
		}
	}

	@Override
	public void evaluateSelf() {
		final double fitness_;	
		fitness_=Double.MIN_VALUE;
		setFitness(fitness_);
		System.out.println("Ejer 2: Wrong fitness params.");
		
	}

	@Override
	public boolean maximize() {
		// TODO Auto-generated method stub
		return false;
	}

}
