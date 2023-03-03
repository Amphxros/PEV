package AGPractica1.Ej1;

import java.util.Random;

import Common.Individuo;

public class IndividuoCalibracion extends Individuo<Integer>{

	// x1 = 11.625 y x2 = 5.726 x1∈ [-3.0,12.1] x2∈ [4.1,5.8]
	final double minX1=-3.000;
	final double maxX1=12.100;

	final double minX2=4.100;
	final double maxX2=5.800;
	
	
	
	public IndividuoCalibracion(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		// TODO Auto-generated constructor stub
		fenotype= new double[2];
		fenotype[0]=fenotype[1]=Double.MIN_VALUE;
		for(int i=0;i<numGenes;i++) {
			
		}
	
	}

	/**
	 * /**
	 * Calculate the fitness in this case f(x,y)= 21.5 + x*sen(4πx)+ y*sen(20πy)
	 */
	@Override
	public void evaluateSelf() {
		final double fitness_;
		if (fenotype.length == 2) {
			double x1= fenotype[0];
			double x2= fenotype[1];
			
			fitness_=(21.5 + x1*Math.sin(4*Math.PI*x1)) + x2*Math.sin(20*Math.PI*x2); //f(x1 , x2) = 21.5 + x1.sin(4π x1)+x2.sin(20π x2)
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
		return true;
	}

	/**
	 * 
	 */
	@Override
	protected boolean mutateSelf(int pos, Random rnd, double probability) {
		boolean changed=false;
			if(0<=pos && pos<cromosoma.getLength()) {
				for(int i=0; i<this.cromosoma.getGen(pos).length();i++) {
					if(rnd.nextDouble()<probability) {
						this.cromosoma.getGen(pos).setAllele(rnd.nextBoolean(),i);
						changed=true;
					}
				}
			}
		return changed;
	}

	/**
	 * 
	 */
	@Override
	protected void calculateFenotype() {
		// TODO Auto-generated method stub
		for(int i=0;i<fenotype.length; i++) {
			
		}
	}

}
