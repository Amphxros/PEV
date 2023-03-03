package AGPractica1.Ej1;

import java.util.Random;

import Common.Conversions;
import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.BooleanGen;
import Common.Genes.Gen;

public class IndividuoCalibracion extends Individuo<Boolean>{

	// x1 = 11.625 y x2 = 5.726 x1∈ [-3.0,12.1] x2∈ [4.1,5.8]
	private final double minX1=-3.000;
	private final double maxX1=12.100;

	private final double minX2=4.100;
	private final double maxX2=5.800;
	
	
	
	public IndividuoCalibracion(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		// TODO Auto-generated constructor stub
		final int tamX1=this.calculateGenSize(this.tolerance, minX1, maxX1);
		final int tamX2=this.calculateGenSize(this.tolerance, minX2, maxX2);
		
		fenotype= new double[2];
		fenotype[0]=fenotype[1]=Double.MIN_VALUE;
		this.cromosoma= new Cromosoma(numGenes);
		Random rnd= new Random();
	
		for(int i=0;i<numGenes;i++) {
			BooleanGen g= new BooleanGen(rnd.nextBoolean());
			System.out.print(g.toString());
			this.cromosoma.setGen(g, i);
		}
		System.out.print(" ");
	
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
				
			}
		return changed;
	}

	/**
	 * 
	 */
	@Override
	protected void calculateFenotype() {
		// TODO Auto-generated method stub
		fenotype[0]= minX1 + (maxX1 - minX1) *(Conversions.BinaryToDecimal(this.cromosoma));
		fenotype[1]= minX2 + (maxX2 - minX2) *(Conversions.BinaryToDecimal(this.cromosoma));
	}

}
