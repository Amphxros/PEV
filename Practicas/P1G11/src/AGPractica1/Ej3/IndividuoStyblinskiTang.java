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
		fenotype= new double[dimension];
		Random rnd= new Random();
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
		// TODO Auto-generated method stub
	
				
	}

	/**
	 * Calculate the fitness in this case f(x)= 0.5*∑(xi^4 - 16xi^2 + 5*xi)
	 */
	@Override
	public void evaluateSelf() {
		// TODO Auto-generated method stub
		final double fitness_; //new fitness
		if (fenotype.length == dimension) {
			// sumatory from 0 to dimension
			double sum=0.0;
			for(int i=0;i<dimension;i++) {
				sum+= (Math.pow(fenotype[i],4)) - (16*Math.pow(fenotype[i], 2)) + 5*fenotype[i];
			}
			sum*=0.5;
			
			fitness_=sum;
		
		}
		else {
			fitness_=Double.MIN_VALUE;
			System.out.println("Ejer 3: Wrong fitness params.");
		}
		
		setFitness(fitness_);
	}

	@Override
	public boolean maximize() {
		// TODO Auto-generated method stub
		return false;
	}

}
