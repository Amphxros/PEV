package AGPractica1;

import java.util.Random;

import Common.Individuo;

public class IndividuoCalibracion extends Individuo<Boolean>{

	final double min1=-3.000;
	final double min2=4.100;
	final double max1=12.100;
	final double max2=5.800;
	
	
	
	public IndividuoCalibracion(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		// TODO Auto-generated constructor stub
			
	
	}

	@Override
	public void evaluateSelf() {
		final double fitness_;
		if (fenotype.length == 2) {
			double x1= fenotype[0];
			double x2= fenotype[1];
			
			fitness_=(21.5 + x1*Math.sin(4*Math.PI*x1)) + x2*Math.cos(20*Math.PI*x2);
		}
		else {
			fitness_=Double.MIN_VALUE;
			System.out.println("Ejer 1: Wrong fitness params.");
		}
		
		setFitness(fitness_);
	}

	@Override
	public boolean maximize() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean mutateGene(int pos, Random rnd, double mutation_chance) {
		boolean changed=false;
			if(0<=pos && pos<cromosoma.getLength()) {
				for(int i=0; i<this.cromosoma.getGen(pos).length();i++) {
					if(rnd.nextDouble()<mutation_chance) {
						this.cromosoma.getGen(pos).setAllele(i,rnd.nextBoolean());
						changed=true;
					}
				}
			}
		return changed;
	}

	@Override
	protected void calculateFenotype() {
		// TODO Auto-generated method stub
		
	}

}
